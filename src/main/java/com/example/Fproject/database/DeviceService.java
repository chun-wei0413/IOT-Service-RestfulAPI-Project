package com.example.Fproject.database;

import com.example.Fproject.database.entity.Device;
import com.example.Fproject.database.entity.User;

import java.util.List;

public interface DeviceService {
    List<Device.DeviceData> getDeviceMembers(String userId);
    List<User> getAllDeviceMembers();
}
