package v_doichev.example;

import v_doichev.example.Ships.*;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final SeaField ownField;
    private final SeaField opponentField;
    public ArrayList<Ship> ships = new ArrayList<>();

    public Player(String name) {

        this.name = name;
        this.ownField = new SeaField();
        this.opponentField = new SeaField();

        for (int i = 0; i < SingleDeck.getCount(); i++) {
            this.ships.add(new SingleDeck());
        }
        for (int i = 0; i < DoubleDeck.getCount(); i++) {
            this.ships.add(new DoubleDeck());
        }
        for (int i = 0; i < ThreeDeck.getCount(); i++) {
            this.ships.add(new ThreeDeck());
        }
        for (int i = 0; i < FourDeck.getCount(); i++) {
            this.ships.add(new FourDeck());
        }
    }

    public String getName() {
        return name;
    }

    public SeaField getOwnField() {
        return ownField;
    }

    public SeaField getOpponentField() {
        return opponentField;
    }

    /**
     * Оновлення поля гравця з урахуванням розміщених кораблів
     */
    public void refreshOwnMarineBoard() {
        for (Ship ship : this.ships) {
            if (ship.isEmptyShip()) {
                for (int j = 0; j < ship.getSize(); j++) {
                    int x = ship.shipCell[j].getX();
                    int y = ship.shipCell[j].getY();
                    this.ownField.cells[x][y] = ship.shipCell[j];

                    if (x - 1 >= 0 && this.ownField.cells[x - 1][y].getCell() == Cell.EMPTY)
                        this.ownField.cells[x - 1][y] = new MarineCell(Cell.HALO, x - 1, y);
                    if (x + 1 < 10 && this.ownField.cells[x + 1][y].getCell() == Cell.EMPTY)
                        this.ownField.cells[x + 1][y] = new MarineCell(Cell.HALO, x + 1, y);
                    if (y - 1 >= 0 && this.ownField.cells[x][y - 1].getCell() == Cell.EMPTY)
                        this.ownField.cells[x][y - 1] = new MarineCell(Cell.HALO, x, y - 1);
                    if (y + 1 < 10 && this.ownField.cells[x][y + 1].getCell() == Cell.EMPTY)
                        this.ownField.cells[x][y + 1] = new MarineCell(Cell.HALO, x, y + 1);
                    if (x - 1 >= 0 && y - 1 >= 0 && this.ownField.cells[x - 1][y - 1].getCell() == Cell.EMPTY)
                        this.ownField.cells[x - 1][y - 1] = new MarineCell(Cell.HALO, x - 1, y - 1);
                    if (x + 1 < 10 && y + 1 < 10 && this.ownField.cells[x + 1][y + 1].getCell() == Cell.EMPTY)
                        this.ownField.cells[x + 1][y + 1] = new MarineCell(Cell.HALO, x + 1, y + 1);
                    if (x - 1 >= 0 && y + 1 < 10 && this.ownField.cells[x - 1][y + 1].getCell() == Cell.EMPTY)
                        this.ownField.cells[x - 1][y + 1] = new MarineCell(Cell.HALO, x - 1, y + 1);
                    if (x + 1 < 10 && y - 1 > 0 && this.ownField.cells[x + 1][y - 1].getCell() == Cell.EMPTY)
                        this.ownField.cells[x + 1][y - 1] = new MarineCell(Cell.HALO, x + 1, y - 1);
                }
            }
        }
    }
}
