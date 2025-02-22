package Pruebas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import Clases.Abstractas.Instruccion;
import Clases.Entorno.Entorno;
import Lenguaje.Parser;
import Lenguaje.Scanner;
public class ParserTest {
    public static void main(String[] args) throws Exception {
        try {
            String input = readInput("./Inputs/Prueba.txt");
            Scanner scanner = new Scanner(
                new BufferedReader(
                    new StringReader(input)
                )
            );
            Parser parser = new Parser(scanner);
            parser.parse();
            Entorno global = new Entorno("global");
            String salida_ = "";
            for (Instruccion instruccion : parser.sentencias) {
                try {
                    instruccion.jugar(global);
                    for (String salida : Clases.Utilidades.Salida.salidaConsola) {
                        salida_ += salida;
                    }
                } catch (Exception e) {

                }
            }
            System.out.println(salida_);
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