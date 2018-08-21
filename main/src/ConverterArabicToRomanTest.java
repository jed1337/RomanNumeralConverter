import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConverterArabicToRomanTest {
    @Test
    public void invalid(){
        assertThrows(IllegalArgumentException.class, () -> {
            Converter.arabicToRoman(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Converter.arabicToRoman(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Converter.arabicToRoman(4000);
        });
    }

    @Test
    public void basic() {
        assertEquals("M" , Converter.arabicToRoman(1000));
        assertEquals("D" , Converter.arabicToRoman(500));
        assertEquals("C" , Converter.arabicToRoman(100));
        assertEquals("L" , Converter.arabicToRoman(50));
        assertEquals("X" , Converter.arabicToRoman(10));
        assertEquals("V" , Converter.arabicToRoman(5));
        assertEquals("I" , Converter.arabicToRoman(1));
    }

    @Test
    public void subtractive(){
        assertEquals("CM", Converter.arabicToRoman(900));
        assertEquals("CD", Converter.arabicToRoman(400));
        assertEquals("XC", Converter.arabicToRoman(90));
        assertEquals("XL", Converter.arabicToRoman(40));
        assertEquals("IX", Converter.arabicToRoman(9));
        assertEquals("IV", Converter.arabicToRoman(4));
    }

    @Test
    public void invalidSubtractive(){
        assertNotEquals("DM", Converter.arabicToRoman(500));
        assertNotEquals("LM", Converter.arabicToRoman(950));
        assertNotEquals("XM", Converter.arabicToRoman(990));
        assertNotEquals("VM", Converter.arabicToRoman(995));
        assertNotEquals("IM", Converter.arabicToRoman(999));

        assertNotEquals("LD", Converter.arabicToRoman(450));
        assertNotEquals("XD", Converter.arabicToRoman(490));
        assertNotEquals("VD", Converter.arabicToRoman(495));
        assertNotEquals("ID", Converter.arabicToRoman(499));

        assertNotEquals("LC", Converter.arabicToRoman(50));
        assertNotEquals("VC", Converter.arabicToRoman(95));
        assertNotEquals("IC", Converter.arabicToRoman(99));

        assertNotEquals("VL", Converter.arabicToRoman(45));
        assertNotEquals("IL", Converter.arabicToRoman(49));
    }

    @Test
    public void tripleLetters(){
        assertEquals("MMM" , Converter.arabicToRoman(3000));
        assertEquals("CCC" , Converter.arabicToRoman(300));
        assertEquals("XXX" , Converter.arabicToRoman(30));
        assertEquals("III" , Converter.arabicToRoman(3));
    }

    @Test
    public void invalidTripleLetters(){
        assertNotEquals("DDD" , Converter.arabicToRoman(1500));
        assertNotEquals("LLL" , Converter.arabicToRoman(150));
        assertNotEquals("VVV" , Converter.arabicToRoman(15));
    }

    @Test
    public void invalidQuadrupleLetters(){
        assertNotEquals("CCCC" , Converter.arabicToRoman(400));
        assertNotEquals("XXXX" , Converter.arabicToRoman(40));
        assertNotEquals("IIII" , Converter.arabicToRoman(4));
    }

    @Test
    public void others(){
        assertEquals("MDCCLXXVI", Converter.arabicToRoman(1776));
        assertEquals("MCMLIV", Converter.arabicToRoman(1954));
        assertEquals("MCMXC", Converter.arabicToRoman(1990));
        assertEquals("MMXIV", Converter.arabicToRoman(2014));
    }
}