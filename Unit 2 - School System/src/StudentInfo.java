import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentInfo {
	public static String scan;
	public static int i = 0;
	public static ArrayList<Student> studRec = new ArrayList<Student>();
	private static long idGenerator = 300000000;
	public static File f = new File("student.txt");

	public static void main(String[] args) throws InvalidInputException {

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			BufferedReader fbr = new BufferedReader(new FileReader("student.txt"));
			String lineInfo = fbr.readLine();
			while (lineInfo != null) {
				studRec.add(new Student());
				idGenerator++;
				studRec.get(studRec.size() - 1).setFirstName(fbr.readLine());
				studRec.get(studRec.size() - 1).setLastName(fbr.readLine());
				studRec.get(studRec.size() - 1).setStreetName(fbr.readLine());
				studRec.get(studRec.size() - 1).setCity(fbr.readLine());
				studRec.get(studRec.size() - 1).setProvince(fbr.readLine());
				studRec.get(studRec.size() - 1).setPostalCode(fbr.readLine());
				studRec.get(studRec.size() - 1).setPhoneNumber(fbr.readLine());
				studRec.get(studRec.size() - 1).setBirthdate(fbr.readLine());
				studRec.get(studRec.size() - 1).setStudentNumber(idGenerator);
				lineInfo = fbr.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		String run = ("true");
		while (run == "true") {
			System.out.println("Choose an option");
			System.out.println("");
			System.out.println("1.  Enter a new student");
			System.out.println("2.  Print a student's info");
			System.out.println("3.  Print all student's info");
			System.out.println("4.  Sort student info list");
			System.out.println("5.  Option 5");
			System.out.println("6.  Option 6");
			System.out.println("7.  Option 7");
			System.out.println("8.  Option 8");
			System.out.println("9.  Option 9");
			System.out.println("10. Quit");
			Scanner option = new Scanner(System.in);
			int optionInput = option.nextInt();

			switch (optionInput) {
			case 1:
				addStudent();
				break;
			case 2:
				printAStudent();
				break;
			case 3:
				printAllStudents();
				break;
			case 4:
				Collections.sort(studRec);
				System.out.println("Sorted!");
				break;
			case 5:
				System.out.println("Not available yet");
				System.out.println("");
				break;
			case 6:
				System.out.println("Not available yet");
				System.out.println("");
				break;
			case 7:
				System.out.println("Not available yet");
				System.out.println("");
				break;
			case 8:
				System.out.println("Not available yet");
				System.out.println("");
				break;
			case 9:
				System.out.println("Not available yet");
				System.out.println("");
				break;
			case 10:
				run = "false";
				System.out.println("Thank you for using my program!");
				return;
			}
		}
	}
	public static void addStudent() throws InvalidInputException {
		PrintStream fos;
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(f);
			fos = new PrintStream(fileOutputStream);

			studRec.add(new Student());
			Scanner scan = new Scanner(System.in);

			idGenerator++;
			studRec.get(studRec.size() - 1).setStudentNumber(idGenerator);

			System.out.print("Enter the student's first name: ");
			studRec.get(studRec.size() - 1).setFirstName(scan.nextLine());

			System.out.print("Enter the student's last name: ");
			studRec.get(studRec.size() - 1).setLastName(scan.nextLine());

			System.out.print("Enter the student's street name: ");
			studRec.get(studRec.size() - 1).setStreetName(scan.nextLine());

			System.out.print("Enter the student's city: ");
			studRec.get(studRec.size() - 1).setCity(scan.nextLine());

			System.out.print("Enter the student's province: ");
			studRec.get(studRec.size() - 1).setProvince(scan.nextLine());

			System.out.print("Enter the student's postal code: (EX: x#x x#x)");
			studRec.get(studRec.size() - 1).setPostalCode(scan.nextLine());

			System.out.print("Enter the student's phone number: (EX: ### ### ####)");
			studRec.get(studRec.size() - 1).setPhoneNumber(scan.nextLine());

			System.out.print("Enter the student's birthdate: (EX: dd/mm/yyyy)");
			studRec.get(studRec.size() - 1).setBirthdate(scan.nextLine());

			System.out.println("");
			System.out.println("What you have entered:");
			System.out.println(studRec.get(studRec.size() - 1).getFirstName());
			System.out.println(studRec.get(studRec.size() - 1).getLastName());
			System.out.println(studRec.get(studRec.size() - 1).getStreetName());
			System.out.println(studRec.get(studRec.size() - 1).getCity());
			System.out.println(studRec.get(studRec.size() - 1).getProvince());
			System.out.println(studRec.get(studRec.size() - 1).getPostalCode());
			System.out.println(studRec.get(studRec.size() - 1).getPhoneNumber());
			System.out.println(studRec.get(studRec.size() - 1).getBirthdate());
			System.out.println("");

			for (i = 0; i < studRec.size(); i++) // NO ; AFTER A FOR OR WHILE LOOP!!!
			{
				fos.println("----------");
				fos.println(studRec.get(i).getFirstName());
				fos.println(studRec.get(i).getLastName());
				fos.println(studRec.get(i).getStreetName());
				fos.println(studRec.get(i).getCity());
				fos.println(studRec.get(i).getProvince());
				fos.println(studRec.get(i).getPostalCode());
				fos.println(studRec.get(i).getPhoneNumber());
				fos.println(studRec.get(i).getBirthdate());
				fos.println(studRec.get(i).getStudentNumber());
			}
			fos.close();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printAStudent() throws InvalidInputException {

		System.out.print("Which student whould you like to print? (Student Number) ");
		Scanner  scan = new Scanner(System.in);
		int lookingStudNum = scan.nextInt();

		for (i = 0; i < studRec.size(); i++){
			studRec.get(i).getStudentNumber();
			if (i == lookingStudNum){
				System.out.println(studRec.get(i).getFirstName());
				System.out.println(studRec.get(i).getLastName());
				System.out.println(studRec.get(i).getStreetName());
				System.out.println(studRec.get(i).getCity());
				System.out.println(studRec.get(i).getProvince());
				System.out.println(studRec.get(i).getPostalCode());
				System.out.println(studRec.get(i).getPhoneNumber());
				System.out.println(studRec.get(i).getBirthdate());
				System.out.println(studRec.get(i).getStudentNumber());
				i = studRec.size() + 1;
				if (i < studRec.size()){
					System.out.println("Student not found");
				}
			}
		}
	}

	public static void printAllStudents() throws InvalidInputException {
		for (i = 0; i < studRec.size(); i++) // NO ; AFTER A FOR OR WHILE LOOP!!!
		{
			System.out.print(i + 1);
			System.out.println(". ");
			System.out.println("     " + studRec.get(i).getFirstName());
			System.out.println("     " + studRec.get(i).getLastName());
			System.out.println("     " + studRec.get(i).getStreetName());
			System.out.println("     " + studRec.get(i).getCity());
			System.out.println("     " + studRec.get(i).getProvince());
			System.out.println("     " + studRec.get(i).getPostalCode());
			System.out.println("     " + studRec.get(i).getPhoneNumber());
			System.out.println("     " + studRec.get(i).getBirthdate());
			System.out.println("     " + studRec.get(i).getStudentNumber());
			System.out.println("");
		}
	}
}