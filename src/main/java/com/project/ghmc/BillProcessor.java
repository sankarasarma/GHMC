package com.project.ghmc;

public class BillProcessor {
	
	public static void main(String[] args) {
		try {
			FileProcessor.readFile();
			FileProcessor.writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
