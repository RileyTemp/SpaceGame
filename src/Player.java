
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Player {

    private Image img;
    int i;
    int x, y, bx, by, dx, dy;
    private final int SPEED = 35;
    boolean left, right, up, down;
    ImageIcon p1 = new ImageIcon("Spaceship left.png");// Looking Left
    ImageIcon p2 = new ImageIcon("Spaceship right.png");// Looking Right
    ImageIcon p3 = new ImageIcon("Spaceship.png");
    ImageIcon p4 = new ImageIcon("Spaceship down.png");
    int imgWidth = p1.getIconHeight();
    int imgHeight = p2.getIconWidth();
    Image arnRunning_R[] = new Image[4];

    public Player() {
        x = 550;
        y = 200;
        dx = 0;
        dy = 0;
        left = false;
        right = false;
        up = false;
        down = false;
        arnRunning_R[0] = p1.getImage();
        arnRunning_R[1] = p2.getImage();
        arnRunning_R[2] = p3.getImage();
        arnRunning_R[3] = p4.getImage();
    }

    public void move() {
        Bullet.SetPlayer(x, y, i);
        x += dx;
        y += dy;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        img = arnRunning_R[i];
        if (right == true) {
            i = 1;
        } else if (left == true) {
            i = 0;
        } else if (up == true) {
            i = 2;
        } else if (down == true) {
            i = 3;
        }
        return img;
    }

    public void keyPressed(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            i = 0;
            dx = -SPEED;
        } else if (code == KeyEvent.VK_RIGHT) {
            i = 1;
            dx = SPEED;
        } else if (code == KeyEvent.VK_UP) {
            i = 2;

            dy = -SPEED;
        } else if (code == KeyEvent.VK_DOWN) {
            i = 3;
            dy = SPEED;
        }

    }

    public void keyReleased(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            left = false;
            if (right) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_RIGHT) {
            right = false;
            if (left) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_UP) {
            up = false;
            if (down) {
            } else {
                dy = 0;
            }
        } else if (code == KeyEvent.VK_DOWN) {
            down = false;
            if (up) {
            } else {
                dy = 0;
            }
        }
    }
}
