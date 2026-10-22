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
        boolean resultadopal1 = true ;
        boolean resultadoresp2 = true ;
        do {
            System.out.println("Turno del jugador  1 introduce la palabra con las letras mostradas  ");
            String respuesta = sc.nextLine();
            comprobacion(respuesta);
            resultadopal1 = palabraJugador1.contains(GeneradorLetras());
            System.out.println("Comprobando si contine las letras predefinidas");
            if (resultadopal1=false ) {
                System.out.println("La palabra no contiene las letras predefinidas  vuelva a intentarlo ");
            }else{
        System.out.println("Enorabuena la palabra si existe ");

            }
            System.out.println("Jugador numero 2 La palabra del jugar 1 existe (si o no) ");
            String resp2 = sc.nextLine();
            resultadoresp2 = resp2.equalsIgnoreCase("si,no");
        } while (!resultadopal1 );
        System.out.println("Enorabuena la palabra si existe ");

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

    public static String comprobacion (String respuesta){
      
       boolean resultado = respuesta.contains(GeneradorLetras());

        return resultado;
    }


    


}
