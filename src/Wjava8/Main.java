package Wjava8;
@FunctionalInterface
interface Transformer {
    String transform(String input);
}

public class Main {
    public static void main(String[] args) {

        Transformer toLowerCase = String::toLowerCase;

        Transformer toUpperCase = (input) -> input.toUpperCase();

        Transformer toTitleCase = (input) -> {
            String[] words = input.split(" ");
            StringBuilder titleCase = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    titleCase.append(Character.toUpperCase(word.charAt(0)))
                            .append(word.substring(1).toLowerCase())
                            .append(" ");
                }
            }
            return titleCase.toString().trim();
        };

        String text = "heLLo everybody";

        System.out.println("original: " + text);
        System.out.println("Lowercase: " + toLowerCase.transform(text));
        System.out.println("Uppercase: " + toUpperCase.transform(text));
        System.out.println("Title Case: " + toTitleCase.transform(text));
    }
}
