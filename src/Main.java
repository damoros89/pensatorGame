import java.util.Scanner;
import java.util.Random;

public class Main {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    static String palabraRandom(String[]lista){//Seleccionar palabra de la lista
        Random rand = new Random();
        int indice = rand.nextInt(lista.length);
        String palabra = lista[indice];
        return palabra;
    }
    static void inicarTablero(char lista_juego[][],String palabra){
        for(int i=0; i<5;i++){
            for(int j=0;j<5; j++){
                if(i==0&&j==0){
                    char charPalabra=palabra.charAt(j);
                    lista_juego[i][j]=charPalabra;
                    System.out.print(ANSI_GREEN_BACKGROUND + ANSI_BLACK + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");
                }else {
                    System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");
                }
            }
            System.out.println("\n");
        }
    }

    static void creartablero(char lista_juego[][],String palabra) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(ANSI_WHITE_BACKGROUND + ANSI_BLUE + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("MAGIC WORD");
        Scanner teclado = new Scanner(System.in);
        String [] listaPalabras = {"avion","camion","reloj","jamon","apnea"};
        String [] listaJuego = {"\u001B[30m","\u001B[31m","\u001B[36m"};

        char lista_juego[][]=new char[][]{{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '}};

        String palabra="animo";
        palabra=palabra.toUpperCase();
        String palabra_input;
        int intento=0;

        System.out.println(palabra);

        inicarTablero(lista_juego,palabra);

        for(int ciclo=0;ciclo<5;ciclo++){
            System.out.println("Introduce una palabra");
            palabra_input=teclado.nextLine().toUpperCase();
            for(int i=0;i<5;i++){
                char charPalabraInput=palabra_input.charAt(i);
                lista_juego[intento][i]=charPalabraInput;
            }
            intento++;
            creartablero(lista_juego,palabra);

        }



    }
}