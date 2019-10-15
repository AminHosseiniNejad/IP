package IP;

import java.util.ArrayList;
public class ProjectReg {
		private ArrayList<Project> projects = new ArrayList<Project>();

		public ProjectReg() {
			this.projects = projects;
		}

		public ArrayList<Project> getProjects() {
			return projects;
		}

		public void setProjects(ArrayList<Project> projects) {
			this.projects = projects;
		}

		// adding projects to a project registry
		public void addTasks(Project aProject) {
			this.getProjects().add(aProject);
		}

		// checking if a projectId is unique on the project registry
		public boolean notUnique(String projectId) {
			for (Project tmpProject : this.getProjects()) {
				if (tmpProject.getProjectId().equals(projectId)) {
					return true;
				}
			}
			return false;
		}

		// finding projects on the task registry by projectId
		public Project findProjectByProjectId(String projectId) {
			for (Project tmpProject : this.getProjects()) {
				if (tmpProject.getProjectId().equals(projectId)) {
					return tmpProject;
				}
			}
			return null;
		}

		// removing projects on the project registry by projectId
		public void removeProjectByProjectId(String projectId) {
			this.getProjects().remove(this.getProjects().indexOf(this.findProjectByProjectId(projectId)));
		}

		// editing project title by projectId
		public void editProjectTitleByProjectId(String projectId, String newProjectTitle) {
			this.findProjectByProjectId(projectId).setProjectTitle(newProjectTitle);
		}

		// editing project due date by projectId
		public void editProjectDueDateByProjectId(String projectId, String newProjectDueDate) {
			this.findProjectByProjectId(projectId).setProjectDueDate(newProjectDueDate);
		}

		// editing project status by projectId
		public void editProjectStatusByProjectId(String projectId, String newProjectStatus) {
			this.findProjectByProjectId(projectId).setProjectStatus(newProjectStatus);
		}

		// marking the project as Done
		public void markProjectAsDone(String projectId) {
			this.findProjectByProjectId(projectId).setProjectStatus("done");
		}

	}


