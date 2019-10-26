package IP;

//importing Random class to generate random numbers
import java.util.Random;

//importing ArrayList class
import java.util.ArrayList;

public class Project {

	// creating an object of the ProjectReg class in that the notUnique method could
	// be reached in this class
	ProjectReg projects = new ProjectReg();

	Random random = new Random();

	// Defining the attributes in the Project class
	private String projectId;
	private String projectTitle;
	private String projectDueDate;
	private String projectStatus;
	private ArrayList<Task> tasksProject = new ArrayList<Task>();

	// the constructor
	public Project(String projectTitle, String projectDueDate, String projectStatus) {

		this.projectTitle = projectTitle;
		this.projectDueDate = projectDueDate;
		this.projectStatus = projectStatus;

		// creating a unique projectId by random numbers and checking if there is
		// already such an projectId in the ProjectReg class
		boolean find = false;
		while (find == false) {
			do {

				projectId = "Project-" + String.valueOf(random.nextInt(20) + 1);
			} while (projects.nonUniqueProjectId(projectId));
			if (projects.nonUniqueProjectId(projectId)) {
				find = false;
			} else {
				find = true;
			}
		}
	}

	// The getters and setters

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDueDate() {
		return projectDueDate;
	}

	public void setProjectDueDate(String projectDueDate) {
		this.projectDueDate = projectDueDate;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public ArrayList<Task> getTasksProject() {
		return tasksProject;
	}

	public void setTasksProject(ArrayList<Task> tasksProject) {
		this.tasksProject = tasksProject;
	}

	// adding tasks to a project
	public void addTaskProject(Task aTask) {
		this.getTasksProject().add(aTask);
	}

	// finding tasks related a project by taskId
	public Task findTasksProject(String taskId) {
		for (Task tmpTask : this.getTasksProject()) {
			if (tmpTask.getTaskId().equals(taskId)) {
				return tmpTask;
			}
		}
		return null;
	}

	// removing tasks related a project by taskId
	public void removeTasksProject(String taskId) {
		this.getTasksProject().remove(this.getTasksProject().indexOf(this.findTasksProject(taskId)));
	}

}
