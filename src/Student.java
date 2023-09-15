import java.util.*;
import java.time.*;
public class Student {
    private String name;
    private String fathersname;
    private String phno;
    private String id;
    private LocalDate admission;
    private Address adder;
    private String standard;

    public List<LocalDate> getFees() {
        return fees;
    }

    public void setFees(List<LocalDate> fees) {
        this.fees = fees;
    }

    private Double percentage;
private List<LocalDate>fees = new ArrayList<>();
    public Student(){

    }
    public Student(String name, Double per){
        this.name = name;
        this.percentage = per;
        this.standard = "11";
    }

    public Student(String name, String fathersname, String phno, String id, List<LocalDate> fees, LocalDate admission, Address adder, String standard, Double percentage, HashMap<String, Double> marks) {
        this.name = name;
        this.fathersname = fathersname;
        this.phno = phno;
        this.id = id;
        this.fees = fees;
        this.admission = admission;
        this.adder = adder;
        this.standard = standard;
        this.percentage = percentage;
        this.marks = marks;
    }

    public HashMap<String, Double> getMarks() {
        return marks;
    }

    public void setMarks(HashMap<String, Double> marks) {
        this.marks = marks;
    }

    private  HashMap<String,Double>marks;

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Address getAdder() {
        return adder;
    }

    public void setAdder(Address adder) {
        this.adder = adder;
    }

    public LocalDate getAdmission() {
        return admission;
    }

    public void setAdmission(LocalDate admission) {
        this.admission = admission;
    }

    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setFathersname(String fathersname){
        this.fathersname=fathersname;
    }
    public String getFathersname(){
        return fathersname;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setPhNo(String phno){
        this.phno=phno;
    }
    public String getPhNo(){
        return phno;
    }
}
