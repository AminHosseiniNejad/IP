package IP;

import java.util.ArrayList;

public class TaskReg {

	private ArrayList<Task> tasks = new ArrayList<Task>();

	public TaskReg() {
		this.tasks = tasks;
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
	public boolean notUnique(String taskId) {
		for (Task tmpTask : this.getTasks()) {
			if (tmpTask.getTaskId().equals(taskId)) {
				return true;
			}
		}
		return false;
	}

	// finding tasks on the task registry by taskId
	public Task findTaskByTaskId(String taskId) {
		for (Task tmpTask : this.getTasks()) {
			if (tmpTask.getTaskId().equals(taskId)) {
				return tmpTask;
			}
		}
		return null;
	}

	// removing tasks on the task registry by taskId
	public void removeTaskByTaskId(String taskId) {
		this.getTasks().remove(this.getTasks().indexOf(this.findTaskByTaskId(taskId)));
	}

	// editing task title by taskId
	public void editTaskTitleByTaskId(String taskId, String newTaskTitle) {
		this.findTaskByTaskId(taskId).setTaskTitle(newTaskTitle);
	}

	// editing task due date by taskId
	public void editTaskDueDateByTaskId(String taskId, String newTaskDueDate) {
		this.findTaskByTaskId(taskId).setTaskDueDate(newTaskDueDate);
	}

	// editing task status by taskId
	public void editTaskStatusByTaskId(String taskId, String newTaskStatus) {
		this.findTaskByTaskId(taskId).setTaskStatus(newTaskStatus);
	}

	// marking task as Done
	public void markTaskAsDone(String taskId) {
		this.findTaskByTaskId(taskId).setTaskStatus("done");
	}

}
