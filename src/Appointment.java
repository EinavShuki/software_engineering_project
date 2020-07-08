import java.io.Serializable;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class Appointment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8515457742734241389L;

	private static int appointmentCount=0;

    private int appointmentID;
    private Map<String ,Integer> participants = new HashMap<String, Integer>();
    private LocalDate date;
    private double startHour;
    private double endHour;
    private String procedureName;


    public Appointment(int doctorID, int patientID, int day, int month, int year, double startHour, double endHour, String procedureName) {
        this.participants.put("WorkerID",doctorID);
        this.participants.put("PatientID",patientID);
        this.date =  LocalDate.of(year, month, day);
        this.startHour = startHour;
        this.endHour = endHour;
        this.procedureName = procedureName;
        this.appointmentID=appointmentCount;
        appointmentCount++;
    }

    public void addAppointmentToParticipant(Person person){
        person.addAppointment(this.appointmentID);
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public LocalDate getDate() {
        return date;
    }


    public DayOfWeek getDayOfTheWeek() {
        return date.getDayOfWeek();
    }

    public double getAppointmentStartHour() {
        return startHour;
    }

    public double getAppointmentEndHour() {
        return endHour;
    }

    public double getAppointmentDuration() {
        return endHour-startHour;
    }

    public void updateAppointmentDateAndHour(int day, int month, int year, double startHour, double endHour) {
        this.date =  LocalDate.of(year, month, day);
        this.startHour = startHour;
        this.endHour = endHour;
    }


    public int getPatientID(){
        return participants.get("PatientID");
    }

    public int getDoctorWorkerID(){
        return participants.get("WorkerID");
    }

    public String getProcedureName() {
        return procedureName;
    }



    @Override
    public String toString() {
        return  "Appointment:\n" +
                "   Participants: DR. " + this.getDoctorWorkerID() +", " + this.getPatientID() + "\n" +
                "   Procedure: " + procedureName + "\n" +
                "   Date: " + this.getDayOfTheWeek() + ", " + this.date + "\n" +
                "   Hour: " + startHour + " - " + endHour + " (Duration: " + this.getAppointmentDuration() + ")\n\n";
    }


}
