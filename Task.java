//================================================================================
// Jonathan Miller - CS-320 - Project One - Task
//================================================================================

public class Task {
	// Task fields.
	private String taskId;
	private String name;
	private String description;
	
	// Constants.
	private static final int MAX_ID_LENGTH = 10;
	private static final int MAX_NAME_LENGTH = 20;
	private static final int MAX_DESCRIPTION_LENGTH = 50;
	
	// The default constructor is hidden to ensure unique task ID's.
	@SuppressWarnings("unused")
	private Task() {}
	
	/**
	 * Constructor for the Task class.
	 * 
	 * @param taskId - The unique task ID for the task.
	 * @param name - The name for the task.
	 * @param description - The description for the task.
	 */
	public Task(String taskId, String name, String description) {
		// Verify format for all fields.
		checkTaskIdFormat(taskId);
		checkNameFormat(name);
		checkDescriptionFormat(description);
		
		// Initialize fields.
		this.taskId = taskId;
		this.name = name;
		this.description = description;
	}
	
	//================================================================================
	// Private Input Format Checker Methods
	//================================================================================
	
	/**
	 * Check the format of the given task ID.
	 * 
	 * @param taskID - The task ID to check proper formatting for.
	 */
	private void checkTaskIdFormat(String taskId) {
		// Verify the task ID format.
		if (taskId == null || taskId.length() > MAX_ID_LENGTH) {
			// Throw an error if the task ID format is incorrect.
			throw new IllegalArgumentException("Invalid task ID format.");
		}
	}
	
	/**
	 * Check the format of the given name.
	 * 
	 * @param name - The name to check proper formatting for.
	 */
	private void checkNameFormat(String name) {
		// Verify the name format.
		if (name == null || name.length() > MAX_NAME_LENGTH) {
			// Throw an error if the name format is incorrect.
			throw new IllegalArgumentException("Invalid name format.");
		}
	}
	
	/**
	 * Check the format of the given description.
	 * 
	 * @param description - The description to check proper formatting for.
	 */
	private void checkDescriptionFormat(String description) {
		// Verify the description format.
		if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
			// Throw an error if the description format is incorrect.
			throw new IllegalArgumentException("Invalid description format.");
		}
	}
	
	//================================================================================
	// Accessors
	//================================================================================
	
	/**
	 * Accessor method for the task ID.
	 * 
	 * @return The task ID for this task.
	 */
	public String getTaskId() {
		return this.taskId;
	}
	
	/**
	 * Accessor method for the name.
	 * 
	 * @return The name for this task.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Accessor method for the description.
	 * 
	 * @return The description for this task.
	 */
	public String getDescription() {
		return this.description;
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	/**
	 * Mutator method for the name.
	 * 
	 * @param name - The new name for this task.
	 */
	public void setName(String name) {
		// Verify the format of the given name.
		checkNameFormat(name);
		
		// Update this task's name.
		this.name = name;
	}
	
	/**
	 * Mutator method for the description.
	 * 
	 * @param description - The new description for this task.
	 */
	public void setDescription(String description) {
		// Verify the format of the given description.
		checkDescriptionFormat(description);
		
		// Update this task's description.
		this.description = description;
	}
}