/**
 * Relies on the proper ordering of enum.
 * Also includes special cases like CM for 900 to avoid
 * manually coding logic involving them
 */
public enum RomanNumerals {
    M(1000, "M"),
    CM(900, "CM"),
    D(500, "D"),
    CD(400, "CD"),
    C(100, "C"),
    XC(90, "XC"),
    L(50, "L"),
    XL(40, "XL"),
    X(10, "X"),
    IX(9, "IX"),
    V(5, "V"),
    IV(4, "IV"),
    I(1, "I");

    public final int intValue;
    private final String stringValue;

    RomanNumerals(int intValue, String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public RomanNumerals[] singleLetters() {
        return new RomanNumerals[]{
                M, D, C, L, X, V, I
        };
    }
}
