package v_doichev.example;

import v_doichev.example.Ships.*;

import java.util.ArrayList;

public class Player {
    private final String name;
    private final MarineField ownField;
    private final MarineField opponentField;
    public ArrayList<Ship> ships = new ArrayList<>();

    public Player(String name) {

        this.name = name;
        this.ownField = new MarineField();
        this.opponentField = new MarineField();

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

    public MarineField getOwnField() {
        return ownField;
    }

    public MarineField getOpponentField() {
        return opponentField;
    }

    /**
     * Оновлення поля гравця з урахуванням розміщених кораблів
     */
    public void refreshOwnMarineBoard() {
        for (Ship ship: this.ships) {
            if (!ship.isEmptyShip()) {
                for (int j = 0; j < ship.getSize(); j++) {
                    int x = ship.shipCell[j].getX();
                    int y = ship.shipCell[j].getY();
                    this.ownField.cells[x][y] = ship.shipCell[j];
                }
            }
        }
    }
}
