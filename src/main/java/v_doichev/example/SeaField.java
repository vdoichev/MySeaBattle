package v_doichev.example;

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

    public MarineCell[][] getCells() {
        return cells;
    }
}
