
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcedureManager {

    private static final String filepath="procedures.det";
	private ArrayList<Procedure> proceduresList = new ArrayList<Procedure>();

    //constructor
    public ProcedureManager() {
    }

    public ArrayList<Procedure> getProceduresList() {
        return proceduresList;
    }

    public void addProcedureToList(Procedure procedure){
        if(this.proceduresList.contains(procedure)){
            Procedure p = this.searchProcedureByName(procedure.getProcedureName());
            p.setDuration(procedure.getDuration());
            p.setCost(procedure.getCost());
            p.setRoom(procedure.getRoom());
            if(procedure instanceof  Surgery){
                ((Surgery)p).setRecoveryDays(((Surgery) procedure).getRecoveryDays());
                ((Surgery)p).setAnestheticType(((Surgery) procedure).getAnestheticType());
            }
        }
        else{
            this.proceduresList.add(procedure);
        }
        this.WriteObjectToFile();
    }

    //delete based on procedure name (String)
    public boolean deleteProcedureFromSet(String procedureName){
        for(Procedure procedure: this.getProceduresList()){
            if(procedure.getProcedureName() == procedureName){
                this.proceduresList.remove(procedure);
                this.WriteObjectToFile();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Surgery> getSurgeriesList() {
        ArrayList<Surgery> surgeryList = new ArrayList<Surgery>();
        for(Procedure procedure : this.getProceduresList()) {
           if (procedure instanceof  Surgery){
               surgeryList.add((Surgery) procedure);
           }
        }
        return  surgeryList;
    }

    public ArrayList<Consultation> getConsultationList() {
        ArrayList<Consultation> consultationList = new ArrayList<Consultation>();
        for(Procedure procedure : this.getProceduresList()) {
            if (procedure instanceof  Consultation){
                consultationList.add((Consultation) procedure);
            }
        }
        return  consultationList;
    }

    //search based on procedure name (String)
    public Procedure searchProcedureByName(String procedureName){
        for(Procedure procedure: this.getProceduresList()){
            if(procedure.getProcedureName() == procedureName)
                return procedure;
        }
        return null;
    }

    @Override
    public String toString() {
        String proceduresString="";
        for(Procedure procedure : this.getProceduresList()) {
            proceduresString += procedure.toString() +"\n-----------\n";
        }
        return proceduresString;
    }


    public void WriteObjectToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            Procedure[] procedures = proceduresList.toArray(new Procedure[proceduresList.size()]);
            objectOut.writeObject(procedures);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void LoadFromFile() {

        try {
            FileInputStream fis = new FileInputStream(filepath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Procedure[] procedures = (Procedure[])ois.readObject();
            proceduresList.addAll(Arrays.asList(procedures));
            ois.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
