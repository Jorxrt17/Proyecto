import java.util.Random;
import java.util.Scanner;
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    public static void main(String[] args) throws Exception {
        Pruebaletras();
        
    }

    public static void Pruebaletras (){
    System.out.println("La palabra mas larga ");
    
        System.out.println(GeneradorLetras());

    }

    public static  String GeneradorLetras (){
    String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String vocales = "AEIOU";
    String consonantes = "BCDFGHJKLMNPQRSTVWXYZ";
    String  letrasgeneradas = " " ;
        for (int i = 0; i < 4; i++) {
            int posicion2 = r.nextInt(vocales.length());
            letrasgeneradas += String.valueOf(vocales.charAt(posicion2));
            int posicion3 = r.nextInt(consonantes.length());
            letrasgeneradas += String.valueOf(consonantes.charAt(posicion3));
        
        
        } 
        for (int i = 0; i < 2; i++) {
            int posicion = r.nextInt(alfabeto.length());
            letrasgeneradas += String.valueOf(alfabeto.charAt(posicion));
        
        
        } 
        

    return letrasgeneradas ;
    }
    


}
