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

    static void creartablero(char lista_juego[][],char lista_codigo[][], String palabra) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("\u001B["+lista_codigo[i][j]+"m"+ ANSI_BLUE + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");///Modificar para imprimir la matriz ya formateada
            }
            System.out.println("\n");
        }
    }

    static char[][] verificarPalabra(char palabraArray[],char palabra_inputArray[],char lista_codigo[][],int intento){
       for(int i=0; i< palabraArray.length;i++){
            if(palabraArray[i]==palabra_inputArray[i]){
                lista_codigo[intento][i]=42;

            }else{
                for(int j=0; j<palabraArray.length;j++){
                    if(palabra_inputArray[i]==palabraArray[j]){
                        lista_codigo[intento][i]=43;
                    }else{
                        lista_codigo[intento][i]=47;
                    }
                }
            }
       }
       return lista_codigo;
    }

    public static void main(String[] args) {
        System.out.println("MAGIC WORD");
        Scanner teclado = new Scanner(System.in);
        String [] listaPalabras = {"avion","arbol","alado","agudo","apnea"};
        String [] listaJuego = {"\u001B[30m","\u001B[31m","\u001B[36m"};

        char lista_juego[][]=new char[][]{{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '}};

        char lista_codigo[][] =new char[][]{{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '}};

        String palabra="animo";
        palabra=palabra.toUpperCase();

        char palabraArray[]=palabra.toCharArray();

        String palabra_input;
        char palabra_inputArray[];

        int intento=0;

        System.out.println(palabra);

        inicarTablero(lista_juego,palabra);

        for(int ciclo=0;ciclo<5;ciclo++){

            System.out.println("Introduce una palabra");
            palabra_input=teclado.nextLine().toUpperCase();
            palabra_inputArray=palabra_input.toCharArray();

            for(int i=0;i<5;i++){
                char charPalabraInput=palabra_input.charAt(i);
                lista_juego[intento][i]=charPalabraInput;
            }
            lista_codigo=verificarPalabra(palabraArray,palabra_inputArray,lista_codigo,intento);


            intento++;
            creartablero(lista_juego,lista_codigo,palabra);

        }



    }
}