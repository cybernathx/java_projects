public class StudManagement {
    private int studID;
    private String studName;
    private int studAge;
    private String course;

    //Constructors
    public StudManagement (int id, String name, int age, String course) {
        this.studID = id;
        this.studName = name;
        this.studAge = age;
        this.course = course;
    }

    //Getters(Accessor)
    public int getID () {
        return studID;
    }
    
    public String getName () {
        return studName;
    }

    public int getAge () {
        return studAge;
    }

    public String getCourse () {
        return course;
    }

    //Setters(Mutator)
    public void setAge (int age) {
        this.studAge = age;
    }

    public void setCourse (String course) {
        this.course = course;
    }

    public String toString() {
        return "ID: " + getID() + "\nName: " + getName() + "\nAge: " + getAge() + "\nCourse: " + getCourse();
    }
}