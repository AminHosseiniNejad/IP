package IP;

import java.util.ArrayList;
public class ProjectReg {
		private ArrayList<Project> projects;
		

		public ProjectReg() {
			this.projects = new ArrayList<Project>();
		}

		public ArrayList<Project> getProjects() {
			return projects;
		}

		public void setProjects(ArrayList<Project> projects) {
			this.projects = projects;
		}
		// adding projects to a project registry
		public void addProjects(Project aProject) {
			this.getProjects().add(aProject);
		}

		// checking if a projectId is unique on the project registry
		public boolean nonUniqueProjectId(String projectId) {
			for (Project tmpProject : this.getProjects()) {
				if (tmpProject.getProjectId().equals(projectId)) {
					return true;
				}
			}
			return false;
		}

		// finding projects on the task registry by projectId
		public Project findProject(String projectId) {
			for (Project tmpProject : this.getProjects()) {
				if (tmpProject.getProjectId().equals(projectId)) {
					return tmpProject;
				}
			}
			return null;
		}

		// removing projects on the project registry by projectId
		public void removeProject(String projectId) {
			this.getProjects().remove(this.getProjects().indexOf(this.findProject(projectId)));
		}

	
		
}