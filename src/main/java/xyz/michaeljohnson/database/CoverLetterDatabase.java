package xyz.michaeljohnson.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import lombok.Getter;

public class CoverLetterDatabase {
	
	@Getter
	private static String coverLetter;
	
	static {
		
		StringBuilder result = new StringBuilder("");
		
		ClassLoader classLoader = CoverLetterDatabase.class.getClassLoader();
//		File file = new File(classLoader.getResource("static/cover-letter-content.txt").getFile());
		InputStream in = classLoader.getResourceAsStream("static/cover-letter-content.txt");
		
		try (Scanner scanner = new Scanner(in)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}

			coverLetter = result.toString();
//			scanner.close();

		}
	}

}
