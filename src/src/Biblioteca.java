import java.util.List;

public class Biblioteca {

    private String id;
    private String nombre;
    private int maximoPrestamosSimultaneos;
    private List<Prestamo> prestamosActivos;

    public Biblioteca(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.maximoPrestamosSimultaneos = 3;
        this.prestamosActivos = null; // o new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaximoPrestamosSimultaneos() {
        return maximoPrestamosSimultaneos;
    }

    public void setMaximoPrestamosSimultaneos(int maximoPrestamosSimultaneos) {
        if (maximoPrestamosSimultaneos < 0) {
            this.maximoPrestamosSimultaneos = 0;
        } else {
            this.maximoPrestamosSimultaneos = maximoPrestamosSimultaneos;
        }
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos; // corregido nombre
    }

    public boolean tieneHuecoParaOtroPrestamo() {

        // Si no hay lista, significa que no tiene préstamos.
        if (prestamosActivos == null) {
            return maximoPrestamosSimultaneos > 0;
        }

        // Si sí hay lista, comprobamos tamaño.
        return prestamosActivos.size() < maximoPrestamosSimultaneos;
    }
}
