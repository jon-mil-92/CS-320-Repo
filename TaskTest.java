import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {
	
	@Test
	void testGetTaskId() {
		// Test object.
		Task task = new Task("1", "Task Name", "Task Description");
		
		// Verify the task's task ID.
		assertTrue(task.getTaskId().equals("1"));
	}
	
	@Test
	void testGetName() {
		// Test object.
		Task task = new Task("1", "Task Name", "Task Description");
		
		// Verify the task's name.
		assertTrue(task.getName().equals("Task Name"));
	}
	
	@Test
	void testGetDescription() {
		// Test object.
		Task task = new Task("1", "Task Name", "Task Description");
		
		// Verify the task's description.
		assertTrue(task.getDescription().equals("Task Description"));
	}
	
	@Test
	void testSetName() {
		// Test object.
		Task task = new Task("1", "Task Name", "Task Description");
		task.setName("New Task Name");
		
		// Verify the new task name was set.
		assertTrue(task.getName().equals("New Task Name"));;
	}
	
	@Test
	void testSetDescription() {
		// Test object.
		Task task = new Task("1", "Task Name", "Task Description");
		task.setDescription("New Task Description");
		
		// Verify the new description was set.
		assertTrue(task.getDescription().equals("New Task Description"));
	}
	
	@Test
	void testTooLongTaskId() {
		// Verify an exception was thrown for too long task ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("*".repeat(11), "Task Name", "Task Description");
		});
	}
	
	@Test
	void testNullTaskId() {
		// Verify an exception was thrown for null task ID.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Task Name", "Task Description");
		});
	}
	
	@Test
	void testTooLongName() {
		// Verify an exception was thrown for too long name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "*".repeat(21), "Task Description");
		});
	}
	
	@Test
	void testNullName() {
		// Verify an exception was thrown for null name.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", null, "Task Description");
		});
	}
	
	@Test
	void testTooLongDescription() {
		// Verify an exception was thrown for too long description.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Task Name", "*".repeat(51));
		});
	}
	
	@Test
	void testNullDescription() {
		// Verify an exception was thrown for null description.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Task Name", null);
		});
	}
}