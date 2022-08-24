import java.util.Scanner;

public class ColeccionLibros {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        String[][] misLibros = new String[100][3];
        int opcion = 0;
        do {
            mostrarOpciones();
            opcion = elegirOpcion();
            switch (opcion) {
                case 1 -> agregarLibro(misLibros);
                case 2 -> buscarLibroPorNombre(misLibros);
                case 3 -> mostrarTotalLibros(misLibros);
                case 4 -> mostrarEspaciosDisponibles(misLibros);
                case 5 -> mostrarTodaColeccion(misLibros);
            }
        }while(opcion != 0);

    }

    public static String[] ingresarLibro() {
        String[] datosLibro = new String[3];
        System.out.println("Ingrese el Nombre del Libro");
        datosLibro[0] = ingresarTexto();

        System.out.println("Ingrese el Autor del Libro");
        datosLibro[1] = ingresarTexto();

        System.out.println("Ingrese la Editorial del Libro");
        datosLibro[2] = ingresarTexto();

        return datosLibro;
    }

    public static String ingresarTexto() {
        Scanner input = new Scanner(System.in);
        String texto = input.nextLine();
        return texto;
    }

    public static void mostrarEspaciosDisponibles(String[][] misLibros) {
        System.out.println("Espacios Disponibles: " + espaciosDisponibles(misLibros));
    }

    public static void mostrarTotalLibros(String[][] misLibros) {
        System.out.println("Total de Libros: " + totalLibros(misLibros));
    }

    public static void mostrarTodaColeccion(String[][] misLibros) {
        System.out.println("-----COLECCION-----");
        for (int i = 0; i < totalLibros(misLibros); i++) {
            for (int j = 0; j < misLibros[i].length; j++) {
                System.out.print("["+misLibros[i][j]+"]");
            }
            System.out.println();
        }
        System.out.println("-----COLECCION-----");
    }

    public static void buscarLibroPorNombre(String[][] misLibros) {
        System.out.println("Ingresa el nombre del libro a buscar: ");
        String nombre = ingresarTexto();
        for (int i = 0; i < totalLibros(misLibros); i++) {
            if(misLibros[i][0].equals(nombre)){
                System.out.println("Libro Encontrado");
            }
        }
    }

    public static int totalLibros(String[][] misLibros) {
        int cantidadLibros = 100- espaciosDisponibles(misLibros);
        return cantidadLibros;
    }

    public static int espaciosDisponibles(String[][] misLibros) {
        int cont = 0;
        for (int i = 0; i < misLibros.length; i++) {
            for (int j = 0; j < misLibros[i].length; j++) {
                if(misLibros[i][j] == null){
                    cont++;
                }
            }
        }
        cont = cont/3;
        return cont;
    }

    public static void agregarLibro(String[][] misLibros) {
        int posicionDisponible = totalLibros(misLibros);
        if(posicionDisponible==100){
            System.out.println("No queda espacio");
        }else{
            String[] datosColeccion = ingresarLibro();
            misLibros[posicionDisponible][0] = datosColeccion[0];
            misLibros[posicionDisponible][1] = datosColeccion[1];
            misLibros[posicionDisponible][2] = datosColeccion[2];
        }
    }

    public static void mostrarOpciones() {
        System.out.println("[0].SALIR");
        System.out.println("[1].AGREGAR LIBRO");
        System.out.println("[2].BUSCAR LIBRO");
        System.out.println("[3].MOSTRAR ESPACIOS USADOS");
        System.out.println("[4].MOSTRAR ESPACIOS DISPONIBLES");
        System.out.println("[5].MOSTRAR TODA LA COLECCION");
    }

    public static int elegirOpcion() {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        do{
            try{
                opcion = input.nextInt();
            }catch (Exception e){
                System.out.println("Por favor ingrese un numero que corresponda a una de las opciones");
                input.next();
            }
        }while(opcion<-1 || opcion>5);

        return opcion;
    }

}
