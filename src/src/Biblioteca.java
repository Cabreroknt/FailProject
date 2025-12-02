import java.util.List;

public class Biblioteca {

    private String id;
    private String nombre;
    private int maximoPrestarsSimultaneos;
    private List<Prestar> PrestarsActivos;

    public Biblioteca(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.maximoPrestarsSimultaneos = 3;
        this.PrestarsActivos = null; // o new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaximoPrestarsSimultaneos() {
        return maximoPrestarsSimultaneos;
    }

    public void setMaximoPrestarsSimultaneos(int maximoPrestarsSimultaneos) {
        if (maximoPrestarsSimultaneos < 0) {
            this.maximoPrestarsSimultaneos = 0;
        } else {
            this.maximoPrestarsSimultaneos = maximoPrestarsSimultaneos;
        }
    }

    public List<Prestar> getPrestarsActivos() {
        return PrestarsActivos; // corregido nombre
    }

    public boolean tieneHuecoParaOtroPrestar() {

        // Si no hay lista, significa que no tiene préstamos.
        if (PrestarsActivos == null) {
            return maximoPrestarsSimultaneos > 0;
        }

        // Si sí hay lista, comprobamos tamaño.
        return PrestarsActivos.size() < maximoPrestarsSimultaneos;
    }
}
