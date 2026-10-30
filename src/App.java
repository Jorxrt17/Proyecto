import java.util.Random;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main() throws Exception {
        int opcion = 0;
        System.out.println("BIENVENIDO A CIFRAS Y LETRAS");
        System.out.println("Para comenzar dime que modo desea utilizar");
        System.out.println("1.Modo concurso ");
        System.out.println("2.Modo rapido");
        System.out.println("3.Ajustes");
        System.out.println("Opcion 5 : Finalizar");

        do {
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("BIENVENIDO A MODO CONCURSO");
                    numerosale();
                    Pruebaletras();
                    calculadoraHumana();

                    break;
                case 2:
                    System.out.println("BIENVENIDO AL MODO RAPIDO");
                    System.out.println("Para comenzar dime que prueba desea realizar");
                    break;
                case 3:
                    System.out.println("BIENVENIDO A AJUSTES");

                    break;

                default:
                    System.out.println("Terminando Pruebas...");
                    break;
            }

        } while (opcion != 5);
    }

    // Inicializar resultado con seleccion
    // Bucle 5 veces
    // Seleccionar operacion
    // seleccionar numero
    // acumular resultado
    public static void numerosale() {
        int numeros0 = numerosgenerados();
        int numeros1 = numerosgenerados();
        int numeros2 = numerosgenerados();
        int numeros3 = numerosgenerados();
        int numeros4 = numerosgenerados();
        int numeros5 = numerosgenerados();
        int resultadoabs2=0;
        int numeroalcanzar=0;
        int numeroalcanzar2=0;
        int resultado1=0;
         numeroalcanzar2 = numeros3cifras();
        System.out.println("Turno del jugador 1");
        System.out.println("Este es tu numero ha alcanzar: " + numeroalcanzar2);
        System.out.println("Estos son tus numeros generados aleatoriamente: ");
        System.out.println("Posicion numero 1..:" + " " + numeros0);
        System.out.println("Posicion numero 2..:" + " " + numeros1);
        System.out.println("Posicion numero 3..:" + " " + numeros2);
        System.out.println("Posicion numero 4..:" + " " + numeros3);
        System.out.println("Posicion numero 5..:" + " " + numeros4);
        System.out.println("Posicion numero 6..:" + " " + numeros5);
        System.out.println(
                "Selecciona la posicion del numero generado para llegar al numero objetivo : " + numeroalcanzar2);
        int resultado = seleccionar(numeros0, numeros1, numeros2, numeros3, numeros4, numeros5);

        for (int i = 0; i < 5; i++) {
            System.out.println("Resultado actual: " + resultado);
            boolean valida;
            do {
                int operacion = pedirOperacion();
                int numero = seleccionar(numeros0, numeros1, numeros2, numeros3, numeros4, numeros5);
                // OPERACION CON AYUDA DE CLAUDE (no tenia ni idea de como hacerla)
                valida = !(operacion == 4 && (numero == 0 || resultado % numero != 0));
                if (!valida) {
                    System.out.println("División no válida, elige de nuevo");
                } else {
                    resultado = switch (operacion) {
                        case 1 -> resultado + numero;
                        case 2 -> resultado - numero;
                        case 3 -> resultado * numero;
                        default -> resultado / numero;
                    };
                }
                System.out.println(
                        "Selecciona otro numero para operar con tu Resultado actual y llegar a: " + numeroalcanzar2);
            } while (!valida);
        }
        System.out.println("Tu resultado final es: " + resultado);
        int resultadoabs = Math.abs(resultado - numeroalcanzar2);
        System.out.println("Diferencia con el objetivo: " + resultadoabs);

        numeroalcanzar = numeros3cifras();
        System.out.println("Turno del jugador 2");
        System.out.println("Este es tu numero ha alcanzar: " + numeroalcanzar);
        System.out.println("Estos son tus numeros generados aleatoriamente: ");
        System.out.println("Posicion numero 1..:" + " " + numeros0);
        System.out.println("Posicion numero 2..:" + " " + numeros1);
        System.out.println("Posicion numero 3..:" + " " + numeros2);
        System.out.println("Posicion numero 4..:" + " " + numeros3);
        System.out.println("Posicion numero 5..:" + " " + numeros4);
        System.out.println("Posicion numero 6..:" + " " + numeros5);
        System.out.println(
                "Selecciona la posicion del numero generado para llegar al numero objetivo : " + numeroalcanzar);
         resultado1 = seleccionar(numeros0, numeros1, numeros2, numeros3, numeros4, numeros5);

        for (int i = 0; i < 5; i++) {
            System.out.println("Resultado actual: " + resultado1);
            boolean valida;
            do {
                int operacion = pedirOperacion();
                int numero = seleccionar(numeros0, numeros1, numeros2, numeros3, numeros4, numeros5);
                // OPERACION CON AYUDA DE CLAUDE (no tenia ni idea de como hacerla)
                valida = !(operacion == 4 && (numero == 0 || resultado1 % numero != 0));
                if (!valida) {
                    System.out.println("División no válida, elige de nuevo");
                } else {
                    resultado1 = switch (operacion) {
                        case 1 -> resultado1 + numero;
                        case 2 -> resultado1 - numero;
                        case 3 -> resultado1 * numero;
                        default -> resultado1 / numero;
                    };
                }
                System.out.println(
                        "Selecciona otro numero para operar con tu Resultado actual y llegar a: " + numeroalcanzar);
            } while (!valida);
        }
        System.out.println("Tu resultado final es: " + resultado);
         resultadoabs2 = Math.abs(resultado - numeroalcanzar);
        System.out.println("Diferencia con el objetivo: " + resultadoabs2);
        if (empate(resultado, numeroalcanzar2, numeroalcanzar2, resultado1, resultadoabs, resultadoabs2)) {
            System.out.println("HABEIS EMPATADO");
        }

        if (ganador1jugador(resultado, numeroalcanzar2) && ganador2jugador(resultado1, numeroalcanzar) == false) {
            System.out.println("GANADOR JUGADOR 1");
        }

        if (ganador2jugador(resultado1, numeroalcanzar) && ganador1jugador(resultadoabs2, numeroalcanzar2) == false) {
            System.out.println("GANADOR JUGADOR 2");
        }
        if(diferencia(resultadoabs, resultadoabs2)==true){
            System.out.println("GANADOR JUGADOR 1");
        }else {System.out.println("GANADOR JUGADOR 2");}
    }

    public static int seleccionar(int numeros0, int numeros1, int numeros2, int numeros3, int numeros4, int numeros5) {
        int resultado = 0;
        do {
            int opcion = sc.nextInt();
            sc.nextLine();
            resultado = switch (opcion) {
                case 1 -> numeros0;
                case 2 -> numeros1;
                case 3 -> numeros2;
                case 4 -> numeros3;
                case 5 -> numeros4;
                case 6 -> numeros5;
                default -> -1;

            };
            if (resultado == -1)
                System.out.println("Numero no valido por favor seleccione entre los generados");
        } while (resultado < 0);
        return resultado;

    }

    public static int pedirOperacion() {
        int opcion;
        do {
            System.out.println("Selecciona la operación");
            System.out.println("1.Sumar");
            System.out.println("2.Restar");
            System.out.println("3.Multiplicar");
            System.out.println("4.Dividir");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion < 1 || opcion > 4)
                System.out.println("Operación no válida");
        } while (opcion < 1 || opcion > 4);
        System.out.println("Selecciona numero para operar entre los antes vistos");
        return opcion;
    }

    public static boolean ganador1jugador(int resultado, int numeroalcanzar2) {
        if (resultado == numeroalcanzar2) {
            return true;
        }
        return false;
    }

    public static boolean ganador2jugador(int resultado1, int numeroalcanzar) {
        if (resultado1 == numeroalcanzar) {
            return true;
        }
        return false;
    }

    public static boolean empate(int resultado, int numeroalcanzar2, int numeroalcanzar, int resultado1, int resultadoabs, int resultadoabs2) {
        if (resultado == numeroalcanzar2 && resultado1 == numeroalcanzar || resultadoabs == resultadoabs2 ) {
            return true;
        }
        return false;
    }

    public static boolean diferencia(int resultadoabs, int resultadoabs2) {
        if (resultadoabs > resultadoabs2) {
            return true;
        }
        return false;
    }

    public static int numerosgenerados() {
        int numerora = r.nextInt(1, 11);
        return numerora;

    }

    public static int numeros3cifras() {
        int numero = r.nextInt(100, 999);
        return numero;

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