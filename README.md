# File_Handling

Introduction:
This is an File handling code fully written JAVA. Using this
program user can do CRUD operations like Create file, Read
file, Update file, Delete from it.
Installation Guide:
1. GitHub link: https://github.com/baljeet-singh97/File_Handling
2. Download the entire project as Zip in local system.
3. import the project in Eclipse IDE
4. Go to src/arithmaticCalculator/arithmeticCalc.java and run the code

How to use:
1. After running the code you will see the window like:

2. Select an option (for eg: 1. Create file). Then program ask user to

enter the locatin where user want to create the file. After that user has

to enter the text to enter in the file. And after that fill will be created at
tha specified location.

Code Description:

Main Function:
• Creates an object of Scanner class
Scanner sc = new Scanner(System.in); .

• taking input from the user as string
String option = sc.nextLine()
Classes:

• created class “takinginputs” to take the location of file and data for
the file from the user.

Created return type methods for location and data separately
public String filLocation() return loc;
public String userData() return str

• created class “createFile” to create and write to the text file case 1
statement calls this method.

creating object for takinginputs class.
takinginputs obj = new takinginputs();

calling filLoaction method to get the location.
FileOutputStream out= new FileOutputStream(obj.filLocation());

calling userData method to get data of the user.
String input = obj.userData();

byte array[]= input.getBytes();

//writing data to txt file
out.write(array);

• created class “readFile” to all the reading will be done here, when
user calls a read class this class will be called.

//getting location of file user want to read.
FileInputStream stream= new FileInputStream(obj.filLocation());

//reading the whole text file and output the text.
while((data=stream.read())!=-1)
System.out.print((char)data);

• created class “AppendFile” to all the reading will be done here,
when user calls a read class this class will be called.

//creating object for the calss takinginputs
takinginputs obj = new takinginputs();

//getting location where the file is present
String path = obj.filLocation();
FileWriter fw = new FileWriter(path, true);

Writing to the file
fw.write(" "+obj.userData());
fw.close()