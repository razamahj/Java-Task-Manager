
import static org.junit.Assert.*;
import org.junit.After; 
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.*;

import static java.lang.System.out;

/**
 * The test class TaskTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TaskTest
{

    private int id1;
    private String description1;
    private int estTime1;
    private int id2;
    private String description2;
    private int estTime2;

    /**
     * Default constructor for test class TaskTest
     */
    public TaskTest()
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
        id1 = 5;
        description1 = "This is a task to do";
        estTime1 = 9;
        id2 = 31;
        description2 = "Tasks should be completed";
        estTime2 = 5;
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

     
    /* *****************************************************************************
     * Copy additional test methods ABOVE this comment and BELOW the comment above *
     * DO NOT CHANGE ANYTHING BELOW THIS COMMENT                                   *
     * *****************************************************************************/

    @Test
    public void taskDataFields() {
        TestUtility.checkField("Task", "id", int.class);
        TestUtility.checkField("Task", "description", java.lang.String.class);
        TestUtility.checkField("Task", "deadline", Deadline.class);
        TestUtility.checkField("Task", "done", boolean.class);
        TestUtility.checkField("Task", "estimatedLength", int.class);
        TestUtility.checkField("Task", "hoursWork", int.class);
    }

    @Test
    public void taskConstructor() {
        Class<?>[] paramList = {int.class, java.lang.String.class, int.class};
        TestUtility.checkConstructor("Task", paramList);
    }

    @Test
    public void taskAccessorMethods() {
        TestUtility.checkMethod("Task", "getId", null,int.class);
        TestUtility.checkMethod("Task", "getDeadline",null,Deadline.class);
        TestUtility.checkMethod("Task", "getDescription",null,java.lang.String.class);
        TestUtility.checkMethod("Task", "isDone",null,boolean.class);
        TestUtility.checkMethod("Task", "getPercentageComplete",null,double.class);
        TestUtility.checkMethod("Task", "isLate",null,boolean.class);
    }

    @Test
    public void taskMutatorMethods() {
        TestUtility.checkMethod("Task", "setDone", null, void.class);
        Class<?>[] typeList = {int.class};
        TestUtility.checkMethod("Task", "extendEstimate", typeList, void.class);
        TestUtility.checkMethod("Task", "recordHoursWorked", typeList, void.class);
        TestUtility.checkMethod("Task", "extendDeadline", typeList, void.class);
    }

    @Test
    public void taskAsString() {
        TestUtility.checkMethod("Task", "getSummary", null, String.class);
        TestUtility.checkMethod("Task", "toString", null, String.class);
        try {
            assertEquals("Checking you have written the toString method.", 
                Task.class.getMethod("toString").getDeclaringClass(), 
                Task.class);
        } catch (NoSuchMethodException e) {
            fail("You haven't written one of the string methods");
        }
    }

   @Test
    public void constructAccess() {
        int id = 5;
        String description = "This is a task to do";
        int estTime = 9;
        Task task = new Task(id, description, estTime);
        assertEquals("I created a task with the id="+id,
            id, task.getId());
        assertEquals("I created a task with the description="+description,
            description, task.getDescription());
        assertEquals("I created a new task with the estimatedLength="+estTime+
            ", so percentage of work done should be 0.0",
            0.0, task.getPercentageComplete(), 0.0);
        assertEquals("I created a new task, isDone should return false", 
            false, task.isDone());
        assertEquals("I created a new task, isLate should return false", 
            false, task.isLate());
        Deadline d = new Deadline();
        assertEquals("Checking the date of the deadline", d, task.getDeadline());
	int id2 = 3;
        String description2 = "Another task to do";
        int estTime2 = 25;
        Task task2 = new Task(id2, description2, estTime2);
        assertEquals("I created a task with the id="+id2,
            id2, task2.getId());
	assertEquals("I created a task with the description="+description2,
            description2, task2.getDescription());
    }    
    
    
    @Test
    public void done() {
        Task task = new Task(id1, description1, estTime1);
        task.setDone();
        assertEquals("I created a new task and called setDone, isDone should now return true", 
            true, task.isDone());



    }
    
    @Test
    public void getPercentageComplete() {
        Task task = new Task(id1, description1, estTime1);
        assertEquals("I created a new task with the estimatedLength="+estTime1+
            ", so percentage of work done should be 0.0",
            0.0, task.getPercentageComplete(), 0.0);
        int record = 1;
        int record2 = 3;
        int extend = 3;
        
        task.recordHoursWorked(record);
        assertEquals("I created a new task with the estimatedLength="+estTime1+
            ", and recorded " + record + " hour of work on that task",
            ((double) record)/estTime1*100.0, task.getPercentageComplete(), 0.000001);

        task.recordHoursWorked(record2);
        assertEquals("I created a new task with the estimatedLength="+estTime1+
            ", and recorded " + record + " hour of work on that task, and then another " + record2 + " hours of work on that task",
            ((double) record+record2)/estTime1*100.0, task.getPercentageComplete(), 0.000001);

        
        task.extendEstimate(extend);
        assertEquals("I created a new task with the estimatedLength="+estTime1+
            ", and recorded " + record + " hour of work on that task, and then another " + record2 + 
            " hours of work on that task and extended the estimated length of the task by " + extend + " hours",
            ((double) record+record2)/(estTime1+extend)*100.0, task.getPercentageComplete(), 0.000001);
    }
    
     @Test
    public void extendDeadline() {
        Task task = new Task(id1, description1, estTime1);
        Deadline d = new Deadline();
        assertEquals("Checking the date of the deadline", d, task.getDeadline());
        int extend = 1;
        task.extendDeadline(extend);
        d.setNewDeadline(extend);
        assertEquals("I extended the deadline by one day.  Checking the date of the deadline", 
            d, task.getDeadline());
        assertEquals("The deadline for the task has NOTE passed. The task should not be reported as late",
            false, task.isLate());

        extend = -10;
        task.extendDeadline(extend);
        d.setNewDeadline(extend);
        assertEquals("I extended the deadline by "+ extend + 
            " days.  Checking the date of the deadline", 
            d, task.getDeadline());
        assertEquals("The deadline for the task has passed it should now be reported as late",
            true, task.isLate());
    }
    }
   
    

    


    
     





