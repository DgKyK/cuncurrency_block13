import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SourceThread extends Thread {
    private Q studentsQue;
    private int biology = 200;
    private int mathematic = 250;


    public SourceThread(Q studentsQue) {
        this.studentsQue = studentsQue;
    }

    public synchronized void run() {
        try {
            while (biology != 0 || mathematic != 0) {
                if (studentsQue.studentsSize() < 25) {
                    notify();
                    addRandomStudent();
                    System.out.println("Added random student");
                } else if (studentsQue.studentsSize() > 50) {
                    wait();
                }
            }
            System.out.println(studentsQue.studentsSize());
            studentsQue.setEndQue(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void addRandomStudent() {
        Random random = new Random();
        int state = random.nextInt(2) + 1;

        if (mathematic != 0 ) {
            studentsQue.add(new Student("Mathematic"));
            mathematic--;
        } else if(biology != 0) {
            studentsQue.add(new Student("Biolog"));
            biology--;
        }
    }
}
