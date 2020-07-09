import java.util.ArrayList;
/**
 * Write a description of class TaskManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaskManager
{
    private ArrayList<Task> tasks;
    private int nextTaskId;

    public TaskManager(){
        tasks = new ArrayList<Task>();
        nextTaskId = 1;
    }

    public int getCount(){
        return this.tasks.size();
    }

    public String addTask(String descriptionOfnewTask, int estimatedLength){
        Task t = new Task(nextTaskId, descriptionOfnewTask,estimatedLength);

        if (tasks.add(t) == true){
            nextTaskId = nextTaskId + 1;
            return "Task added.";
        }else{
            return "Error: not added.";
        }
    }
    
    public String search ( String description){
        for (int i =0; i < tasks.size(); i++){
            if (tasks.get(i).getDescription() == description){
                return tasks.get(i).getSummary();
            }
        }
    return null;
}

    public Task findById(int taskID){
        for(int i = 0;i < this.tasks.size(); i++){
            if(this.tasks.get(i).getId() == taskID){
                return tasks.get(i);

            }
        }
        return null;
    }

    public Task setCompleted (int completedTaskID){
        int i = 0;
        Task task = findById(completedTaskID);
        while(i < this.tasks.size()){
            if(task != null){
                task.getId();
                task.setDone();
                i++;

            }
            return task;
        }
        return null;

    }

    public Task deleteTask(int idOfTasktoBeDeleted){
        Task t = findById(idOfTasktoBeDeleted);

        if (t != null && t.isDone() == true){   
            this.tasks.remove(t);
            return t;
        }else{
            return null;

        }
    }

    public int getCountTodo(){
        int count = 0;

        for(int i =0; i< tasks.size(); i++){
            Task t = tasks.get(i);
            if(t.isDone() == false){

                count++;

            }

        } 
        return count;
    }

    public String getSummaryComplete(){
        StringBuilder completeSummary = new StringBuilder();
        completeSummary.append("Tasks IDs:\n");
        for(int i =0; i < tasks.size();i++){
            if (tasks.get(i).isDone() == true){
                completeSummary.append(tasks.get(i).getSummary());
            }
        }
        return completeSummary.toString();  

    }

    public String getSummaryIncomplete(){
        StringBuilder summaryIncomplete = new StringBuilder();
        summaryIncomplete.append("Tasks IDs:\n");
        for (int i = 0 ; i < tasks.size();i++){
         
            if (tasks.get(i).isDone() ==  false){

                summaryIncomplete.append(tasks.get(i).getSummary());
            }

        }
        return summaryIncomplete.toString();
    }

    public String getAllTasks(){

        StringBuilder allTasks = new StringBuilder();
        allTasks.append("All Tasks:\n");
        for (int i = 0 ; i < tasks.size(); i++){
            allTasks.append(tasks.get(i).toString());
        }
        return allTasks.toString();

    }

    
    public String getIncompleteTasks(){
        StringBuilder sb = new StringBuilder();
        sb.append ("Incomplete Tasks:\n");

        for(int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).isDone() == false){
                sb.append(tasks.get(i).toString());
            }

        }
        return sb.toString();
    }

    public String getLateTasks(){
        StringBuilder sb = new StringBuilder();
        sb.append("Late Tasks:\n");
        
        
        for( int i = 0; i <tasks.size(); i++){
            if(tasks.get(i).isDone() == false && tasks.get(i).isLate() == true){
                sb.append(tasks.get(i).toString());
            
                
            }
            
            
        
    }
    
    return sb.toString();
}
     
}




