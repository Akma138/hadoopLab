package point;

public class Area {

    private Point leftTopCorner;
    private Point rightButtomCorner;

    public Area(Point leftTopCorner, Point rightButtomCorner) {
        this.leftTopCorner = leftTopCorner;
        this.rightButtomCorner = rightButtomCorner;
    }

    public Point getLeftTopCorner() {
        return leftTopCorner;
    }

    public Point getRightButtomCorner() {
        return rightButtomCorner;
    }
}
