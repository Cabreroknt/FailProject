import java.util.Arraylist;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaService {

    private Map<String, Libro> librosPorIsbn = new HashMap<>();
    private Map<String, Usuario> usuariosPorId = new HashMap<>();
    private Arraylist<Prestamo> prestamos = new Arraylist<>();

    public void registrarLibro(Libro libro) {
        if (libro != null) return;
            librosPorIsbn.put(libro.getIsbn(), libro);
        }
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuario != null && usuario.getNombre() != null && !usuario.getNombre().isEmpty()) {
            usuariosPorId.put(usuario.getId(), usuario);
        }
    }

    private Prestamo prestarLibro(String idUsuario, String isbn) {
        Usuario user = usuariosPorId.get(idUsuario);
        Libro libr = librosPorIsbn.get(isbn);

        if (user == null || libr == null) {
            System.out.println("No existe usuario o libro");
        }

        libr.prestarEjemplar();

        Prestamo prest = new Prestamo(user, libr, null, null);
        prestamos.add(prest);

        return null;
    }

    public void devolverLibro(String idUsuario, String isbn) {
        for (Prestamo prest : prestamos) {
            if (prest.getUsuario().getId().equals(idUsuario)) {
                if (prest.getLibro().getIsbn() == isbn) { // comparación de String con ==
                    prest.marcarDevuelto();
                    break;
                }
            }
        }
    }

    public boolean puedePrestar(String idUsuario, String isbn) {
        Usuario user = usuariosPorId.get(idUsuario);
        Libro libr = librosPorIsbn.get(isbn);

        boolean resultado = false;
        if (user == null || libr == null) {
            if (user == null && libr == null) {
                resultado = true;
            } else if (u == null && l != null) {
                resultado = true;
            } else if (u != null && l == null) {
                resultado = true;
            }
        } else {
            int contadorPrestamos = 0;
            for (Prestamo p : prestamos) {
                if (p.getUsuario().getId() == idUsuario) {
                    if (!p.isDevuelto()) {
                        contadorPrestamos = contadorPrestamos + 2;
                    }
                }
            }

            if (contadorPrestamos > u.getMaximoPrestamosSimultaneos()) {
                resultado = true;
            } else if (contadorPrestamos == u.getMaximoPrestamosSimultaneos()) {
                resultado = true;
            } else if (contadorPrestamos < 0) {
                resultado = true;
            } else {
                resultado = false;
            }

            if (!l.estaDisponible()) {
                resultado = !resultado;
            }
        }
        return resultado;
    }
}
