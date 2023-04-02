package parser;

public class CoordinateParser {

    private String x;
    private String y;
    private String userId;
    private String timeStamp;

    public CoordinateParser(String line) {
        String[] arr = line.split(" ");
        try {
            Integer.parseInt(arr[0]);
            this.x = arr[0];
        } catch (NumberFormatException nfe) {
            this.x = "";
        }
        try {
            Integer.parseInt(arr[1]);
            this.y = arr[1];
        } catch (NumberFormatException nfe) {
            this.y = "";
        }
        this.userId = arr[2];
        this.timeStamp = arr[3];
    }

    public static CoordinateParser parseCoordinate(String line) {
        return new CoordinateParser(line);
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
