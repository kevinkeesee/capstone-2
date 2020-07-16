package notdemonssouls;

import java.util.ArrayList;

public interface TextToDisplay {
	
	ArrayList<String> readFile(String fileName);
	
	String getLine(int i);
	
	public int getLength();
	
	public void changeFile(int i);
}