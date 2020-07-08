
import javax.print.Doc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class DoctorRepository {
    private static final String filepath="doctors.det";
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    public DoctorRepository() {
    }

    public ArrayList<Doctor> getDoctorsList() {
        return doctors;
    }

    public void addDoctorToRepository(Doctor doctor){
        doctors.add(doctor);
        this.WriteObjectToFile();
    }

    public void removeDoctorFromRepository(int doctorID){
        Doctor doctor = searchDoctorByWorkerID(doctorID);
        doctors.remove(doctor);
        this.WriteObjectToFile();
    }

    public Doctor searchDoctorByWorkerID(int workerID){
        for(Doctor doctor : this.doctors){
            if(doctor.getWorkerID()==workerID){
                return doctor;

            }
        }
        return null;
    }


    public ArrayList<Doctor> getSkilledDoctors(String procedureName){
        ArrayList<Doctor> skilledDoctors = new ArrayList<Doctor>();
        for(Doctor doctor: doctors){
            if(doctor.getSkills().contains(procedureName))
                skilledDoctors.add(doctor);
        }
        return skilledDoctors;
    }

    @Override
    public String toString() {
        String doctorsString="";
        for(Doctor doctor : this.getDoctorsList()) {
            doctorsString += doctor.toString() +"\n-----------\n";
        }
        return doctorsString;
    }


    public void WriteObjectToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            Doctor[] doctorsToWrite = doctors.toArray(new Doctor[doctors.size()]);
            objectOut.writeObject(doctorsToWrite);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void LoadFromFile() {

        try {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Doctor[] doctorsToRead = (Doctor[])ois.readObject();
            doctors.addAll(Arrays.asList(doctorsToRead));
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
