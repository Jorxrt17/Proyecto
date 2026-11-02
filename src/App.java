import java.util.Random;
import java.util.Scanner;

public class App {
    private static int puntosjugador1=0;
    private static int puntosjugador2=0;
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
        int punto1 =0;
        int punto2=0;

        /*
         * Hacemos que do while que contienen (pedir los datos y devolver si
         * comprobacion y si existe es true se guarda la respuesta si es falso se repite
         * )para cada jugador
         */

        do {
            System.out.println("Turno del jugador  1 introduce la palabra con las letras mostradas  ");
            respuesta = sc.nextLine();
            respuestamayus = respuesta.toUpperCase();
            System.out.println(
                    "Jugador 2 con la ayuda del diccionario ¿la palabra que ha escrito el jugador 1 existe ? (si / no)");
            respuestaValidez = sc.nextLine();

            if (respuestaValidez.equalsIgnoreCase("si")) {
                System.out.println(
                        "Perfecto si existe , el juego comprobara que se ha utilizado solo las letras permitidas ");

            } else {
                System.out.println(
                        "La palabra no es valida , de todas formas el juego comprobara si se han utilizado las letras adecuadas,tendras otra oportunidad jugador 1");
            }

            if (comprobacion(respuestamayus, letras) == true) {
                System.out.println("El programa a confirmado que si contiene las palabras predefinidas ");
            } else {

                System.out.println("El programa a confirmado que no contiene las palabras predefinidas ");
                System.out.println("!Intentalo de nuevo¡");

            }

        } while (comprobacion(respuesta, letras) == false && respuestaValidez.equalsIgnoreCase("no"));

        System.out.println("Turno del jugador 2");
        letras = GeneradorLetras();
        System.out.println("Letras disponibles " + letras);
        do {
            System.out.println("Turno del jugador  2 introduce la palabra con las letras mostradas  ");
            respuesta2 = sc.nextLine();
            respuestamayus = respuesta2.toUpperCase();
            System.out.println(
                    "Jugador 1 con la ayuda del diccionario ¿la palabra que ha escrito el jugador 2 existe ? (si / no)");
            respuestaValidez = sc.nextLine();

            if (respuestaValidez.equalsIgnoreCase("si")) {
                System.out.println(
                        "Perfecto si existe , el juego comprobara que se ha utilizado solo las letras permitidas ");

            } else {
                System.out.println(
                        "La palabra no es valida , de todas formas el juego comprobara si se han utilizado las letras adecuadas,tendras otra oportunidad jugador 2");
            }

            if (comprobacion(respuestamayus, letras) == true) {
                System.out.println("El programa a confirmado que si contiene las palabras predefinidas ");
            } else {

                System.out.println("El programa a confirmado que no contiene las palabras predefinidas ");
                System.out.println("!Intentalo de nuevo¡");

            }

        } while (comprobacion(respuesta, letras) == false && respuestaValidez.equalsIgnoreCase("no"));

        // comprobamos que jugador ha conseguido la palabra mas larga o si es un empate
        if (empate(respuesta, respuesta2) == true) {

            System.out.println("                                                                                                         ");
            System.out.println("!Empate¡  Ninguno ha obtenido un punto ");
        }
        if (ganadorJugador1(respuesta, respuesta2) == true) {
            System.out.println("Felicidades jugador 1 tu palabra es mas larga has obtenido un punto ");
             punto1++;
        }
        if (ganadorJugador2(respuesta, respuesta2) == true) {
            System.out.println("Felicidades jugador 2 tu palabra es mas larga has obtenido un punto ");
             punto2++;
        }
        if(punto1>punto2){
            puntosjugador1++;
        }else if (punto1<punto2){
            puntosjugador2++;
        }

    }

    public static String GeneradorLetras() {
        String alfabeto = "ABCDEFGHIJLMNOPQRSTUVWXY";
        String vocales = "AEIOU";
        String consonantes = "BCDFGHJLMNPRSTV";
        String letrasgeneradas = " ";
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

        return letrasgeneradas;
    }

    /*
     * Funcion que le entra los datos con la variable letras que guarda las letras
     * generadas
     * respuestamayus que guarda la respuesta en mayuscula y comprobamos si contiene
     * esas letras
     * en la palabra que ha escrito el usuario
     */
    public static boolean comprobacion(String respuestamayus, String letras) {
        String posicion;
        for (int i = 0; i < respuestamayus.length(); i++) {
            posicion = String.valueOf(respuestamayus.charAt(i));
            if (letras.contains(posicion)) {
                letras = letras.replaceFirst(posicion, "");

            } else {
                return false;
            }
        }
        return true;
    }

    // Hacemos una funcion para comprobar que palabra es mas larga
    public static boolean ganadorJugador1(String respuesta, String respuesta2) {

        if (respuesta.length() > respuesta2.length()) {
            return true;

        }
        return false;

    }

    public static boolean ganadorJugador2(String respuesta, String respuesta2) {

        if (respuesta.length() < respuesta2.length()) {
            return true;

        }
        return false;

    }

    public static boolean empate(String respuesta, String respuesta2) {

        if (respuesta.length() == respuesta2.length()) {
            return true;

        }
        return false;
    }

    public static void calculadoraHumana() throws InterruptedException {
        int suma = valorsumarestaRandom();
        int resta = valorsumarestaRandom();
        int div = valordivmultiRandom();
        int multi = valordivmultiRandom();
        int inicial = numeroinicialRandom();
        int opcionn = opcion();
        int contador = 0;
        int contadorfallos = 0;
        int contador2 = 0;
        int numoperaciones = 4;
        int resultado = 0;
        int resultado1 = 0;
        long inicio = 0;
        long fin = 0;
        int tiempofallo = 0;
        int punto1=0;
        int punto2=0;
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("                                                                                                         ");
        System.out.println("Bienvenidos al juego de la calculadora humana");
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("                                                                                                         ");
        System.out.println("DETALLES DEL JUEGO");
        System.out.println("                                                                                                         ");
        System.out.println("-Cada jugador realizara 4 operacion");
        System.out.println("-Ganar el jugador que realize las operaciones en el menor tiempo posible ");
        System.out.println("-Por cada operacion que se falle se añadiran 20 segundos al contador");
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("                                                                                                         ");
        System.out.println("Turno del jugador 1 ");
        System.out.println("_________________________________________________________________________________________________________");

        inicio = System.currentTimeMillis();
        while (contador != numoperaciones) {
            suma = valorsumarestaRandom();
            resta = valorsumarestaRandom();
            div = valordivmultiRandom();
            multi = valordivmultiRandom();
            opcionn = opcion();
            switch (opcionn) {

                case 1:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " + " + suma);
                    resultado = sc.nextInt();
                    resultado1 = operacionsuma(suma, inicial);
                    if (resultado != resultado1) {
                        tiempofallo = tiempofallo + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }

                    break;
                case 2:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " - " + resta);
                    resultado = sc.nextInt();
                    resultado1 = operacionresta(resta, inicial);
                    if (resultado != resultado1) {
                        tiempofallo = tiempofallo + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }

                    break;

                case 3:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " * " + multi);
                    resultado = sc.nextInt();
                    resultado1 = operacionmulti(multi, inicial);
                    if (resultado != resultado1) {
                        tiempofallo = tiempofallo + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }

                    break;

                case 4:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " / " + div);
                    resultado = sc.nextInt();
                    resultado1 = operaciondiv(div, inicial);
                    if (resultado != resultado1) {
                        tiempofallo = tiempofallo + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }
                    break;

                default:
                    break;
            }

            inicial = resultado1;

            contador++;

        }
        fin = System.currentTimeMillis();
        int segundosTotales = (int) ((fin - inicio) / 1000) + tiempofallo;
        System.out.println("El jugador 1 ya ha realizado las 4 operaciones ");
        System.out.println("Ha realizado las 4 operaciones con un total de "+ contadorfallos+" fallos");
        System.out.println("El tiempo final es de " + segundosTotales+" segundos ");
        System.out.println("_________________________________________________________________________________________________________");
        System.out.println("                                                                                                         ");
        System.out.println("Turno del jugador 2 ");
        System.out.println("                                                                                                         ");
        System.out.println("_________________________________________________________________________________________________________");
        int tiempofallo2 = 0;
        contadorfallos=0;
        inicio = System.currentTimeMillis();
        while (contador2 != numoperaciones) {
            suma = valorsumarestaRandom();
            resta = valorsumarestaRandom();
            div = valordivmultiRandom();
            multi = valordivmultiRandom();
            opcionn = opcion();
            switch (opcionn) {

                case 1:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " + " + suma);
                    resultado1 = operacionsuma(suma, inicial);
                    resultado = sc.nextInt();
                    if (resultado != resultado1) {
                        tiempofallo2 = tiempofallo2 + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;
                    }
                    break;
                case 2:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " - " + resta);
                    resultado1 = operacionresta(resta, inicial);
                    resultado = sc.nextInt();
                    if (resultado != resultado1) {
                        tiempofallo2 = tiempofallo2 + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }
                    break;

                case 3:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " * " + multi);
                    resultado1 = operacionmulti(multi, inicial);
                    resultado = sc.nextInt();
                    if (resultado != resultado1) {
                        tiempofallo2 = tiempofallo2 + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }

                    break;

                case 4:
                    System.out.println("La opercion es la siguiente");
                    System.out.println(inicial + " / " + div);
                    resultado1 = operaciondiv(div, inicial);
                    resultado = sc.nextInt();
                    if (resultado != resultado1) {
                        tiempofallo2 = tiempofallo2 + 20;
                        System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                        contadorfallos++;

                    }

                    break;

                default:
                    break;
            }

            inicial = resultado1;

            contador2++;

        }
        fin = System.currentTimeMillis();
        int segundosTotales2 = (int) ((fin - inicio) / 1000) + tiempofallo2;
         System.out.println("El jugador 2 ya ha realizado las 4 operaciones ");
        System.out.println("Ha realizado las 4 operaciones con un total de "+ contadorfallos+" fallos");
        System.out.println("El tiempo final es de " + segundosTotales2+" segundos ");

        System.out.println("____________________________________________________________________________________");

        System.out.println("                                                                                                         ");

            if(comprobador(segundosTotales,segundosTotales2)==true && comprobadorempate(segundosTotales, segundosTotales2)==false){System.out.println("¡¡¡GANDOR JUGADOR 1 !!!");
                punto1++;
            }else{
                System.out.println("¡¡¡GANDOR JUGADOR 2 !!!");
                punto2++;
            }
            if(comprobadorempate(segundosTotales, segundosTotales2)==true){System.out.println("¡¡¡EMPATE !!!");}




        System.out.println("____________________________________________________________________________________");
             if(punto1>punto2){
            puntosjugador1++;
        }else if (punto1<punto2){
            puntosjugador2++;
        }

    }


    //Funciones de la calculadora humana 


    public static int numeroinicialRandom() {
        int numeroinicial = r.nextInt(0, 101);
        return numeroinicial;
    }

    public static int opcion() {
        int numeroinicial = r.nextInt(1, 5);
        return numeroinicial;
    }

    public static int operacionsuma(int suma, int inicial) {

        int resultado1 = inicial + suma;
        return resultado1;

    }

    public static int operacionresta(int resta, int inicial) {

        int resultado1 = inicial - resta;
        return resultado1;

    }

    public static int operacionmulti(int multi, int inicial) {

        int resultado1 = inicial * multi;
        return resultado1;

    }

    public static int operaciondiv(int div, int inicial) {

        int resultado1 = inicial / div;
        return resultado1;

    }

    public static int valorsumarestaRandom() {
        int valorsumaresta = r.nextInt(10, 100);
        return valorsumaresta;
    }

    public static int valordivmultiRandom() {
        int valordivmulti = r.nextInt(1, 10);
        return valordivmulti;
    }
    public static boolean comprobador(int segundosTotales, int segundosTotales2){
        if (segundosTotales>segundosTotales2){
            return false ;
            
        }else {
            return true ;
        }

    }
     public static boolean comprobadorempate(int segundosTotales, int segundosTotales2){
        if (segundosTotales==segundosTotales2){
            return true  ;
            
        }else {
            return false  ;
        }

    }


  
}