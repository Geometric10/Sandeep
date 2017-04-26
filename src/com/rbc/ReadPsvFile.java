package com.rbc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author Sandeep
 * 
 * This class is used to read the data from .psv file ,writing them to .csv file in reversing the order.
 * And remove the specified column from file
 *
 */

public class ReadPsvFile {

	/**
	 * 
	 * @param fileName
	 * @param csvFileName
	 * @param columnName
	 */
	public static void reverseFile(File inputPsvFile,File csvFileName,String columnName) {
		
		//initializing all local variables.
		
		Integer numOfColRead=0;
		Integer numOfColOutput=0;
		Integer numOfRowsRead=0;
		BufferedReader PSVFile=null;
		BufferedWriter CSVFile=null;
		int count=0;
		
		
		try {
			//Reading the student details from .psv file
			PSVFile = new BufferedReader(new FileReader(inputPsvFile));
			
			//writing the student details in reverse order in .csv file 
			CSVFile=new BufferedWriter(new FileWriter(csvFileName));
		
		String dataRow = PSVFile.readLine();
		int code=2000000000;
		dataRow=dataRow.replace('|',',');
		String[] removeColoumn=dataRow.split(",");
		numOfColRead=removeColoumn.length;
		for(int i=0;i<removeColoumn.length;i++){
			if(removeColoumn[i].equals(columnName)){
				code=i;
				count++;
			}
			++numOfColOutput;
		}
		numOfColOutput=numOfColOutput-count;
		while (dataRow != null)
		{
		 dataRow=dataRow.replace('|', ',');
		 
		 String[] s=dataRow.split(",");
		 StringBuffer sb=new StringBuffer();
		 for(int i=s.length-1;i>=0;i--){
			 if(i!=code){
				 
			 sb.append(s[i]);
			 
			 sb.append(",");
			 
			 }
		 }
		 
		 String s1=null;
		s1 =sb.toString();
		if(s1.endsWith(",")){
			char c[]=s1.toCharArray();
			c[s1.length()-1]='\u0020';
			s1=new String(c);
		}
		s1=s1.trim();
		CSVFile.write(s1);
		CSVFile.newLine();	 
		System.out.println();
		numOfRowsRead++;
		dataRow = PSVFile.readLine();
		
		}
		
		
		System.out.println("Total number of Reading colomns --->"+numOfColRead);
		System.out.println("Total number of output coloumns ------->"+numOfColOutput);
		System.out.println("Total no of psv rows(Input file) and output number of rows(csv rows)---->"+numOfRowsRead);
		if(numOfColOutput!=numOfColRead){
			System.out.println("The removed column name is------>"+columnName);
		}else{
			System.out.println("The give column is ------>"+columnName+"<------is not avilable in the .psv file");
		}
	}catch(FileNotFoundException f){
		f.printStackTrace();
	}catch (IOException e) {
	
	}finally{
		try {
			if(PSVFile!=null){
			PSVFile.close();
			}
			if(CSVFile!=null){
				CSVFile.close();}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}
	
	
}

