package com.example.Fproject.controller;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.handler.APIHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Tag(name="User Services API")
@RestController
public class UserController {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private APIHandler apiHandler;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete user", description = "Delete the user with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/user/delete", method=RequestMethod.DELETE)
    public String deleteUser(@Valid @RequestBody UserBean.DeleteUserBean deleteUserBean){
        return apiHandler.deleteUser(deleteUserBean);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Authorization", description = "Authorized users can control specific devices")
    @RequestMapping(value="/user/author", method=RequestMethod.POST)
    public String authorUser(@Valid @RequestBody UserBean.AuthorUserBean authorUserBean){
        return apiHandler.authorUser(authorUserBean);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add new user", description = "Add a user with authentication")
    @RequestMapping(value="/user/register", method=RequestMethod.POST)
    public String registerUser(@Valid @RequestBody UserBean.RegisterUserBean registerUserBean){
        return apiHandler.registerUser(registerUserBean);
    }


}
