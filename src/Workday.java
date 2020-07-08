import java.io.Serializable;

public class Workday implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -76096844130079629L;
	
	private double startHour;
    private double shiftDuration;
    private double restHourStart;
    private double restDuration;

    private static final double START_HOUR = 7;
    private static final double END_HOUR = 19.5;

    public Workday(double startHour, double shiftDuration, double restHourStart, double restDuration) {
        if (checkValidHours(startHour, shiftDuration, restHourStart, restDuration)) {
            this.startHour = startHour;
            this.shiftDuration = shiftDuration;
            this.restHourStart = restHourStart;
            this.restDuration = restDuration;
        }

    }

    public double getStartHour() {
        return startHour;
    }

    public double getShiftDuration() {
        return shiftDuration;
    }

    public double getRestHourStart() {
        return restHourStart;
    }

    public double getRestDuration() {
        return restDuration;
    }

    public double getEndHour(){
        return this.startHour + this.shiftDuration;
    }

    public double getRestEndHour(){
        return this.restHourStart + this.restDuration;
    }

    public boolean modifyWorkday(double startHour, double shiftDuration, double restHourStart, double restDuration){
        if (checkValidHours(startHour, shiftDuration, restHourStart, restDuration)) {
            this.startHour = startHour;
            this.shiftDuration = shiftDuration;
            this.restHourStart = restHourStart;
            this.restDuration = restDuration;
            return true;
        }
        return false;
    }


    public boolean checkValidHours(double startHour, double shiftDuration, double restHourStart, double restDuration) {
        //shift not in working time
        if (startHour < START_HOUR || startHour + shiftDuration > END_HOUR)
            return false;
            //rest not in working time
        else if (restHourStart < START_HOUR || restHourStart + restDuration > END_HOUR)
            return false;
            //rest hour is before Starting hour
        else if (restHourStart < startHour)
            return false;
            //rest hour after shift ends
        else if (restHourStart > startHour + shiftDuration)
            return false;
        else
            return true;
    }

    @Override
    public String toString() {
        double endHour = this.getEndHour();
        double restEnd = this.getRestEndHour();
        return "\nStart shift hour: " + this.startHour + " | End shift hour: " + endHour + "\nrest hour start at: " +
                this.restHourStart + " | rest hour ends: " + restEnd +"\n\n";

    }
}
