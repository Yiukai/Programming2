package Assignment_two;
import java.util.ArrayList;
public class Department {
    public int id;
    public String description;
    ArrayList<Teacher> TeacherList = new ArrayList<>();
    ArrayList<Student> StudentList = new ArrayList<>();
    static Teacher Dean;
    
    Department(int id, String description){
        this.id = id; 
        this.description = description;
    }
    public void setDesc(String n){
        this.description = n;
    }
    public String getDesc(){
        return this.description;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }   
}
