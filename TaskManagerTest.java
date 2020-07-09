import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * The test class TaskManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TaskManagerTest
{
    private TaskManager taskMana1;
    private TaskManager taskMana2;
    private String d, dm1, dm9;

    /**
     * Default constructor for test class TaskManagerTest
     */
    public TaskManagerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        taskMana1 = new TaskManager();
        taskMana2 = new TaskManager();
        taskMana2.addTask("First Task", 9);
        taskMana2.addTask("Second Task", 5);
        taskMana2.addTask("Third Task", 15);
        Deadline deadline = new Deadline();
        d = deadline.toString();
        deadline.setNewDeadline(-1);
        dm1 = deadline.toString();
        deadline.setNewDeadline(-8);
        dm9 = deadline.toString();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
     
   

    /* *****************************************************************************
     * Copy additional test methods BELOW this comment and ABOVE the comment below *
     * DO NOT CHANGE ANYTHING ABOVE THIS COMMENT                                   *
     * *****************************************************************************/
 @Test
    public void addTask()
    {
        TaskManager taskMana1 = new TaskManager();
        assertEquals("A new task manager should not contain any tasks.",
            0, taskMana1.getCount());
        assertEquals("You should have added one task", 
            "Task added.", taskMana1.addTask("My first task", 3));
        assertEquals("The task manager should now contain ONE task.", 
            1, taskMana1.getCount());
        assertEquals("You should have added one task",
            "Task added.", taskMana1.addTask("Another task", 10));
        assertEquals("The task manager should now contain TWO tasks.", 
            2, taskMana1.getCount());
        }
        
         @Test
    public void findById()
    {
        TaskManager taskMana1 = new TaskManager();
        assertEquals(null, taskMana1.findById(1));
        taskMana1.addTask("The first task", 7);
        assertEquals(1, taskMana1.getCount());
        assertEquals("There should never be any task with the ID 0", null, 
            taskMana1.findById(0));
        Task task1 = taskMana1.findById(1);
        assertNotNull("You should have found a task with the ID 1",
            task1);
        assertEquals("This task should have been the one with ID 1", 1,task1.getId());
        taskMana1.addTask("A second task", 3);
        assertEquals(2, taskMana1.getCount());
        Task task1Again = taskMana1.findById(1);
        Task task2 = taskMana1.findById(2);
        assertEquals("This task should have been the one with ID 2", 2,task2.getId());
        assertNotNull(task1Again);
        assertEquals("You should have just returned the task with ID equal to 1",
            task1, task1Again);
        assertEquals("You should have just returned the task with ID equal to 1",1, task1Again.getId());
        assertNotNull("You should have just returned the task with ID equal to 2",task2);
        assertTrue("Tasks with the ID 1 and 2 cannot be the same task.", task1 != task2);
    }
    
      @Test
    public void setCompleted()
    {
        TaskManager taskMana1 = new TaskManager();
        assertEquals("No tasks have been added yet", null, taskMana1.setCompleted(0));
        assertEquals("No tasks have been added yet", null, taskMana1.setCompleted(1));
        taskMana1.addTask("The first Task", 5);
        taskMana1.addTask("The Second Task", 9);
        Task one = taskMana1.findById(1);
        assertNotNull("There should be a task in your list with the ID of 1", one);
        Task two = taskMana1.findById(2);
        assertNotNull("There should be a task in your list with the ID of 2", two != null);
        assertTrue("Tasks with the ID 1 and 2 cannot be the same task.", one != two);
        assertEquals("There should be two tasks in the list.", 2, taskMana1.getCount());
        assertEquals("There is no task with the ID 0", null, taskMana1.setCompleted(0));
        assertEquals("There is no task with the ID 3", null, taskMana1.setCompleted(3));
        assertEquals("The task with ID 1 should NOT have been set to be completed.", false, one.isDone());
        assertEquals("The task with ID 2 should NOT have been set to be completed.", false, two.isDone());
        assertEquals("You should have set task with ID 2 to be completed and returned task 2.", two, taskMana1.setCompleted(2));
        assertEquals("You should have set task with ID 2 to be completed, checking isDone().", true, two.isDone());
        assertEquals("The task with ID 1 should NOT have been set to be completed.", false, one.isDone());
        assertEquals("You should have set task with ID 1 to be completed and returned task 1.", one, taskMana1.setCompleted(1));
        assertEquals("You should have set task with ID 1 to be completed, checking isDone().", true, one.isDone());
    }
  @Test
    public void deleteTask()
    {
        TaskManager taskMana1 = new TaskManager();
        assertEquals("There is no task with ID of 0", null, taskMana1.deleteTask(0));
        assertEquals("You cannot delete task 1 because it is not completed.", null, taskMana1.deleteTask(1));
        taskMana1.addTask("The first Task", 3);
        Task task1 = taskMana1.findById(1);
        assertEquals("You cannot delete task 1 because it is not completed.", null, taskMana1.deleteTask(1));
        assertEquals("There should be one task in the list", 1, taskMana1.getCount());
        taskMana1.addTask("The second task", 8);
        Task task2 = taskMana1.findById(2);
        assertEquals("There is no task with ID of 3", null, taskMana1.deleteTask(3));
        assertEquals("You cannot delete task 2 because it is not completed.", null, taskMana1.deleteTask(2));
        assertEquals("There should be two tasks in the list", 2, taskMana1.getCount());
        assertEquals("Task 1 should be marked completed.", task1, taskMana1.setCompleted(1));
        assertEquals("You cannot delete task 2 because it is not completed.", null, taskMana1.deleteTask(2));
        assertEquals("Task 1 should have been deleted.", task1, taskMana1.deleteTask(1));
        assertEquals("There should be one task in the list", 1, taskMana1.getCount());
        assertEquals("Task 1 has been deleted and so cannot be marked completed.", null, taskMana1.setCompleted(1));
        assertEquals("Task 2 should be marked completed.", task2, taskMana1.setCompleted(2));
        assertEquals("There should be one task in the list", 1, taskMana1.getCount());
        assertEquals("Task 2 should have been deleted.", task2, taskMana1.deleteTask(2));
        assertEquals("There should be no tasks in the list", 0, taskMana1.getCount());
    }
    
     @Test
    public void getCountTodo()
    {
        TaskManager taskMana1 = new TaskManager();
        assertEquals("No tasks have been created, getCountTodo should return 0",
            0, taskMana1.getCountTodo());
        taskMana1.addTask("My first Task", 4);
        assertEquals("Added one task, is it not completed", 
            1, taskMana1.getCountTodo());
        taskMana1.setCompleted(1);
        assertEquals("Added one task, set it to be completed", 
            0, taskMana1.getCountTodo());
        taskMana1.addTask("This is another Task", 10);
        taskMana1.addTask("Third Task", 7);
        assertEquals("Three tasks in the list, only one is completed", 
            2, taskMana1.getCountTodo());
        taskMana1.setCompleted(2);
        assertEquals("Three tasks in the list, two are completed",
            1, taskMana1.getCountTodo());
        taskMana1.setCompleted(3);
        assertEquals("Three tasks in the list, all three are completed",
            0, taskMana1.getCountTodo());
    }
    
     @Test
    public void getSummaryComplete()
    {
        assertEquals("Tasks IDs:\n", taskMana1.getSummaryComplete());
        assertEquals("Tasks IDs:\n", taskMana2.getSummaryComplete());
        taskMana2.setCompleted(3);
        assertEquals("Tasks IDs:\n3: Third Task: 0.0\n", taskMana2.getSummaryComplete());
        taskMana2.deleteTask(3);
        assertEquals("Tasks IDs:\n", taskMana2.getSummaryComplete());
        taskMana2.setCompleted(1);
        assertEquals("Tasks IDs:\n1: First Task: 0.0\n", taskMana2.getSummaryComplete());
        taskMana2.setCompleted(2);
        assertEquals("Tasks IDs:\n1: First Task: 0.0\n2: Second Task: 0.0\n", taskMana2.getSummaryComplete());
        Task task1 =  taskMana2.findById(1);
        task1.recordHoursWorked(3);
        String s = taskMana2.getSummaryComplete();
        assertEquals("Tasks IDs:\n1: First Task: 33.33333333333333\n2: Second Task: 0.0\n", taskMana2.getSummaryComplete());
        Task task2 =  taskMana2.findById(2);
        task2.recordHoursWorked(3);
        assertEquals("Tasks IDs:\n1: First Task: 33.33333333333333\n2: Second Task: 60.0\n", taskMana2.getSummaryComplete());
        task2.recordHoursWorked(2);
        assertEquals("Tasks IDs:\n1: First Task: 33.33333333333333\n2: Second Task: 100.0\n", taskMana2.getSummaryComplete());
        task2.recordHoursWorked(1);
        assertEquals("Tasks IDs:\n1: First Task: 33.33333333333333\n2: Second Task: 120.0\n", taskMana2.getSummaryComplete());
    }
    
    @Test
    public void getSummaryIncomplete()
    {
        assertEquals("Tasks IDs:\n", taskMana1.getSummaryIncomplete());
        assertEquals("Tasks IDs:\n1: First Task: 0.0\n2: Second Task: 0.0\n3: Third Task: 0.0\n", taskMana2.getSummaryIncomplete());
        taskMana2.setCompleted(1);
        assertEquals("Tasks IDs:\n2: Second Task: 0.0\n3: Third Task: 0.0\n", taskMana2.getSummaryIncomplete());
        taskMana2.setCompleted(1);
        assertEquals("Tasks IDs:\n2: Second Task: 0.0\n3: Third Task: 0.0\n", taskMana2.getSummaryIncomplete());
        TaskManager taskMana3 = new TaskManager();
        taskMana3.addTask("Test Percentage", 10);
        assertEquals("Tasks IDs:\n1: Test Percentage: 0.0\n", taskMana3.getSummaryIncomplete());
        Task t = taskMana3.findById(1);
        t.recordHoursWorked(1);
        assertEquals("Tasks IDs:\n1: Test Percentage: 10.0\n", taskMana3.getSummaryIncomplete());
        t.recordHoursWorked(3);
        assertEquals("Tasks IDs:\n1: Test Percentage: 40.0\n", taskMana3.getSummaryIncomplete());
        t.recordHoursWorked(3);
        assertEquals("Tasks IDs:\n1: Test Percentage: 70.0\n", taskMana3.getSummaryIncomplete());
        t.setDone();
        assertEquals("Tasks IDs:\n", taskMana3.getSummaryIncomplete());
    }
    
     @Test
    public void getAllTasks()
    {
        assertEquals("All Tasks:\n", taskMana1.getAllTasks());
        assertEquals("All Tasks:\n1: First Task, Due: "+d+": 0.0% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getAllTasks());
        Task t1 = taskMana2.findById(1);
        t1.recordHoursWorked(2);
        assertEquals("All Tasks:\n1: First Task, Due: "+d+": 22.22222222222222% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getAllTasks());
        t1.extendDeadline(-1);
        assertEquals("All Tasks:\n1: First Task, Due: "+dm1+": 22.22222222222222% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getAllTasks());
        t1.recordHoursWorked(1);
        assertEquals("All Tasks:\n1: First Task, Due: "+dm1+": 33.33333333333333% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getAllTasks());
        t1.extendEstimate(1);
        assertEquals("All Tasks:\n1: First Task, Due: "+dm1+": 30.0% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getAllTasks());
        t1.setDone();
        assertEquals("All Tasks:\n1: First Task, Due: "+dm1+": 30.0% complete, done: true\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getAllTasks());
    }
    
    @Test
    public void getIncompleteTasks()
    {
        assertEquals("Incomplete Tasks:\n", taskMana1.getIncompleteTasks());
        assertEquals("Incomplete Tasks:\n1: First Task, Due: "+d+": 0.0% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getIncompleteTasks());
        Task t1 = taskMana2.findById(1);
        t1.recordHoursWorked(2);
        assertEquals("Incomplete Tasks:\n1: First Task, Due: "+d+": 22.22222222222222% complete, done: false\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getIncompleteTasks());
        t1.setDone();
        assertEquals("Incomplete Tasks:\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getIncompleteTasks());
        Task t3 = taskMana2.findById(3);
        t3.extendEstimate(-1);
        t3.recordHoursWorked(7);
        assertEquals("Incomplete Tasks:\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n3: Third Task, Due: "+d+": 50.0% complete, done: false\n", taskMana2.getIncompleteTasks());
        t3.setDone();
        assertEquals("Incomplete Tasks:\n2: Second Task, Due: "+d+": 0.0% complete, done: false\n", taskMana2.getIncompleteTasks());
    }
    
     @Test
    public void getLateTasks()
    {
        assertEquals("Late Tasks:\n", taskMana2.getLateTasks());
        Task t1 = taskMana2.findById(1);
        t1.recordHoursWorked(2);
        assertEquals("Late Tasks:\n", taskMana2.getLateTasks());
        t1.extendDeadline(-9);
        assertEquals("Late Tasks:\n1: First Task, Due: "+dm9+": 22.22222222222222% complete, done: false\n", taskMana2.getLateTasks());
        t1.setDone();
        assertEquals("Late Tasks:\n", taskMana2.getLateTasks());
        Task t3 = taskMana2.findById(3);
        t3.extendEstimate(-1);
        t3.recordHoursWorked(7);
        t3.extendDeadline(-9);
        assertEquals("Late Tasks:\n3: Third Task, Due: "+dm9+": 50.0% complete, done: false\n", taskMana2.getLateTasks());
        t3.setDone();
        assertEquals("Late Tasks:\n", taskMana2.getLateTasks());
    }



    /* *****************************************************************************
     * Copy additional test methods ABOVE this comment and BELOW the comment above *
     * DO NOT CHANGE ANYTHING BELOW THIS COMMENT                                   *
     * *****************************************************************************/

    @Test
    public void taskManagerDataFields() {
        String className = "TaskManager";
        String fieldName = "tasks";
        try {
            Class<?> clzz = Class.forName(className);
            Field field = clzz.getDeclaredField(fieldName);
            ParameterizedType type = (ParameterizedType)field.getGenericType();
            int foundMods = field.getModifiers();
            if (!Modifier.isPrivate(foundMods)) {
                fail("The field called " + fieldName + " should be declared to be private");
            }
            Type[] modifiers = type.getActualTypeArguments();
            assertEquals(modifiers.length, 1);
            assertEquals(modifiers[0], Task.class);
            TestUtility.checkField("TaskManager", "nextTaskId", int.class);
            Field[] fields = clzz.getDeclaredFields();
            if (fields == null | fields.length != 2) {
                fail("There should be exactly 2 fields in the " + className + " class." +
                    "  You should NOT create additional fields.  Use a local variable if you created a new field.");
            }
        } catch (ClassNotFoundException e) {
            fail("There should be a class in your project called " + className +
                ". However I cannot find it.  Did you spell its name correctly?");
        } catch (NoSuchFieldException e) {
            fail("There should be a private field called " + fieldName +
                ".  If you think you put it there, check your spelling of it");
        }

    }

    @Test
    public void taskManagerConstructor() {
        Class<?>[] paramList = {};
        TestUtility.checkConstructor("TaskManager", paramList);
    }

    @Test
    public void taskManagerCountAndAdd() {
        TestUtility.checkMethod("TaskManager", "getCount", null, int.class);
        Class<?>[] paramList = {String.class, int.class};
        TestUtility.checkMethod("TaskManager", "addTask", paramList, String.class);
    }

    @Test
    public void taskManagerFindTask() {
        Class<?>[] paramList = {int.class};
        TestUtility.checkMethod("TaskManager", "findById", paramList, Task.class);
    }

    @Test
    public void taskManagerCompleteTask() {
        Class<?>[] paramList = {int.class};
        TestUtility.checkMethod("TaskManager", "setCompleted", paramList, Task.class);
    }

    @Test
    public void taskManagerDeleteTask() {
        Class<?>[] paramList = {int.class};
        TestUtility.checkMethod("TaskManager", "deleteTask", paramList, Task.class);
    }

    @Test
    public void taskManagerGetCountTodo() {
        Class<?>[] paramList = {};
        TestUtility.checkMethod("TaskManager", "getCountTodo", paramList, int.class);
    }

    @Test
    public void taskManagerGetSummaryComplete() {
        Class<?>[] paramList = {};
        TestUtility.checkMethod("TaskManager", "getSummaryComplete", paramList, String.class);
    }

    @Test
    public void taskManagerGetSummaryIncomplete() {
        Class<?>[] paramList = {};
        TestUtility.checkMethod("TaskManager", "getSummaryIncomplete", paramList, String.class);
    }

    @Test
    public void taskManagerGetAllTasks() {
        Class<?>[] paramList = {};
        TestUtility.checkMethod("TaskManager", "getAllTasks", paramList, String.class);
    }

    @Test
    public void taskManagerGetIncompleteTasks() {
        Class<?>[] paramList = {};
        TestUtility.checkMethod("TaskManager", "getIncompleteTasks", paramList, String.class);
    }

    @Test
    public void taskManagerGetLateTasks() {
        Class<?>[] paramList = {};
        TestUtility.checkMethod("TaskManager", "getLateTasks", paramList, String.class);
    }


}

