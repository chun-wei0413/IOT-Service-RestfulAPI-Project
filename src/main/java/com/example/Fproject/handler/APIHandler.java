package com.example.Fproject.handler;
import com.example.Fproject.apibody.*;
import com.example.Fproject.database.entity.*;

import java.util.List;

public interface APIHandler {
    String getState(IotBean.GetStateBean getStateBean);
    String powerOff(IotBean.PowerOffBean powerOffBean);
    String powerOn(IotBean.PowerOnBean powerOnBean);
    String deleteUser(UserBean.DeleteUserBean deleteUserBean);
    String authorUser(UserBean.AuthorUserBean authorUserBean);
    String registerUser(UserBean.RegisterUserBean registerUserBean);
    String alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean);
    String deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean);
    List<Device.Data> queryDevice(DeviceBean.QueryDeviceBean queryDeviceBean);
    String addDevice(DeviceBean.AddDeviceBean addDeviceBean);

    String addManager(ManagerBean.AddManagerBean addManagerBean);
    String deleteManager(ManagerBean.DeleteManagerBean deleteManagerBean);

    List<Manager.member> listManager(ManagerBean.ManagerListBean managerListBean);
}
