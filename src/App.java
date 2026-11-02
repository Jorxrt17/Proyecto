import java.util.Random;
import java.util.Scanner;

public class App {
    private static int puntosjugador1 = 0;
    private static int puntosjugador2 = 0;
    private static int nrondas = 3;
    private static int nletras = 2;
    private static int noperaciones = 4;
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();

    public static void main() throws Exception {
        int opcion = 0;
        int opcion1 = 0;
        System.out.println("BIENVENIDO A CIFRAS Y LETRAS");
        System.out.println("Para comenzar dime que modo desea utilizar");
        System.out.println("1. Modo concurso ");
        System.out.println("2. Modo rapido");
        System.out.println("3. Ajustes");
        System.out.println("4. Finalizar");

        do {
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("BIENVENIDO A MODO CONCURSO");
                    numerosale();
                    System.out.println("PRUEBA NUMERO 2");
                    System.out.println("__________________________________");
                    Pruebaletras();
                    System.out.println("PRUEBA NUMERO 3");
                    System.out.println("__________________________________");
                    calculadoraHumana();
                    System.out.println("PRUEBA NUMERO 4");
                    System.out.println("__________________________________");
                    cuentaatras();
                    break;
                case 2:
                    System.out.println("BIENVENIDO AL MODO RAPIDO");
                    System.out.println("Para comenzar dime que prueba desea realizar");
                    System.out.println("Prueba 1 : La cifra exacta");
                    System.out.println("Prueba 2 : La palabra más larga");
                    System.out.println("Prueba 3 : La calculadora humana");
                    System.out.println("Prueba 4 : La cuenta atras (Original)");
                    System.out.println("Opcion 5 : Salir");
                    do {
                        opcion1 = sc.nextInt();
                        sc.nextLine();
                        switch (opcion1) {
                            case 1:
                                numerosale();
                                break;
                            case 2:
                                Pruebaletras();
                                break;
                            case 3:
                                calculadoraHumana();
                                break;
                            case 4:
                                cuentaatras();
                                break;

                            default:
                                break;
                        }
                    } while (opcion1 != 5);
                    break;
                case 3:
                    System.out.println("BIENVENIDO A AJUSTES");
                    configuracion();

                    break;

                default:
                    System.out.println("Terminando Pruebas...");
                    break;
            }

        } while (opcion != 4);
    }

    public static void numerosale() {
        int punto1 = 0;
        int punto2 = 0;
        int numeros0 = numerosgenerados();
        int numeros1 = numerosgenerados();
        int numeros2 = numerosgenerados();
        int numeros3 = numerosgenerados();
        int numeros4 = numerosgenerados();
        int numeros5 = numerosgenerados();
        int resultadoabs2 = 0;
        int numeroalcanzar = 0;
        int numeroalcanzar2 = 0;
        int resultado1 = 0;
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
            punto1++;
        }

        if (ganador2jugador(resultado1, numeroalcanzar) && ganador1jugador(resultadoabs2, numeroalcanzar2) == false) {
            System.out.println("GANADOR JUGADOR 2");
            punto2++;
        }
        if (diferencia(resultadoabs, resultadoabs2) == true) {
            System.out.println("GANADOR JUGADOR 2");
            punto2++;

        } else {
            System.out.println("GANADOR JUGADOR 1");
            punto1++;

        }
        if (punto1 > punto2) {
            puntosjugador1++;
        } else {
            puntosjugador2++;
        }
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

    public static int seleccionar2(int numero1, int numero2, int numero3, int numero4, int numero5) {
        int resultado = 0;
        do {
            int opcion = sc.nextInt();
            sc.nextLine();
            resultado = switch (opcion) {
                case 1 -> numero1;
                case 2 -> numero2;
                case 3 -> numero3;
                case 4 -> numero4;
                case 5 -> numero5;
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

    public static boolean empate(int resultado, int numeroalcanzar2, int numeroalcanzar, int resultado1,
            int resultadoabs, int resultadoabs2) {
        if (resultado == numeroalcanzar2 && resultado1 == numeroalcanzar || resultadoabs == resultadoabs2) {
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
        int numero = r.nextInt(1, 11);
        return numero;

    }

    public static int numeros3cifras() {
        int numero = r.nextInt(100, 999);
        return numero;

    }

    public static int numeroALE() {
        int numero = r.nextInt(20, 50);
        return numero;
    }

    public static void cuentaatras() {
        System.out.println("BIENVENIDO A CUENTA ATRAS");
        System.out.println("");
        System.out.println("TIENES COMO OBJETIVO LLEGAR AL NUMERO '0' ANTES QUE TU RIVAL");
        System.out.println("");
        System.out.println("MIENTRAS EL NUMERO SEA POSTIVO LE RESTARAS NUMEROS Y SI ES NEGATIVO LOS SUMARAS");
        int numeroobjetivo = numeroALE();
        int numero1 = numerosgenerados();
        int numero2 = numerosgenerados();
        int numero3 = numerosgenerados();
        int numero4 = numerosgenerados();
        int numero5 = numerosgenerados();
        int punto1=0;
        int punto2=0;
        System.out.println("Este es vuestro numero objetivo: " + numeroobjetivo);
        System.out.println("Tus numeros a operar son: ");
        System.out.println("Posicion numero 1..:" + " " + numero1);
        System.out.println("Posicion numero 2..:" + " " + numero2);
        System.out.println("Posicion numero 3..:" + " " + numero3);
        System.out.println("Posicion numero 4..:" + " " + numero4);
        System.out.println("Posicion numero 5..:" + " " + numero5);
        System.out.println(
                "Selecciona la posicion del numero generado para llegar al numero objetivo : " + numeroobjetivo);
        int contador = 1;
        do {
            if (contador % 2 == 0) {
                System.out.println("Turno del jugador 2");
            } else {
                System.out.println("Turno del jugador 1");
            }
            int numero = seleccionar2(numero1, numero2, numero3, numero4, numero5);
            if (numeroobjetivo > 0) {
                numeroobjetivo = numeroobjetivo - numero;

            } else {
                numeroobjetivo = numeroobjetivo + numero;
            }
            System.out.println("Has operado con este numero: " + numero);
            System.out.println("Resultado actual: " + numeroobjetivo);
            contador++;
        } while (numeroobjetivo != 0);

        if (contador % 2 == 0) {
            System.out.println("GANADOR JUGADOR 1");
            punto1++;
        } else {
            System.out.println("GANADOR JUGADOR 2");
            punto2++;
        }
         if(punto1>punto2){
            puntosjugador1++;
        }else{puntosjugador2++;}
    }

    /*
     * Empezamos con el juego de letras ,se le da un serie de letras y los jugadores
     * tienen que escribir
     * una plabara con esas letras lo mas grande posible el jugador que escriba la
     * palabra mas grande posible
     * con las letras generadas gana 1 punto en el marcador global .
     */
    public static void mostrarMarcadorGlobal() {
        System.out.println("==================================");
        System.out.println("     MARCADOR GLOBAL FINAL        ");
        System.out.println("==================================");
        System.out.println("Jugador 1: " + puntosjugador1 + " puntos");
        System.out.println("Jugador 2: " + puntosjugador2 + " puntos");

        if (puntosjugador1 > puntosjugador2) {
            System.out.println("¡EL GANADOR ES EL JUGADOR 1!");
        } else if (puntosjugador2 > puntosjugador1) {
            System.out.println("¡EL GANADOR ES EL JUGADOR 2!");
        } else {
            System.out.println("¡HA HABIDO UN EMPATE GLOBAL!");
        }
    }

    public static void configuracion() {
        System.out.println("==========================");
        System.out.println("      CONFIGURACIÓN       ");
        System.out.println("==========================");
        System.out.println("                              ");
        System.out.println("Para cambiar el numero de rondas en los juegos introduzca el numero 1 ");
        System.out.println("Para cambiar el numero de letras en el juego (Prueba de letras) introduzca el numero 2 ");
        System.out.println(
                "Para cambiar el numero de operciones en el juego (calculadora humana ) introduzca el numero 3 ");
        System.out.println("Para salir  introduzca el numero 1 ");
        int opcion = sc.nextInt();
        int rondas = 0;
        int letras = 0;
        int operacion = 0;
        switch (opcion) {
            case 1:
                System.out.println(" Introduzca el numero de rondas ");
                rondas = sc.nextInt();
                if (rondas >= 1) {
                    nrondas = rondas;
                } else {
                    System.out.println("La cantidad minima es de 1 ronda introduce por favor un valor mayor que 0 ");
                    rondas = sc.nextInt();
                    nrondas = rondas;

                }

                break;
            case 2:
                System.out.println("Introduce la cantidad de letras quieres ");
                letras = sc.nextInt();
                if (letras >= 2) {
                    nletras = letras;
                } else {
                    System.out.println("La cantidad minima es de 2 letras introduce por favor un valor mayor que 2 ");
                    letras = sc.nextInt();
                    nletras = letras;
                }

            case 3:
                System.out.println("introduce la cantidad de operaciones ");
                operacion = sc.nextInt();
                if (operacion >= 1) {
                    noperaciones = operacion;

                } else {
                    System.out
                            .println("LA cantidad minima es de 1 operacion introduce por favor un valor mayor que 1 ");
                    operacion = sc.nextInt();
                    noperaciones = operacion;
                }

            default:
                break;
        }

    }

    public static void pruebaLetras() {
        System.out.println("La palabra mas larga ");

        String letras;
        String respuesta;
        String respuesta2;
        String respuestamayus;
        String respuestaValidez;
        int punto1 = 0;
        int punto2 = 0;
        int contador = 0;

        /*
         * Hacemos que do while que contienen (pedir los datos y devolver si
         * comprobacion y si existe es true se guarda la respuesta si es falso se repite
         * )para cada jugador
         */
        do {

            do {
                letras = GeneradorLetras();
                System.out.println("Letras disponibles " + letras);
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
                System.out.println(" introduce la palabra con las letras mostradas  ");
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

                System.out.println("==================================");
                System.out.println("!Empate¡  Ninguno ha obtenido un punto ");
                System.out.println("==================================");

            }
            if (ganadorJugador1(respuesta, respuesta2) == true) {
                System.out.println("==================================");
                System.out.println("Felicidades jugador 1 has ganado");
                System.out.println("==================================");

                punto1++;
            }
            if (ganadorJugador2(respuesta, respuesta2) == true) {
                System.out.println("==================================");
                System.out.println("Felicidades jugador 2 has ganado ");
                System.out.println("==================================");

                punto2++;

            }

            contador++;
            System.out.println("==================================");
            System.out.println("        RONDA    " + contador + "     FINALIZADA");
            System.out.println("==================================");

        } while (contador != nrondas);

        if (punto1 > punto2) {
            puntosjugador1++;
        } else if (punto1 < punto2) {
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
        for (int i = 0; i < nletras; i++) {
            int posicion = r.nextInt(alfabeto.length());
            letrasgeneradas += String.valueOf(alfabeto.charAt(posicion));

        }

        return letrasgeneradas;
    }

    /*
         Funcion que le entra los datos con la variable letras que guarda las letras
         generadas
         respuestamayus que guarda la respuesta en mayuscula y comprobamos si contiene
         esas letras
         en la palabra que ha escrito el usuario
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
        int inicial1 = numeroinicialRandom();
        int suma;
        int resta;
        int div;
        int multi;
        int opcionn;
        int resultado = 0;
        int resultado1 = 0;
        long inicio = 0;
        long fin = 0;
        int contadorondas = 0;
        int punto1 = 0;
        int punto2 = 0;
        System.out.println(
                "_________________________________________________________________________________________________________");
        System.out.println(
                "                                                                                                         ");
        System.out.println("Bienvenidos al juego de la calculadora humana");
        System.out.println(
                "_________________________________________________________________________________________________________");
        System.out.println(
                "                                                                                                         ");
        System.out.println("DETALLES DEL JUEGO");
        System.out.println(
                "                                                                                                         ");
        System.out.println("-Cada jugador realizara " + noperaciones + " operacion");
        System.out.println("-Ganar el jugador que realize las operaciones en el menor tiempo posible ");
        System.out.println("-Por cada operacion que se falle se añadiran 20 segundos al contador");
        System.out.println(
                "_________________________________________________________________________________________________________");
        System.out.println(
                "                                                                                                         ");
        System.out.println("Turno del jugador 1 ");
        System.out.println(
                "_________________________________________________________________________________________________________");
        do {

            int inicial = numeroinicialRandom();
            int contador = 0;
            int contadorfallos = 0;
            int tiempofallo = 0;

            System.out.println("\nTurno del jugador 1 ");
            System.out.println(
                    "_________________________________________________________________________________________________________");

            inicio = System.currentTimeMillis();
            while (contador < noperaciones) {
                suma = valorsumarestaRandom();
                resta = valorsumarestaRandom();
                div = valordivmultiRandom();
                multi = valordivmultiRandom();
                opcionn = opcion();

                switch (opcionn) {
                    case 1:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial1 + " + " + suma);
                        resultado = sc.nextInt();
                        resultado1 = operacionsuma(suma, inicial);
                        if (resultado != resultado1) {
                            tiempofallo += 20;
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
                            tiempofallo += 20;
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
                            tiempofallo += 20;
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
                            tiempofallo += 20;
                            System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                            contadorfallos++;
                        }
                        break;
                }

                inicial1 = resultado1;
                contador++;
            }

            fin = System.currentTimeMillis();
            int segundosTotales = (int) ((fin - inicio) / 1000) + tiempofallo;
            System.out.println("El jugador 1 ya ha realizado las " + noperaciones + " operaciones ");
            System.out.println("Ha realizado las operaciones con un total de " + contadorfallos + " fallos");
            System.out.println("El tiempo final es de " + segundosTotales + " segundos ");

            // TURNO PARA EL JUGADOR 2
            int contador2 = 0;
            int contadorfallos2 = 0;
            int tiempofallo2 = 0;
            inicial1 = numeroinicialRandom();

            System.out.println("\nTurno del jugador 2 ");
            System.out.println(
                    "_________________________________________________________________________________________________________");

            inicio = System.currentTimeMillis();
            while (contador2 < noperaciones) {
                suma = valorsumarestaRandom();
                resta = valorsumarestaRandom();
                div = valordivmultiRandom();
                multi = valordivmultiRandom();
                opcionn = opcion();

                switch (opcionn) {
                    case 1:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial1 + " + " + suma);
                        resultado1 = operacionsuma(suma, inicial1);
                        resultado = sc.nextInt();
                        if (resultado != resultado1) {
                            tiempofallo2 += 20;
                            System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                            contadorfallos2++;
                        }
                        break;
                    case 2:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial1 + " - " + resta);
                        resultado1 = operacionresta(resta, inicial1);
                        resultado = sc.nextInt();
                        if (resultado != resultado1) {
                            tiempofallo2 += 20;
                            System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                            contadorfallos2++;
                        }
                        break;
                    case 3:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial1 + " * " + multi);
                        resultado1 = operacionmulti(multi, inicial1);
                        resultado = sc.nextInt();
                        if (resultado != resultado1) {
                            tiempofallo2 += 20;
                            System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                            contadorfallos2++;
                        }
                        break;
                    case 4:
                        System.out.println("La opercion es la siguiente");
                        System.out.println(inicial1 + " / " + div);
                        resultado1 = operaciondiv(div, inicial1);
                        resultado = sc.nextInt();
                        if (resultado != resultado1) {
                            tiempofallo2 += 20;
                            System.out.println("HAS FALLADO PENALIZACION DE 20 SEGUNDOS");
                            contadorfallos2++;
                        }
                        break;
                }

                inicial1 = resultado1;
                contador2++;
            }

            fin = System.currentTimeMillis();
            int segundosTotales2 = (int) ((fin - inicio) / 1000) + tiempofallo2;
            System.out.println("El jugador 2 ya ha realizado las " + noperaciones + " operaciones ");
            System.out.println("Ha realizado las operaciones con un total de " + contadorfallos2 + " fallos");
            System.out.println("El tiempo final es de " + segundosTotales2 + " segundos ");

            System.out.println("____________________________________________________________________________________");

            // DETERMINAR GANADOR DE LA RONDA
            if (comprobadorempate(segundosTotales, segundosTotales2)) {
                System.out.println("¡¡¡EMPATE EN ESTA RONDA!!!");
            } else if (comprobador(segundosTotales, segundosTotales2)) {
                System.out.println("¡¡¡GANADOR JUGADOR 1 EN ESTA RONDA!!!");
                punto1++;
            } else {
                System.out.println("¡¡¡GANADOR JUGADOR 2 EN ESTA RONDA!!!");
                punto2++;
            }

            System.out.println("____________________________________________________________________________________");

            contadorondas++;
            System.out.println("==================================");
            System.out.println("        RONDA " + contadorondas + " FINALIZADA ");
            System.out.println("==================================");

        } while (contadorondas != nrondas);

        if (punto1 > punto2) {
            puntosjugador1++;
        } else if (punto1 < punto2) {
            puntosjugador2++;
        }
    }

    // Funciones de la calculadora humana

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

    public static boolean comprobador(int segundosTotales, int segundosTotales2) {
        if (segundosTotales > segundosTotales2) {
            return false;

        } else {
            return true;
        }

    }

    public static boolean comprobadorempate(int segundosTotales, int segundosTotales2) {
        if (segundosTotales == segundosTotales2) {
            return true;

        } else {
            return false;
        }

    }


}


