package com.project.ghmc.march.template;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File> {
	
	@Override
	public int compare(File file1, File file2) {
		String fileOneName = file1.getName();
		int fileOneNumber = Integer.valueOf(fileOneName.substring(fileOneName.indexOf(".")+1, fileOneName.lastIndexOf(".")));
		String fileTwoName = file2.getName();
		int fileTwoNumber = Integer.valueOf(fileTwoName.substring(fileTwoName.indexOf(".")+1, fileTwoName.lastIndexOf(".")));
		return fileOneNumber - fileTwoNumber;
	}

}
