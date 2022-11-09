package v_doichev.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Tag("first")
public class CellTest {


    @Nested
    @DisplayName("All tests for get emoji")
    class getEmojiTest{
        @Test
        void getEmojiEmptyTest() {
            Cell.EMPTY.getEmoji();
            assertEquals(Cell.EMPTY.getEmoji(), "⬜");
        }

        @Test
        void getEmojiWholeShipTest() {
            Cell.EMPTY.getEmoji();
            assertEquals(Cell.WHOLE_SHIP.getEmoji(), "\uD83D\uDEA2");
        }
    }
}
