import java.awt.*;
import java.util.Random;

/**
 * Created by madelinefox on 11/4/14.
 */
public class player {
    private int[] maincolor;
    private String name;
    private int energy, sheilds;
    public int x, y;
    private int bx, by;

    public player(String name, int[] maincolor, Map map) {
        this.name = name;
        this.maincolor = maincolor;
        energy = 100;
        sheilds = 100;
        boolean state = true;
        while (state) {
            bx = new Random().nextInt(833) + 49;
            by = new Random().nextInt(280) + 73;
            if (map.checkBounds(bx, by) && map.checkBounds(bx + 35, by) && map.checkBounds(bx, by + 35) && map.checkBounds(bx + 35, by + 35))
                state = false;

        }
        x = bx + 15;
        y = by + 15;
    }

    /**
     *
     * @return maincolor
     */
    public int[] getMaincolor() {
        return (maincolor);
    }
}
