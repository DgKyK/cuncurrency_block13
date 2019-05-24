import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Q que = new Q();
        SourceThread source = new SourceThread(que);
        GlobalUniversity gu = new GlobalUniversity(que);
        MathematicUniversity mu = new MathematicUniversity(que);
        BiologyUniversity bu = new BiologyUniversity(que);
        source.start();
        gu.start();
        mu.start();
        bu.start();

    }
}
