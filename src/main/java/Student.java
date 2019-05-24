public class Student {
    private String profession;

    public Student(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Student{" +
                "profession='" + profession + '\'' +
                '}';
    }
}
