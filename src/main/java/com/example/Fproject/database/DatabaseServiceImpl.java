package com.example.Fproject.database;

import com.example.Fproject.database.entity.device;
import com.example.Fproject.database.dao.deviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.Optional;
import java.util.UUID;

@Service
public class DatabaseServiceImpl implements DatabaseService {

	@Autowired
	private deviceRepository deviceRepository;

	@Override
	public boolean authorization(String key, String id) {
		//驗證key:放入key和id 回傳true or false
		device device=deviceRepository.findById(id).orElse(null);
		//若device找到對應的id則device會有該筆id對應到的key/url/id，否則device為null
		if(device!=null){
			return device.getApiKey().equals(key);
		}
		return false;
	}

	@Override
	public String getUrl(String id) {
		//用id獲得該裝置的url
		//資料庫格式:三個column分別是ID/URL/KEY
		device device=deviceRepository.findById(id).orElse(null);
		if (device!=null){
			return device.getUrl();
		}
		else{
			return null;
		}
	}
	@Override
	public String[] addDevice(String url) {
		// TODO Auto-generated method stub
		//新增裝置
		//KEY和ID是我們設定的所以用string回傳

		String id=generateRandomId();
		String apiKey=generateRandomApiKey();

		device device=new device();
		device.setId(id);
		device.setUrl(url);
		device.setApiKey(apiKey);

		deviceRepository.save(device);

		if(id!=null&&apiKey!=null){
			return new String[]{id,apiKey};
		}
		else{
			return null;
		}

	}

	@Override
	public boolean alterDevice(String id,String url) {
		// TODO Auto-generated method stub
		device device=deviceRepository.findById(id).orElse(null);
		if(device!=null){
			device.setUrl(url);
			deviceRepository.save(device);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteDevice(String id) {
		//刪除裝置
		device device=deviceRepository.findById(id).orElse(null);
		if(device!=null){
			deviceRepository.delete(device);
			return true;
		}
		return false;
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
	private String generateRandomApiKey(){
		return UUID.randomUUID().toString().replaceAll("-","").substring(0,6);
	}

}
