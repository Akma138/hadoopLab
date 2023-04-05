package calculate;

import point.Area;
import point.Point;

import java.util.HashMap;

public class Calculate {

    private static final HashMap<Area, String> map = new HashMap<>();
    static {
        map.put(new Area(new Point(0, 0), new Point(15, 15)), "top left");
        map.put(new Area(new Point(15, 0), new Point(30, 15)), "top right");
        map.put(new Area(new Point(0, 15), new Point(15, 30)), "bottom left");
        map.put(new Area(new Point(15, 15), new Point(30, 30)), "bottom right");
    }


    public static String calculateArea(int x, int y) {

        for (HashMap.Entry<Area, String> set :
                map.entrySet()) {
            Area temp = set.getKey();

            Point topLeft = temp.getLeftTopCorner();
            Point bottomRight = temp.getRightButtomCorner();

            if (topLeft.getX() >= x && topLeft.getY() >= y &&
                bottomRight.getX() <= x && bottomRight.getY() <= y) {
                return set.getValue();
            }
        }

        return "Malformed";
    }
}
