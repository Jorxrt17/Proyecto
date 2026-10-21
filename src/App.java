import java.util.Random;
import java.util.Scanner;
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static Random r= new Random();
    public static void main() {
        int opcion =0;
        System.out.println("BIENVENIDO A CIFRAS Y LETRAS");
        System.out.println("Para comenzar dime que prueba desea realizar");
        System.out.println("Prueba 1 (La cifra exacta)");
        System.out.println("Prueba 2 (La palabra mas larga)");
        System.out.println("Prueba 3 (La calculadora humana)");
        System.out.println("Prueba 4 (Prueba original)");
        System.out.println("Opcion 5 : Finalizar pruebas");
        opcion = sc.nextInt();
    do{switch (opcion) {
        case 1:
            numerosale();
            break;
    
        default:
            System.err.println("Terminando Pruebas...");
            break;
    }

    }while(opcion==5);
    }
    public static void numerosale() {
        int numeros3cifras=0;
        int numeros0=0;
        int numeros1=0;
        int numeros2=0;
        int numeros3=0;
        int numeros4=0;
        int numeros5=0;
        numeros3cifras = r.nextInt(100, 999);
        numeros0 = r.nextInt( 10);
        numeros1 = r.nextInt( 10);
        numeros2 = r.nextInt( 10);
        numeros3 = r.nextInt( 10);
        numeros4 = r.nextInt( 10);
        numeros5 = r.nextInt( 10);
        System.out.println("Este es tu numero ha alcanzar: " + numeros3cifras);
        System.out.println("Estos son tus numeros generados aleatoriamente: ");
        System.out.println(numeros0);
        System.out.println(numeros1);
        System.out.println(numeros2);
        System.out.println(numeros3);
        System.out.println(numeros4);
        System.out.println(numeros5);
        
     }
        
    }
