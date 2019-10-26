package IP;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ToDoList {
	public static void main(String[] args) throws IOException {

		boolean quit = false;

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		Scanner scan = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
		TaskReg tasks = new TaskReg();
		ProjectReg projects = new ProjectReg();
		CsvReadWrite readWriteCSV = new CsvReadWrite("src/IP/ToDo.csv", tasks, projects);

//read the predefined data on the CSV file saved at "src/IP/ToDo.csv" to test the methods
		readWriteCSV.readCsv("src/IP/ToDo.csv");

		try {
			while (quit == false) {
//Welcome message
				System.out.println("--------------------\nWelcome to ToDoList.");

//Determine how many of the tasks are to do and how many are done
				System.out.println("You have " + tasks.countToDoTask() + " tasks to do, and "
						+ (tasks.getTasks().size() - tasks.countToDoTask()) + " are done!");

//Putting multiple options for users to choose one of them

				System.out.println("Pick an option:");
				System.out.println("(1) Show Task List (by date or project)");
				System.out.println("(2) Add New Task");
				System.out.println("(3) Edit Task(update, mark as done, remove)");
				System.out.println("(4) Save and Quit");

				int option = scan.nextInt();

			}
		} finally {
			scan.close();
		}
	}
}
