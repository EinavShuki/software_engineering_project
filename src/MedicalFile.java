
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;



public class MedicalFile implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7787574045105059902L;
	private char sex;
    private int yearOfBirth;
    private int monthOfBirth;
    private double age;
    private String knownDiseases;
    private String allergies;
    private boolean minor;


    public MedicalFile(char sex, int yearOfBirth, int monthOfBirth, String knownDiseases, String allergies) {
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.knownDiseases = knownDiseases;
        this.allergies = allergies;
        this.age = CalculateAge(yearOfBirth, monthOfBirth);
        this.minor = this.age < 18;
    }

    public char getSex() {
        return sex;
    }

    public double getAge() {
        return age;
    }

    public String getKnownDiseases() {
        return knownDiseases;
    }

    public String getAllergies() {
        return allergies;
    }

    public boolean isMinor() {
        return minor;
    }

    public void addDisease(String newDisease) {
        this.knownDiseases += ", " + newDisease;
    }

    public void addAllergy(String newAllergy) {
        this.allergies += ", " + newAllergy;
    }

    public double CalculateAge(int yearOfBirth, int monthOfBirth) {
        LocalDate today = LocalDate.now();                          //Today's date
        LocalDate birthday = LocalDate.of(yearOfBirth, monthOfBirth, 1);  //Birth date

        Period p = Period.between(birthday, today);

        double age = p.getYears() + ((double) p.getMonths() / 100);
        return age;
    }

    @Override
    public String toString() {
        return "Medical File:\n     Sex: " + sex + "\n     Age: " + age + "\n     Known Diseases: " + knownDiseases + "\n     Allergies: " +
                allergies + "\n     Minor: " + minor;
    }
}
