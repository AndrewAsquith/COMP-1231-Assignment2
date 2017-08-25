//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 2
// Task Class 
//
// This is the Task class.
// It defines a private variable for the priority and 
// implements the required methods for the Priority Interface
// It also contains a string for a description
// trying to set priority outside of the bounds defined by the 
// interface results in using the highest or lowest as appropriate
// This class also implements the Comparable interface
// The compareTo implementation uses the priority as a basis for comparison
//
//==============================================
public class Task implements Priority, Comparable {

	// private member for priority
	private int taskPriority;

	// private member for description with default value
	private String taskDescription = "Undescribed Task";

	// constructor accepting no arguments, sets lowest priority and leaves default description
	public Task() {
		taskPriority = Priority.LOWEST_PRIORITY;
	}

	// constructor accepting only a description, sets lowest priority
	public Task(String description) {
		taskPriority = Priority.LOWEST_PRIORITY;
		taskDescription = description;
	}

	// constructor accepting a priority and leaving default description
	public Task(int priority) {
		setPriority(priority);
	}

	// constructor accepting both a priority and a description
	public Task(int priority, String description) {
		setPriority(priority);
		taskDescription = description;
	}

	// accessor for the task description
	public String getDescription() {
		return taskDescription;
	}

	// mutator for the task description
	public void setDescription(String description) {
		taskDescription = description;
	}

	// accessor for priority, implementation of interface method
	public int getPriority() {
		return taskPriority;
	}

	// mutator for priority, implementation of interface method
	public void setPriority(int priority) {

		// make sure the priority we are given is within the bounds described by the interface
		if (priority > Priority.HIGHEST_PRIORITY) {
			taskPriority = Priority.HIGHEST_PRIORITY;
		} else if (priority < Priority.LOWEST_PRIORITY) {
			taskPriority = Priority.LOWEST_PRIORITY;
		} else {
			taskPriority = priority;
		}
	}

	// implementation of the compareTo method for the comparable interface
	// the comparison is performed on the priority of the task
	public int compareTo(Object arg0) throws IllegalArgumentException, NullPointerException {

		// some constants that satisfy the compareTo requirements 
		// and make comparison result intention clear
		final int GREATER_THAN = 1;
		final int LESS_THAN = -1;
		final int EQUAL_TO = 0;

		// the reference for the argument to be compared
		Priority task2;

		// if null was passed, throw a NullPointerException as per the documentation
		if (arg0 == null) {
			throw new NullPointerException("Argument cannot be null");
		}
		
		// if they are the same reference, return equal_to
		if (arg0 == this) { 
			return EQUAL_TO;
		}

		// the provided argument must implement the priority interface
		if (arg0 instanceof Priority) {
			// cast the argument to the interface type
			task2 = (Priority) arg0;
		} else {
			// if it doesn't throw an IllegalArgumentException
			// this could be avoided by using the Comparable<T> interface instead of the raw one
			throw new IllegalArgumentException("Argument must be of type Task");
		}

		// determine comparison result based on the priority according to compareTo contract
		if (taskPriority > task2.getPriority()) {

			// greater than should be positive
			return GREATER_THAN;

		} else if (taskPriority < task2.getPriority()) {

			// less than should be a negative value
			return LESS_THAN;
			
		} else {

			// and equal values should be 0
			return EQUAL_TO;
		}

	}

	//toString implementation returning priority and description
	public String toString() {
		return "Priority: " + taskPriority + " - " + taskDescription;
	}
}