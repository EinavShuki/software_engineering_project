import java.io.Serializable;

public class Consultation extends Procedure  implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6002897255532966269L;


	public Consultation(String procedureName, double duration, double cost, int room) {
        super(procedureName, duration, cost, room);
    }
    public Consultation(){
        super();
    }

    public Consultation(Consultation consultation){
        super(consultation);

    }


    @Override
    public String toString(){
        return "Consultation - " + super.toString() +"\n\n";
    }



}
