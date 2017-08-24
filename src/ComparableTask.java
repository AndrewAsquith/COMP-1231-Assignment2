
public class ComparableTask implements Priority, Comparable {

	private int taskPriority;

	private String taskDescription = "Undescribed Task";

	// constructor accepting no arguments, sets lowest priority and leaves
	// default description
	public ComparableTask() {
		taskPriority = Priority.LOWEST_PRIORITY;
	}

	// constructor accepting only a description, sets lowest priority
	public ComparableTask(String description) {
		taskPriority = Priority.LOWEST_PRIORITY;
		taskDescription = description;
	}

	// constructor accepting a priority and leaving default description
	public ComparableTask(int priority) {
		setPriority(priority);
	}

	// constructor accepting both a priority and a description
	public ComparableTask(int priority, String description) {
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
	public int compareTo(Object arg0) throws IllegalArgumentException, NullPointerException {

		// some constants that satisfy the compareTo requirements 
		// and make comparison result intention clear
		final int GREATER_THAN = 1;
		final int LESS_THAN = -1;
		final int EQUAL_TO = 0;

		// the reference for the argument to be compared
		Priority task2;

		// if null was passed, throw a NullPointerException as per the
		// documentation
		if (arg0 == null) {
			throw new NullPointerException("Argument cannot be null");
		}

		// the provided argument must implement the priority interface
		if (arg0 instanceof Priority) {
			// cast the argument to the interface type
			task2 = (Priority) arg0;
		} else {
			// if it doesn't throw an IllegalArgumentException
			// this could be avoided by using the Comparable<T> interface
			// instead of the raw one
			throw new IllegalArgumentException("Argument must be of type ComparableTask");
		}

		// determine comparison result based on the priority according to
		// compareTo contract
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

}
