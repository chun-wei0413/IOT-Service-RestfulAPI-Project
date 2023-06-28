package com.example.Fproject.handler;
import com.example.Fproject.apibody.IotBean;
import com.example.Fproject.apibody.UserBean;
import com.example.Fproject.apibody.DeviceBean;

public interface APIHandler {
    String getState(IotBean.GetStateBean getStateBean);
    String powerOff(IotBean.PowerOffBean powerOffBean);
    String powerOn(IotBean.PowerOnBean powerOnBean);
    void deleteUser(UserBean.DeleteUserBean deleteUserBean);
    void authorUser(UserBean.AuthorUserBean authorUserBean);
    void registerUser(UserBean.RegisterUserBean registerUserBean);
    void alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean);
    void deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean);
    void queryDevice(DeviceBean.QueryDeviceBean queryDeviceBean);
    void addDevice(DeviceBean.AddDeviceBean addDeviceBean);

}