package parser;

public class CoordinateParser {

    private int x;
    private int y;
    private String userId;
    private String timeStamp;

    public CoordinateParser(String line) {
        String[] arr = line.split(" ");
        try {
            this.x = Integer.parseInt(arr[0]);
        } catch (NumberFormatException nfe) {
            this.x = -1;
        }
        try {
            this.y = Integer.parseInt(arr[1]);
        } catch (NumberFormatException nfe) {
            this.y = -1;
        }
        this.userId = arr[2];
        this.timeStamp = arr[3];
    }

    public static CoordinateParser parseCoordinate(String line) {
        return new CoordinateParser(line);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
