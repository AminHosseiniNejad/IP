package IP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class TaskReg {

	private ArrayList<Task> tasks;

	

	public TaskReg() {
	this.tasks = new ArrayList<Task>();
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	// adding tasks to a task registry
	public void addTasks(Task aTask) {
		this.getTasks().add(aTask);
	}

	// checking if a taskId is unique on the task registry
	public boolean nonUniqueTaskId(String taskId) {
		for (Task tmpTask : this.getTasks()) {
			if (tmpTask.getTaskId().equals(taskId)) {
				return true;
			}																																																																																																																																																																																													
		}
		return false;
	}

	// finding tasks on the task registry by taskId
	public Task findTask(String taskId) {
		for (Task tmpTask : this.getTasks()) {
			if (tmpTask.getTaskId().equals(taskId)) {
				return tmpTask;
			}
		}
		return null;
	}

	// removing tasks on the task registry by taskId
	public void removeTask(String taskId) {
		this.getTasks().remove(this.getTasks().indexOf(this.findTask(taskId)));
	}

	// editing task title by taskId
	public void editTaskTitle(String taskId, String newTaskTitle) {
		this.findTask(taskId).setTaskTitle(newTaskTitle);
	}

	// editing task due date by taskId
	public void editTaskDueDate(String taskId, String newTaskDueDate) {
		this.findTask(taskId).setTaskDueDate(newTaskDueDate);
	}

	// editing task status by taskId
	public void editTaskStatus(String taskId, String newTaskStatus) {
		this.findTask(taskId).setTaskStatus(newTaskStatus);
	}

	// marking task as Done
	public void markTaskAsDone(String taskId) {
		this.findTask(taskId).setTaskStatus("done");
	}
//finding the list of the tasks with the same due date
	public ArrayList<Task> findTaskListByDuedate(String taskDueDate){
		ArrayList<Task> tasksByDueDate = new ArrayList<Task>();
		for (int i=0;i<this.getTasks().size();i++) {
			if(this.getTasks().get(i).getTaskDueDate().equals(taskDueDate)) {
			tasksByDueDate.add(this.getTasks().get(i));
		}
		}
		return tasksByDueDate;
	}	
		
//Counting the number of the tasks which are to do
	public int countToDoTask() {
		int counterToDo = 0;
		for (int i = 0; i < this.getTasks().size(); i++) {
			if (this.getTasks().get(i).getTaskStatus().equals("toDo")) {
				counterToDo += 1;
			}
		}
		return counterToDo;
	}

// Sorting tasks by date
	public ArrayList<Date> sortTasksDueDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		TreeSet<Date> tree = new TreeSet<Date>();
		ArrayList<Date> dates = new ArrayList<Date>();
		ArrayList<Date> newDates = new ArrayList<Date>();
		
		for (int i = 0; i < this.getTasks().size(); i++) {
			try {
				dates.add(dateFormatter.parse(this.getTasks().get(i).getTaskDueDate()));

			}catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "It cannot be parsed as a date!");
			}
		}
		Collections.sort(dates);

		// Using TreeSet class to eliminate repeated dates on the list of task due dates
		for (int k = 0; k < dates.size(); k++) {
			tree.add(dates.get(k));
		}

		Date [] datesArray = new Date[tree.size()];
		tree.toArray(datesArray);

		for (int j = 0; j < datesArray.length; j++) {
			newDates.add(datesArray[j]);
		}
		return newDates;
	}
}

