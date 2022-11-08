package v_doichev.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    void getEmojiEmptyTest(){
        Cell.EMPTY.getEmoji();
        assertEquals(Cell.EMPTY.getEmoji(), "⬜");
    }

    @Test
    void getEmojiWholeShipTest(){
        Cell.EMPTY.getEmoji();
        assertEquals(Cell.WHOLE_SHIP.getEmoji(), "\uD83D\uDEA2");
    }
}
