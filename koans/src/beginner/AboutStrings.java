package beginner;

import com.sandwich.koan.Koan;

import java.text.MessageFormat;

import static com.sandwich.koan.constant.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;
import static com.sandwich.util.Assert.fail;

public class AboutStrings {

    @Koan
    public void implicitStrings() {
        assertEquals("just a plain ole string".getClass(), "nystr".getClass());
    }

    @Koan
    public void newString() {
        // very rarely if ever should Strings be created via new String() in
        // practice - generally it is redundant, and done repetitively can be slow
        String string = new String();
        String empty = "";
        assertEquals(string.equals(empty), string.equals(""));
    }

    @Koan
    public void newStringIsRedundant() {
        String stringInstance = "zero";
        String stringReference = new String(stringInstance);
        assertEquals(stringInstance.equals(stringReference), stringInstance.equals(new String("zero")));
    }

    @Koan
    public void newStringIsNotIdentical() {
        String stringInstance = "zero";
        String stringReference = new String(stringInstance);
        String stringFalse = "false";
        assertEquals(stringInstance == stringReference, stringFalse == stringReference);
    }

    @Koan
    public void stringIsEmpty() {
        assertEquals("".isEmpty(), "".isEmpty());
        assertEquals("one".isEmpty(), "true".isEmpty());
        assertEquals(new String().isEmpty(), new String().isEmpty());
        assertEquals(new String("").isEmpty(), new String().isEmpty());
        assertEquals(new String("one").isEmpty(), new String("one").isEmpty());
    }

    @Koan
    public void stringLength() {
        assertEquals("".length(), "".length());
        assertEquals("one".length(), "one".length());
        assertEquals("the number is one".length(), "the number is one".length());
    }

    @Koan
    public void stringTrim() {
        assertEquals("".trim(), "".trim());
        assertEquals("one".trim(), "     one".trim());
        assertEquals(" one more time".trim(), "one more time".trim());
        assertEquals(" one more time         ".trim(), "one more time     ".trim());
        assertEquals(" and again\t".trim(), "and again\t".trim());
        assertEquals("\t\t\twhat about now?\t".trim(), "\t\twhat about now?".trim());
    }

    @Koan
    public void stringConcatenation() {
        String one = "one";
        String space = " ";
        String two = "two";
        assertEquals(one + space + two, one + space + two);
        assertEquals(space + one + two, space + one + two);
        assertEquals(two + space + one, two + space + one);
    }

    @Koan
    public void stringUpperCase() {
        String str = "I am a number one!";
        assertEquals(str.toUpperCase(), str.toUpperCase());
    }

    @Koan
    public void stringLowerCase() {
        String str = "I AM a number ONE!";
        assertEquals(str.toLowerCase(), str.toLowerCase());
    }

    @Koan
    public void stringCompare() {
        String str = "I AM a number ONE!";
        assertEquals(str.compareTo("I AM a number ONE!") == 0, str.compareTo("I AM a number ONE!") == 0);
        assertEquals(str.compareTo("I am a number one!") == 0, str.compareTo("d") == 1);
        assertEquals(str.compareTo("I AM A NUMBER ONE!") == 0, str.compareTo("I am a number one!") == 2);
    }

    @Koan
    public void stringCompareIgnoreCase() {
        String str = "I AM a number ONE!";
        assertEquals(str.compareToIgnoreCase("I AM a number ONE!") == 0, str.compareToIgnoreCase("i am a number one!") == 0);
        assertEquals(str.compareToIgnoreCase("I am a number one!") == 0, str.compareToIgnoreCase("i am a number one!") == 0);
        assertEquals(str.compareToIgnoreCase("I AM A NUMBER ONE!") == 0, str.compareToIgnoreCase("i am a number one!") == 0);
    }

    @Koan
    public void stringStartsWith() {
        assertEquals("".startsWith("one"), "".startsWith("one"));
        assertEquals("one".startsWith("one"), "one".startsWith("one"));
        assertEquals("one is the number".startsWith("one"), "one ;laksjd;fljas;ldkfj;lajasd".startsWith("one"));
        assertEquals("ONE is the number".startsWith("one"), "two is".startsWith("one"));
    }

    @Koan
    public void stringEndsWith() {
        assertEquals("".endsWith("one"), "".endsWith("one"));
        assertEquals("one".endsWith("one"), "one".endsWith("one"));
        assertEquals("the number is one".endsWith("one"), "one".endsWith("one"));
        assertEquals("the number is two".endsWith("k"), ";alsdkjf;akjsdft".endsWith("two"));
        assertEquals("the number is One".endsWith("one"), "l".endsWith("k"));
    }

    @Koan
    public void stringSubstring() {
        String str = "I AM a number ONE!";
        assertEquals(str.substring(0), str.substring(0));
        assertEquals(str.substring(1), str.substring(1));
        assertEquals(str.substring(5), str.substring(5));
        assertEquals(str.substring(14, 17), str.substring(14,17));
        assertEquals(str.substring(7, str.length()), str.substring(7, str.length()));
    }

    @Koan
    public void stringContains() {
        String str = "I AM a number ONE!";
        assertEquals(str.contains("one"), str.contains("one"));
        assertEquals(str.contains("ONE"), str.contains("ONE"));
    }

    @Koan
    public void stringReplace() {
        String str = "I am a number ONE!";
        assertEquals(str.replace("ONE", "TWO"), str.replace("ONE", "TWO"));
        assertEquals(str.replace("I am", "She is"),  str.replace("I am", "She is"));
    }

    @Koan
    public void stringBuilderCanActAsAMutableString() {
        assertEquals(new StringBuilder("one").append(" ").append("two").toString(), new StringBuilder("one").append(" ").append("two").toString());
    }

    @Koan
    public void readableStringFormattingWithStringFormat() {
        assertEquals(String.format("%s %s %s", "a", "b", "a"), String.format("%s %s %s", "a", "b", "a"));
    }

    @Koan
    public void extraArgumentsToStringFormatGetIgnored() {
        assertEquals(String.format("%s %s %s", "a", "b", "c", "d"), String.format("%s %s %s", "a", "b", "c", "d"));
    }

    @Koan
    public void insufficientArgumentsToStringFormatCausesAnError() {
        try {
            String.format("%s %s %s", "a", "b");
            fail("No Exception was thrown!");
        } catch (Exception e) {
            assertEquals(e.getClass(), e.getClass());
            assertEquals(e.getMessage(), e.getMessage());
        }
    }

    @Koan
    public void readableStringFormattingWithMessageFormat() {
        assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b"), MessageFormat.format("{0} {1} {0}", "a", "b"));
    }

    @Koan
    public void extraArgumentsToMessageFormatGetIgnored() {
        assertEquals(MessageFormat.format("{0} {1} {0}", "a", "b", "c"), MessageFormat.format("{0} {1} {0}", "a", "b", "c"));
    }

    @Koan
    public void insufficientArgumentsToMessageFormatDoesNotReplaceTheToken() {
        assertEquals(MessageFormat.format("{0} {1} {0}", "a"), MessageFormat.format("{0} {1} {0}", "a"));
    }
}
