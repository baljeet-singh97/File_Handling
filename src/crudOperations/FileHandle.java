package crudOperations;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//created class takinginputs to take all the location of file and data for the file from the user
class takinginputs
{
	Scanner sc = new Scanner(System.in);
	//FilLocation return type, method to ask user for location of file for creating
	//new file or if user want to append data to file
	public String filLocation()
	{
		System.out.println("enter complete path of text file. ");
		System.out.println("Eg: - D:\\NewFileName.txt");
		String loc = sc.nextLine();
		return loc;
	}
	//userData return type method, to get the data from the user to append to the file
	public String userData()
	{
		System.out.println("Write Something.");
		String str = sc.nextLine();
		return str;
	}
}

//CreateFile Class to create new text file
class CreateFile
{
	//create method with exception handling
	public void create()  throws IOException
	{
		//creating object for takinginputs class
		takinginputs obj = new takinginputs();
		//calling filLoaction method to get the location
		FileOutputStream out= new FileOutputStream(obj.filLocation());
		//calling userData method to get data of the user.
		String input = obj.userData();
		byte array[]=  input.getBytes();
		//writing data to txt file
		out.write(array);
		System.out.println("Data Written Successfully");
		out.close();
	}
	
}

//class readfile if user want to read file this function will be called
class ReadFile
{
	//created object for taking inputs
	takinginputs obj = new takinginputs();
	public void read() throws IOException
	{
		//getting location of file user want to read
		FileInputStream stream= new FileInputStream(obj.filLocation());
		int data;
		//reading the whole text file and output the text.
		while((data=stream.read())!=-1)
		{
			
			System.out.print((char)data);
		}
		System.out.println("\n--- End of file ---");
	}
}

//class AppendFile if user want to add new data to the file.
class AppendFile
{
	//creating object for the calss takinginputs
	takinginputs obj = new takinginputs();
	public void appendText() throws IOException
	{
		//getting location where the file is present 
		String path = obj.filLocation();
		FileWriter fw = new FileWriter(path, true);
		fw.write(" "+obj.userData());
		fw.close();
		System.out.println("\nText Successfull Added.");
	}
}

public class FileHandle {
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("select an option. \n 1.Create & Write \n 2.Read \n 3.Append");
		
		//getting input from user
		int option = sc.nextInt();
		
		//switching to specified case
		switch(option)
		{
		case 1:
		{
			//creating object for class createFile
			CreateFile obj = new CreateFile();
			//using Exception handling to deal with exceptions
			try 
			{
				//calling create method
				obj.create();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("Wrong directory, change location. \n");
				e.printStackTrace();
			}
			break;
		}
		case 2:
		{
			//creating object for class ReadFile
			ReadFile obj = new ReadFile();
			//using Exception handling to deal with exceptions
			try 
			{
				//calling read method
				obj.read();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("file not found");
				//e.printStackTrace();
			}
			break;
		}
		case 3:
		{
			//creating object for class AppendFile
			AppendFile obj = new AppendFile();
			//using Exception handling to deal with exceptions
			try 
			{
				//calling append method
				obj.appendText();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				System.out.println("file not found");
				//e.printStackTrace();
			}
			break;
		}
			
		}
	}
}
