package v_doichev.example;

import v_doichev.example.Ships.Ship;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        System.out.println("---------------Вітаємо у грі \"Морський бій\"---------------");
        Scanner scanner = new Scanner(System.in);
        Deque<Player> players = addPlayersToGame(scanner);
        for (Player player : players) {
            AddShipsForPlayer(player, scanner);
        }
    }

    /**
     * Додавання кораблів гравця до ігрового поля
     * @param player - гравець
     * @param scanner - пристрій вводу данних
     */
    private static void AddShipsForPlayer(Player player, Scanner scanner) {
        System.out.println("Почнемо розкладати кораблі на полі гравця " + player.getName() +
                "! Іншій гравець не дивиться!");
        player.getOwnField().print();
        for (Ship ship : player.ships) {
            boolean isAddNewShip;
            do {
                isAddNewShip = readCoordinatesForShip(scanner, ship);
            } while (!isAddNewShip);
            player.refreshOwnMarineBoard();
            player.getOwnField().print();
        }
    }

    /**
     * Зчитування координат корабля з пристрою вводу
     * @param scanner - пристрій вводу данних
     * @param ship - корабель гравця
     * @return - true, якщо успішно додані коордінати корабля
     */
    private static boolean readCoordinatesForShip(Scanner scanner, Ship ship) {
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
                        result = true;
                    } else System.out.println("Не вірно вказані координати! " +
                            "Допустимий діапазон числа: 0-9");
                } else System.out.println("Не вірно вказані коордінати!");
            }
        } else System.out.println("Не вірно вказані коордінати! " +
                "Не відповідність розміру корабля");
        return result;
    }

    /**
     * Додаємо гравців до гри
     * @param scanner - через командну строку
     * @return - повертаємо чергу з двох гравців
     */
    private static Deque<Player> addPlayersToGame(Scanner scanner) {
        Deque<Player> players = new LinkedList<>();
        System.out.println("Введіть і'мя першого гравця:");
        players.addFirst(new Player(scanner.nextLine()));
        System.out.println("Введіть і'мя другого гравця:");
        players.addLast(new Player(scanner.nextLine()));
        return players;
    }
}