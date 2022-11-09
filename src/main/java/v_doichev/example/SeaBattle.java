package v_doichev.example;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) throws Exception {
        System.out.println("---------------Вітаємо у грі \"Морський бій\"---------------");
        Scanner scanner = new Scanner(System.in);
        Deque<Player> players = addPlayersToGame(scanner);
        players.getFirst().addShipsForPlayer(scanner);
        players.getLast().addShipsForPlayer(scanner);
        System.out.println("-----------------------Гра починається----------------------");
        boolean isGameOver = false;
        battle:
        do {
            boolean isHit;
            do {
                System.out.println("Наступний хід робить гравець " +
                        players.getFirst().getName());
                isHit = players.getFirst().nextShot(players.getLast(), scanner);
                if (isHit) {
                    System.out.println("Влучив!");
                    isGameOver = players.getLast().isLoser();
                    if (isGameOver) {
                        System.out.println("Кінець гри! Переможець гравець " +
                                players.getFirst().getName());
                        break battle;
                    }
                } else System.out.println("Промах!");
            } while (isHit);

            do {
                System.out.println("Наступний хід робить гравець " +
                        players.getLast().getName());
                isHit = players.getLast().nextShot(players.getFirst(), scanner);
                if (isHit) {
                    System.out.println("Влучив!");
                    isGameOver = players.getFirst().isLoser();
                    if (isGameOver) {
                        System.out.println("Кінець гри! Переможець гравець " +
                                players.getLast().getName());
                        break battle;
                    }
                } else System.out.println("Промах!");
            } while (isHit);
        } while (!isGameOver);
    }

    /**
     * Додаємо гравців до гри
     *
     * @param scanner - через командну строку
     * @return - повертаємо чергу з двох гравців
     */
    private static Deque<Player> addPlayersToGame(Scanner scanner) {
        Deque<Player> players = new LinkedList<>();
        System.out.println("Введіть ім'я першого гравця:");
        players.addFirst(new Player(scanner.nextLine()));
        System.out.println("Введіть ім'я другого гравця:");
        players.addLast(new Player(scanner.nextLine()));
        return players;
    }
}