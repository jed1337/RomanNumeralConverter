import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterRomanToArabicTest {
    @Test
    public void invalidCharacters() {
        assertThrows(IllegalArgumentException.class, () ->
                Converter.romanToArabic("a")
        );
        assertThrows(IllegalArgumentException.class, () ->
                Converter.romanToArabic("abc")
        );
        assertThrows(IllegalArgumentException.class, () ->
                Converter.romanToArabic("XYZ")
        );
    }

    @Test
    public void moreThanThreeRepetitions(){
        assertThrows(IllegalArgumentException.class, ()->
            Converter.romanToArabic("IIII")
        );
        assertThrows(IllegalArgumentException.class, ()->
            Converter.romanToArabic("MCMCCCIIII")
        );
        assertThrows(IllegalArgumentException.class, ()->
            Converter.romanToArabic("CDCCCC")
        );
    }

    @Test
    public void invalidRepetitions(){
        assertThrows(IllegalArgumentException.class, ()->
            Converter.romanToArabic("VV")
        );
        assertThrows(IllegalArgumentException.class, ()->
            Converter.romanToArabic("MCMDDI")
        );
        assertThrows(IllegalArgumentException.class, ()->
            Converter.romanToArabic("LLLLL")
        );
    }
}
