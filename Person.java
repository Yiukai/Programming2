package Assignment_two;

abstract class Person {
    int id;
    String name;
    String nationality;
    int age;
    String gender;
    
    void setId(int id){
        this.id = id;
    }
    void setName(String name){
        this.name = name;
    }
    void setAge(int age){
        this.age = age;
    }
    void setGender(String gender){
        this.gender = gender;
    }
    
    int getId(){
        return this.id;
    }
    String getName(){
        return this.name;
    }
    int getAge(){
        return this.age;
    }
    String getGender(){
        return this.gender;
    }
}
