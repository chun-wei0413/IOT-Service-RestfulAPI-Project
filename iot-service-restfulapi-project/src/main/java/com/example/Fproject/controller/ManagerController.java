package com.example.Fproject.controller;


import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.ManagerBean;
import com.example.Fproject.database.entity.Manager;
import com.example.Fproject.handler.ManagerHandler;
import com.example.Fproject.rabbitmq.RabbitmqConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Device manager control Services API")
@RestController
public class ManagerController {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private ManagerHandler managerHandler;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RabbitmqConfig rabbitmqConfig;

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Add a new manager in certain device", description = "After verifying the user's identity, add them as an administrator on the specified device.")
    @RequestMapping(value = "/manager/new", method = RequestMethod.POST)
    public String addManager(@Valid @RequestBody ManagerBean.AddManagerBean addManagerBean) {
        return managerHandler.addManager(addManagerBean);
    }
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete a manager in certain device", description = "After confirming the user's identity, remove the administrator role from the specific device.")
    @RequestMapping(value = "/manager/delete", method = RequestMethod.DELETE)
    public String deleteManager(@Valid @RequestBody ManagerBean.DeleteManagerBean deleteManagerBean) {
        return managerHandler.deleteManager(deleteManagerBean);
    }
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Check the manager list in certain device",
            description = "After verifying that the user possesses administrative privileges for the specific device, request the list of administrators for that particular device from the system.")
    @RequestMapping(value = "/manager/list", method = RequestMethod.GET)
    public List<Manager.member> listManager(@Valid @RequestBody ManagerBean.ManagerListBean managerListBean) {
        List<Manager.member> data = managerHandler.listManager(managerListBean);
        rabbitTemplate.convertAndSend(rabbitmqConfig.MANAGERLIST_EXCHANGE,"",data);
        return data;
    }
}
