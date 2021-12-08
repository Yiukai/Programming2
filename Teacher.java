package Assignment_two;

public class Teacher extends Person implements PayRoll{
    public int id;
    public String name;
    int age;
    String gender;
    String speciality;
    String degree;
    int department_id;
    double payRoll;
    
    Teacher(){}
    Teacher (int id, String name){
        this.id = id; 
        this.name = name;
    }
    Teacher(int id, String name, int age, String gender, String speciality, String degree, int department_id){
        this.id = id; 
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.speciality = speciality;
        this.degree = degree;
        this.department_id = department_id;
    }
    void setDepartmentId(int department_id){
        this.department_id = department_id;
    }
    int getDepartmentId(){
        return this.department_id;
    }
    @Override
    public void setAge(int age){
        this.age = age;
    }
    @Override
    public int getAge(){
        return this.age;
    }
    @Override
    public void setGender(String gender){
        this.gender = gender;
    }
    @Override
    public String getGender(){
        return this.gender;
    }
    public void setSpeciality(String speciality){
        this.speciality = speciality;
    }
    public String getSpeciality(){
        return this.speciality;
    }
    public void setDegree(String degree){
        this.degree = degree;
    }
    public String getDegree(){
        return this.degree;
    }
    @Override
    public void setName(String n){
        this.name = n;
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
    void setPayRoll(double payRoll){
        this.payRoll = payRoll;
    }
    double getPayRoll(){
        return this.payRoll;
    }
    public void Display(){
        System.out.println("ID: "+id+"Name: "+name);
    }

    @Override
    public double computePayRoll(double payRoll) {
        switch(degree){
            case("PhD"):
                payRoll = 36*112*0.76; break;
            case("Master"):
                payRoll = 36*82*0.76; break;
            case("Bachelor"):
                payRoll = 36*42*0.76; break;
        }
        return payRoll;
    }
    @Override
    public String toString(){
        return "ID: "+getId()+
               "\nName: "+getName()+
               "\nAge: "+getAge()+
               "\nGender: "+getGender()+
               "\nSpeciality: "+getSpeciality()+
               "\nDegree: "+getDegree()+
               "\nDepartment id: "+getDepartmentId();
    }
}
