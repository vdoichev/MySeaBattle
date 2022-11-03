package v_doichev.example.Ships;

import v_doichev.example.*;

import java.util.Arrays;

/**
 * Абстрактний клас "Корабель"
 */
public abstract class Ship {
    private final int size;
    public final MarineCell[] shipCell;

    public Ship(int size) {
        this.size = size;
        this.shipCell = new MarineCell[this.size];
    }

    public void addCell(int i, int x, int y) {
        shipCell[i] = new MarineCell(Cell.WHOLE_SHIP, x, y);
    }

    public int getSize() {
        return size;
    }

    public abstract String getSizeStr();

    public abstract String getFormat();

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", coordinates=" + Arrays.toString(shipCell) +
                '}';
    }

    public MarineCell[] getShipCell() {
        return shipCell;
    }

    public boolean isEmptyShip() {
        boolean result = false;
        for (MarineCell cell : this.shipCell) {
            if (cell == null || cell.getCell() == Cell.EMPTY) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Перевірка на коректність координат корабля (клітинки поряд по горизонталі або вертикалі)
     * @return
     */
    public boolean isCheckShip() {
        boolean result = false;
        if (!this.isEmptyShip()) {
            int xFirst = this.shipCell[0].getX();
            int yFirst = this.shipCell[0].getY();
            int xLast = this.shipCell[this.shipCell.length - 1].getX();
            int yLast = this.shipCell[this.shipCell.length - 1].getY();
            if ((xFirst == xLast && Math.abs(yLast - yFirst) == this.shipCell.length - 1) |
                    (yFirst == yLast && Math.abs(xLast - xFirst) == this.shipCell.length - 1)) {
                result = true;
            }
        }
        return result;
    }
}
