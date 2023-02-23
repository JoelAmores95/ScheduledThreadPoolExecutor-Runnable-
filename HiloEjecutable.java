import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HiloEjecutable implements Runnable {
    public static final int MAX_EJECUCIONES = 5;

    private int ejecucionesRestantes = MAX_EJECUCIONES;

    @Override
    public void run() {
        // Imprime la hora de inicio de la tarea
        Calendar calendario = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Hora inicio tarea: " + sdf.format(calendario.getTime()));

        // Ejecuta la tarea
        System.out.println("Tarea en ejecución...");

        // Actualiza el número de ejecuciones restantes
        ejecucionesRestantes--;
    }

    // Devuelve true si quedan ejecuciones por realizar
    public boolean hayEjecucionesRestantes() {
        return ejecucionesRestantes > 0;
    }

    // Reinicia el contador de ejecuciones
    public void reiniciar() {
        ejecucionesRestantes = MAX_EJECUCIONES;
    }
}
