public class ColeccionLibros {
    public static void main(String[] args) {
        String[][] misLibros = new String[100][3];
        String libro = "El Hobbit";
        String autor = "J.R.R. Tolkien";
        String editorial = "Ed. Planeta";

        agregarLibro(misLibros, libro, autor, editorial);
        agregarLibro(misLibros, libro, autor, editorial);

        buscarLibroPorNombre(misLibros, libro);

        mostrarTotalLibros(misLibros);
        mostrarEspaciosDisponibles(misLibros);

        mostrarTodaColeccion(misLibros);

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

    public static void buscarLibroPorNombre(String[][] misLibros, String libro) {
        for (int i = 0; i < misLibros.length; i++) {
            if(misLibros[i][0] == libro){
                System.out.println("Libro Encontrado: " + misLibros[i][0]);
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

    public static void agregarLibro(String[][] misLibros, String libro, String autor, String editorial) {
        int posicionDisponible = totalLibros(misLibros);
        misLibros[posicionDisponible][0] = libro;
        misLibros[posicionDisponible][1] = autor;
        misLibros[posicionDisponible][2] = editorial;

    }

}
