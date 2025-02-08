package Pruebas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import java_cup.runtime.Symbol;
import Lenguaje.Scanner;
public class PruebaS {
    public static void main(String[] args) throws Exception {
        try {
            String input = readInput("./Inputs/Prueba.txt");
            Scanner scanner = new Scanner(
                new BufferedReader(
                    new StringReader(input)
                )
            );
            Symbol token = null;
            System.out.println("TOKEN" + " ".repeat(35 - "TOKEN".length()) + "LINE" + " ".repeat(6 - "LINE".length()) + "COLUMN" + " ".repeat(8 - "COLUMN".length()) + "TYPE");
            do {
                token = scanner.next_token();
                System.out.println(token.value + " ".repeat(35 - String.valueOf(token.value).length()) + token.left + " ".repeat(6 - String.valueOf(token.left).length()) + token.right + " ".repeat(8 - String.valueOf(token.right).length()) + Lenguaje.Terminal.terminalNames[token.sym]);
            } while(token.value != null);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public static String readInput(String path) {
        try {
            File archivo = new File(path);
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            BufferedReader br = new BufferedReader(isr);
            
            String texto = "";
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea + "\n";
            }
            br.close();
            fis.close();
            return texto;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
