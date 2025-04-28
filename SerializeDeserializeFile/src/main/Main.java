package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
	private Scanner scan = new Scanner(System.in);
	
	public void readAndPrintFiles(String fileName) {
		try {
			List<String> fileDatas = Files.readAllLines(Paths.get(fileName));
			
			fileDatas.forEach(data -> {
				String[] parts = data.split("#");
				
				String name = parts[0];
				Integer umur = Integer.parseInt(parts[1]);
				String bio = parts[2];
				System.out.println(name + umur + bio);
			});
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void writeFiles(String filePath, String line) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
			
			writer.write(line);
			writer.newLine();
			
			writer.close();
			System.out.println("mntp bang");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void serializeData(String fileName, Data data) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(fileName);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOutput);
			
			objOut.writeObject(data);
			objOut.close();
			fileOutput.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Data deserializeData(String fileName) {
		try {
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			
			Data result = (Data) objIn.readObject();
			System.out.println(result.name + result.size);
			return result;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public int sum(int a, int b) {
		return a + b;
	}
	
	public Double sum(Double a, Double b) {
		return a + b;
	}
	
	public Main() {
//		writeFiles("text.txt", "awawa#20#sadfasda");
//		readAndPrintFiles("text.txt");
//		Data data = new Data("namadatanya", 20);
//		
//		serializeData("data.ser", data);
//		
//		Data resultDeserialize = deserializeData("data.ser");
//		System.out.println(resultDeserialize.name + " " + resultDeserialize.size);
		
		int hasilSum = sum(2, 3);
		System.out.println(hasilSum);
		
		Double hasilSumDouble = sum(0.2, 0.3);
		System.out.println(hasilSumDouble);
	}

	public static void main(String[] args) {
		new Main();
	}

}
