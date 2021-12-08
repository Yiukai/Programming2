package Assignment_two;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyMain {
    //attempt to add a dean with a type other than teacher
    static void addDean(Student s)throws InvalidDean{
        StudentList.add(s);
    }
    
    static void addTeacher(Teacher t)throws deptNotExist{
        TeachList.add(t);
    }
    static void addStudent(Student s)throws deptNotExist{
        StudentList.add(s);
    }
    static void addStaff(Staff s)throws deptNotExist{
        Staffs.add(s);
    }
    
    static void addingTeacher(Teacher t)throws alreadyExists{
        TeachList.add(t);
    }
    static void addingStudent(Student s)throws alreadyExists{
        StudentList.add(s);
    }
    static void addingStaff(Staff s)throws alreadyExists{
        Staffs.add(s);
    }
    
    static ArrayList<Staff> Staffs = new ArrayList<>();
    static ArrayList<Student> StudentList = new ArrayList<>();
    static ArrayList<Teacher> TeachList = new ArrayList<>();
       
    public static void main(String[] args) throws IOException{
        //read staff file
        String filePath = "C:\\\\Users\\\\wyiuk\\\\Desktop\\\\FinalProject\\\\Staff.txt";
        try{
            RandomAccessFile file = new RandomAccessFile(filePath, "r");
            String string;
            while((string=file.readLine())!=null){
                System.out.println(string);
                String staffLine[] = string.split(",");
                Staff staff = new Staff(Integer.parseInt(staffLine[0]),staffLine[1],
                                        Integer.parseInt(staffLine[2]), staffLine[3], 
                                        staffLine[4],Integer.parseInt(staffLine[5]),Integer.parseInt(staffLine[6]));
                Staffs.add(staff);
            }
            Staffs.forEach((s) -> {
                s.toString();
            });        
        }catch(IOException ex){}
        
         //read student file 
        String filePath1 = "C:\\\\Users\\\\wyiuk\\\\Desktop\\\\FinalProject\\\\Student.txt";
        try{
            RandomAccessFile file = new RandomAccessFile(filePath1, "r");
            String string;
            while((string=file.readLine())!=null){
                System.out.println(string);
                String studentLine[] = string.split(",");
                Student student = new Student(Integer.parseInt(studentLine[0]),studentLine[1],
                                              Integer.parseInt(studentLine[2]),studentLine[3], 
                                              studentLine[4],Integer.parseInt(studentLine[5]),Integer.parseInt(studentLine[6]));
                StudentList.add(student);
            }
            StudentList.forEach((s) -> {
                s.toString();
            });        
        }catch(IOException ex){}   
        //read teacher file       
        String filePath2 = "C:\\\\Users\\\\wyiuk\\\\Desktop\\\\FinalProject\\\\Teacher.txt";
        try{
            RandomAccessFile file = new RandomAccessFile(filePath2, "r");
            String string;
            while((string=file.readLine())!=null){
                System.out.println(string);
                String teacherLine[] = string.split(",");
                Teacher teacher = new Teacher(Integer.parseInt(teacherLine[0]),teacherLine[1],
                                              Integer.parseInt(teacherLine[2]),teacherLine[3], 
                                              teacherLine[4],teacherLine[5],Integer.parseInt(teacherLine[6]));
                TeachList.add(teacher);
            }
            TeachList.forEach((t) -> {
                t.toString();
            });        
        }catch(IOException ex){}
        
    int choice;
    String response;
    Scanner input = new Scanner(System.in);
    ArrayList<Department> DeptList = new ArrayList<>();
    
    do{
    System.out.println("Please choose an option: ");
    System.out.println("1. Add Department: ");
    System.out.println("2. Add Teacher: ");
    System.out.println("3. Add Student:");
    System.out.println("4. Assign dean:");
    System.out.println("5. Display departments:");
    System.out.println("6. Display teachers:");
    System.out.println("7. Display students:");
    System.out.println("8. Display dean:");
    System.out.println("9. Add staff:");
    System.out.println("Enter your choice: ");
    choice = input.nextInt();
        switch (choice) {
case 1:
                //1. Add department 
                System.out.println("Creating a department");
                System.out.println("Enter Id: ");
                int id = input.nextInt();
                System.out.println("Enter Description");
                String desc = input.next();
                Department mydept = new Department(id, desc);
                DeptList.add(mydept);
                break;
case 2:
                //2. Add teacher and assign the teacher to a department
                    System.out.println("Creating a teacher");
                    System.out.println("Which department you want to assign this teacher to?");
                    int idDept = input.nextInt();
                    System.out.println("Enter the Id of the teacher");
                    int teachId = input.nextInt();
                    System.out.println("Enter the name of the teacher");
                    String teachName = input.next();
                    Teacher newTeacher = new Teacher(teachId, teachName);
                    TeachList.add(newTeacher);

                    int count = -1;
                    int index = -1;
                    for (Teacher t : TeachList){
                        index++;
                        if(t.getId() == teachId){
                            count = index;
                        }
                    }
                    int count_d = -1;
                    int index_d = -1;
                    for (Department d : DeptList){
                        count_d++;
                        if(d.getId() == idDept){
                            count_d = index_d;
                        }
                    }
                    if ((count > -1) && (count_d > -1)){
                        DeptList.get(count_d).TeacherList.add(TeachList.get(count));
                    }
                //try to add a teacher to an inexistent department
                try{
                    for(int i=0;i<TeachList.size();i++){
                        int a=0;
                        if(DeptList.get(a).id != TeachList.get(i).department_id){
                            Teacher t = new Teacher();
                            addTeacher(t);
                            a++;
                        }
                    }                    
                }catch(deptNotExist dne){
                    System.out.println("We can't add the teacher because the department doesn't exist");
                }
                //try to add a teacher that already exists
                try{
                    for(int i=0;i<TeachList.size();i++){
                        for(int a=0;a<TeachList.size();a++){
                            if(TeachList.get(i).department_id != DeptList.get(a).id){
                                Teacher t = new Teacher();
                                addingTeacher(t);
                            }
                        }
                    }
                }catch(alreadyExists ae){
                    System.out.println("We can't add the teacher because the teacher already exists");
                }
                try{
                    Scanner stdDean = new Scanner(System.in);
                    System.out.println("Enter the id of the student");
                    int stdId = stdDean.nextInt();
                    System.out.println("Enter the name of the student");
                    String stdName = stdDean.next();
                    Student Dean = new Student(stdId,stdName);
                    addDean(Dean);
                }catch(InvalidDean e){
                    System.out.println("The dean should be a teacher of that department");
                }
                //generate new version of the teacher file
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:Users/wyiuk/Desktop/FinalProject/Teacher.txt",true));
                for(int i=0;i<TeachList.size();i++){
                    writer.write(TeachList.get(i).id+",");
                    writer.write(TeachList.get(i).name+",");
                    writer.write(TeachList.get(i).age+",");
                    writer.write(TeachList.get(i).gender+",");
                    writer.write(TeachList.get(i).speciality+",");
                    writer.write(TeachList.get(i).degree+",");
                    writer.write(TeachList.get(i).department_id);
                }
                writer.close();               
                break;
case 3:
                //3. Add student
                    System.out.println("Which department you want to assign this student to? Enter the id of a department");
                    int stdidDept = input.nextInt();
                    System.out.println("Enter the Id of the student");
                    int stdId = input.nextInt();
                    System.out.println("Enter the name of the student");
                    String stdName = input.next();
                    Student newStudent = new Student(stdId, stdName);
                    StudentList.add(newStudent);

                    int stcount = -1;
                    int stindex = -1;
                    for (Student s : StudentList){
                        stindex++;
                        if(s.getId() == stdId){
                            stcount = stindex;
                        }
                    }
                    int stcount_d = -1;
                    int stindex_d = -1;
                    for (Department d : DeptList){
                        stcount_d++;
                        if(d.getId() == stdidDept){
                            stcount_d = stindex_d;
                        }
                    }
                    if ((stcount > -1) && (stcount_d > -1)){
                        DeptList.get(stcount_d).StudentList.add(StudentList.get(stcount));
                    }                   
                
                //try to add a student to an inexistent department
                try{
                    for(int i=0;i<StudentList.size();i++){
                        int a=0;
                        if(DeptList.get(a).id != StudentList.get(i).department_id){
                            Student s = new Student();
                            addStudent(s);
                            a++;
                        }
                    }                    
                }catch(deptNotExist dne){
                    System.out.println("We can't add the student because the department doesn't exist");
                }
                //try to add a student that already exists
                try{
                    for(int i=0;i<StudentList.size();i++){
                        for(int a=0;a<StudentList.size();a++){
                            if(StudentList.get(i).department_id != DeptList.get(a).id){
                                Student s = new Student();
                                addingStudent(s);
                            }
                        }
                    }
                }catch(alreadyExists ae){
                    System.out.println("We can't add the student because the student already exists");
                }
                //generate new version of the student file
                BufferedWriter studentWriter = new BufferedWriter(new FileWriter("C:Users/wyiuk/Desktop/FinalProject/Student.txt",true));
                for(int i=0;i<StudentList.size();i++){
                    studentWriter.write(StudentList.get(i).id+",");
                    studentWriter.write(StudentList.get(i).name+",");
                    studentWriter.write(StudentList.get(i).age+",");
                    studentWriter.write(StudentList.get(i).gender+",");
                    studentWriter.write(StudentList.get(i).course+",");
                    studentWriter.write(StudentList.get(i).semester+",");
                    studentWriter.write(StudentList.get(i).department_id);
                }
                studentWriter.close();
                break;
case 4:
                //4. Assign dean
                System.out.println("Assigning a dean");
                System.out.println("Enter the id of the teacher");
                int teacherId = input.nextInt();
                System.out.println("Enter the name of the teacher");
                String teacherName = input.next();
                Teacher dean = new Teacher(teacherId, teacherName);
                dean = Department.Dean;           
                break;
case 5:
                //5.Display departments
                System.out.println("Displaying a list of departments");
                DeptList.forEach((d) -> {
                    System.out.println(d.toString());});
                break;
case 6:
                //6. Display teachers
                System.out.println("Displaying a list of teachers");
                TeachList.forEach((t) -> {
                    System.out.println(t.toString());});
                break;
case 7:
                //7. Display students
                System.out.println("Displaying a list of students");
                StudentList.forEach((s) -> {
                    System.out.println(s.toString());});               
                break;
case 8:
                //8. Display dean
                System.out.println("Displaying a dean");
                System.out.println("ID: "+Department.Dean.getId()+"\nName: "+Department.Dean.getName());
                break;
case 9:
                //9.Add staff
                System.out.println("Displaying a list of staffs");
                Staffs.forEach((s) -> {
                    System.out.println(s.toString());
                }); 
                //try to add a staff to an inexistent department
                try{
                    for(int i=0;i<Staffs.size();i++){
                        int a=0;
                        if(DeptList.get(a).id != Staffs.get(i).department_id){
                            Staff s = new Staff();
                            addStaff(s);
                            a++;
                        }
                    }                    
                }catch(deptNotExist dne){
                    System.out.println("We can't add the staff because the department doesn't exist");
                }
                //try to add a staff that already exists
                try{
                    for(int i=0;i<Staffs.size();i++){
                        for(int a=0;a<Staffs.size();a++){
                            if(Staffs.get(i).department_id != DeptList.get(a).id){
                                Staff s = new Staff();
                                addingStaff(s);
                            }
                        }
                    }
                }catch(alreadyExists ae){
                    System.out.println("We can't add the staff because the staff already exists");
                }
                //generate new version of the teacher file
                BufferedWriter staffWriter = new BufferedWriter(new FileWriter("C:Users/wyiuk/Desktop/FinalProject/Staff.txt",true));
                for(int i=0;i<Staffs.size();i++){
                    staffWriter.write(Staffs.get(i).id+",");
                    staffWriter.write(Staffs.get(i).name+",");
                    staffWriter.write(Staffs.get(i).age+",");
                    staffWriter.write(Staffs.get(i).gender+",");
                    staffWriter.write(Staffs.get(i).duty+",");
                    staffWriter.write(Staffs.get(i).workload+",");
                    staffWriter.write(Staffs.get(i).department_id);
                }
                staffWriter.close();
                break;
            default:
                System.out.println("Option invalid ");
                break;
        }
    System.out.println("Do you want to continue? Type no to exit");
    response = input.next();
    
    }while(response.compareTo("no")!=0);}
}
class InvalidDean extends Exception{
    public InvalidDean(String s){
        super(s);
    }
}
class deptNotExist extends Exception{
    public deptNotExist(String s){
        super(s);
    }
}
class alreadyExists extends Exception{
    public alreadyExists(String s){
        super(s);
    } 
}