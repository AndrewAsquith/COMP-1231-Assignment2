//==============================================
// Andrew Asquith
// COMP 1231
// Assignment 2
// Priority Interface
// 
// Defines the two required methods and provides 
// constants for the expected boundaries for
// a class implementing the interface
//==============================================

public interface Priority {

	public final int HIGHEST_PRIORITY = 10;
	public final int LOWEST_PRIORITY = 1;
	
	public int getPriority();
	public void setPriority(int priority);
	
}