package com.pack;

import java.beans.Expression;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriteClass {

	public boolean writeMethod (String query, String filePath, Boolean appendType )
	{
		PrintWriter writter=null;
		

		try
		{
			System.out.println("writting in path: "+filePath+".....");

			writter = new PrintWriter(new FileWriter(new File (filePath), appendType));

			writter.println(query);
		

			System.out.println("Writting done");

			return true;
		}
		catch (Exception e)
		{
			writter.close();

			System.out.println("Error in writing is "+e.toString());
			return false;
		}
		finally {
			writter.close();
		}



	}	

	public ArrayList<Object> readMethod(String filePath)
	{
		
		ArrayList<Object>retArray=new ArrayList<Object>();

		
		StudentModel std;
		Professor prof;
		
		Scanner read = null;
		try {
			System.out.println("reading data.... "+filePath);
			read = new Scanner(new File(filePath));
		}

		catch(FileNotFoundException e)
		{
			System.out.println("error in finding file: "+e.toString());

		}
		if(filePath.contains("student.txt"))
		{
			ArrayList<StudentModel>arrayStudent=new ArrayList<StudentModel>();

		
		while(read.hasNext())
		{
			std=new StudentModel();
			
			
			String line= read.nextLine();
			//System.out.println("Data is : "+ line );
			
			String[] seperated;
			
			seperated= line.split(" ");
			std.setId(seperated[0]) ;
			std.setFirstName(seperated[1]); 
			std.setLastName(seperated[2] );
			std.setDepartment(seperated[3] );
			std.setGpa(Double.parseDouble(seperated[4])  );
			
			arrayStudent.add(std);
			//displayStudent(std);
			  
			 
		}
		retArray = (ArrayList<Object>) (Object) arrayStudent;
		}
		
		else if(filePath.contains("professor.txt"))
		{
			ArrayList<Professor>arrayProfessor=new ArrayList<Professor>();

			while(read.hasNext())
			{
				prof=new Professor();
				
				
				String line= read.nextLine();
				//System.out.println("Data is : "+ line );
				
				String[] seperated;
				
				seperated= line.split(" ");
				prof.setId(seperated[0]) ;
				prof.setFirstName(seperated[1]); 
				prof.setLastName(seperated[2] );
				prof.setDepartment(seperated[3] );
				prof.setSalary(Double.parseDouble(seperated[4]));
				
				arrayProfessor.add(prof);
				retArray= (ArrayList<Object>) (Object)  arrayProfessor;
				  
				 
			}
			
		}

		return retArray;


	}	
	
	
	public int searchPerson(String path,String searchID)
	{
		int returnIndex=-2;
		
		if (path.contains("student"))
		{
			ArrayList<Object>arr= readMethod( path );
			ArrayList<StudentModel> stdArr= (ArrayList<StudentModel>) (Object) arr;
			
			for (int i =0;i<stdArr.size() ;i++)
			{
			 if( stdArr.get(i).getId().contains(searchID) )
			 {

				 returnIndex=i;
				 //System.out.println("found index "+ returnIndex);
				 break;

			 }
			 else
			 {
				 returnIndex =-1;
			 }
			
			}

		}
		else if(path.contains("professor"))
		{
			ArrayList<Object>arr= readMethod( path );
			ArrayList<Professor> profArr= (ArrayList<Professor>) (Object) arr;
			
			for (int i =0;i<profArr.size() ;i++)
			{
			 if( profArr.get(i).getId().contains(searchID) )
			 {

				 returnIndex=i;
				 //System.out.println("found index "+ returnIndex);
				 break;

			 }
			 else
			 {
				 returnIndex =-1;
			 }
			
			}
			
		}
		else
		{
			 System.out.println("no student or prof ");	
		}		
		return returnIndex;
		
	}
	
	
	public void findDataByIndex(int index, String path)
	{
		ArrayList<Object> arr= readMethod(path);
		
		if(path.contains("student"))
		{
			ArrayList<StudentModel> stdArr= (ArrayList<StudentModel>) (Object) arr;
			 System.out.println("data is "+ stdArr.get(index) );
			 String outPath="F:\\Cources\\java_udemy\\searchOutStd.txt";
			 String query=stdArr.get(index).toString();
			 writeMethod(query, outPath, true);


			//stdArr.get(index).toString();	
		}
		
		else if (path.contains("professor"))
		{
			ArrayList<Professor> profArr= (ArrayList<Professor>) (Object) arr;
			 System.out.println("data is "+ profArr.get(index) );
			 String outPath="F:\\Cources\\java_udemy\\searchOutProf.txt";
			 String query=profArr.get(index).toString();
			 writeMethod(query, outPath, true);

			//stdArr.get(index).toString();	
		}
		else 
		{
			 System.out.println("No student or prof ");

		}
		
		
	}
	
	
	
	
	public static void systemOutHellow(String x)
	{
		 System.out.println("		         "
					+ "          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n"
					+ "    				  	 ~~~~~~~~~~ Hello " + x +" ~~~~~~~~~~ \n"
					+ "     				  ~~~~ To enter a new "+ x + " press ---------------> (1) \n"
					+ "     				  ~~~~ To display all " +x+"s data press-----------> (2) \n"
					+ "     				  ~~~~ To search press------------------------------> (3) \n"
					+ "     				  ~~~~ To go back press-----------------------------> (4) \n"
					+ "     				  ~~~~ To exit press--------------------------------> (0) \n"
					+ "       			          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n"
					);
		
	}
	
	

	/*
	 * public ArrayList<Object> readMethod(String filePath) {
	 * 
	 * 
	 * 
	 * StudentModel std; Professor prof;
	 * 
	 * Scanner read = null; try { System.out.println("reading data.... ");
	 * 
	 * 
	 * read = new Scanner(new File(filePath)); }
	 * 
	 * catch(FileNotFoundException e) {
	 * System.out.println("error in finding file: "+e.toString());
	 * 
	 * } if(filePath.equals("student.txt")) {
	 * ArrayList<StudentModel>arrayStudent=new ArrayList<StudentModel>();
	 * 
	 * 
	 * while(read.hasNext()) { std=new StudentModel();
	 * 
	 * 
	 * String line= read.nextLine(); //System.out.println("Data is : "+ line );
	 * 
	 * String[] seperated;
	 * 
	 * seperated= line.split(" "); std.setId(seperated[0]) ;
	 * std.setFirstName(seperated[1]); std.setLastName(seperated[2] );
	 * std.setDepartment(seperated[3] ); std.setGpa(Double.parseDouble(seperated[4])
	 * );
	 * 
	 * arrayStudent.add(std); //displayStudent(std);
	 * 
	 * 
	 * } return (ArrayList<Object>) (Object) arrayStudent; }
	 * 
	 * else if(filePath.equals("professor.txt")) {
	 * ArrayList<Professor>arrayProfessor=new ArrayList<Professor>();
	 * 
	 * while(read.hasNext()) { prof=new Professor();
	 * 
	 * 
	 * String line= read.nextLine(); //System.out.println("Data is : "+ line );
	 * 
	 * String[] seperated;
	 * 
	 * seperated= line.split(" "); prof.setId(seperated[0]) ;
	 * prof.setFirstName(seperated[1]); prof.setLastName(seperated[2] );
	 * prof.setDepartment(seperated[3] );
	 * prof.setSalary(Double.parseDouble(seperated[4]));
	 * 
	 * arrayProfessor.add(prof); return (ArrayList<Object>) (Object) arrayProfessor;
	 * 
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return null;
	 * 
	 * 
	 * }
	 */
	
	
	
	
	
	
/*	public static void displayStudent (ArrayList<StudentModel> arraySearch)
	
	{
		
		
		  System.out.println("ID is "+std.getId() );
		  System.out.println("first name is "+std.getFirstName() );
		  System.out.println("second name is "+std.getLastName() );
		
	}
	
	*/
	




}
