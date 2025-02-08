package Generadores;

import java.io.File;

public class GeneradorS {
    public static void main(String [] args) {
        jflex.Main.generate(new File("src/Lenguaje/Scanner.jflex"));
    }
}
