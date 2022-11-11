package v_doichev.example.Ships;

import org.junit.jupiter.api.*;
import v_doichev.example.Cell;

import static org.junit.jupiter.api.Assertions.*;

@Tag("first")
@DisplayName("Тестування кораблів")
public class ShipTest {
    private Ship singleDeckShip;
    private Ship singleDeckShip2;

    @BeforeEach
    void prepaire() throws Exception {
        singleDeckShip = new SingleDeck();
        singleDeckShip.addCell(0, 0, 0,Cell.EMPTY);
        singleDeckShip2 = new SingleDeck();
    }


    @Test
    @DisplayName("Строкове відображення однопалубного корабля")
    void SingleDeckShipToStringTest() {
        String actualString = singleDeckShip.toString();
        String expectedString = "Ship{size=1, coordinates=[{ x = 0, y = 0 }]}";
        assertEquals(expectedString, actualString, "Не вірний формат виводу координат корабля");
    }

    @Test
    @DisplayName("Розмір однопалубного корабля має дорівнювати 1")
    void SingleDeckShipGetSizeTest() {
        assertEquals(singleDeckShip.getSize(), 1, "Не вірний розмір однопалубного корабля");
    }

    @Test
    @DisplayName("Не вірно вказаний індекс масиву клітинки у корабля")
    void InCorrectIndexForCell(){
        try {
            singleDeckShip.addCell(-1, 1, 1, Cell.WHOLE_SHIP);
            fail();
        }catch (Exception e){
            assertEquals("Вихід за розміри масиву!",e.getMessage(),e.getMessage());
        }
    }

    @Test
    @DisplayName("Перевірка що корабель не вказаний")
    void CheckForEmptyShip(){
        try {
            singleDeckShip.addCell(0,1,1,Cell.EMPTY);
            assertTrue(singleDeckShip.isEmptyShip());
        } catch (Exception e) {
            assertEquals("Вихід за розміри масиву!",e.getMessage(),e.getMessage());
        }
    }

    @Test
    @DisplayName("Перевірка що корабель підбитий")
    void CheckForWreckedShip(){
        try {
            singleDeckShip.addCell(0,1,1,Cell.WRECKED_SHIP);
            assertTrue(singleDeckShip.isWreckedShip());
        } catch (Exception e) {
            assertEquals("Вихід за розміри масиву!",e.getMessage(),e.getMessage());
        }
    }

    @Test
    @DisplayName("Перевірка щою клітинка не була зайнята іншим кораблем")
    void CheckForCheckShip(){
        try {
            singleDeckShip.addCell(0,1,1,Cell.WHOLE_SHIP);
            singleDeckShip2.addCell(0,1,1,Cell.WHOLE_SHIP);
            assertTrue(singleDeckShip2.isCheckShip());
        } catch (Exception e) {
            assertEquals("Вихід за розміри масиву!",e.getMessage(),e.getMessage());
        }
    }
}
