package com.example.Fproject.database;

import com.example.Fproject.database.entity.device;
import com.example.Fproject.database.dao.deviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Autowired
	private deviceRepository deviceRepository;

	@Override
	public boolean authorization(String key, String id) {
		device device = deviceRepository.findById(id).orElse(null);
		System.out.println("device: " + device);
		if (device == null) {
			return false;
		}
		return device.getApiKey().equals(key);
	}

	@Override
	public String getUrl(String id) {
		Optional<device> optionalDevice = deviceRepository.findById(id);
		if (optionalDevice.isPresent()) {
			device device = optionalDevice.get();
			return device.getUrl();
		} else {
			return null;
		}
	}


	@Override
	public String[] addDevice(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean alterDevice(String id,String url) {
		Optional<device> optionalDevice = deviceRepository.findById(id);
		if (optionalDevice.isPresent()) {
			device existingDevice = optionalDevice.get();
			existingDevice.setUrl(url);
			deviceRepository.save(existingDevice);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteDevice(String id) {
		Optional<device> optionalDevice = deviceRepository.findById(id);
		if (optionalDevice.isEmpty()) {
			return false;
		}
		deviceRepository.delete(optionalDevice.get());
		return true;
	}
}
