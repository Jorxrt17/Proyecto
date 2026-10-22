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
    do{switch (opcion) {
        case 1:
            System.out.println("BIENVENIDO A MODO CONCURSO");
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
        System.out.println("Selecciona 2 numeros para poder llegar al numero objetivo: " + numeros3cifras);     
        int primerusado = sc.nextInt();
        System.out.println("Ahora el segundo numero");
        int segundousado = sc.nextInt();
        System.out.println("Ahora selecciona que operacion deseas realizar: ");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir..");
        int operacion = sc.nextInt();
        do {
        System.out.println("Ahora selecciona que operacion deseas realizar: ");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir..");
        operacion = sc.nextInt();
        switch (operacion) {
            case 1:
                int resultadomas=primerusado+segundousado;
                System.out.println("Este es el resultado de tu suma : " + resultadomas);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            case 2:
                int resultadomenos= primerusado-segundousado;
                System.out.println("Este es el resultado de tu resta : " + resultadomenos);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            case 3:
                int resultadopor= primerusado*segundousado;
                System.out.println("Este es el resultado de tu multiplicacion : " + resultadopor);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            case 4:
                int resultadodiv= primerusado/segundousado;
                System.out.println("Este es el resultado de tu division : " + resultadodiv);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            default:
                System.out.println("Opción no valida");
                break;}
        } while (operacion != 5); 
        System.out.println("Dime tu primer resultado y con que numero deseas operar");
        int primerresultado = sc.nextInt();
         System.out.println("Ahora el numero deseado");
        int deseado = sc.nextInt();
        System.out.println("Dime la operación");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        int operacion2 = sc.nextInt();
        switch (operacion2) {
            case 1:
                int resultadomas=primerresultado+deseado;
                System.out.println("Este es el resultado de tu suma : " + resultadomas);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            case 2:
                int resultadomenos= primerresultado-deseado;
                System.out.println("Este es el resultado de tu resta : " + resultadomenos);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            case 3:
                int resultadopor= primerresultado*deseado;
                System.out.println("Este es el resultado de tu multiplicacion : " + resultadopor);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            case 4:
                int resultadodiv= primerresultado/deseado;
                System.out.println("Este es el resultado de tu division : " + resultadodiv);
                System.out.println("Y este es el numero ha alcanzar: " + numeros3cifras);
                break;
            default:
                System.out.println("Opción no valida");
                break;
     }
        
    }

    public static void resultado() {
        
    }
}