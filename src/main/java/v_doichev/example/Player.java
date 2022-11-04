package v_doichev.example;

import v_doichev.example.Ships.*;

import java.util.ArrayList;
import java.util.Scanner;

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
        /*for (int i = 0; i < DoubleDeck.getCount(); i++) {
            this.ships.add(new DoubleDeck());
        }
        for (int i = 0; i < ThreeDeck.getCount(); i++) {
            this.ships.add(new ThreeDeck());
        }
        for (int i = 0; i < FourDeck.getCount(); i++) {
            this.ships.add(new FourDeck());
        }*/
    }

    public String getName() {
        return name;
    }

    public SeaField getOwnField() {
        return ownField;
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

    /**
     * Додавання кораблів гравця до ігрового поля
     *
     * @param scanner - пристрій вводу даних
     */
    public void addShipsForPlayer(Scanner scanner) {
        System.out.println("Почнемо розкладати кораблі на полі гравця " + this.getName() +
                "! Інший гравець не дивиться!");
        this.getOwnField().print();
        for (Ship ship : this.ships) {
            boolean isAddNewShip;
            do {
                isAddNewShip = readCoordinatesForShip(scanner, ship);
            } while (!isAddNewShip);
            this.refreshOwnMarineBoard();
            this.getOwnField().print();
        }
    }

    /**
     * Перевірка на кінець гри
     * @return - true якщо всі кораблі гравця підбиті
     */
    public boolean isLoser(){
        boolean result = true;
        for (Ship ship : this.ships) {
            if (!ship.isWreckedShip()){
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Зчитування координат корабля з пристрою вводу
     *
     * @param scanner - пристрій вводу даних
     * @param ship    - корабель гравця
     * @return - true, якщо успішно додані координати корабля
     */
    public boolean readCoordinatesForShip(Scanner scanner, Ship ship) {
        boolean result = false;
        System.out.println("Введи координати " + ship.getSizeStr() +
                " корабля (формат: " + ship.getFormat() + ")");
        String[] shipCoordinates = scanner.nextLine().split(";");
        if (shipCoordinates.length == ship.getSize()) {
            for (int i = 0; i < shipCoordinates.length; i++) {
                String[] cellCoordinates = shipCoordinates[i].split(",");
                if (cellCoordinates.length == 2) {
                    int x = Integer.parseInt(cellCoordinates[0]);
                    int y = Integer.parseInt(cellCoordinates[1]);
                    if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                        ship.addCell(i, x, y);
                    } else System.out.println("Не вірно вказані координати! " +
                            "Допустимий діапазон числа: 0-9");
                } else System.out.println("Не вірно вказані координати! " +
                        "Не дійсний формат вводу координат!");
            }
            result = ship.isCheckShip();
            if (!result) {
                System.out.println("Не вірно вказані координати! " +
                        "Клітинки мають бути розташовані поряд по горизонталі або вертикалі!");
            }
            result = !this.ownField.isConflictOtherShip(ship);
            if (!result) {
                System.out.println("Не вірно вказані координати! " +
                        "Клітинки вже зайняті іншим кораблем!");
            }
        } else System.out.println("Не вірно вказані координати! " +
                "Не відповідність розміру корабля");
        return result;
    }

    public boolean nextShot(Player opponent, Scanner scanner){
        boolean result = false;
        System.out.println("Введи координати наступного пострілу (формат: x,y)");
        String[] fireCell = scanner.nextLine().split(",");
        if (fireCell.length == 2) {
            int x = Integer.parseInt(fireCell[0]);
            int y = Integer.parseInt(fireCell[1]);
            if (x >= 0 && x < 10 && y >= 0 && y < 10) {
                if (opponent.ownField.cells[x][y].getCell() == Cell.WHOLE_SHIP){
                    opponent.ownField.cells[x][y].setCell(Cell.WRECKED_SHIP);
                    opponent.getOwnField().print();
                    result = true;
                }
            } else System.out.println("Не вірно вказані координати! " +
                    "Допустимий діапазон числа: 0-9");
        } else System.out.println("Не вірно вказані координати! " +
                "Не дійсний формат вводу координат!");
        return result;
    }
}
