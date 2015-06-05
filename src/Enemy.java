
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.Image;

public class Enemy {

    private Image img;
    int k;
    int x, y, dx, dy, bx, by;
    static int X, Y, I, BX, BY, nHit;
    boolean left, right, up, down;
    int nWidth, nLength, EH, EW, nEXP, nSpawn;
    private final int nSpeed = 30;
    ImageIcon e1 = new ImageIcon("Enemy2.png");// Looking Left
    ImageIcon e2 = new ImageIcon("Enemy1.png");// Looking Right
    ImageIcon e3 = new ImageIcon("Enemy3.png");// Looking Up
    ImageIcon e4 = new ImageIcon("Enemy4.png");// Looking down
    int imgWidth = e1.getIconHeight();
    int imgHeight = e2.getIconWidth();
    Image arnEnemy[] = new Image[5];
    int arnHit[] = new int[50];

    static void SetPlayer(int _x, int _y, int _i) {
        X = _x;
        Y = _y;
        I = _i;
    }

    static void SetBullet(int _x, int _y, int _nHit) {
        BX = _x;
        BY = _y;
        nHit = _nHit;
    }

    public Enemy() {
        dx = 0;
        dy = 0;
        x = 100;
        y = 100;
        nEXP = 5;
        arnEnemy[1] = e1.getImage();
        arnEnemy[2] = e2.getImage();
        arnEnemy[3] = e3.getImage();
        arnEnemy[4] = e4.getImage();
    }

    public void move() {
        EH = imgHeight + y - 30;
        EW = imgWidth + x - 30;
        x += dx;
        y += dy;
        Bullet.SetEnemy(x, y, EH, EW, k);
    }

    public int getEX() {
        return x;
    }

    public int getEY() {
        return y;
    }

    public Image getImage() {
        img = arnEnemy[k];
        if (right == true) {
            k = 1;
        } else if (left == true) {
            k = 0;
        } else if (up == true) {
            k = 2;
        } else if (down == true) {
            k = 3;
        }
        return img;
    }

    public void keyPressed(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_A) {//Left
            k = 1;
            dx = -nSpeed;
        } else if (code == KeyEvent.VK_D) {//Right
            k = 2;
            dx = nSpeed;
        } else if (code == KeyEvent.VK_W) {//Up
            k = 3;
            dy = -nSpeed;
        } else if (code == KeyEvent.VK_S) {//Down
            k = 4;
            dy = nSpeed;
        }

    }

    public void keyReleased(KeyEvent w) {
        int code = w.getKeyCode();
        if (code == KeyEvent.VK_A) {
            left = false;
            if (right) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_D) {
            right = false;
            if (left) {
            } else {
                dx = 0;
            }
        } else if (code == KeyEvent.VK_W) {
            up = false;
            if (down) {
            } else {
                dy = 0;
            }
        } else if (code == KeyEvent.VK_S) {
            down = false;
            if (up) {
            } else {
                dy = 0;
            }
        }
    }
}
