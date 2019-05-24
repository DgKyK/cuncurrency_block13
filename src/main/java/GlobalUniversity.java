import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GlobalUniversity extends Thread{
    private Q studentsQue;
    private List<Student> students;

    private final int maxStudentsPerOnce = 5;

    public GlobalUniversity(Q studentsQue) {
        this.studentsQue = studentsQue;
        students = new ArrayList<Student>();
    }

    public void run() {
        Random rand = new Random();
        while (!studentsQue.isEndQue()) {
            int numberOfStudent = rand.nextInt(5) + 1;
            for (int i = 0; i < numberOfStudent && studentsQue.studentsSize() >= numberOfStudent; i++) {
                Student currentStudent = studentsQue.get(0);
                students.add(currentStudent);
                System.out.println("GlobalUniversity : we added Student [" + currentStudent.getProfession() + "]" );
                studentsQue.removeStudent(currentStudent);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println("Exception in GlobalUnivarsity");
                e.printStackTrace();
            }

        }

        System.out.println("GlobalUniversity/////////////////////-------> " + students.size());
    }
}
