
public class Task implements Priority {

	private int taskPriority;
	
	private String taskDescription = "Undescribed Task";
	
	//constructor accepting no arguments, sets lowest priority and leaves default description
	public Task() {
		taskPriority = Priority.LOWEST_PRIORITY;
	}
	
	//constructor accepting only a description, sets lowest priority
	public Task(String description) {
		taskPriority = Priority.LOWEST_PRIORITY;
		taskDescription = description;
	}
	
	//constructor accepting a priority and leaving default description
	public Task(int priority) {
		setPriority(priority);
	}
	
	//constructor accepting both a priority and a description
	public Task(int priority, String description) {
		setPriority(priority);
		taskDescription = description;
	}
	
	//accessor for the task description
	public String getDescription() {
		return taskDescription;
	}
	
	//mutator for the task description
	public void setDescription(String description) {
		taskDescription = description;
	}

	//accessor for priority, implementation of interface method
	public int getPriority() {
		return taskPriority;
	}

	//mutator for priority, implementation of interface method
	public void setPriority(int priority) {
		
		//make sure the priority we are given is within the bounds described by the interface
		if (priority > Priority.HIGHEST_PRIORITY) {
			taskPriority = Priority.HIGHEST_PRIORITY;
		} else if (priority < Priority.LOWEST_PRIORITY) {
			taskPriority = Priority.LOWEST_PRIORITY;
		} else {
			taskPriority = priority;
		}
	}

}
