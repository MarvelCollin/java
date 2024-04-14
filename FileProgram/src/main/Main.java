package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import models.Data;


public class Main {
	List < Data > datas = new ArrayList <> ();
	String filePath = "data.txt";
	Data data;

	private void readFile() {	
			datas.removeAll(datas);
	        try {
	            List <String> lines = Files.readAllLines(Paths.get(filePath));

	            for (String line: lines) {
	                String[] parts = line.split("#", 2);

	                data = new Data(parts[0], Integer.parseInt(parts[1]));
	                datas.add(data);
	            }
	        } catch (IOException e) {
	            System.out.println("Failed");
	        }

	}
	
	private void writeFile(String text) {
		try {
//			readFile();

			FileWriter w = new FileWriter(filePath, true);
			
			BufferedWriter buff = new BufferedWriter(w);
			
			buff.write(text);
			buff.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void printData() {
		for (Data data: datas) {
            System.out.println("Name : " + data.getName() + " Balance : " + data.getBalance());
        }
	}
	
    public Main() {
        // letakin file txt ke projectnya bukan di dalam src
//    	writeFile("asdasdas");
//    	readFile();
    	writeFile("asdaasdasdasdass#1231231231\n");
    	readFile();
    	printData();
    }

    public static void main(String[] args) {
        new Main();
    }

}