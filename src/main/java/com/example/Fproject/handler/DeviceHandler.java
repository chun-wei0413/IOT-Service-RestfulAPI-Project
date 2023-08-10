package com.example.Fproject.handler;

import com.example.Fproject.apibody.DeviceBean;
import com.example.Fproject.database.entity.Device;

import java.util.List;

public interface DeviceHandler {
    String alterDevice(DeviceBean.AlterDeviceBean alterDeviceBean);
    String deleteDevice(DeviceBean.DeleteDeviceBean deleteDeviceBean);
    List<Device.Data> queryDevice(DeviceBean.QueryDeviceBean queryDeviceBean);
    String addDevice(DeviceBean.AddDeviceBean addDeviceBean);
}
