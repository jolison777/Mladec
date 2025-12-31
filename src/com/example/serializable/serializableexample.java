package com.example.serializable;

import java.io.Serializable;

public class serializableexample implements Serializable {

	
	public int id;
	public String name;
	public String type;
	public transient String city;
	public serializableexample(int id, String name, String type,String city) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.city=city;
	}
	
	@Override
	public String toString() {
		return "serializableexample [id=" + id + ", name=" + name + ", type=" + type +"city="+city+city+"]";
	}
	

}
