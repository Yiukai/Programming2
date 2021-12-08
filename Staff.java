package Assignment_two;

public class Staff extends Person implements PayRoll{
    int id;
    String name;
    int age;
    String gender;
    String duty;
    int workload;
    int department_id;
    double payRoll;
      
    Staff(){}
    Staff(int id, String name, int age, String gender,String duty, int workload,int department_id){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.duty = duty;
        this.workload = workload;
        this.department_id = department_id;
    }
    void setDepartmentId(int department_id){
        this.department_id = department_id;
    }
    int getDepartmentId(){
        return this.department_id;
    }
    void setPayRoll(double payRoll){
        this.payRoll = payRoll;
    }
    double getPayRoll(){
        return this.payRoll;
    }
    void setDuty(String duty){
        this.duty = duty;
    }
    String getDuty(){
        return this.duty;
    }
    void setWorkload(int workload){
        this.workload = workload;
    }
    int getWorkload(){
        return this.workload;
    }   
    @Override
    public double computePayRoll(double payRoll) {
        payRoll = workload*32*2*0.85;
        return payRoll;
    }
    @Override
    public String toString(){
        return "Payroll: "+getPayRoll()+
               "\nDuty: "+getDuty()+
               "\nWorkload: "+getWorkload();
    }
}
