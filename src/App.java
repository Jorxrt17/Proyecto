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
        String respuesta;
        do {
            System.out.println("Turno del jugador  1 introduce la palabra con las letras mostradas  ");
             respuesta = sc.nextLine();
            if(comprobacion(respuesta)==true){
                System.out.println("El programa a confirmado que si contiene las palabras predefinidas ");
            }else{
                
                System.out.println("El programa a confirmado que no contiene las palabras predefinidas ");
                System.out.println("!Intentalo de nuevo¡");

            }
           
        } while (comprobacion(respuesta)==false);
        System.out.println("Enorabuena la palabra si existe ");

    }

    public static  String GeneradorLetras (){
     String alfabeto = "ABCDEFGHIJLMNOPQRSTUVWXY";
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNPQRSTV";
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

    public static boolean comprobacion (String respuesta){
        String posicion ;
      for (int i = 0; i < respuesta.length(); i++) {
       posicion = String.valueOf(respuesta.charAt(i));
       
      }
    }

   


}
