import javax.swing.JFrame;

public class Frame extends JFrame {

    public Frame() {
        add(new PanBoard());
        setTitle("Space Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        this.setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
