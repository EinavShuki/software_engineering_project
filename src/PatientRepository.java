import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class PatientRepository {
    private static final String filepath="patients.det";
    private ArrayList<Patient> patients = new ArrayList<Patient>();

    public PatientRepository() {
    }


    public ArrayList<Patient> getPatientsList() {
        return patients;
    }

    public void addPatientsToRepository(Patient patient){
        for(Patient p: patients){
            if(p.getID() == patient.getID())
                return;
        }
        patients.add(patient);
        this.WriteObjectToFile();
    }

    public void removePatientToRepository(int patientID){
        Patient patient = searchPatientByID(patientID);
        patients.remove(patient);
        this.WriteObjectToFile();
    }

    public Patient searchPatientByID(int ID){
        for(Patient patient : this.patients){
            if(patient.getID()==ID){
                return patient;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String patientsString="";
        for(Patient patient : this.getPatientsList()) {
            patientsString += patient.toString() +"\n-----------\n";
        }
        return patientsString;
    }


    public void WriteObjectToFile() {

        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            Patient[] patientsToWrite = patients.toArray(new Patient[patients.size()]);
            objectOut.writeObject(patientsToWrite);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void LoadFromFile() {

        try {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Patient[] patientsToRead = (Patient[])ois.readObject();
            patients.addAll(Arrays.asList(patientsToRead));
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
