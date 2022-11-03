package v_doichev.example;

/**
 * Перелік можливих зображень клітинок на полі бою
 */
public enum Cell {
    EMPTY("⬜"),
    WHOLE_SHIP("\uD83D\uDEA2"),
    HALO("\uD83D\uDFE6"),
    WRECKED_SHIP("\uD83D\uDFE5"),
    CHECK_MARK("✅"),
    CROSS_MARK("❎");

    private final String emoji;


    Cell(String emoji) {
        this.emoji = emoji;
    }


    public String getEmoji() {
        return emoji;
    }

}
