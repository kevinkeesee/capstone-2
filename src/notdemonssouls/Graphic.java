package notdemonssouls;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Graphic implements TextToDisplay {
	
	private ArrayList<String> lines;
	private static BufferedReader reader;
	
	public Graphic(int screenNumber) {
		
		lines = new ArrayList<String>();
		
		lines = readFile("C:/Users/kevdo/OneDrive/Documents/Coding Bootcamp/Java/capstone-2/assets/graphics/graphic"+screenNumber+".txt");
	}
	
	public ArrayList<String> readFile(String fileName) {
		System.out.println("Reading "+fileName);
		
		ArrayList<String> strings = new ArrayList<String>();
		
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: "+fileName+" not found!");
		}
		
		try {
			String str = reader.readLine();
			strings.add(str);
			
			while(str!=null) {
				str = reader.readLine();
				strings.add(str);
			}
			
		} catch(IOException e) {
			System.out.println("ERROR: IOException");
		}
		
		return strings;
	}
	
	public String getLine(int i) {
		if(lines.get(i) == null) {
			return "";
		}
		
		return lines.get(i);
	}
	
	public int getLength() {
		return lines.size();
	}
	
	public void changeFile(int i) {
		lines = readFile("C:/Users/kevdo/OneDrive/Documents/Coding Bootcamp/Java/capstone-2/assets/graphics/graphic"+i+".txt");
	}
}
