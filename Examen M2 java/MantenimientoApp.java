import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Comparator;

public class MantenimientoApp {

    
    public static void encabezadopgm() {
        String nombre = "Harold Roldan Vargas";
        String campus = "Campus Cali, U. Cooperativa de Colombia";
        String repositorioGit = "https://github.com/edier18/Estructura-de-datos";

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaHora = ahora.format(formateador);

        System.out.println();
        System.out.println("+----------------------------------------");
        System.out.println("| 👤 Nombre: " + nombre);
        System.out.println("| 🎓 Campus: " + campus);
        System.out.println("| 📅 Fecha y hora: " + fechaHora);
        System.out.println("| 📂 Repositorio Git: " + repositorioGit);
        System.out.println("+----------------------------------------");
        System.out.println();
    }

    
    static class Solicitud {
        String descripcion;
        String prioridad;

        public Solicitud(String descripcion, String prioridad) {
            this.descripcion = descripcion;
            this.prioridad = prioridad;
        }

        public int getNivelPrioridad() {
            return switch (prioridad.toLowerCase()) {
                case "alta" -> 3;
                case "media" -> 2;
                case "baja" -> 1;
                default -> 0;
            };
        }

        @Override
        public String toString() {
            return descripcion + " (Prioridad: " + prioridad + ")";
        }
    }

    
    static void mostrarCola(PriorityQueue<Solicitud> colaOriginal) {
        PriorityQueue<Solicitud> copia = new PriorityQueue<>(colaOriginal);
        while (!copia.isEmpty()) {
            System.out.println("- " + copia.poll());
        }
    }

    public static void main(String[] args) {
        encabezadopgm(); // Mostrar encabezado

        
        PriorityQueue<Solicitud> colaSolicitudes = new PriorityQueue<>(
            Comparator.comparingInt(Solicitud::getNivelPrioridad).reversed()
        );

        
        colaSolicitudes.add(new Solicitud("Revisión del motor principal", "alta"));
        colaSolicitudes.add(new Solicitud("Cambio de filtro de aire", "media"));
        colaSolicitudes.add(new Solicitud("Limpieza general", "baja"));
        colaSolicitudes.add(new Solicitud("Revisión de sistema eléctrico", "alta"));

        
        System.out.println("📋 Estado de la lista (antes del procesamiento):");
        mostrarCola(colaSolicitudes);

        
        if (!colaSolicitudes.isEmpty()) {
            Solicitud procesada = colaSolicitudes.poll();
            System.out.println("\n🔧 Procesando: " + procesada);
        }

        
        System.out.println("\n📋 Estado de la lista (después del procesamiento):");
        mostrarCola(colaSolicitudes);
    }
}
