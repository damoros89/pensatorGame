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
    static void iniciarTablero(char lista_juego[][],String palabra){
        for(int i=0; i<5;i++){
            for(int j=0;j<5; j++){
                if(i==0&&j==0){
                    char charPalabra=palabra.charAt(j);
                    lista_juego[i][j]=charPalabra;
                    System.out.print(ANSI_GREEN_BACKGROUND +"\u001B[1m"+ ANSI_BLACK + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");
                }else {
                    System.out.print(ANSI_WHITE_BACKGROUND +"\u001B[1m"+ANSI_BLACK + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");
                }
            }
            System.out.println("\n");
        }
    }
    static void creartablero(char lista_juego[][],int lista_codigo[][], String palabra) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("\u001B[1m\u001B["+lista_codigo[i][j]+"m"+ ANSI_BLACK + " " + lista_juego[i][j] + " " + ANSI_RESET + "  ");///Modificar para imprimir la matriz ya formateada
            }
            System.out.println("\n");
        }
    }
    static int[][] verificarPalabra(char palabraArray[],char palabra_inputArray[],int lista_codigo[][],int intento){

        String cadena_palabraArray=new String(palabraArray);
        String cadena_palabra_inputArray=new String(palabra_inputArray);
        char[] lista_letras_verdes;

        lista_letras_verdes = new char[]{' ', ' ', ' ', ' ', ' ', ' '};

        int posicion=0;

        for(int y=0; y< palabraArray.length;y++){
            if(palabraArray[y]==palabra_inputArray[y]){
                lista_letras_verdes[y]=palabraArray[y];
            }}

        String cadena_letras_verdes=new String(lista_letras_verdes);

        for(int i=0; i<5; i++){
        int contador_palabra=0;
            for(int j = 0;j<cadena_palabraArray.length();j++){
                if(palabra_inputArray[i] == cadena_palabraArray.charAt(j)){
                    contador_palabra++;
                }
        }
        int contador_palabraInput=0;
        for(int x=0;x<posicion;x++){
            if(palabra_inputArray[i] == cadena_palabra_inputArray.charAt(x)){
                contador_palabraInput++;
            }}

        int contador_letra_verde=0;
        for(int letra=0;letra<cadena_letras_verdes.length();letra++){
            if(palabra_inputArray[i] == cadena_letras_verdes.charAt(letra)){
                contador_letra_verde++;
            }
        }

        int contador_letra_amarilla=0;
            for(int x=0;x<i;x++){
                if(palabra_inputArray[i]==palabraArray[i]){
                    continue;
                }else{
                    if(palabra_inputArray[i] == cadena_palabra_inputArray.charAt(x)){
                    contador_letra_amarilla++;
                }}
            }

        if(palabraArray[i]==palabra_inputArray[i]){
                lista_codigo[intento][i]=42;}
        else if (cadena_palabraArray.indexOf(palabra_inputArray[i])!=-1&&cadena_letras_verdes.indexOf(palabra_inputArray[i])==-1){
            if(contador_palabraInput<contador_palabra){
            lista_codigo[intento][i]=43;}
        } else if (cadena_palabraArray.indexOf(palabra_inputArray[i])!=-1&&cadena_letras_verdes.indexOf(palabra_inputArray[i])!=-1){
            if(contador_letra_amarilla+contador_letra_verde<=contador_palabra){
            lista_codigo[intento][i]=43;
            }
        }
//        else if (cadena_palabraArray.indexOf(palabra_inputArray[i])!=-1&&cadena_letras_verdes.indexOf(palabra_inputArray[i])!=-1&&contador_letra_verde<contador_palabra){
//            lista_codigo[intento][i]=43;}
//        else if(cadena_letras_verdes.indexOf(palabra_inputArray[i])!=-1&&contador_palabra<contador_letra_verde) {
//                lista_codigo[intento][i] = 43;
//            }
        posicion++;
        }

       return lista_codigo;
    }

    static boolean comprobarFin(char palabraArray[], char palabra_inputArray[]){
        for(int i=0; i< palabraArray.length;i++){
            if(palabraArray[i]!=palabra_inputArray[i]){
                return false;
            }
        }
        return true;
    }


    static void animate(char lista_juego[][], String palabra){
        // Método para animar mostrando la palabra correcta con fondos alternos
        System.out.println("ADIVINASTE LA PALABRA\n");
        System.out.println("Mostrando la palabra: \n");
        for (int i = 0; i < palabra.length(); i++) {
            if (i % 2 == 0) {
                System.out.print(ANSI_GREEN_BACKGROUND + "\u001B[1m"+ANSI_BLACK+ palabra.charAt(i) + ANSI_RESET);
            } else {
                System.out.print(ANSI_WHITE_BACKGROUND + "\u001B[1m"+ANSI_BLACK+ palabra.charAt(i) + ANSI_RESET);
            }
        }
        System.out.println();
        System.out.println("\n¡FELICIDADES!");
    }

    static void animate_fin(char lista_juego[][], String palabra){
        // Método para animar mostrando la palabra correcta con fondos alternos
        System.out.println("¡¡¡HAS PERDIDO!!!:\n");
        System.out.println("La palabra es: \n");
        for (int i = 0; i < palabra.length(); i++) {
            if (i % 2 == 0) {
                System.out.print(ANSI_RED_BACKGROUND + "\u001B[1m"+ANSI_BLACK+ palabra.charAt(i) + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW_BACKGROUND + "\u001B[1m"+ANSI_BLACK+ palabra.charAt(i) + ANSI_RESET);
            }
        }
        System.out.println();
        System.out.println("\n¡SIGUE INTENTANDOLO!");
    }

    public static void main(String[] args) {
        System.out.println("=======MAGIC WORD=======\n==>Descubre la palabra: \n");
        Scanner teclado = new Scanner(System.in);
        String [] listaPalabras = {"avion","arbol","alado","agudo","apnea"};
        String [] listaJuego = {"\u001B[30m","\u001B[31m","\u001B[36m"};

        char lista_juego[][]=new char[][]{{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '},{' ',' ',' ',' ',' '}};

        int lista_codigo[][] =new int[][]{{47,47,47,47,47},{47,47,47,47,47},{47,47,47,47,47},{47,47,47,47,47},{47,47,47,47,47}};

        String palabra="anima";

        palabra=palabra.toUpperCase();
        char palabraArray[]=palabra.toCharArray();

        String palabra_input;
        char palabra_inputArray[];

        int intento=0;

        System.out.println(palabra);

        iniciarTablero(lista_juego,palabra);

        for(int ciclo=0;ciclo<5;ciclo++){

            System.out.println("Introduce una palabra");
            palabra_input=teclado.nextLine().toUpperCase();
            palabra_inputArray=palabra_input.toCharArray();

            for(int i=0;i<5;i++){
                char charPalabraInput=palabra_input.charAt(i);
                lista_juego[intento][i]=charPalabraInput;
            }
            lista_codigo=verificarPalabra(palabraArray,palabra_inputArray,lista_codigo,intento);

            boolean finJuego=comprobarFin(palabraArray,palabra_inputArray);

            creartablero(lista_juego,lista_codigo,palabra);
            if (finJuego) {
                animate(lista_juego, palabra);

                break;
            }

            intento++;
            //creartablero(lista_juego,lista_codigo,palabra);
        }
        if(intento>=5){
            animate_fin(lista_juego,palabra);
        }

    }
}