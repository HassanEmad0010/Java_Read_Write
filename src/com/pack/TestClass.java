package com.pack;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestClass  {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		ReadWriteClass readWriteObject =new ReadWriteClass();

		StudentModel std = new StudentModel();
		Professor prof=new Professor();

		char type = 0;
		char choice = 'a';
		String query;
		String path;
		boolean exit=false;

		do
		{
			System.out.println("If you are a professor enter P \n" +
					"if you are a student enter S \n"
					+ "To exit enter 0 \n ");

			type= input.next().charAt(0);


			if (type=='s'||type=='S')
			{
				path="F:\\Cources\\java_udemy\\student.txt";

				do
				{
					ReadWriteClass.systemOutHellow("Student");
					try {
						choice= input.next().charAt(0);
						switch(choice)
						{
						case '1':
							try {
								System.out.println(" Entering your Data! ");
								ArrayList<Object>arr= readWriteObject.readMethod(path);
								
								int genID= ReadWriteClass.generateId(arr,path);
								std.setId(genID);
								
								
								
								System.out.println("Your First Name? "); std.setFirstName(input.next());
								System.out.println("Your Last Name? "); std.setLastName(input.next());
								System.out.println("Your Department ? "); std.setDepartment(input.next());
								System.out.println("Your GPA? ");  std.setGpa(Double.parseDouble(input.next()) );
								query= std.getId()+" "+std.getFirstName()+" "+std.getLastName()+" "+std.getDepartment()+" "+std.getGpa();
								readWriteObject.writeMethod(query, path, true)	;
							} catch (InputMismatchException entIdExp)
							{
								System.out.println("Exception found: "+entIdExp.toString());
							}
							break; 

						case '2':

							ArrayList<Object>arr= readWriteObject.readMethod(path);
							ArrayList<StudentModel> stdArr= (ArrayList<StudentModel>) (Object) arr;
							System.out.println(stdArr.size());

							for(int i=0; i<stdArr.size();i++)
							{
								System.out.println(stdArr.get(i).toString());
							}
							break;

						case '3':
							try {
							System.out.println("Enter the id to search: ");
							int inputSearch= input.nextInt();						

							int searchIndex=readWriteObject.searchPerson(path, inputSearch);


							if(searchIndex == -1 || searchIndex== -2)
							{
								System.out.println("Can't find data with id= "+inputSearch );

							}
							else
							{
								System.out.println("index is " + searchIndex);
								readWriteObject.findDataByIndex(searchIndex, path);

							}
							}
						 catch (InputMismatchException entIdExp)
						{
							System.out.println("Exception found: "+entIdExp.toString());
						}

							break;

						case '4': 
							System.out.println("Going back.......");
							choice='0';	
							break;

						case '0':
							choice='0';
							exit=true;
							System.out.println("Exitting.......");
							break;

						default:
							System.out.println("Wrong input, try again! ");
							break;


						}




					}
					catch(NumberFormatException e)
					{
						System.out.println("Error in number Frmatting:- "+e.toString());

					}












				}
				while(choice !='0');
			}
			else if (type=='p'||type=='P')
			{
				path="F:\\Cources\\java_udemy\\professor.txt";

				do
				{

					ReadWriteClass.systemOutHellow("Professor");
					try {
						choice= input.next().charAt(0);



						switch(choice)
						{
						case '1':
							try {
								System.out.println(" Entering your Data! ");
								ArrayList<Object>arr= readWriteObject.readMethod(path);
							int genID= ReadWriteClass.generateId(arr,path);
								prof.setId(genID);
								
								System.out.println("Your First Name? "); prof.setFirstName(input.next());
								System.out.println("Your Last Name? "); prof.setLastName(input.next());
								System.out.println("Your Department ? "); prof.setDepartment(input.next());
								System.out.println("Your Salary? ");  prof.setSalary(Double.parseDouble(input.next()) );
								query= prof.getId()+" "+prof.getFirstName()+" "+prof.getLastName()+" "+prof.getDepartment()+" "+prof.getSalary();
								readWriteObject.writeMethod(query, path, true)	;
							} catch (InputMismatchException entIdExp)
							{
								System.out.println("Exception found: "+entIdExp.toString());
							}
							break; 

						case '2':

							ArrayList<Object>arr= readWriteObject.readMethod(path);
							ArrayList<Professor> profArr= (ArrayList<Professor>) (Object) arr;
							System.out.println(profArr.size());

							for(int i=0; i<profArr.size();i++)
							{
								System.out.println(profArr.get(i).toString());
							}

							break;
						case '3':
							System.out.println("Enter the id to search: ");
							try {
								int inputSearch= input.nextInt();
								int searchIndex= readWriteObject.searchPerson(path, inputSearch);
								if(searchIndex == -1 || searchIndex== -2)
								{
									System.out.println("Cant find data with id= "+inputSearch );
								}
								else
								{
									System.out.println("index is " + searchIndex);
									readWriteObject.findDataByIndex(searchIndex, path);
								}
							}
							catch (InputMismatchException entIdExp)
							{
								System.out.println("Exception found: "+entIdExp.toString());
							}

							break;

						case '4':
							choice='0';
							System.out.println("Going back.......");




							break;


						case '0': 
							choice ='0';
							exit=true;
							System.out.println("Exitting.......");

							break;
						default:
							System.out.println("Wrong input, try again! ");

							break;
						}

					}

					catch(NumberFormatException e1)
					{
						System.out.println("Error in number formatting:- "+e1.toString());

					}













				}
				while(choice !='0');


			}

			else if(type =='0')
			{
				exit = true;
				System.out.println("Exitting......");

			}

			else {

				System.out.println("Wrong input, try again: ");


			}


		}
		while(!exit);









	}

















}
