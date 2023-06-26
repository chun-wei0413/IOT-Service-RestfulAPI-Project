package com.example.Fproject.database;

import com.example.Fproject.database.entity.device;
import com.example.Fproject.database.entity.user;
import com.example.Fproject.database.entity.userDevice;
import com.example.Fproject.database.dao.deviceRepository;
import com.example.Fproject.database.dao.userRepository;
import com.example.Fproject.database.dao.userDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Autowired
	private deviceRepository deviceRepository;
	@Autowired
	private userRepository userRepository;
	@Autowired
	private userDeviceRepository userDeviceRepository;

	public DatabaseServiceImpl(com.example.Fproject.database.dao.deviceRepository deviceRepository, com.example.Fproject.database.dao.userRepository userRepository, com.example.Fproject.database.dao.userDeviceRepository userDeviceRepository) {
		this.deviceRepository = deviceRepository;
		this.userRepository = userRepository;
		this.userDeviceRepository = userDeviceRepository;
	}

	@Override
	public boolean authorization(String userId,String deviceId) {
		//授權
		userDevice userDevice=userDeviceRepository.findById(userId).orElse(null);
		//若user找到對應的id，則User會有該筆id對應到的password，否則為null

		if(userDevice!=null&&Objects.equals(userDevice.getDevice().getDeviceId(),deviceId)){
			return true;
		}
		return false;
	}

	@Override
	public boolean authentication(String userId,String password){
		//驗證
		user user=userRepository.findById(userId).orElse(null);
		if(Objects.equals(user.getPassword(),password)){
			return true;
		}
		return false;
	}

	@Override
	public boolean addDevice(String url,String type,String pin,String userId) {
		// TODO Auto-generated method stub
		//新增裝置

		String deviceId=generateRandomId();

		device device=new device();
		device.setDeviceId(deviceId);
		device.setUrl(url);
		device.setType(type);
		device.setPin(pin);
		device.setManager(userId);


		try{
			deviceRepository.save(device);
			return true;

		}catch(Exception e){
			System.out.println("Error"+e.getMessage());
			return false;

		}

	}

	@Override
	public boolean alterDevice(String userId,String deviceId,String url) {
		// TODO Auto-generated method stub
		//改變裝置的url
		device device=deviceRepository.findById(deviceId).orElse(null);
		if(device!=null&&Objects.equals(device.getManager(),userId)){
			device.setUrl(url);
			deviceRepository.save(device);
			return true;
		}else{
			return false;
		}

	}

	@Override
	public boolean deleteDevice(String deviceId,String userId) {
		//刪除裝置
		device device=deviceRepository.findById(deviceId).orElse(null);
		if(device!=null&&Objects.equals(device.getManager(),userId)){
			deviceRepository.delete(device);
			return true;
		}else{
			return false;
		}

	}

	@Override
	public boolean registerUser(String userId,String password){
		user user=new user(userId,password);
		try{
			userRepository.save(user);
			return true;
		}catch(Exception e){
			System.out.println("Error"+e.getMessage());
			return false;
		}

	}
	public boolean deleteUser(String userId,String password){
		user user=userRepository.findById(userId).orElse(null);
		if(user!=null&&Objects.equals(user.getPassword(),password)){
			userRepository.delete(user);
			return true;
		}else{
			return false;
		}
	}
	public String getUrl(String deviceId){
		device device=deviceRepository.findById(deviceId).orElse(null);
		if(device!=null){
			return device.getUrl();
		}else{
			return null;
		}
	}

	private String generateRandomId(){
		Random random=new Random();
		int id;
		boolean duplicate;
		String idString;

		do{
			id=random.nextInt(1000);
			//return 0-999的整數作為id
			idString=String.valueOf(id);
			duplicate=deviceRepository.existsById(idString);//判斷id是否重複
		}while(duplicate);

		return idString;

	}


}
