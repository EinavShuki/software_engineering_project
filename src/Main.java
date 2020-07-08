
public class Main 
{
    public static void main(String[] args) {
        ProcedureManager procedures = new ProcedureManager();
        DoctorRepository docRep = new DoctorRepository();
        PatientRepository patientRep = new PatientRepository();
        AppointmentManager appointmentManager = new AppointmentManager();


        procedures.LoadFromFile();
        docRep.LoadFromFile();
        patientRep.LoadFromFile();
        appointmentManager.LoadFromFile();


        System.out.println(procedures);
        System.out.println(docRep);
        System.out.println(patientRep);
        System.out.println(appointmentManager);
       // MedicalFile(char sex, int yearOfBirth, int monthOfBirth, String knownDiseases, String allergies)
        
        //MedicalFile m0=("female",1997,4,"Astma","dust");
        
       // Patient p0("Shuki","Shpigel",313188888,"Macabi",)
        
        

    }
}
