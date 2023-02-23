import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTester {

    public static final int NUM_HILOS = 5;
    public static final int SEGUNDOS_ESPERA = 30;
    public static final int DELAY_INCIAL = 3;
    public static final int DELAY = 5;

    public static void main(String[] args) throws InterruptedException {

        // Muestro la fecha de inicio:
        Calendar calendario = new GregorianCalendar();
        System.out.println("Inicio: " + calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) +
                ":" + calendario.get(Calendar.SECOND));

        // Creo un Pool de X hilos
        ScheduledThreadPoolExecutor ejecutorProgramado = new ScheduledThreadPoolExecutor(NUM_HILOS);

        // Creo un objeto Runnable
        HiloEjecutable hilo = new HiloEjecutable();

        // Preparo la ejecución con un delay inicial de 1s, después cada 5s
        ejecutorProgramado.scheduleWithFixedDelay(hilo, DELAY_INCIAL, DELAY,TimeUnit.SECONDS);

        // Espero un tiempo para parar la ejecucion
        ejecutorProgramado.awaitTermination(SEGUNDOS_ESPERA, TimeUnit.SECONDS);

        // Paro la ejecucion
        ejecutorProgramado.shutdown();
    }
}
