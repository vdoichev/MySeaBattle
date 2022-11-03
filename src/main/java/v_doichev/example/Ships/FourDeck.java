package v_doichev.example.Ships;
/**
 * Чотирипалубний корабель
 */
public class FourDeck extends Ship {
    private static final int count = 1;
    public static int getCount() {
        return count;
    }
    public FourDeck() {
        super(4);
    }
    @Override
    public String getFormat() {
        return "x,y;x,y;x,y;x,y";
    }
    @Override
    public String getSizeStr() {
        return "чотирипалубного";
    }
}
