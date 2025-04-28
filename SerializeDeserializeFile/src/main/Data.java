package main;

import java.io.Serializable;

public class Data implements Serializable{
	public String name;
	public Integer size;
	
	public Data(String name, Integer size) {
		this.name = name;
		this.size = size;
	}

}
