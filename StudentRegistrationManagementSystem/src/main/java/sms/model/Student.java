package sms.model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String gender;
    private String course;
    private String skills; // Stored as comma-separated values
    private String address;

    public Student() {}

    public Student(String name, int age, String email, String password, String gender, String course, String skills, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.course = course;
        this.skills = skills;
        this.address = address;
    }

    public Student(int id, String name, int age, String email, String password, String gender, String course, String skills, String address) {
        this(name, age, email, password, gender, course, skills, address);
        this.id = id;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}