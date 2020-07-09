
/**
 * Write a description of class TaskSystem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaskSystem
{
    // instance variables - replace the example below with your own
    private InputReader reader;
    private TaskManager manager;

    /**
     * Constructor for objects of class TaskSystem
     */
    public TaskSystem()
    {
        reader = new InputReader();
        manager = new TaskManager();

    }

    public TaskSystem(String filename )
    {
        reader = new InputReader(filename);

        manager = new TaskManager();
    }

    public void start(){
        boolean finished = false;
        printWelcome();

        while(!finished){
            String input = reader.getTextInput("Enter a command");

            if (input.equals("add")){
                String description = reader.getTextInput ("Enter description of task; ");
                int estimatedLength = reader.getIntegerInput(" Enter estimated hours; ");
                System.out.println("task added");
                manager.addTask(description,estimatedLength);
            }else if(input.equals("bye")){
                finished = true;  
            }
            else if (input.equals("all")){
                System.out.println(manager.getAllTasks());
            }
            else if (input.equals("late")){
                System.out.println(manager.getLateTasks());
            }
            else if (input.equals("todo")){
                System.out.println(manager.getIncompleteTasks());
            }
            else if (input.equals("done")){
                int completedTaskID = reader.getIntegerInput( "Enter a completed task id; ");
                System.out.println(manager.setCompleted (completedTaskID));
            }
            else if (input.equals("delete")){
                if(manager.getCount() == 0){
                    System.out.println("no tasks in list");
                }
                else{
                    String completedTasks = manager.getSummaryComplete();
                    System.out.println(completedTasks);
                    int idOfTasktoBeDeleted = reader.getIntegerInput( "Enter a deleted task id; ");
                    if (manager.findById(idOfTasktoBeDeleted) != null && manager.findById(idOfTasktoBeDeleted).isDone() == true){
                        manager.deleteTask(idOfTasktoBeDeleted);
                        System.out.println("task deleted");
                    }else{
                        System.out.println("task cannot be deletd because Id cannot be found ");

                    }
                }
            }

            else if (input.equals("deadline")){
                if(manager.getCount() == 0){
                    System.out.println("no tasks in list");
                }
                else{
                    String Incompletetasks = manager.getSummaryIncomplete();
                    System.out.println(Incompletetasks);
                    int id = reader.getIntegerInput( "Enter task id; ");
                    if (manager.findById(id) != null && manager.findById(id).isDone() == false){
                        int days = reader.getIntegerInput( "Enter number of days; ");
                        manager.findById(id).extendDeadline(days);
                        System.out.println("task extended");
                    }else{
                        System.out.println("task cannot be extended as if cannot be found");
                    }
                }
            }
                        

                
                else if (input.equals("countall")){
                    System.out.println(manager.getAllTasks());
                }
                else if (input.equals("count")){
                    System.out.println(manager.getIncompleteTasks());
                }
                else if (input.equals("time")){
                    if(manager.getCount() == 0){
                    System.out.println("no tasks in list");
                }
                else{
                    String IncompleteTasks = manager.getSummaryIncomplete();
                    System.out.println(IncompleteTasks);
                    int id = reader.getIntegerInput( "Enter task id; ");
                    if (manager.findById(id) != null && manager.findById(id).isDone() != true ){
                         int hours = reader.getIntegerInput( "Enter number of hours; ");
                        manager.findById(id).recordHoursWorked(hours);
                        System.out.println("hours worked has been recorded.\n");
                        
                    }else{
                        System.out.println("hours cannot be recorded as ID cannot be found");
                    }
                }
            }
                  
                    
                
                else if (input.equals("Incomplete")){
                    System.out.println(manager.getSummaryIncomplete());          
                }
                else if (input.equals("complete")){
                    System.out.println(manager.getSummaryComplete());          
                }
                else if (input.equals("extend estimate")){
                    int id = reader.getIntegerInput( "Enter task id; ");
                    int hours = reader.getIntegerInput( "Enter number of hours; ");
                    Task task = manager.findById(id);
                    task.extendEstimate(hours);
                }else if (input.equals("search")){
                     if(manager.getCount() == 0){
                    System.out.println("no tasks in list");
                }
                else{
                    String description = manager.search( "Enter task description; ");
                    System.out.println(description);
                    
                    if (manager.search(description) == description ){
                        
                       
                        
                    }else{
                        System.out.println("hours cannot be recorded as ID cannot be found");
                    }
                }
            }
                    
                
                    
                    
                    
                    
                    
                }
                
      
            
                
                    System.out.println("That method isnt recognised");
                }
                
            
       

        private void printWelcome(){
            System.out.println("Welcome to the Task Management System.");
            System.out.println("\n");
            System.out.println("Commands are:");
            System.out.println("'add' to add a task.");
            System.out.println("'all' to print all tasks.");
            System.out.println("'late' to print all late tasks.");
            System.out.println("'todo' to print all incomplete tasks.");
            System.out.println("'done' to complete a task.");
            System.out.println("'delete' to delete a task.");
            System.out.println("'deadline' to extend a deadline for a task.");
            System.out.println("'countall' to print the number of tasks.");
            System.out.println("'count' to print the number of tasks to complete.");
            System.out.println("'time' to record the number of hours working on a task.");
            System.out.println("'Incomplete' to get a summary of the not yet completed tasks.");
            System.out.println("'complete' to get a summary of the completed tasks.");
            System.out.println("'extend estimate' to extend the estimated amount of days.");
            System.out.println("'search' search for a task.");
            System.out.println("\n");
            System.out.println("please type 'bye' to exit our system.");

        }
    }

