import java.io.Serializable;
import java.util.Objects;

public abstract class Procedure  implements Serializable {

    private static final long serialVersionUID = 4840351299801912258L;
    private String procedureName;
    private double duration;
    private double cost;
    private int room;

    // constructor
    public Procedure(String procedureName, double duration, double cost, int room) {
        this.procedureName = procedureName;
        this.duration = duration;
        this.cost = cost;
        this.room = room;
    }

    public Procedure() {
    }

    public Procedure(Procedure procedure) {
        this.procedureName = procedure.getProcedureName();
        this.duration = procedure.getDuration();
        this.cost = procedure.getCost();
        this.room = procedure.getRoom();
    }


    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return procedureName.equals(procedure.procedureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedureName);
    }

    @Override
    public String toString() {
        return this.getProcedureName() + ": \nDuration: " + this.getDuration() + " hours \nCost: " + this.getCost() + " NIS \nRoom number: " + +this.getRoom();
    }
}
