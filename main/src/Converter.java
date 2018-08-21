import java.util.*;
import java.util.stream.Collectors;

public class Converter {
    private final static Set<String> ROMAN_NUMERALS = initialiseRomanNumerals();
    private final static Set<String> INVALID_REPEATING_ROMAN_NUMERALS = initialiseInvalidRepeatingRomanNumerals();

    private final static String CONSECUTIVE_LETTERS_REGEX = "(?<=(.))(?!\\1)";

    private Converter() {
    }

    private static Set<String> initialiseRomanNumerals() {
        return Arrays.stream(RomanNumerals.values())
                .map(romanNumeral -> romanNumeral.getStringValue())
                .collect(Collectors.toCollection(HashSet::new));
    }

    private static Set<String> initialiseInvalidRepeatingRomanNumerals() {
        return new HashSet<String>(
            Arrays.asList("D", "L", "V")
        );
    }

    public static String arabicToRoman(int input) throws IllegalArgumentException {
        checkIfWithinRange(input);

        StringBuilder sb = new StringBuilder();

        for (RomanNumerals rn : RomanNumerals.values()) {
            int quotient = input / rn.getIntValue();

            for (int i = 0; i < quotient; i++) {
                sb.append(rn.getStringValue());
            }

            input %= rn.getIntValue();
        }

        return sb.toString();
    }

    private static void checkIfWithinRange(int input) throws IllegalArgumentException {
        if (input < 1 || input > 3999) {
            throw new IllegalArgumentException("Valid inputs are only from 1 to 3999");
        }
    }

    public static int romanToArabic(String input) throws IllegalArgumentException {
        input = input.toUpperCase();

        checkIfOnlyAllowedCharacters(input);
        checkIfInvalidCharacterRepetition(input);
        checkIfMoreThanThreeRepetitions(input);



        return 0;
    }

    private static void checkIfOnlyAllowedCharacters(String input) throws IllegalArgumentException {
        for (String singleLetter : input.split("")) {
            if (!ROMAN_NUMERALS.contains(singleLetter)) {
                throw new IllegalArgumentException(
                        String.format("A non-Roman numeral character '%s' was found", singleLetter)
                );
            }
        }
    }

    private static void checkIfInvalidCharacterRepetition(String input) throws IllegalArgumentException{
        Arrays.stream(input.split(CONSECUTIVE_LETTERS_REGEX))
                .filter(consecutiveLetters -> consecutiveLetters.length() > 1)
                .map(consecutiveLetters -> consecutiveLetters.substring(0, 1))
                .filter(INVALID_REPEATING_ROMAN_NUMERALS::contains)
                .findAny()
                .ifPresent(e->{
                    throw new IllegalArgumentException(
                            String.format("'%s' was consecutively repeated more than once", e)
                    );
                });
    }

    private static void checkIfMoreThanThreeRepetitions(String input) throws IllegalArgumentException {
        for (String consecutiveLetters : input.split(CONSECUTIVE_LETTERS_REGEX)) {
            if (consecutiveLetters.length() > 3) {
                throw new IllegalArgumentException(
                        String.format("'%c' was repeated more than three times", consecutiveLetters.charAt(0))
                );
            }
        }
    }
}
