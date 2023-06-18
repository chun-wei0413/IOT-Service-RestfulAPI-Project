package com.example.Fproject.database;

public interface DatabaseService {
	boolean authorization(String key,String id);
	String getUrl(String id);
	String[] addDevice(String url);
	boolean alterDevice(String id,String url);
	boolean deleteDevice(String id);
}
