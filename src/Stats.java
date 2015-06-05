
import java.io.*;
import java.util.*;

public class Stats {

    public Stats() throws FileNotFoundException {
        String slvl = new String();
        String sName = new String();
        Scanner sin = new Scanner(System.in);
        int atk = 1;
        int lvl = 0;
        int hp = 0;
        int currXp = 0;
        int Xpgoal = 0;

        try {
            File level = new File("level.txt");
            File name = new File("name.txt");
            if (!level.exists()) {
                level.createNewFile();
                slvl = "one";
            }
            if (!name.exists()) {
                name.createNewFile();
                System.out.println("Enter your name");
                sName = sin.next();
            }
            FileWriter fileWritter = new FileWriter(level.getName(), true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(slvl + " ");
            bufferWritter.close();

            FileWriter fileWritter1 = new FileWriter(name.getName(), true);
            BufferedWriter bufferWritter2 = new BufferedWriter(fileWritter1);
            bufferWritter2.write(sName);
            bufferWritter2.close();
        } catch (IOException e) {
        }
        Scanner fin = new Scanner(new FileReader("level.txt"));
        Scanner nin = new Scanner(new FileReader("name.txt"));

        while (fin.hasNext()) {
            slvl = fin.next();
        }
        if (slvl.equals("one")) {
            lvl = 1;
            atk = 5;
            hp = 50;
            Xpgoal = 100;

            sName = nin.next();
            PanBoard.setStats(lvl, atk, hp, sName, currXp, Xpgoal);
        }


    }
}
