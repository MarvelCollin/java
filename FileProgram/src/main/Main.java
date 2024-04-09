package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import models.Data;


public class Main {

	public Main() {
		List<Data> datas = new ArrayList<>();
		
		// letakin file txt ke projectnya bukan di dalam src
		String filePath = "data.txt";
		
		try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            for(String line : lines) {
            	String[] parts = line.split("#", 2);
            	
            	Data data = new Data(parts[0], Integer.parseInt(parts[1]));
            	datas.add(data);
            }
		} catch (IOException e) {
            System.out.println("Failed");
        }
		
		for(Data data : datas) {
			System.out.println("Name : " + data.getName() + " Balance : " + data.getBalance());
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

}
