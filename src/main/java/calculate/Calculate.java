package calculate;

import point.Area;
import point.Point;

import java.util.HashMap;

public class Calculate {

    private static final HashMap<Area, String> map = new HashMap<>();
    static {
        map.put(new Area(new Point("0", "0"), new Point("15", "15")), "top left");
        map.put(new Area(new Point("15", "0"), new Point("30", "15")), "top right");
        map.put(new Area(new Point("0", "15"), new Point("15", "30")), "bottom left");
        map.put(new Area(new Point("15", "15"), new Point("30", "30")), "bottom right");
    }


    public static String calculateArea(String x, String y) {

        for (HashMap.Entry<Area, String> set :
                map.entrySet()) {
            Area temp = set.getKey();

            Point topLeft = temp.getLeftTopCorner();
            Point bottomRight = temp.getRightButtomCorner();

            if (topLeft.getX().compareTo(x) >= 0 && topLeft.getY().compareTo(y) >= 0 &&
                bottomRight.getX().compareTo(x) <= 0 && bottomRight.getY().compareTo(y) <= 0) {
                return set.getValue();
            }
        }

        return "Malformed";
    }
}
