import java.util.ArrayList;

public class School {
    private String schoolname;
    private ArrayList<Student>student;
    private int code;
    public void setSchoolName(String schoolname){
        this.schoolname=schoolname;
    }
    public String getSchoolName(){
        return schoolname;
    }
    public void setStudent(ArrayList<Student> student){
        this.student=student;
    }
    public ArrayList<Student> getStudent(){
        return student;
    }
    public void setCode(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }
}
