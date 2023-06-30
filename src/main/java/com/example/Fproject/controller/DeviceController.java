package com.example.Fproject.controller;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.DeviceBean;
import com.example.Fproject.handler.APIHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.Fproject.database.entity.*;

import java.util.List;

@Tag(name="Device Services API")
@RestController
public class DeviceController {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private APIHandler apiHandler;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "modify device", description = "Modify the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/alter", method = RequestMethod.PUT)
    public String alterDevice(@Valid @RequestBody DeviceBean.AlterDeviceBean alterDeviceBean) {
        return apiHandler.alterDevice(alterDeviceBean);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "delete device", description = "Delete the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/delete", method=RequestMethod.DELETE)
    public String deleteDevice(@Valid @RequestBody DeviceBean.DeleteDeviceBean deleteDeviceBean){
        return apiHandler.deleteDevice(deleteDeviceBean);
    }
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Query", description = "Query which devices the user owns")
    @RequestMapping(value="devices/query", method=RequestMethod.GET)
    public List<Device.Data> queryDevice(@Valid @RequestBody DeviceBean.QueryDeviceBean queryDeviceBean){
        return apiHandler.queryDevice(queryDeviceBean);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add new device", description = "Add a device with authentication")
    @RequestMapping(value="/devices/new", method=RequestMethod.POST)
    public String addDevice(@Valid @RequestBody DeviceBean.AddDeviceBean addDeviceBean){
        return apiHandler.addDevice(addDeviceBean);
    }

}
