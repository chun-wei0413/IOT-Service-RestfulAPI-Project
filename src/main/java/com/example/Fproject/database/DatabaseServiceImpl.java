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
import java.util.Optional;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Autowired
	private deviceRepository deviceRepository;
	private userRepository userRepository;
	private userDeviceRepository userDeviceRepository;

	@Override
	public boolean authorization(String userId,String deviceId,String password) {
		//user會有每一個家電的password若使用者的password輸入正確則表示具有該device的控制權限

		user user=userRepository.findById(userId).orElse(null);
		//若user找到對應的id，則User會有該筆id對應到的password，否則為null
		device device=deviceRepository.findById(deviceId).orElse(null);

		if(user!=null&& Objects.equals(user.getPassword(),password)){
			userDevice userDevice=new userDevice(user,device);
			userDeviceRepository.save(userDevice);
			return true;
		}
		return false;
	}

	@Override
	public boolean addDevice(String url,String type,String pin,String manager) {
		// TODO Auto-generated method stub
		//新增裝置

		String deviceId=generateRandomId();

		device device=new device();
		device.setDeviceId(deviceId);
		device.setUrl(url);
		device.setType(type);
		device.setPin(pin);
		device.setManager(manager);

		try{
			deviceRepository.save(device);
			return true;

		}catch(Exception e){
			System.out.println("Error"+e.getMessage());
			return false;

		}

	}

	@Override
	public boolean alterDevice(String userId,String password,String deviceId,String url) {
		// TODO Auto-generated method stub
		//改變裝置的url
		user user=userRepository.findById(userId).orElse(null);
		if(user!=null&&Objects.equals(user.getPassword(),password)){
			device device=deviceRepository.findById(deviceId).orElse(null);
			if(device!=null) {
				device.setUrl(url);
				deviceRepository.save(device);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean deleteDevice(String userId,String deviceId,String password) {
		//刪除裝置
		device device=deviceRepository.findById(deviceId).orElse(null);

		try{
			if(device!=null){
				deviceRepository.delete(device);
				return true;
			}
		}catch(Exception e){
			System.out.println("Error"+e.getMessage());
			return false;
		}

		return false;

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

	@Override
	public device queryDevice(String userId, String password){

		user user=userRepository.findById(userId).orElse(null);

		if(user!=null&&Objects.equals(user.getPassword(),password)){
			Optional<userDevice> userDevice=userDeviceRepository.findById(userId);
			if(userDevice.isPresent()){
				String deviceId=userDevice.get().getDevice().getDeviceId();
				device device=deviceRepository.findById(deviceId).orElse(null);
				return device;
			}

		}
		return null;
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
