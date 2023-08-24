import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	private final PrintStream initialConsoleOutput = System.out;
	
	@BeforeEach
	public void setOutputStream() {
	    System.setOut(new PrintStream(consoleOutput));
	}
	
	@AfterEach
	public void restoreInitialOutputStream() {
	    System.setOut(initialConsoleOutput);
	}
	
	@Test
	void testAddTask() {
		// Test object.
		TaskService taskService = new TaskService();

		// Try to add a valid task.
		taskService.addTask("1", "Task Name", "Task Description");

		// Verify the task was added.
		assertTrue(taskService.getTasks().containsKey("1"));
	}
	
	@Test
	void testAddInvalidTask() {
		// Test object.
		TaskService taskService = new TaskService();

		// Verify an exception occurs when trying to add the invalid task.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Try to add an invalid task.
			taskService.addTask("*".repeat(11), "*".repeat(21), "*".repeat(51));
		});
	}
	
	@Test
	void testAddDuplicateTask() {
		// Test object.
		TaskService taskService = new TaskService();

		// Try to add a valid task.
		taskService.addTask("1", "Task Name", "Task Description");

		// Try to add another valid task with the same task ID.
		taskService.addTask("1", "Task Name", "Task Description");

		// Verify a duplicate task was not added.
		assertTrue(taskService.getTasks().size() == 1);
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Task already exists."));
	}
	
	@Test
	void testDeleteTask() {
		// Test object.
		TaskService taskService = new TaskService();
	
		// Try to add a valid task.
		taskService.addTask("1", "Task Name", "Task Description");

		// Try to delete a task that already exists.
		taskService.deleteTask("1");

		// Verify the task was deleted from the tasks hash map.
		assertFalse(taskService.getTasks().containsKey("1"));
	}
	
	@Test
	void testDeleteNonExistentTask() {
		// Test object.
		TaskService taskService = new TaskService();

		// Get the current tasks hash map.
		HashMap<String, Task> currentTasks = taskService.getTasks();

		// Try to delete a task that does not exist.
		taskService.deleteTask("1");

		// Verify the tasks hash map is unchanged.
		assertTrue(currentTasks == taskService.getTasks());
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Task does not exist."));
	}
	
	@Test
	void testUpdateTaskName() {
		// Test object.
		TaskService taskService = new TaskService();

		// Try to add a valid task.
		taskService.addTask("1", "Task Name", "Task Description");

		// Update the name.
		taskService.updateTaskName("1", "New Task Name");

		// Verify that the name has changed.
		assertTrue(taskService.getTasks().get("1").getName().equals("New Task Name"));
	}
	
	@Test
	void testUpdateNonExistentTaskName() {
		// Test object.
		TaskService taskService = new TaskService();

		// Update the name.
		taskService.updateTaskName("1", "New Task Name");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Task does not exist."));
	}
	
	@Test
	void testUpdateTaskDescription() {
		// Test object.
		TaskService taskService = new TaskService();

		// Try to add a valid task.
		taskService.addTask("1", "Task Name", "Task Description");

		// Update the description.
		taskService.updateTaskDescription("1", "New Task Description");

		// Verify that the description has changed.
		assertTrue(taskService.getTasks().get("1").getDescription().equals("New Task Description"));
	}
	
	@Test
	void testUpdateNonExistentTaskDescription() {
		// Test object.
		TaskService taskService = new TaskService();

		// Update the description.
		taskService.updateTaskDescription("1", "New Task Description");
		
		// Verify the console output from the else branch.
		assertTrue(consoleOutput.toString().equals("Task does not exist."));
	}
}