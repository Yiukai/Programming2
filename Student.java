package Assignment_two;

public class Student extends Person{
    int id;
    String name;
    int age;
    String gender;
    String course;
    int department_id;
    int semester;
    
    Student(){}
    Student(int id, String name){
        this.id = id; 
        this.name = name;
    }
    Student(int id, String name, int age, String gender, String course,int semester, int department_id){
        this.id = id; 
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.semester = semester;
        this.department_id = department_id;
    }
    void setDepartmentId(int department_id){
        this.department_id = department_id;
    }
    int getDepartmentId(){
        return this.department_id;
    }
    @Override
    void setGender(String gender){
        this.gender = gender;
    }
    @Override
    String getGender(){
        return this.gender;
    }
    @Override
    void setAge(int age){
        this.age = age;
    }
    @Override
    int getAge(){
        return this.age;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return this.name;
    }
    @Override
    public void setId(int id){
        this.id = id;
    }
    @Override
    public int getId(){
        return this.id;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public String getCourse(){
        return this.course;
    }
    public void setSemester(int semester){
        this.semester = semester;
    }
    public int getSemester(){
        return this.semester;
    }
    @Override
    public String toString(){
        return "ID: "+getId()+
               "\nName: "+getName()+
               "\nAge: "+getAge()+
               "\nGender: "+getGender()+
               "\nCourse: "+getCourse()+
               "\nSemester: "+getSemester()+
               "\nDepartment id: "+getDepartmentId()+"\n";
    }
}
