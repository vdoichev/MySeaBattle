package v_doichev.example;

public class MarineCell {
    private final Cell cell;
    private final int x;
    private final int y;

    public MarineCell(Cell cell, int x, int y) {
        this.cell = cell;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{ x = " + x + ", y = " + y + " }";
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
