package v_doichev.example;

import v_doichev.example.Ships.Ship;

public class SeaField {

    public final MarineCell[][] cells;

    SeaField() {
        this.cells = new MarineCell[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.cells[i][j] = new MarineCell(
                        Cell.EMPTY, i, j);
            }
        }
    }

    /**
     * Вивід на екран морського поля
     */
    public void print() {
        System.out.println("   0  1  2  3  4  5  6  7  8  9");
        int count = 0;

        for (MarineCell[] cellsOuter : cells) {
            System.out.print(count + " ");
            for (MarineCell cellsInner : cellsOuter) {
                System.out.print(cellsInner.getCell().getEmoji() + " ");
            }
            System.out.println();
            count++;
        }
    }

    /**
     * Перевірка координат корабля з координатами поля на наявність вже іншого корабля
     * @param ship - корабель
     * @return true якщо є конфлікт з іншим кораблем або ореолом корабля
     */
    public boolean isConflictOtherShip(Ship ship){
        boolean result = false;
        for (int j = 0; j < ship.getSize(); j++) {
            int x = ship.shipCell[j].getX();
            int y = ship.shipCell[j].getY();
            if (this.cells[x][y].getCell()!=Cell.EMPTY){
                result = true;
                break;
            }
        }
        return result;
    }
}
