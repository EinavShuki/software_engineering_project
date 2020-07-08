import java.io.Serializable;

public class Surgery extends Procedure  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -725413154693947040L;
	private int recoveryDays;
    private String anestheticType;

    public Surgery(String procedureName, double duration, double cost, int room, int recoveryDays, String anestheticType) {
        super(procedureName, duration, cost, room);
        this.recoveryDays = recoveryDays;
        this.anestheticType = anestheticType;
    }

    public Surgery(){
        super();
    }

    public Surgery(Surgery surgery){
        super(surgery.getProcedureName(),surgery.getDuration(),surgery.getCost(),surgery.getRoom());
        this.recoveryDays = surgery.getRecoveryDays();
        this.anestheticType = surgery.getAnestheticType();
    }

    public int getRecoveryDays() {
        return recoveryDays;
    }

    public void setRecoveryDays(int recoveryDays) {
        this.recoveryDays = recoveryDays;
    }

    public String getAnestheticType() {
        return anestheticType;
    }

    public void setAnestheticType(String anestheticType) {
        this.anestheticType = anestheticType;
    }

    @Override
    public String toString(){
        return "Surgery - " + super.toString() + "\nRecovery Days: "+ this.getRecoveryDays() +"\nAnesthetic Type: "+ this.getAnestheticType()+"\n\n";
    }



}
