//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 2
// TaskDriver Class 
//
// This is the UncomparableTaskDriver class.
// It exercises a few simple examples of UncomparableTask 
// objects verifying their accessors and mutators work as 
// expected and utilizing the Priority interface 
//
//==============================================
public class UncomparableTaskDriver {

	public static void main(String[] args) {

		// array of tasks for examples
		UncomparableTask[] tasks = new UncomparableTask[4];

		// generate 4 ordered tasks for our examples
		for (int i = 0; i < 4; i++) {
			tasks[i] = new UncomparableTask(i + 1, "Task with priority " + (i + 1));
		}

		System.out.println("All tasks:");
		for (UncomparableTask eachTask : tasks) {
			System.out.println(eachTask);
		}
		System.out.println();

		// accessors example
		System.out.println("Task 1 Acessors: ");
		System.out.println("Description: " + tasks[0].getDescription());
		System.out.println("Priority: " + tasks[0].getPriority());
		System.out.println();

		// mutator - invalid input
		System.out.println("Task 2 after having priority set to -5");
		tasks[1].setPriority(-5);
		System.out.println(tasks[1]);
		System.out.println();

		// mutator - invalid input
		System.out.println("Task 3 after having priority set to 21");
		tasks[2].setPriority(21);
		System.out.println(tasks[2]);
		System.out.println();

		// constructor with invalid input
		UncomparableTask negativePriorityTask = new UncomparableTask(-99, "Negative 99 priority task");
		System.out.println(negativePriorityTask);
		System.out.println();

		// using the interface type instead
		System.out.println("Using task 4 as Priority instead of Task");
		Priority interfaceReferenceTask = new UncomparableTask(4, "Task with priority 4");
		System.out.println("Priority: " + interfaceReferenceTask.getPriority());
		// We can't call this next line - it won't compile
		//System.out.println("Description: " + interfaceReferenceTask.getDescription());
		// We can cast and call it though
		System.out.println("Description: " + ((UncomparableTask)interfaceReferenceTask).getDescription());

		System.out.println("Changing priority to 5:");
		interfaceReferenceTask.setPriority(5);
		// this still calls the UncomparableTask toString since that's what the object actually is
		System.out.println(interfaceReferenceTask);
		System.out.println();
	}
}