package IP;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
public static void main(String[] args) {
  String filePath = "/Users/aminhosseininejad/Documents/ToDoLIst.csv";
  
//  System.out.println("starting write user.csv file: " + filePath);
//  writeCsv(filePath);
  
  System.out.println("starting to read ToDoLIst.csv file"+ filePath);
  readCsv(filePath);
 }
 
 public static void writeCsv(String filePath) {
	 
//building objects of Task class
//  Task task1 = new Task("Buy a cake","20/08/2019","toDo");
//  Task task2 = new Task("Clean up the kitchen","18/08/2019","done");
//  Task task3 = new Task("Wash the car","20/08/2019","toDo");
//  Task task4 = new Task("Vacuum the car","20/08/2019","done");
//  Task task5 = new Task("Polish the car","20/08/2019","toDo");
//  Task task6 = new Task("Redecorate the kitchen","19/08/2019","done");
//  Task task7 = new Task("Buy a present","21/08/2019","toDo");
//  Task task8 = new Task("Decorate the saloon","23/08/2019","toDo");
//  Task task9 = new Task("Redocorate the kitchen","20/08/2019","toDo");
//  Task task10 = new Task("Clean up the kitchen","21/08/2019","toDo");
  
//  TaskReg tasks=new TaskReg();
  
  //Adding Task objects to the task registry
//  tasks.addTasks(task1);
//  tasks.addTasks(task2);
//  tasks.addTasks(task3);
//  tasks.addTasks(task4);
//  tasks.addTasks(task5);
//  tasks.addTasks(task6);
//  tasks.addTasks(task7);
//  tasks.addTasks(task8);
//  tasks.addTasks(task9);
//  tasks.addTasks(task10);
  
  
//building objects of Project class
//  Project project1=new Project("Car","20/08/2019","toDo");
//  Project project2=new Project("Kitchen","19/08/2019","done");
//  Project project3=new Project("Kitchen","21/08/2019","toDo");
//  Project project4=new Project("Birthday","23/08/2019","toDo");
//  
//  ProjectReg projects=new ProjectReg();
  
//Adding Task objects to the task registry
//  projects.addTasks(project1);
//  projects.addTasks(project2);
//  projects.addTasks(project3);
//  projects.addTasks(project4);
  
//Assigning tasks to projects
// task1.setConstituter(project4);
// task2.setConstituter(project2);
// task3.setConstituter(project1);
// task4.setConstituter(project1);
// task5.setConstituter(project1);
// task6.setConstituter(project2);
// task7.setConstituter(project4);
// task8.setConstituter(project4);
// task9.setConstituter(project3);
// task10.setConstituter(project3);
// 
// project1.addTaskProject(task3);
// project1.addTaskProject(task5);
// project1.addTaskProject(task4);
// project2.addTaskProject(task2);
// project2.addTaskProject(task6);
// project3.addTaskProject(task9);
// project3.addTaskProject(task10);
// project4.addTaskProject(task1);
// project4.addTaskProject(task7);
// project4.addTaskProject(task8);
 
 public static void readCsv(String filePath) {
  BufferedReader reader = null;
  
  try {
   List<Task> tasks = new ArrayList<Task>();
   List<Project> projects = new ArrayList<Project>();
   String line = "";
   reader = new BufferedReader(new FileReader(filePath));
   reader.readLine();
   
   while((line = reader.readLine()) != null) {
    String[] fields = line.split("\t");
    
   if(fields.length > 0 && fields[0].charAt(0)=='T') {
     Task task = new Task(taskTitle,taskDueDate,taskStatus);
     task.setTaskId(fields[0]);
     task.setTaskTitle(fields[1]);
     task.setTaskDueDate(fields[2]);
     task.setTaskStatus(fields[3]);
     tasks.add(task);
    }
   else if(fields.length > 0 && fields[0].charAt(0)=='P') {
	   Project project = new Project(taskTitle,taskDueDate,taskStatus);
	   project.setProjectId(fields[0]);
	   project.setProjectTitle(fields[1]);
	   project.setProjectDueDate(fields[2]);
	   project.setProjectStatus(fields[3]);
	     projects.add(project);
   }
   
   for(Task t: tasks) {
    System.out.printf("[taskId=%s, taskTitle=%s, taskDueDate=%s, taskStatus=%s]\n", t.getTaskId(), t.getTaskTitle(), t.getTaskDueDate(), t.getTaskStatus());
   }
   
   for(Project p: projects) {
	    System.out.printf("[taskId=%s, taskTitle=%s, taskDueDate=%s, taskStatus=%s]\n", t.getTaskId(), t.getTaskTitle(), t.getTaskDueDate(), t.getTaskStatus());
	   }
   }
  } catch (Exception ex) {
   ex.printStackTrace();
  } finally {
   try {
    reader.close();
   } catch (Exception e) {
    e.printStackTrace();
   }
  }
  
 }
 FileWriter fileWriter = null;
 try {
  fileWriter = new FileWriter(filePath);
  
  fileWriter.append("taskId, taskTitle, taskDueDate,taskStatus\n");
  for(User u: users) {
   fileWriter.append(String.valueOf(u.getId()));
   fileWriter.append("\t");
   fileWriter.append(u.getFirstName());
   fileWriter.append("\t");
   fileWriter.append(u.getLastName());
   fileWriter.append("\n");
  }
 } catch (Exception ex) {
  ex.printStackTrace();
 } finally {
  try {
   fileWriter.flush();
   fileWriter.close();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}
	}

}
