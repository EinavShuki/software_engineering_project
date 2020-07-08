

import java.io.Serializable;

import java.util.LinkedList;

public abstract class Person implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6052581537082334137L;
	private String firstName;
    private String lastName;
    private LinkedList<Integer> scheduledAppointments = new LinkedList<Integer>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract String getFullName();

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LinkedList<Integer> getScheduledAppointments() {
        return scheduledAppointments;
    }

    public boolean addAppointment(Integer appointmentID){
        return this.scheduledAppointments.add(appointmentID);
    }

    public boolean removeAppointment(Integer appointmentID){
        return this.scheduledAppointments.remove(appointmentID);
    }


}
