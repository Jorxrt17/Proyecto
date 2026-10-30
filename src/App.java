
import java.util.Random;
import java.util.Scanner;
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    public static void main(String[] args) throws Exception {
        Pruebaletras();
        calculadoraHumana();
        
    }

    /*Empezamos con el juego de letras ,se le da un serie de letras y los jugadores tienen que escribir 
    una plabara con esas letras lo mas grande posible el jugador que escriba la palabra mas grande posible 
    con las letras generadas gana 1 punto en el marcador global .
    */ 
    public static void Pruebaletras (){
     System.out.println("La palabra mas larga ");
    
        String letras= GeneradorLetras();
        System.out.println("Letras disponibles " + letras );
        String respuesta;
        String respuesta2;
        String respuestamayus;
        String respuestaValidez;
        
     /*Hacemos que do while que contienen (pedir los datos y devolver si comprobacion  y si existe es true se guarda la respuesta si es falso se repite )para cada jugador  */

        do {
            System.out.println("Turno del jugador  1 introduce la palabra con las letras mostradas  ");
             respuesta = sc.nextLine();
             respuestamayus =respuesta.toUpperCase();
             System.out.println("Jugador 2 con la ayuda del diccionario ¿la palabra que ha escrito el jugador 1 existe ? (si / no)");
             respuestaValidez = sc.nextLine();
             
             if (respuestaValidez.equalsIgnoreCase("si") ){
                System.out.println("Perfecto si existe , el juego comprobara que se ha utilizado solo las letras permitidas ");

             }else{
                System.out.println("La palabra no es valida , de todas formas el juego comprobara si se han utilizado las letras adecuadas,tendras otra oportunidad jugador 1");
             }

            if(comprobacion(respuestamayus,letras)==true){
                System.out.println("El programa a confirmado que si contiene las palabras predefinidas ");
            }else{
                
                System.out.println("El programa a confirmado que no contiene las palabras predefinidas ");
                System.out.println("!Intentalo de nuevo¡");

            }
           
        } while (comprobacion(respuesta,letras)==false && respuestaValidez.equalsIgnoreCase("no"));
       
        

        System.out.println("Turno del jugador 2");
        letras= GeneradorLetras();
        System.out.println("Letras disponibles " + letras );
        do {
            System.out.println("Turno del jugador  2 introduce la palabra con las letras mostradas  ");
             respuesta2 = sc.nextLine();
             respuestamayus=respuesta2.toUpperCase();
             System.out.println("Jugador 1 con la ayuda del diccionario ¿la palabra que ha escrito el jugador 2 existe ? (si / no)");
             respuestaValidez = sc.nextLine();
             
             if (respuestaValidez.equalsIgnoreCase("si") ){
                System.out.println("Perfecto si existe , el juego comprobara que se ha utilizado solo las letras permitidas ");

             }else{
                System.out.println("La palabra no es valida , de todas formas el juego comprobara si se han utilizado las letras adecuadas,tendras otra oportunidad jugador 2");
             }

            if(comprobacion(respuestamayus,letras)==true){
                System.out.println("El programa a confirmado que si contiene las palabras predefinidas ");
            }else{
                
                System.out.println("El programa a confirmado que no contiene las palabras predefinidas ");
                System.out.println("!Intentalo de nuevo¡");

            }

           
        } while (comprobacion(respuesta,letras)==false && respuestaValidez.equalsIgnoreCase("no"));

        // comprobamos que jugador ha conseguido la palabra mas larga o si es un empate 
       if (empate(respuesta, respuesta2)==true) {
            System.out.println("!Empate¡  Ninguno ha obtenido un punto ");
        }
        if (ganadorJugador1(respuesta, respuesta2)==true) {
            System.out.println("Felicidades jugador 1 tu palabra es mas larga has obtenido un punto ");
        }
        if (ganadorJugador2(respuesta,respuesta2)==true) {
            System.out.println("Felicidades jugador 2 tu palabra es mas larga has obtenido un punto ");
        }
    


      





    }

    public static  String GeneradorLetras (){
     String alfabeto = "ABCDEFGHIJLMNOPQRSTUVWXY";
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNPRSTV";
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
    /* Funcion que le entra los datos con la variable letras que guarda las letras generadas 
    respuestamayus que guarda la respuesta en mayuscula y comprobamos si contiene esas letras 
    en la palabra que ha escrito el usuario 
    */ 
    public static boolean comprobacion (String respuestamayus  , String letras ){
        String posicion ;
      for (int i = 0; i < respuestamayus.length(); i++) {
       posicion = String.valueOf(respuestamayus.charAt(i));
        if(letras.contains(posicion)){
            letras=letras.replaceFirst(posicion,"");

        }else{
            return false;
        }
      }
      return true;
    }
    // Hacemos una funcion para comprobar que palabra es mas larga 
    public static boolean ganadorJugador1 (String respuesta,String respuesta2){

        if(respuesta.length()>respuesta2.length()){
            return  true ;
            

        }
        return  false;
        
        
    }
     public static boolean ganadorJugador2 (String respuesta,String respuesta2){

        if(respuesta.length()<respuesta2.length()){
            return  true ;
            

        }
        return  false;
        
        
    }

    public static boolean empate (String respuesta,String respuesta2){

        if(respuesta.length()==respuesta2.length()){
            return  true ;
            

        }
        return false;
    }
    public static void calculadoraHumana() throws InterruptedException {
        int suma = valorsumarestaRandom();
        int resta= valorsumarestaRandom();
        int div= valordivmultiRandom();
        int multi= valordivmultiRandom();
        int inicial= numeroinicialRandom();
        int opcion = opcion();
        int contador=0; 
        int numoperaciones = 4;
        int resultado =0;
        long inicio =0 ;
        long fin=0;
        int tiempofallo=0;

         inicio = System.currentTimeMillis();
        while (contador!=numoperaciones) {
             suma = valorsumarestaRandom();
             resta= valorsumarestaRandom();
             div= valordivmultiRandom();
             multi= valordivmultiRandom();
             opcion = opcion();
            switch (opcion) {
                
                case 1:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial+" + "+suma);
                        resultado = sc.nextInt();
                        if(operacionRandom(suma, resta, div, multi, inicial, opcion, resultado)==false){
                            tiempofallo=tiempofallo+20;
                        }
                    break;
                case 2:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial+" - "+resta);
                        resultado = sc.nextInt();
                          if(operacionRandom(suma, resta, div, multi, inicial, opcion, resultado)==false){
                            tiempofallo=tiempofallo+20;
                        }
                    break;  
                    
                case 3:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial+" * "+multi);
                        resultado = sc.nextInt();
                          if(operacionRandom(suma, resta, div, multi, inicial, opcion, resultado)==false){
                            tiempofallo=tiempofallo+20;
                        }       
                   
                    break;
            
                case 4:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial+" / "+div);
                        resultado = sc.nextInt();
                          if(operacionRandom(suma, resta, div, multi, inicial, opcion, resultado)==false){
                            tiempofallo=tiempofallo+20;
                        }
                    
                    break;
            
                default:
                    break;
            }
            
            inicial=resultado;
            
            contador++;
            
            
        }
        fin = System.currentTimeMillis();
        int segundosTotales = (int) ((fin - inicio) / 1000)-tiempofallo;
       System.out.println("Esto es lo que has tardado "+ segundosTotales);

    }
    public static int numeroinicialRandom(){
        int numeroinicial = r.nextInt(0, 101);
        return numeroinicial;
    }
      public static int opcion(){
        int numeroinicial = r.nextInt(1,5);
        return numeroinicial;
    }
    public static boolean operacionRandom(int suma,int resta ,int div,int multi,int inicial,int opcion,int resultado){
        int resultado1=0;
        switch (opcion) {
            case 1:
                 resultado1=inicial-resta;
                 if(resultado1==resultado){
                    return true;
                 }else{
                    return false ;
                }
            case 2:
               resultado1=inicial+suma;
               if (resultado1==resultado) {
                 return true;
               }else{
                return false;
               }
            case 3:
               resultado1=inicial*multi;
               if (resultado1==resultado) {
                return true;
               }else{
                return false;
               }
            case 4:
                resultado1=inicial/div;
                if(resultado1==resultado){
                    return true;
                }else{
                    return false;
                }
            default:
                break;
        }
        return true;
    }
    public static int valorsumarestaRandom(){
        int valorsumaresta = r.nextInt(10, 100);
        return valorsumaresta;
    }
    public static int valordivmultiRandom(){
        int valordivmulti = r.nextInt(1, 10);
        return valordivmulti;
    }


}
