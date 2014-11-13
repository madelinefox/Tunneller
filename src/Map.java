import java.util.Random;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 * Created by madelinefox on 11/4/14.
 */
public class Map {
    private int[][] map;
    private BufferedImage buff;
    private player[] playerList;


    public Map() {
        map = new int[931][428];
        playerList = new player[2];
        //buff = new BufferedImage(2793, 1284, BufferedImage.TYPE_INT_ARGB);
        buff = new BufferedImage(1284, 2793, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Reports whether the coordinate passed
     * to the method is in usable play space.
     *
     * @param x
     * @param y
     * @return boolean value
     */
    public boolean checkBounds(int x, int y) {
        //TODO
        return true;
    }

    /**
     * Adds a new base to the map.
     *
     * @param x
     * @param y
     * @param p
     */
    public void makeBase(int x, int y, player p) {
        //TODO
    }

    /**
     * Fill in the map array with probable data values
     *
     */
    private void makeMap() {
        Random rand = new Random();
        for (int i = 0; i < map.length; i++) {              // For loop to cycle
            for (int j = 0; j < map[i].length; j++) {       // through and add
                map[i][j] = -1 * (1 + rand.nextInt(500) % 2);// textured terrain
            }
        }
        int start = 36;
        int end = -36;
        int changee = 0;
        int changes = 0;
        for (int i = 0; i < map.length; i++) {
            do {
                changes = rand.nextInt(12) - 6;
                start = +changes;
                //start = rand.nextInt(73);
            } while (!(start < 73 && start > 0));
            do {
                changee = rand.nextInt(12) - 6;
                end =+ changee;
                //end = -1*rand.nextInt(73);
            } while (!(end > -73 && end < -1));
            for (int s = 0; s < start; s++) {
                map[i][s] = 0;
            }
            for (int e = map[i].length - 1; e > map[i].length + end; e--) {
                map[i][e] = 0;
            }
        }

        start = 24;
        end = 24;
        for (int i = 0; i < map[0].length; i++) {
            do {
                changes = rand.nextInt(8) - 4;
                start =+ changes;
                //start = rand.nextInt(49);
            } while (!(start > 0 && start < 49));
            do {
                changee = rand.nextInt(8) - 4;
                end = +changee;
                //end = rand.nextInt(49);
            } while (!(end > 1 && end < 49));
            for (int s = 0; s < start; s++) {
                map[s][i] = 0;
            }
            for (int e = map.length - 1; e > map.length - end; e--) {
                map[e][i] = 0;
            }
        }
    }



    public void show() {
        JFrame frame = new JFrame("Your Picture!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                int convert = 0;
                int rowP = row * 3;
                int colP = col * 3;
                switch (map[row][col]) {
                    case -2:
                        //is usable-movable space
                        convert = convert(100, 200, 150, 48);
                        break;
                    case -1:
                        //is usable-movable space
                        convert = convert(100, 255, 200, 0);
                        break;
                    case 0:
                        //is rock
                        convert = convert(100, 140, 140, 140);
                        break;
                    case 1:
                        //is moved in space
                        convert = convert(100, 0, 0, 0);
                        break;
                    case 10:
                        //is the "base" for player 1
                        convert = convert(playerList[0].getMaincolor()[0], playerList[0].getMaincolor()[1], playerList[0].getMaincolor()[2], playerList[0].getMaincolor()[3]);
                        break;
                    case 11:
                        //TODO make the player 1 car point up
                        break;
                    case 12:
                        //TODO make the player 1 car point down
                        break;
                    case 13:
                        //TODO make the player 1 car point left
                        break;
                    case 14:
                        //TODO make the player 1 car point right
                        break;
                    case 15:
                        //TODO make the player 1 car point up left
                        break;
                    case 16:
                        //TODO make the player 1 car point up right
                        break;
                    case 17:
                        //TODO make the player 1 car point down left
                        break;
                    case 18:
                        //TODO make the player 1 car point down right
                        break;
                    case 20:
                        //is the "base" for the player 2
                        convert = convert(playerList[1].getMaincolor()[0], playerList[1].getMaincolor()[1], playerList[1].getMaincolor()[2], playerList[1].getMaincolor()[3]);
                        break;
                    case 21:
                        //TODO make the player 2 car point up
                        break;
                    case 22:
                        //TODO make the player 2 car point down
                        break;
                    case 23:
                        //TODO make the player 2 car point left
                        break;
                    case 24:
                        //TODO make the player 2 car point right
                        break;
                    case 25:
                        //TODO make the player 2 car point up left
                        break;
                    case 26:
                        //TODO make the player 2 car point up right
                        break;
                    case 27:
                        //TODO make the player 2 car point down left
                        break;
                    case 28:
                        //TODO make the player 2 car point down right
                        break;
                    default:
                        convert = convert(100, 255, 255, 255);
                        break;
                }
                buff.setRGB(colP, rowP, convert);
                buff.setRGB(colP + 1, rowP, convert);
                buff.setRGB(colP, rowP + 1, convert);
                buff.setRGB(colP + 1, rowP + 1, convert);
                buff.setRGB(colP + 2, rowP + 1, convert);
                buff.setRGB(colP + 1, rowP + 2, convert);
                buff.setRGB(colP, rowP + 2, convert);
                buff.setRGB(colP + 2, rowP, convert);
                buff.setRGB(colP + 2, rowP + 2, convert);
            }
        }

        frame.add(new JLabel(new ImageIcon(buff)));
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This is deep bitshifting magic. Also don't worry about this.
     *
     * @param alpha the alpha value
     * @param red   the red value
     * @param green the green value
     * @param blue  the blue value
     * @return The converted ARGB int.
     */
    private int convert(int alpha, int red, int green, int blue) {
        return alpha << 24 | red << 16
                | green << 8 | blue;
    }
    public static void main(String [] args) {
        Map run = new Map();
        run.makeMap();
        run.show();
        String next = new Scanner(System.in).nextLine();
    }
}
