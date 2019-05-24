import java.util.ArrayList;
import java.util.List;

public class MathematicUniversity extends Thread{
    private Q studentsQue;
    private List<Student> students;

    public MathematicUniversity(Q studentsQue) {
        this.studentsQue = studentsQue;
        students = new ArrayList<Student>();
    }

    public synchronized void run() {
        try {
            while (!studentsQue.isEndQue()) {
                if(studentsQue.studentsSize() > 0) {
                    Student currentStudent = studentsQue.get(0);
                    if (currentStudent.getProfession().equals("Mathematic")) {
                        students.add(currentStudent);
                        studentsQue.removeStudent(currentStudent);
                        System.out.println("MathematicUniversity : we added Student [" + currentStudent.getProfession() + "]" );
                    } else {
                        Thread.sleep(100);
                    }
                } else wait(1000);
            }
            System.out.println("MathematicUniversity/////////////////////-------> " + students.size());
        } catch (InterruptedException e) {
            System.err.println("Exception in MathematicUniversity");
            e.printStackTrace();
        }
    }
}
