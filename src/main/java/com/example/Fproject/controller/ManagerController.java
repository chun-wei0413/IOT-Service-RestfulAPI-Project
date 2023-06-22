package com.example.Fproject.controller;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.handler.APIHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Tag(name="IOT group")
@RestController
public class ManagerController {
    @Autowired
    private IoTGatewayService ioTGatewayService;
    @Autowired
    private APIHandler apiHandler;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "modify device", description = "Modify the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/alter", method = RequestMethod.PUT)
    public void alterDevice() {

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "delete device", description = "Delete the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/delete", method=RequestMethod.DELETE)
    public void deleteDevice(){

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "delete user", description = "Delete the user with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/user/delete", method=RequestMethod.DELETE)
    public void deleteUser(){

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Query", description = "Query which devices the user owns")
    @RequestMapping(value="devices/query", method=RequestMethod.POST)
    public void queryDevice(){

    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Authorization", description = "Authorized users can control specific devices")
    @RequestMapping(value="device/author", method=RequestMethod.POST)
    public void authorUser(){

    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add new user", description = "Add a user with authentication")
    @RequestMapping(value="register/user", method=RequestMethod.POST)
    public void registerUser(){

    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add new device", description = "Add a device with authentication")
    @RequestMapping(value="/devices/new", method=RequestMethod.POST)
    public void addDevice(@Valid @RequestBody IotBean.AddDeviceBean addDeviceBean){

    }

}
