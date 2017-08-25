//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 2
// ComparableTaskDriver Class 
//
// This is the ComparableTaskDriver class.
// It exercises a few simple examples of ComparableTask objects
// verifying their accessors and mutators work as 
// expected and utilizing the Priority interface 
// It also contains examples of comparisons, both invalid and not
// and leverages the standard api Arrays.sort method to demonstrate
// the Comparable interface works like it's supposed to
//
//==============================================
// need Arrays.sort for the final example
import java.util.Arrays;
// need a random number generator with bounds for the final example
import java.util.Random;

public class ComparableTaskDriver {

	public static void main(String[] args) {

		// array of 10 tasks for examples
		ComparableTask[] tasks = new ComparableTask[10];

		// int for holding the compareTo results
		int comparisonResult;
		
		//generate 10 ordered tasks for our examples
		for (int i = 0; i < 10; i++) {
			tasks[i] = new ComparableTask(i + 1, "Task with priority " + (i + 1));
		}

		//and print them out for reference
		System.out.println("All tasks:");
		for (ComparableTask task : tasks) {
			System.out.println(task);
		}
		System.out.println();

		//accessors example
		System.out.println("Task 1 Acessors: ");
		System.out.println("Description: " + tasks[0].getDescription());
		System.out.println("Priority: " + tasks[0].getPriority());
		System.out.println();

		//mutator - invalid negative input
		System.out.println("Task 2 after having priority set to -5");
		tasks[1].setPriority(-5);
		System.out.println(tasks[1]);
		System.out.println();

		//mutator - invalid positive input
		System.out.println("Task 3 after having priority set to 21");
		tasks[2].setPriority(21);
		System.out.println(tasks[2]);
		System.out.println();
		
		//constructor with invalid input - uses the mutators, but for completeness sake is included
		System.out.println("Invalid priority provided constructor:");
		ComparableTask negativePriorityTask = new ComparableTask(-99, "Negative 99 priority task");
		System.out.println(negativePriorityTask);
		System.out.println();
		
		//less than comparison 
		System.out.print("Task 4 Compared to Task 6: ");
		comparisonResult = tasks[3].compareTo(tasks[5]);
		System.out.println(prettyComparisonResult(comparisonResult));
		System.out.println();
		
		//greater than comparison
		System.out.print("Task 6 Compared to Task 4: ");
		comparisonResult = tasks[5].compareTo(tasks[3]);
		System.out.println(prettyComparisonResult(comparisonResult));
		System.out.println();
		
		//equal reference comparison
		System.out.print("Task 5 compared to itself: ");
		comparisonResult = tasks[4].compareTo(tasks[4]);
		System.out.println(prettyComparisonResult(comparisonResult));
		System.out.println();

		//equal priority comparison
		System.out.print("Task 7 Compared to an equal priority task: ");
		ComparableTask anotherTask = new ComparableTask(7,"Another Task with priority 7");
		comparisonResult = tasks[6].compareTo(anotherTask);
		System.out.println(prettyComparisonResult(comparisonResult));
		System.out.println();

		//using the interface type instead
		System.out.println("Using task 8 as Priority instead of ComparableTask");
		Priority interfaceReferenceTask = tasks[7];
		System.out.println("Priority: " + interfaceReferenceTask.getPriority());
		//Can't call this - it won't compile
		//System.out.println("Description: " + interfaceReferenceTask.getDescription());
		//Can cast and call though
		System.out.println("Description (from cast): " + ((ComparableTask)interfaceReferenceTask).getDescription());
		
		System.out.println("Changing priority to 4:");
		interfaceReferenceTask.setPriority(4);
		//this still calls the ComparableTask toString since that's what the object actually is
		System.out.println(interfaceReferenceTask);
		System.out.println();
		
		// null comparison example
		System.out.println("Comparing a task to null:");
		try {
			tasks[8].compareTo(null);
			
		} catch (NullPointerException e) {
			System.out.println("Caught NullReferenceException - " +  e.getMessage());
		}
		System.out.println();

		// invalid comparison example
		System.out.println("Comparing a task to a String:");
		try {
			tasks[9].compareTo("Not a task");
		} catch (IllegalArgumentException e) {
			System.out.println("Caught IllegalArgumentException - " + e.getMessage() );
		}
		System.out.println();

		//Standard API provided Array sort using Comparable interface
		System.out.println("Builtin sorting example:");
		ComparableTask randomTasks[] = new ComparableTask[6];
		
		Random rng = new Random();
		for (int i=0; i < 6; i++) {
			int randomValue = rng.nextInt(Priority.HIGHEST_PRIORITY) + 1;
			randomTasks[i] = new ComparableTask(randomValue, "#" + (i+1) + " - Random Priority: " + randomValue);
		}
		
		//print the initial order of the array
		System.out.println("Initial Array Order:");
		for(int i = 0; i< 6; i++) {
			System.out.println("Index: " + i + " - " + randomTasks[i]);
		}
		System.out.println();

		//sort the array, this should use the comparable interface
		Arrays.sort(randomTasks);
		System.out.println("Sorted Array Order:");
		for(int i = 0; i< 6; i++) {
			System.out.println("Index: " + i + " - " + randomTasks[i]);
		}
	}

	// helper method to convert the compareTo results to a human readable format
	private static String prettyComparisonResult(int result) {
		if (result < 0) {
			return "Less than";
		} else if (result > 0) {
			return "Greater than";
		} else {
			return "Equal to";
		}
	}
}