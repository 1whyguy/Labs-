package lab5;

import java.util.regex.*;

public class CapitalLetterHighlight {
    public static void main(String[] args) {
        String text = "thisIs a testString withCamelCase wordsLike iPad and iPhone.";

        Pattern pattern = Pattern.compile("([a-zа-яё])([A-ZА-ЯЁ])");
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll("$1!$2!");

        System.out.println("Оригинал: " + text);
        System.out.println("Результат: " + result);
    }
}