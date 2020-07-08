import java.io.Serializable;

public class Patient extends Person implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8685758684316438318L;
	private int ID;
    private String HMO;
    private MedicalFile medicalFile;
    private String appointmentsHistory;

    public Patient(String firstName, String lastName, int ID, String HMO, MedicalFile medicalFile) {
        super(firstName, lastName);
        this.ID = ID;
        this.HMO = HMO;
        this.medicalFile = medicalFile;
        this.appointmentsHistory="";
    }
    
    public Patient(int ID) {
    	super("","");
    	this.ID=ID;
    }
    
    public void addPatientDetails(String firstName, String lastName, String HMO, MedicalFile medicalFile) {
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
    	this.HMO=HMO;
    	this.medicalFile=medicalFile;
    }

    public String getFullName(){
        return this.getFirstName() +" "+ this.getLastName();
    }
    
    

    public int getID() {
        return ID;
    }



    public String getHMO() {
        return HMO;
    }



    public MedicalFile getMedicalFile() {
        return medicalFile;
    }



    public String getAppointmentsHistory() {
        return appointmentsHistory;
    }

    public void addAppointmentToHistory(Appointment appointment) {
        this.appointmentsHistory += appointment.toString();
    }




    @Override
    public String toString() {
        return "Patient: " + this.getFirstName() +" " + this.getLastName()+"\n\n"
                +"  ID: " + ID + "\n\n"
                +"  HMO: " + HMO + "\n\n"
                +"  " + medicalFile + "\n\n"
                +"  Appointments History: " + appointmentsHistory + "\n\n";
    }
}
