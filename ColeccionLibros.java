public class ColeccionLibros {
    public static void main(String[] args) {
        String[][] misLibros = new String[100][3];
        String libro = "El Hobbit";
        String autor = "J.R.R. Tolkien";
        String editorial = "Ed. Planeta";
        agregarLibro(misLibros, libro, autor, editorial);
        agregarLibro(misLibros, libro, autor, editorial);
        agregarLibro(misLibros, libro, autor, editorial);

        System.out.println(totalLibros(misLibros));
        System.out.println(espaciosDisponibles(misLibros));

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
