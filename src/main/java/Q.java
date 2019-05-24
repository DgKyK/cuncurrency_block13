import java.util.ArrayList;
import java.util.List;

public class Q {
    private List<Student> students;
    private boolean endQue;

    public Q(){
        students = new ArrayList<Student>();
        students.add(new Student("Mathematic"));
        endQue = false;
    }

    public synchronized void add(Student student) {
        students.add(student);
    }

    public synchronized int studentsSize() {
        return students.size();
    }

    public synchronized Student get(int i) {
        return students.get(i);
    }

    public synchronized void removeStudent(Student student) {
        students.remove(student);
    }

    public void setEndQue(boolean endQue) {
        this.endQue = endQue;
    }


    public boolean isEndQue() {
        return endQue;
    }

    @Override
    public String toString() {
        return "Q{" +
                "students=" + students +
                '}';
    }
}
