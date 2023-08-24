//================================================================================
// Jonathan Miller - CS-320 - Project One - TaskService
//================================================================================

import java.util.HashMap;

public class TaskService {
	// Container to hold all the tasks.
	private HashMap<String, Task> tasks;
	
	/**
	 * Constructor for the TaskService class.
	 */
	public TaskService() {
		// Initialize the tasks container.
		this.tasks = new HashMap<String, Task>();
	}
	
	//================================================================================
    // Public Class Methods
    //================================================================================
	
	/**
	 * Accessor method to get the tasks hash map.
	 * 
	 * @return The hash map of tasks.
	 */
	public HashMap<String, Task> getTasks() {
		return tasks;
	}
	
	/**
	 * Add a new task to the hash map with the given task ID if it doesn't exist.
	 * 
	 * @param taskId - The unique task ID for the new task.
	 * @param name - The name for the new task.
	 * @param description - The description for the new task.
	 */
	public void addTask(String taskId, String name, String description) {
		// If the hash map does not contain the given task ID.
		if (!tasks.containsKey(taskId)) {
			// Create the new task.
			Task newTask = new Task(taskId, name, description);
		
			// Add the new task to the hash map.
			tasks.put(taskId, newTask);
		}
		else {
			// Print a message to the console.
			System.out.print("Task already exists.");
		}
	}
	
	/**
	 * Delete a specified task from the hash map.
	 * 
	 * @param taskId - The unique task ID for the specified task.
	 */
	public void deleteTask(String taskId) {
		// If the hash map contains the given task ID...
		if (tasks.containsKey(taskId)) {
			// Delete the specified task from the hash map.
			tasks.remove(taskId);
		}
		else {
			// Print a message to the console.
			System.out.print("Task does not exist.");
		}
	}
	
	/**
	 * Update the specified task's name from the hash map.
	 * 
	 * @param taskId - The unique task ID for the specified task.
	 * @param name - The new name for the specified task.
	 */
	public void updateTaskName(String taskId, String name) {
		// If the task exists in the hash map...
		if (tasks.containsKey(taskId)) {
			// Update the task's name.
			tasks.get(taskId).setName(name);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Task does not exist.");
		}
	}
	
	/**
	 * Update the specified task's description from the hash map.
	 * 
	 * @param taskId - The unique task ID for the specified task.
	 * @param description - The new description for the specified task.
	 */
	public void updateTaskDescription(String taskId, String description) {
		// If the task exists in the hash map...
		if (tasks.containsKey(taskId)) {
			// Update the task's description.
			tasks.get(taskId).setDescription(description);
		}
		else
		{
			// Print a message to the console.
			System.out.print("Task does not exist.");
		}
	}
}
