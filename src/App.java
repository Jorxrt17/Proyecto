import java.util.Random;
import java.util.Scanner;
public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main() {
        System.out.println("BIENVENIDO A CIFRAS Y LETRAS");
        int opcion =0;
        System.out.println("Para comenzar dime que prueba desea realizar");
        System.out.println("Prueba 1 (La cifra exacta)");
        System.out.println("Prueba 2 (La palabra mas larga)");
        System.out.println("Prueba 3 (La calculadora humana)");
        System.out.println("Prueba 4 (Prueba original)");
        System.out.println("Opcion 5 : Finalizar pruebas");
        opcion = sc.nextInt();
    do{switch (opcion) {
        case 1:
            
            break;
    
        default:
            System.err.println("Terminando Pruebas...");
            break;
    }

    }while(opcion!=5);
    }

    public static void prueba1() {
        
    }
}
