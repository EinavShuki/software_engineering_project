import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class AppointmentManager {
    private static final String filepath="appointments.det";
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();


    public AppointmentManager() {
    }

    public void addAppointmentToList(Appointment appointment){
        appointments.add(appointment);
        this.WriteObjectToFile();
    }

    public void RemoveAppointmentFromList(int appointmentID){
        Appointment appointment = searchAppointmentsByID(appointmentID);
        appointments.remove(appointment);
        this.WriteObjectToFile();
    }


    public Appointment searchAppointmentsByID(int appointmentID){
        for(Appointment appointment: appointments){
            if(appointment.getAppointmentID()==appointmentID)
                return appointment;
        }
        return null;
    }

    public ArrayList<Appointment> getAppointmentsForToday(){
        LocalDate currentDate = LocalDate.now();
        ArrayList<Appointment> todaysAppointments = new ArrayList<Appointment>();
        for(Appointment appointment: appointments){
            if(currentDate.equals(appointment.getDate()))
                todaysAppointments.add(appointment);
        }
    return todaysAppointments;
    }


    public ArrayList<Appointment> getOldAppointments(){
        LocalDate currentDate = LocalDate.now();
        ArrayList<Appointment> oldAppointments = new ArrayList<Appointment>();

        for(Appointment appointment: appointments){
            if(appointment.getDate().isBefore(currentDate))
                oldAppointments.add(appointment);
        }
        return oldAppointments;
    }

    public ArrayList<Appointment> searchAppointmentsByDoctor(int doctorID){
        ArrayList<Appointment> doctorsAppointment = new ArrayList<Appointment>();
        for(Appointment appointment: appointments){
            if(appointment.getDoctorWorkerID()==doctorID)
            doctorsAppointment.add(appointment);
        }
        return doctorsAppointment;
    }

    public ArrayList<Appointment> searchAppointmentsByPatient(int patientID){
        ArrayList<Appointment> patientsAppointments = new ArrayList<Appointment>();
        for(Appointment appointment: appointments){
            if(appointment.getPatientID()==patientID)
            patientsAppointments.add(appointment);
        }
        return patientsAppointments;
    }

    public ArrayList<Appointment> getAppointmentsForDate(LocalDate askedDate){
        ArrayList<Appointment> askedAppointments = new ArrayList<Appointment>();
        for(Appointment appointment: appointments){
            if(askedDate.equals(appointment.getDate()))
            askedAppointments.add(appointment);
        }
        return askedAppointments;
    }


    public void WriteObjectToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            Appointment[] appointmentsToWrite = appointments.toArray(new Appointment[appointments.size()]);
            objectOut.writeObject(appointmentsToWrite);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void LoadFromFile() {

        try {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Appointment[] appointmentsToRead = (Appointment[])ois.readObject();
            appointments.addAll(Arrays.asList(appointmentsToRead));
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String toString() {
        String appoitmentsString="";
        for(Appointment appointment : appointments) {
            appoitmentsString += appointment.toString() +"\n-----------\n";
        }
        return appoitmentsString;
    }

}
