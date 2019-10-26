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

//Using Switch method for the user to be able go on with one of the options
				switch (option) {
				
				case 1:// Show Task List (by date or project)
					System.out.println("Determine if the tasks are to be sorted by (1)date or by (2)project:");
					int sortedTask = scan.nextInt();
					// nested switch
					switch (sortedTask) {
					case 1:// sorting tasks by their due dates
						System.out.println("The tasks list sorted by date is as below:");
						for (int i = 0; i < tasks.sortTasksDueDate().size(); i++) {

							String sortedDate = formatter.format(tasks.sortTasksDueDate().get(i));
							System.out.println(sortedDate + ":");
							for (int j = 0; j < tasks.findTaskListByDuedate(sortedDate).size(); j++) {
								System.out.println(tasks.findTaskListByDuedate(sortedDate).get(j).getTaskId());
							}
						}
						quit = false;
						break;

					case 2:// sorting tasks by their projects
						System.out.println("The tasks list sorted by their projects is as below:\n");
						ArrayList<String> sortedProjectIdList = new ArrayList<String>();
						for (Project tmpProject: projects.getProjects()) {
							sortedProjectIdList.add(tmpProject.getProjectId());
						}
						
						Collections.sort(sortedProjectIdList);
						
						for (String sortedProjectId: sortedProjectIdList) {
							System.out.println(sortedProjectId + ":");
							
							Project tmpoProject = projects.findProject(sortedProjectId);
							for (Task aTask: tmpoProject.getTasksProject()) {
								System.out.println(aTask.getTaskId());
							}

						}
						quit = false;
						break;

					}
					break;
				case 2:// Add New Task

					System.out.println("Enter the task title:");
					String newTaskTitle = reader.readLine();
					System.out.println("Enter the task due date:");
					String newTaskDueDate = reader.readLine();

					Task newTask = new Task(newTaskTitle, newTaskDueDate, "toDo");
					tasks.addTasks(newTask);
					System.out.println("Add the new task to (1) an existing project OR (2) a new project:");
					int taskInProject = scan.nextInt();

					// nested switch
					switch (taskInProject) {
					case 1:// adding the task to the existing projects

						System.out.println("Which project(specified by projectId) do you want to add the task to? ");
						for (Project project : projects.getProjects()) {
							System.out.print(project.getProjectId() + "\t");
						}

						System.out.println("");
						String projectId = reader.readLine();

						for (Project tmpProject : projects.getProjects()) {
							if (tmpProject.getProjectId().equals(projectId)) {
								tmpProject.addTaskProject(newTask);
								newTask.setConstituter(tmpProject);
							}
						}
						quit = false;
						break;

					case 2:// adding the task to a new project
						System.out.println("Enter the project title:");
						String newProjectTitle = reader.readLine();
						System.out.println("Enter the project due date:");
						String newProjectDueDate = reader.readLine();

						Project newProject = new Project(newProjectTitle, newProjectDueDate, "toDo");
						projects.addProjects(newProject);

						newTask.setConstituter(newProject);
						newProject.addTaskProject(newTask);

						quit = false;
						break;
					}
					break;

				case 3:// Edit Task(update,mark as done,remove)
					System.out.println("Enter 1 to update, 2 to mark as done, and 3 to remove a task:");
					int editOption = scan.nextInt();

					switch (editOption) {
					case 1:// update a task
						System.out.println("Enter 1 to update the task title, 2 to update the task due date, and 3"
								+ " to update the task status:");
						int updateOption = scan.nextInt();

						System.out.println("Enter the taskId of the task that you want to update:");
						for (Task t : tasks.getTasks()) {
							System.out.print(t.getTaskId() + "\t");
						}
						System.out.println("");
						switch (updateOption) {
						case 1:// update the task title

							String selectedtaskId = reader.readLine();
							System.out.println("Enter the new task title:");
							String aNewTaskTitle = reader.readLine();
							tasks.editTaskTitle(selectedtaskId, aNewTaskTitle);

							quit = false;
							break;

						case 2:// update the task due date
//							System.out.println("Enter the taskId of the task that you want to update:");
							String selectedtaskId2 = reader.readLine();
							System.out.println("Enter the new task due date:");
							String aNewTaskDueDate = reader.readLine();
							tasks.editTaskDueDate(selectedtaskId2, aNewTaskDueDate);
							quit = false;
							break;

						case 3:// update the task status
//							System.out.println("Enter the taskId of the task that you want to update:");
							String selectedtaskId3 = reader.readLine();
							System.out.println("Enter the new task status:");
							String newTaskStatus = reader.readLine();
							tasks.editTaskStatus(selectedtaskId3, newTaskStatus);

							quit = false;
							break;
						}
						break;

					case 2:// mark a task as done
						System.out.println("Enter the taskId of the task that you want to mark as done:");
						for (Task t : tasks.getTasks()) {
							System.out.print(t.getTaskId() + "\t");
						}
						System.out.println("");

						String markedTaskId = reader.readLine();
						tasks.markTaskAsDone(markedTaskId);
						break;

					case 3:// remove a task
						System.out.println("Enter the taskId of the task that you want to remove:");
						for (Task t : tasks.getTasks()) {
							System.out.print(t.getTaskId() + "\t");
						}
						System.out.println("");

						String removedTaskId = reader.readLine();
						tasks.removeTask(removedTaskId);

						// removing projects from the projects list if there is no more tasks in that
						// project
//						for(Project aProject: projects.getProjects()) {
//							boolean emptyProject = aProject.getTasksProject().isEmpty();
//							if(emptyProject == true) {
//								projects.removeProject(aProject.getProjectId());
//							}
//						}
						break;

					}

					quit = false;
					break;

				case 4:// save and quit

					/*
					 * write the data on the CSV file saved at "src/IP/ToDo.csv" to be able to save
					 * them while quitting the project
					 */
					readWriteCSV.writeCsv("src/IP/ToDo.csv");

					// quit
					System.exit(0);
					quit = true;
					break;
				}

			}
		} finally {
			scan.close();
		}
	}
}
