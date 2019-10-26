# ToDoList Application User's Manual
## Application Summary:
This application helps the users manage their to-do lists. They could define new tasks and new projects, and assign the tasks to the projects through the application. It also gives the user the possibility to sort all the tasks by their due dates or their projects. It also enables the users to edit, mark as done or remove tasks from the task list.
## How to get started:
To start the application, the user should click on `run` circled in the below picture:
  
![](https://docs.eyesopen.com/toolkits/java/_images/Eclipse-Run.PNG)
  
This will give the user the current status of the tasks and the menu discussed in the next session in details:
```
Welcome to ToDoList
You have X tasks to do and Y tasks are done!
Pick an option:
(1) Show Task List by
  (1.1) Due Date
  (1.2) Project
(2) Add New Task
(3) Edit Task
  (3.1) Update Task
  (3.2) Mark Task As Done
  (3.3) Remove Task
(4) Save and Quit
```

At the first step, the application counts the number of the tasks which are to do, *X*, and those that are already done, *Y*.
 ***
 ## Application Menu:
 ### (1) Show Task List:
 If the user needs to sort all the tasks by their due dates or their projects, they should type **1** and **Enter**. The application will ask them if they want the tasks to be sorted by their due dates or their projects by typing **1** or **2**, respectively.
 ```
 Determine if the tasks are to be sorted by (1)date or by (2)project:
 ```
 #### (1.1) Due Date:
 This will give the user the tasks sorted by their due dates, from the earliest one to the soonest one; since several tasks could have the same due dates, it is possible that a date contains more than one tasks on the list.
 #### (1.1) Project:
 This will give the user the tasks sorted by their projects.
 ### (2) Add New Task:
 If the user needs to create a new task and add it to the tasks list, they should type **2** at the begining and then **Enter**. Hence, they are asked to type the new task title and its due date. Afterwards, they are asked if they want to add the new task to an existing project or to create a new project for that task, which could be chosen by typing **1** or **2**, respectively.
 ```
 Add the new task to (1) an existing project OR (2) a new project:
 ```
 Follwing that, they are asked either to type the existing `project Id` or create a new projetc by asking for typing its *tilte* and *due date*.
 ### (3) Edit Task:
 By typing **3**, the user would have the possiblity to edit tasks. They will have 3 options:
  ```
  (3.1) Update Task
  (3.2) Mark Task As Done
  (3.3) Remove Task
  ```
  
 #### (3.1) Update Task:
 The user could update the task title, its due date or even its status, by typing **1**, **2** or **3**.
 #### (3.2) Mark Task As Done:
 By this option, the user could mark a task as *Done*.
 #### (3.3) Remove Task:
 It gives the user the possiblity to remove a task from the tasks list.
 ### (4) Save and Quit:
 If the user needs to quit the application, it will first save all the data and quit the *Running* state of the application. That could be done by typing **4** and **Enter** in the main menu. 
 
