package com.example.Fproject.controller;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.handler.APIHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "delete user", description = "Delete the user with authentication, otherwise it will be invalid.")
    @RequestMapping(value="/user/delete", method=RequestMethod.DELETE)
    public void deleteUser(@Valid @RequestBody UserBean.DeleteUserBean deleteUserBean){
        String userId = deleteUserBean.getUserId();
        String password = deleteUserBean.getPassword();
        ioTGatewayService.deleteUser(userId,password);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Authorization", description = "Authorized users can control specific devices")
    @RequestMapping(value="/user/author", method=RequestMethod.POST)
    public void authorUser(@Valid @RequestBody UserBean.AuthorUserBean authorUserBean){

    }
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "add new user", description = "Add a user with authentication")
    @RequestMapping(value="/user/register", method=RequestMethod.POST)
    public void registerUser(@Valid @RequestBody UserBean.RegisterUserBean registerUserBean){
        String userId = registerUserBean.getUserId();
        String password = registerUserBean.getPassword();
        ioTGatewayService.registerUser(userId,password);
    }


}
