import java.util.Random;
import java.util.Scanner;
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r= new Random();
    public static void main() {
        int opcion =0;
        System.out.println("BIENVENIDO A CIFRAS Y LETRAS");
        System.out.println("Para comenzar dime que modo desea utilizar");
        System.out.println("1.Modo concurso ");
        System.out.println("2.Modo rapido");
        System.out.println("3.Ajustes");
        System.out.println("Opcion 5 : Finalizar");
        opcion = sc.nextInt();
        sc.nextLine();
    do{switch (opcion) {
        case 1:
            System.out.println("BIENVENIDO A MODO CONCURSO");
            System.out.println("Turno del jugador 1");
            numerosale();
            System.out.println("Turno del jugador 2");
            numerosale();
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

    }while(opcion!=5);
    }

    //Inicializar resultado con seleccion
    //Bucle 5 veces
    //     Seleccionar operacion
    //     seleccionar numero 
    //     acumular resultado
    public static void numerosale() {
        int numeros3cifras=0;
        int numeros0=0;
        int numeros1=0;
        int numeros2=0;
        int numeros3=0;
        int numeros4=0;
        int numeros5=0;
        numeros3cifras = r.nextInt(100, 999);
        numeros0 = r.nextInt(1,11);
        numeros1 = r.nextInt(1,11);
        numeros2 = r.nextInt(1,11);
        numeros3 = r.nextInt(1,11);
        numeros4 = r.nextInt(1,11);
        numeros5 = r.nextInt(1,11);
        System.out.println("Este es tu numero ha alcanzar: " + numeros3cifras);
        System.out.println("Estos son tus numeros generados aleatoriamente: ");
        System.out.println("Posicion numero 1..:" + " " + numeros0);
        System.out.println("Posicion numero 2..:" + " " + numeros1);
        System.out.println("Posicion numero 3..:" + " " + numeros2);
        System.out.println("Posicion numero 4..:" + " " + numeros3);
        System.out.println("Posicion numero 5..:" + " " + numeros4);
        System.out.println("Posicion numero 6..:" + " " + numeros5);
        System.out.println("Selecciona la posicion del numero generado para llegar al numero objetivo : " + numeros3cifras);     
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
    System.out.println("Selecciona otro numero para operar con tu Resultado actual y llegar a: " + numeros3cifras);
    } while (!valida);
}
System.out.println("Tu resultado final es: " + resultado);
System.out.println("Diferencia con el objetivo: " + Math.abs(resultado - numeros3cifras));
    }
    public static int seleccionar(int numeros0, int numeros1, int numeros2, int numeros3, int numeros4, int numeros5) {
        int resultado=0;
        do {
            int opcion =sc.nextInt();
            sc.nextLine();
            resultado=switch (opcion) {
                case 1 -> numeros0;
                case 2 -> numeros1;
                case 3 -> numeros2;
                case 4 -> numeros3;
                case 5 -> numeros4;
                case 6 -> numeros5;
                default -> -1;

            };
            if (resultado==-1)
                System.out.println("Numero no valido por favor seleccione entre los generados");
        } while (resultado<0);
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
}