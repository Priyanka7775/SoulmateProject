package com.example.SoulmateNeo4j.rabbitmqReceiver;




public class UserDTO {
    private String email;
    private String name;
    private int age;
    private String gender;
    private String city;
    public UserDTO() {
    }

    public UserDTO(String email, String name, int age, String gender, String city) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    //    private String password;
//
//    public UserDTO(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public UserDTO() {
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
