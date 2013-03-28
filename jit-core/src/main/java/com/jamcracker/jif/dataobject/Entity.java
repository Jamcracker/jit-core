package com.jamcracker.jif.dataobject;

import java.util.HashMap;
import java.util.Map;

public class Entity {
	Map<String,String> fields = new HashMap<String,String>();
	String type;
	public Entity(){
		
	}

	public Entity(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void addField(String name, String value){
		fields.put(name, value);
	}
	
	public String getField(String name){
		return (String)fields.get(name);
	}
	
	public Map<String,String> getFields(){
		return fields;
	}
}
