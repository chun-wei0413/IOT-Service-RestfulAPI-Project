package com.example.Fproject.handler.handlerImpl;

import com.example.Fproject.IotService.IoTGatewayService;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.controller.exception.RequestNotFoundException;
import com.example.Fproject.handler.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserHandlerImpl implements UserHandler {
    @Autowired
    private IoTGatewayService ioTGatewayService;

    @Override
    public String deleteUser(UserBean.DeleteUserBean deleteUserBean){
        if(deleteUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(deleteUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.deleteUser(deleteUserBean.getUserId(),deleteUserBean.getPassword());
    }

    @Override
    public String authorUser(UserBean.AuthorUserBean authorUserBean){
        if(authorUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(authorUserBean.getDeviceId()==null) throw new RequestNotFoundException("deviceId");
        if(authorUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.addRelationship(authorUserBean.getUserId(),authorUserBean.getDeviceId(),authorUserBean.getPassword());
    }

    @Override
    public String registerUser(UserBean.RegisterUserBean registerUserBean){
        if(registerUserBean.getUserId()==null) throw new RequestNotFoundException("userId");
        if(registerUserBean.getPassword()==null) throw new RequestNotFoundException("password");
        return ioTGatewayService.registerUser(registerUserBean.getUserId(),registerUserBean.getPassword());

    }
}
