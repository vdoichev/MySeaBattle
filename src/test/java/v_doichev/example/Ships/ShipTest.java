package v_doichev.example.Ships;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@Tag("first")
@DisplayName("Тестування кораблів")
public class ShipTest {
    private Ship singleDeckShip;

    @BeforeEach
    void prepaire() throws Exception {
        singleDeckShip = new SingleDeck();
        singleDeckShip.addCell(0, 0, 0);
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
            singleDeckShip.addCell(-1, 1, 1);
            assertTrue(false);
        }catch (Exception e){
            assertEquals("Вихід за розміри масиву!",e.getMessage(),e.getMessage());
        }
    }
}
