import java.util.Calendar;
import java.util.GregorianCalendar;

public class HiloEjecutable implements Runnable {
    public static final int MAX_EJECUCIONES = 5;

    int ejecuciones = 1;

    @Override
    public void run() {

        // Creo un calendario
        Calendar calendario = new GregorianCalendar();
        System.out.println("Hora inicio tarea: " +
                calendario.get(Calendar.HOUR_OF_DAY) + ":" +
                calendario.get(Calendar.MINUTE) + ":" +
                calendario.get(Calendar.SECOND));
        System.out.println("Tarea en ejecución...");
        System.out.println("Ejecución acabada: " + ejecuciones);

        // Control de ejecuciones
        if (ejecuciones < 5) {
            ejecuciones++;
        }
    }

}
