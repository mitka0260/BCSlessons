package ee.bcs.java.lessons;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonsLangStringUtils {

    public static void main(String[] args) {

        final ArrayList<String> strings = new ArrayList<String>();

        System.out.println("is empty");
        System.out.println(StringUtils.isEmpty("")); //true  //checks if a String contains text
        System.out.println(StringUtils.isEmpty("abc")); //false //IsEmpty==IsBlank

        System.out.println();
        System.out.println();
        System.out.println(StringUtils.trim("   Without spaces at the beginning & the end     "));  //Trim/Strip - removes leading and trailing whitespace

        System.out.println();
        System.out.println("equals");
        System.out.println("abc" == "abc");
        System.out.println(StringUtils.equals("abc", "Abc"));   //Equals/Compare - compares two strings in a null-safe manner

        System.out.println();
        System.out.println("starts with");
        System.out.println(StringUtils.startsWith("John is the best", "Jo"));   //check if a String starts with a prefix in a null-safe manner
        //endsWith

        System.out.println();
        System.out.println("indexOf");
        System.out.println(StringUtils.indexOf("John is the best", "best"));
        System.out.println(StringUtils.lastIndexOf("John is the best", "best"));
        System.out.println(StringUtils.contains("John is the best", "best"));

        System.out.println();
        System.out.println("contains");
        System.out.println(StringUtils.containsOnly("aaa", "a")); //checks if String contains only/none/any of these characters
        System.out.println(StringUtils.containsNone("aaa", "b"));
        System.out.println(StringUtils.containsAny("abcdef", "g, a"));

        System.out.println();
        System.out.println("SubstringBefore/SubstringAfter/SubstringBetween - substring extraction relative to other strings");
        System.out.println(StringUtils.substring("abcdefg", 3));    //null-safe substring extractions
        System.out.println(StringUtils.left("abcdefg", 3));
        System.out.println(StringUtils.right("abcdefg", 3));
        System.out.println(StringUtils.mid("abcdefghijkklomni", 3, 3));


        System.out.println();
        System.out.println("Split/Join - splits a String into an array of substrings and vice versa");
        System.out.println(Arrays.toString(StringUtils.split("I am crazy man")));
        System.out.println(StringUtils.join(StringUtils.split("I am crazy man"), " "));

        System.out.println();
        System.out.println("Remove/Delete - removes part of a String");
        System.out.println(StringUtils.remove("abcdefgijk", "def"));

        System.out.println();
        System.out.println("Replace/Overlay - Searches a String and replaces one String with another");
        System.out.println(StringUtils.replace("ABCDEFGHIKLMNOPQRSTVXYZ", "ABC", "XYZ"));

        System.out.println();
        System.out.println("Chomp/Chop - removes the last part of a String");
        System.out.print("I am a crazy man after sleeping ofcouse\n");
        System.out.print(StringUtils.chomp("I am a crazy man after sleeping ofcouse\n"));
        System.out.print("I am a crazy man after sleeping ofcouse\n");

        System.out.println();
        System.out.println("AppendIfMissing - appends a suffix to the end of the String if not present");
        System.out.println("PrependIfMissing - prepends a prefix to the start of the String if not present");
        System.out.println(StringUtils.appendIfMissing("ABCDEFGHIKLMNOPQRSTVXYZ", "suffix"));

        System.out.println();   //????????????
        System.out.println("LeftPad/RightPad/Center/Repeat - pads a String");
        System.out.println(StringUtils.leftPad("abcdef", 3, "z"));

        System.out.println();
        System.out.println("UpperCase/LowerCase/SwapCase/Capitalize/Uncapitalize - changes the case of a String");
        System.out.println(StringUtils.upperCase("abcdefg"));

        System.out.println();
        System.out.println("CountMatches - counts the number of occurrences of one String in another");
        System.out.println(StringUtils.countMatches("abcdefabdiksakjsabksksab", "ab"));

        System.out.println();
        System.out.println("IsAlpha/IsNumeric/IsWhitespace/IsAsciiPrintable - checks the characters in a String");
        System.out.println(StringUtils.isAlpha("abcdef"));
        System.out.println(StringUtils.isAlpha("123456"));
        System.out.println(StringUtils.isNumeric("123456"));
        System.out.println(StringUtils.isWhitespace(" "));

        System.out.println();
        System.out.println("Rotate - rotate (circular shift) a String");
        System.out.println(StringUtils.rotate("abcdefgh", 3));

        System.out.println();
        System.out.println("Reverse/ReverseDelimited - reverses a String");
        System.out.println(StringUtils.reverse("abcdefgh"));

        System.out.println();
        System.out.println("Abbreviate - abbreviates a string using ellipses or another given String");
        System.out.println(StringUtils.abbreviate("I am John", 8));


        System.out.println();
        System.out.println("Difference - compares Strings and reports on their differences");
        System.out.println(StringUtils.difference("I am a man", "I am a girl"));

        System.out.println();
        System.out.println("Difference - compares Strings and reports on their differences");
        System.out.println(StringUtils.difference("I am a man", "I am a girl"));


    }
}
