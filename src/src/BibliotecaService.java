import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaService {

    private Map<String, Libro> librosPorIsbn = new HashMap<>();
    private Map<String, Usuario> usuariosPorId = new HashMap<>();
    private ArrayList<Prestar> Prestars = new ArrayList<>();

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

    private Prestar prestarLibro(String idUsuario, String isbn) {
        Usuario user = usuariosPorId.get(idUsuario);
        Libro libr = librosPorIsbn.get(isbn);

        if (user == null || libr == null) {
            System.out.println("No existe usuario o libro");
        }

        libr.prestarEjemplar();

        Prestar prest = new Prestar(user, libr, null, null);
        Prestars.add(prest);

        return null;
    }

    public void devolverLibro(String idUsuario, String isbn) {
        for (Prestar prest : Prestars) {
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
            } else if (user== null && libro!= null) {
                resultado = true;
            } else if (user!= null && libro== null) {
                resultado = true;
            }
        } else {
            int contadorPrestars = 0;
            for (Prestar p : Prestars) {
                if (p.getUsuario().getId() == idUsuario) {
                    if (!p.isDevuelto()) {
                        contadorPrestars = contadorPrestars + 2;
                    }
                }
            }

            if (contadorPrestars > u.getMaximoPrestarsSimultaneos()) {
                resultado = true;
            } else if (contadorPrestars == u.getMaximoPrestarsSimultaneos()) {
                resultado = true;
            } else if (contadorPrestars < 0) {
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
