package com.example.Fproject.controller;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.IotBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Tag(name="IOT group")
@RestController
public class ManagerController {
    private IoTGatewayService ioTGatewayService;

    public ManagerController(IoTGatewayService ioTGatewayService) {
        this.ioTGatewayService = ioTGatewayService;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "modify device", description = "Modify the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value = "/devices/{id}/alter", method = RequestMethod.PUT)
    public void alterDevice(@RequestHeader(name = "Authorization") String accessToken,
                            @Parameter(description = "The id is a string composed of 3 digit numbers", example = "001")
                            @PathVariable String id,
                            HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        ioTGatewayService.alterDevice(accessToken, id, requestUrl);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "delete device", description = "Delete the device with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/devices/{id}/delete", method=RequestMethod.DELETE)
    public void deletedevice (@RequestHeader(name = "Authorization") String accessToken,
                              @Parameter(description = "The id is a string composed of 3 digit numbers", example = "001")
                              @PathVariable String id){
        ioTGatewayService.deleteDevice(accessToken, id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add new device", description = "Add a device without authentication")
    @RequestMapping(value="/devices/new", method=RequestMethod.POST)
    public String addDevice(@Valid @RequestBody IotBean.AddDeviceBean addDeviceBean){
        return "Success";
    }
}
