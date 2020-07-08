

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Doctor extends Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7255740742669977213L;
	
	private int workerID;
    private LinkedList<String> skills = new LinkedList<String>();
    private Map<String ,Workday> receptionDays = new HashMap<String, Workday>();

    public Doctor(String firstName, String lastName, int workerID) {
        super(firstName, lastName);
        this.workerID = workerID;
    }



    public String getFullName(){
        return "Dr. " + this.getFirstName() +" "+ this.getLastName();
    }

    public int getWorkerID() {
        return workerID;
    }


    public LinkedList<String> getSkills() {
        return skills;
    }

    public boolean addSkill(Procedure procedure){
        return this.skills.add(procedure.getProcedureName());
    }

    public boolean removeSkill(String procedureName){
        return this.skills.remove(procedureName);
    }


    public void addReceptionDay(String dayOfTheWeek, Workday workday){
        this.receptionDays.put(dayOfTheWeek, workday);
    }

    public Workday getReceptionHoursByDay(String dayOfTheWeek) {
        return receptionDays.containsKey(dayOfTheWeek) ? receptionDays.get(dayOfTheWeek): null;
    }


    @Override
    public String toString() {
        return "Dr. " + this.getFirstName() +" " + this.getLastName()+"\n\n"
                +"  Worker ID: " + workerID + "\n\n"
                +"  Skills: " + skills + "\n\n"
                +"  Reception Days: " + receptionDays + "\n\n";
    }
}
