package v_doichev.example.Ships;
/**
 * Двопалубний корабель
 */
public class DoubleDeck extends Ship {
    private static final int count = 3;

    public static int getCount() {
        return count;
    }

    public DoubleDeck() {
        super(2);
    }

    @Override
    public String getSizeStr() {
        return "двопалубного";
    }

    @Override
    public String getFormat() {
        return "x,y;x,y";
    }
}
