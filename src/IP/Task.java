package IP;

//importing Random class to generate random numbers
import java.util.Random;

public class Task {

	// creating an object of the TaskReg class in that the notUnique method could be
	// reached in this class
	TaskReg tasks = new TaskReg();

	Random random = new Random();

	// Defining the attributes in the Task class
	private String taskId;
	private String taskTitle;
	private String taskDueDate;
	private String taskStatus;

	// Defining association with Project class
	private Project constituter;

	// the constructor
	public Task(String taskTitle, String taskDueDate, String taskStatus) {

		this.taskTitle = taskTitle;
		this.taskDueDate = taskDueDate;
		this.taskStatus = taskStatus;
		// creating a unique taskId by random numbers and checking if there is already
		// such an taskId in the TaskReg class
		boolean find = false;
		while (find ==false) {
			do {

				taskId = "Task-" + String.valueOf(random.nextInt(100) + 1);
			} while (tasks.nonUniqueTaskId(taskId));
			if (tasks.nonUniqueTaskId(taskId)) {
				find = false;
			} else {
				find = true;
			}
		}

	}

	// The getters and setters

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDueDate() {
		return taskDueDate;
	}

	public void setTaskDueDate(String taskDueDate) {
		this.taskDueDate = taskDueDate;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Project getConstituter() {
		return constituter;
	}

	public void setConstituter(Project constituter) {
		this.constituter = constituter;
	}
}
