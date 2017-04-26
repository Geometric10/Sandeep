package com.rbc.test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import com.rbc.ReadPsvFile;

public class ReadPsvTest {

	@Test
	public void test()  {
		//Input student.psv file
		try{
				String inputPsvFileName=null;
				String outputPsvFileName=null;
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter Input psvfile Name");
				inputPsvFileName=sc.next();
				String workinDir=System.getProperty("user.dir");
				inputPsvFileName=workinDir+"\\Resources\\"+inputPsvFileName;
				File psvFile=new File(inputPsvFileName);
			
				
				//output StudentOutput.psv file
				if(psvFile.exists()){
					System.out.println("Enter csv file to write the student details");
					outputPsvFileName=sc.next();
					outputPsvFileName=workinDir+"\\Resources\\"+outputPsvFileName;
				File csvFile=new File(outputPsvFileName);
				if(!csvFile.exists()){
					csvFile.createNewFile();
				}
				
				System.out.println("Enter the column name to remove from given .psv file");
				String columnName=sc.next();
				ReadPsvFile.reverseFile(psvFile,csvFile,columnName);
				}else{
					System.out.println("file does not exsits in the Resource folder,Enter valid file name");
				}
		}catch(IOException i){
			i.printStackTrace();
		}
		
	}

}
