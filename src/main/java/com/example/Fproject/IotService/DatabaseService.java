package com.example.Fproject.IotService;

public interface DatabaseService {
	boolean authorization(String key,String id);
	String getUrl(String id);
	String[] addDevice(String url);
	boolean alterDevice(String url);
	boolean deleteDevice(String key,String id);
}
