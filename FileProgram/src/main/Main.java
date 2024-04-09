package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

	public Main() {
		// letakin file txt n
		String filePath = "data.txt";
		
		try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Failed");
        }
	}

	public static void main(String[] args) {
		Main main = new Main();
	}

}
