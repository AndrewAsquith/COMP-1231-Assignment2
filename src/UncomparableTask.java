//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 2
// UncomparableTask Class 
//
// This is the UncomparableTask class.
// It defines a private variable for the priority and 
// implements the required methods for the Priority Interface
// it also contains a string for a description
// trying to set priority outside of the bounds defined by the 
// interface results in using the highest or lowest as appropriate
//
//==============================================
public class UncomparableTask implements Priority {

	//private member for priority
	private int taskPriority;
	
	//private member for description with default value
	private String taskDescription = "Undescribed Task";
	
	//constructor accepting no arguments, sets lowest priority and leaves default description
	public UncomparableTask() {
		taskPriority = Priority.LOWEST_PRIORITY;
	}
	
	//constructor accepting only a description, sets lowest priority
	public UncomparableTask(String description) {
		taskPriority = Priority.LOWEST_PRIORITY;
		taskDescription = description;
	}
	
	//constructor accepting a priority and leaving default description
	public UncomparableTask(int priority) {
		setPriority(priority);
	}
	
	//constructor accepting both a priority and a description
	public UncomparableTask(int priority, String description) {
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
	
	//toString implementation returning priority and description
	public String toString() {
		return "Priority: " + taskPriority + " - " + taskDescription;
	}
}