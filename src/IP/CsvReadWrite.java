package IP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


import javax.swing.JOptionPane;

public class CsvReadWrite {
	String filePath;//the attribute
	
	//making objects of TaskReg and ProjectReg classes
	private TaskReg tasks;
	private ProjectReg projects;
	
	public CsvReadWrite(String filePath,TaskReg tasks,ProjectReg projects) {//the constructor
		this.filePath=filePath ;
		this.tasks=tasks;
		this.projects=projects;
	}

	// Read CSV file method
	public void readCsv(String filePath) {
		BufferedReader reader = null;

		try {
			String line="";
			reader = new BufferedReader(new FileReader(filePath));

			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				
				if (fields.length > 0 && fields[0].charAt(0) == 'P') {
					Project project = new Project(fields[1], fields[2], fields[3]);
					project.setProjectId(fields[0]);
					
					projects.addProjects(project);
				}
				else if (fields.length > 0 && fields[0].charAt(0) == 'T') {
					Task task = new Task(fields[1], fields[2], fields[3]);
					task.setTaskId(fields[0]);
					for (Project tmProject:projects.getProjects()) {
						if(tmProject.getProjectId().equals(fields[4])) {
							task.setConstituter(tmProject);
							tmProject.addTaskProject(task);
					}
					}
					tasks.addTasks(task);}
			
		}
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "The csv file is not readable!");
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Write CSV file method
	public void writeCsv(String filePath) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(filePath);

			

			// writing the projects data in the CSV file
			for (Project p : projects.getProjects()) {
				System.out.println("");
				fileWriter.append(p.getProjectId());
				fileWriter.append(",");
				fileWriter.append(p.getProjectTitle());
				fileWriter.append(",");
				fileWriter.append(p.getProjectDueDate());
				fileWriter.append(",");
				fileWriter.append(p.getProjectStatus() + "\n");
			}
			// writing the tasks data in the CSV file
						for (Task t : tasks.getTasks()) {
							fileWriter.append(t.getTaskId());
							fileWriter.append(",");
							fileWriter.append(t.getTaskTitle());
							fileWriter.append(",");
							fileWriter.append(t.getTaskDueDate());
							fileWriter.append(",");
							fileWriter.append(t.getTaskStatus());
							fileWriter.append(",");
							fileWriter.append(t.getConstituter().getProjectId()+"\n");
						}
		} catch (Exception ex) {
			ex.printStackTrace();
//			JOptionPane.showMessageDialog(null, "The data is not writable on the CSV file!");
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