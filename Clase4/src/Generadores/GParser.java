package Generadores;

public class GParser {
    public static void main(String[] args) {
        try {
            java_cup.Main.main(
                new String[] {
                    "-destdir",
                    "src/Lenguaje",
                    "-symbols",
                    "Terminal",
                    "-parser",
                    "Parser",
                    "src/Lenguaje/Parser.cup"
                });
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
