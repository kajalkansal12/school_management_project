import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Runner {
    public static void main(String[]args) throws Exception {
        School school=new School();
        school.setSchoolName("ABC Public School");


//        ArrayList<Student> aa = new ArrayList<>(List.of(new Student("A",92.1),new Student("B",32.3),new Student("C",65.3)));
        school.setStudent(new ArrayList<>());
        school.setCode(123);

        Scanner sc=new Scanner(System.in);
        System.out.println("*****  WELCOME TO ABC PUBLIC SCHOOL  *****");
        while(true){
            System.out.println("PRESS 1 TO ADD STUDENT");
            System.out.println("PRESS 2 TO DISPLAY ALL STUDENTS OF SCHOOL");
            System.out.println("PRESS 3 TO FIND STUDENT BY THEIR ID");
            System.out.println("PRESS 4 TO FIND STUDENT BY THEIR NAME");
            System.out.println("PRESS 5 TO FIND STUDENTS BY THEIR STANDARDS");
            System.out.println("PRESS 6 TO DEPOSIT FEES OF STUDENT");
            System.out.println("PRESS 7 TO UPLOAD MARKS");
            System.out.println("PRESS 8 TO SORT STUDENT ACCORDING TO THEIR STANDARD ON THE BASIS OF THEIR PERCENTAGE");
            System.out.println("PRESS 9 TO SEND ANY MESSAGE TO PARENTS ");
            System.out.println("PRESS 10 FOR EXIT");
            System.out.println("!!! Enter Your Choice !!!");
            int choice=sc.nextInt();
            if(choice==1){
                //add student
                Student S1=new Student();
                System.out.println("Enter The Name Of Student:");
                String name=sc.next();
                while(!name.matches("[a-zA-Z]+") || name.length() <2){
                    System.out.println("Invalid Name");
                    System.out.println("Please,Enter Name Again");
                    name = sc.next();
                }
                S1.setName(name);
                S1.setAdmission(LocalDate.now()); //now is a static function and localdate is a class
                System.out.println("Enter The Father's Name:");
                String fathersname=sc.next();
                while(!fathersname.matches("[a-zA-Z]+")){
                    System.out.println("Invalid Father's Name");
                    System.out.println("Please,Enter Father's Name Again");
                    fathersname=sc.next();
                }
                S1.setFathersname(fathersname);
                System.out.println("Enter The Contact Number of Parents:" );
                String phno=sc.next();
                while(!phno.matches("[6-9]{1}[0-9]{9}")) {
                    System.out.println("Invalid Phone Number");
                    System.out.println("Please,Enter Phone Number Again");
                    phno=sc.next();
                }
                System.out.println("Sending OTP");
                Thread.sleep(1000);
                Random random = new Random();
                int otp = random.nextInt(100)*random.nextInt(100);
                Sms.sendMessage("Your otp is "+otp,phno);
                LocalDateTime sentOTPTime = LocalDateTime.now();
                System.out.println("Please enter OTP sent to your phone");
                int userOTP = sc.nextInt();
                LocalDateTime userEnterOTPtime = LocalDateTime.now();
                if(userEnterOTPtime.isAfter(sentOTPTime.plusSeconds(30))){
                    System.out.println("OTP Expired");
                    break;
                }
                System.out.print("Verifying");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                while (otp!=userOTP){
                    System.out.println("Please enter valid otp");
                    userOTP = sc.nextInt();
                    System.out.println("Verifying");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                }
                System.out.println("\n");
                System.out.println("NUMBER IS VERIFIED");
                  S1.setPhNo(phno);
                S1.setAdder(new Address());
                System.out.println("Enter Your Permanent Address:");
                System.out.println("Enter Your Street Line Number:");
                String streetline1=sc.next();
                while(!streetline1.matches("[0-9]{2}")){
                    System.out.println("Invalid StreetLine Number");
                    System.out.println("Please,Enter StreetLine Again");
                    streetline1=sc.next();
                }
                S1.getAdder().setStreetline1(streetline1);
                System.out.println("Enter Your LandMark or Colony:");
                String streetline2=sc.next();
                while(!streetline2.matches("[a-zA-Z]+")){
                    System.out.println("Invalid LandMark or Colony");
                    System.out.println("Please,Enter LandMark or Colony Again");
                    streetline2=sc.next();
                }
                S1.getAdder().setStreetline2(streetline1);
                System.out.println("Enter Your City:");
                String city=sc.next();
                while(!city.matches("[a-zA-Z]+")){
                    System.out.println("Invalid City Name");
                    System.out.println("Please,Enter City Name Again");
                    city=sc.next();
                }
                S1.getAdder().setCity(city);
                System.out.println("Enter Pincode Number");
                String pincode= sc.next();
                while(!pincode.matches("[0-9]{6}")) {
                    System.out.println("Invalid  Pincode Number");
                    System.out.println("Please,Enter Pincode Number Again");
                    pincode = sc.next();
                }
                S1.getAdder().setPincode(pincode);
                System.out.println("Enter Country");
                String country=sc.next();
                while(!country.matches("[a-zA-Z]+")) {
                    System.out.println("Invalid Country Name ");
                    System.out.println("Please,Enter Country Name Again");
                    country = sc.next();
                }
                S1.getAdder().setCountry(country);
                System.out.println("Enter The Aadhar Number Of Student");
                String id=sc.next();
                while(!id.matches("[0-9]{4}")){
                    System.out.println("Invalid Aadhar Number");
                    System.out.println("Please,Enter Aadhar Number Again");
                    id=sc.next();
                }
                S1.setId(id);
                System.out.println("Enter The Standard Of Student");
                String standard=sc.next();
                while(!(standard.matches("[1-9]{1}")||standard.matches("[1]{1}[0-2]{1}"))){
                    System.out.println("Invalid Standard");
                    System.out.println("Please,Enter Standard Again");
                    standard=sc.next();
                }
                S1.setStandard(standard);
                System.out.println("                   THANKYOU!!");
                System.out.println("*****! YOUR CHILD ADDMISSION IS SUCCESSFUL !*****");
                System.out.println("          ADMISSION DATE:"+S1.getAdmission());
                System.out.println(" ");
                school.getStudent().add(S1);

                Sms.sendMessage("Welcome in our school "+name,phno);
                S1.getFees().add(LocalDate.now());
            }
            else if(choice==2){
                //print all students
                ArrayList<Student> temp=school.getStudent();
                for(int i=0;i<temp.size();i++){
                    System.out.println(" ***  Here,is the information of"+" "+i+" "+"student  ***");
                    System.out.println("NAME: "+temp.get(i).getName());
                    System.out.println("FATHER'S NAME:"+temp.get(i).getFathersname());
                    System.out.println("CONTACT NUMBER:"+temp.get(i).getPhNo());
                    System.out.println("ID:"+temp.get(i).getId());
                    System.out.println(" ");
                }
            }
            else if(choice==3){
                //find student with id
                System.out.println("Enter ID That You Want To Search");
                String tempid=sc.next();
                while(!tempid.matches("[0-9]{4}"));{
                    System.out.println("Invalid ID Number");
                    System.out.println("Enter ID Again");
                    tempid=sc.next();
                }
                ArrayList<Student>templist=school.getStudent();
                boolean found= true;
                for(int i=0;i<templist.size();i++){
                    if(templist.get(i).getId().equals(tempid)){
                        System.out.println("!!! Student Found !!!!");
                        System.out.println("Name of Student:"+templist.get(i).getName());
                        System.out.println("Fees Of Your Student Is:"+templist.get(i).getFees());
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("No Any Student Found");
                }
                System.out.println(" ");
            }
            else if(choice==4){
                //find student with id
                System.out.println("Enter NAME That You Want To Search");
                String tempname=sc.next();
                while(!tempname.matches("[a-zA-Z]+") && tempname.length() <2){
                    System.out.println("Invalid Name");
                    System.out.println("Enter Name Again");
                    tempname = sc.next();
                }
                ArrayList<Student>templist2=school.getStudent();
                boolean found= true;
                for(int i=0;i<templist2.size();i++){
                    if(templist2.get(i).getName().contains(tempname)){
                        System.out.println("!!! Student Found !!!!");
                        System.out.println("Name of Student:"+templist2.get(i).getName());
                        found=true;
                    }
                }
                if(!found){
                    System.out.println("No Any Student Found");
                }
                System.out.println(" ");
            }
            else if(choice==5){
              //students in same standard
                System.out.println("Enter The Standard For Students");
                String standard =sc.next();
                while(!(standard.matches("[1-9]{1}")||standard.matches("[1]{1}[0-2]{1}"))){
                    System.out.println("Invalid Standard");
                    System.out.println("Please,Enter Standard Again");
                    standard=sc.next();
                }
                System.out.println("!!! HERE., ARE THE DETAILS !!!");
                ArrayList<Student>standards=school.getStudent();
                for(int i=0;i< standards.size();i++){
                    if( standards.get(i).getStandard().equals(standard)){
                        System.out.println("NAME:"+standards.get(i).getName());
                        System.out.println("FATHER'S NAME:"+standards.get(i).getFathersname());
                        System.out.println("ADDRESS:"+standards.get(i).getAdder().getCity());
                        System.out.println("CONTACT NUMBER:"+standards.get(i).getPhNo());
                        System.out.println("ADMISSION DATE:"+standards.get(i).getAdmission());
                        System.out.println(" ");
                    }
                    System.out.println(" ");
                    //else{
                      //  System.out.println("No Any Student Found");
                    //}
                }
            }
            else if(choice==6){
                //deposit money
//                System.out.println("Enter Month ");
//                int tempmonth=sc.nextInt();
//                System.out.println("Enter Year");
//                int tempyear=sc.nextInt();
                System.out.println("Enter The ID Of Student");
                String tempid=sc.next();
                ArrayList<Student>templist=school.getStudent();
                boolean found=false;
                for(int i=0;i<templist.size();i++){
                    if(templist.get(i).getId().equals(tempid)){
                        System.out.println("Last fees Found:");
                        System.out.println(templist.get(i).getFees().get(templist.get(i).getFees().size()-1));
                        System.out.println("For How Many Months You Want To Submit Fees:");
                        int p= sc.nextInt();
                        if(p==1||p==2||p==3){
                            LocalDate lastfee=templist.get(i).getFees().get(templist.get(i).getFees().size()-1);
                            for(int j=1;j<=p;j++){
                                templist.get(i).getFees().add(lastfee.plusMonths(j));
                            }
                            System.out.println("FEES SUBMIT SUCCESSFULLY:");
                            System.out.println(templist.get(i).getFees());
                        }
                        else{
                            System.out.println("Invalid Month:");
                        }
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("No Any Student Found");
                }
                System.out.println(" ");
            }
            else if(choice==7){
                //to upload markss
                System.out.println("Enter The ID Of Student");
                String id=sc.next();
                while(!id.matches("[1-9]{4}")){
                    System.out.println("Invalid ID Number");
                    System.out.println("Enter ID Again");
                    id=sc.next();
                }
                ArrayList<Student>markss=school.getStudent();
                boolean found=false;
                for(int i=0;i<markss.size();i++){
                    if(markss.get(i).getId().equals(id)){
                        System.out.println("STUDENT FOUND");
                        System.out.println("ID:"+markss.get(i).getId());
                        //System.out.println("Enter Your Standard");
                        //String standard=sc.next();
                        if((markss.get(i).getStandard().length()==1)|| (markss.get(i).getStandard().equals("10"))){
                            System.out.println("ENTER MATHEMATICS MARKS:");
                            double maths=sc.nextDouble();
                            System.out.println("ENTER ENGLISH MARKS:");
                            double eng=sc.nextDouble();
                            System.out.println("ENTER HINDI MARKS:");
                            double hindi=sc.nextDouble();
                            System.out.println("ENTER SCIENCE MARKS:");
                            double sci=sc.nextDouble();
                            System.out.println("ENTER SOCIAL SCIENCE MARKS:");
                            double sst=sc.nextDouble();
                            double percentage=((maths+eng+hindi+sci+sst)/500)*100;

                            Sms.sendMessage("Hi "+markss.get(i).getName() +" \n Your Percentage is "+percentage , markss.get(i).getPhNo());

                            HashMap<String,Double>map=new HashMap<>();
                            map.put("MATHEMATICS",maths);
                            map.put("ENGLISH",eng);
                            map.put("HINDI",hindi);
                            map.put("SCIENCE",sci);
                            map.put("SOCIAL SCIENCE",sst);
                            markss.get(i).setMarks(map);
                            markss.get(i).setPercentage(percentage);
                            System.out.println("MARKS:"+markss.get(i).getMarks());
                            System.out.println("HERE, IS YOUR PERCENTAGE:"+percentage);
                            System.out.println(" ");
                        }
                        else{
                            System.out.println("ENTER MATHEMATICS MARKS:");
                            double maths=sc.nextDouble();
                            System.out.println("ENTER ENGLISH MARKS:");
                            double eng=sc.nextDouble();
                            System.out.println("ENTER PHYSICS MARKS:");
                            double hindi=sc.nextDouble();
                            System.out.println("ENTER CHEMISTRY MARKS:");
                            double sci=sc.nextDouble();
                            System.out.println("ENTER BIOLOGY MARKS:");
                            double sst=sc.nextDouble();
                            double percentage=(((maths+eng+hindi+sci+sst)/500)*100);

                            Sms.sendMessage("Hi "+markss.get(i).getName() +" \n Your Percentage is "+percentage , markss.get(i).getPhNo());

                            HashMap<String,Double>map=new HashMap<>();
                            map.put("MATHEMATICS",maths);
                            map.put("ENGLISH",eng);
                            map.put("PHYSICS",hindi);
                            map.put("CHEMISTRY",sci);
                            map.put("BIOLOGY",sst);
                            markss.get(i).setMarks(map);
                            markss.get(i).setPercentage(percentage);
                            System.out.println("MARKS:"+markss.get(i).getMarks());
                            System.out.println("HERE, IS YOUR PERCENTAGE:"+percentage);
                            System.out.println(" ");
                        }
                        found=true;
                        break;
                    }
                }
                if(!found){
                    System.out.println("No Any Student Found Of This Id");
                    System.out.println(" ");
                }
            }
            else if(choice==8) {
                //sorting
                System.out.println("ENTER STANDARD:");
                String standard = sc.next();
                while (!(standard.matches("[1-9]{1}") || standard.matches("[1]{1}[0-2]{1}"))) {
                    System.out.println("Invalid Standard");
                    System.out.println("Please,Enter Standard Again");
                    standard = sc.next();
                }
                ArrayList<Student> distinct = school.getStudent();
                ArrayList<Student> filter = new ArrayList<>();
                for (int i = 0; i < distinct.size(); i++) {
                    if (distinct.get(i).getStandard().equals(standard)) {
                        filter.add(distinct.get(i));
                    }
                }
                Collections.sort(filter, (S1, S2) -> S2.getPercentage().compareTo(S1.getPercentage()));
                for(int i=0;i< filter.size();i++){
                    System.out.println("MARKS:"+filter.get(i).getName()+" "+filter.get(i).getPercentage());
                    System.out.println(" ");
                }

            }
            else if(choice==9){
                //to send message

 List<Student> allStudent = school.getStudent();
                System.out.println("Enter The Message That You Want To Send");
                String message = sc.next();

for(int i=0;i< allStudent.size();i++) {
//    System.out.println("Enter The Message That You Want To Send");
//    String message = sc.next();
    Sms.sendMessage(message, allStudent.get(i).getPhNo());
//                Thread.sleep(1000);
//                Thread.sleep(1000);
    System.out.println("Message Is Sent Successfully");
}
            }
            else if(choice==10){

            }
            else if(choice==10){
                break;
            }
            else{
                System.out.println("!--- PLEASE ENTER VALID CHOICE ---!");
            }
        }
    }
}
