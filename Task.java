 /**
 * This class models a Task.  Each task has an id, a deadline and a 
 * description.  Tasks may be marked as completed (ie they have been 
 * finished).  Each task has an estimated number of hours to complete.  
 * A task will can keep track of the number of hours spent working on it.
 * 
 * @author PUT YOUR NAME HERE
 * @version November 2015
 */
public class Task {  
    private int id;
    private String description;
    private Deadline deadline;
    private boolean done;
    private int estimatedLength;
    private int hoursWork;
    private Integer numberOfhours;
    

    public Task(int id, String description, int estimatedLength){
        deadline = new Deadline();
        this.id = id;
        this.description = description;
        this.estimatedLength = estimatedLength;
        done = false;
        hoursWork = 0;
    }

    public int getId(){
        return id;
    }
    
    

    public Deadline getDeadline(){
        return deadline;
    }

    public String getDescription(){
        return description;
    }

    public boolean isDone(){
        return done;
    }

    public double getPercentageComplete(){

        double estimatedLengthDouble = (double) estimatedLength;
        double hoursWorkDouble = (double) hoursWork;

        return (double)hoursWork/(double)estimatedLength* 100.0;
    }

    public boolean isLate(){
        if (done == false && deadline.hasPassed()){
            return true;
        }else{
            return false;
        }
    }

    public void setDone(){
        this.done = true;

    }
 
    public void recordHoursWorked(int hours){
        hoursWork = hoursWork + hours;

    }

    public void extendEstimate(int hours){
        estimatedLength = estimatedLength + hours;

    }

    public void extendDeadline(int days ) {
        deadline.setNewDeadline(days);
        
    }
    
    

    public String getSummary(){
        StringBuilder sb = new StringBuilder();
        sb.append(id + ": "); 
        sb.append(getDescription() + ": "); 
        sb.append(getPercentageComplete() + "\n");
        return sb.toString();
    }
    
    public String toString(){
       StringBuilder sb = new StringBuilder();
        sb.append(id + ": "); 
        sb.append(description + ", Due: " + deadline + ": ");
        sb.append(getPercentageComplete() + "% complete, done: " + done + "\n");
        return sb.toString();
  
    
    
    
     
    
    
    


}


}

    