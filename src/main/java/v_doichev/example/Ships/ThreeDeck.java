package v_doichev.example.Ships;
/**
 * Трипалубний корабель
 */
public class ThreeDeck extends Ship {
    private static final int count = 2;
    public static int getCount() {
        return count;
    }
    public ThreeDeck() {
        super(3);
    }
    @Override
    public String getFormat() {
        return "x,y;x,y;x,y";
    }
    @Override
    public String getSizeStr() {
        return "трипалубного";
    }
}
