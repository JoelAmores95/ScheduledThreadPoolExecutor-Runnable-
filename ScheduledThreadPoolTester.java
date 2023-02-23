import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTester {

    // Constantes
    public static final int NUM_HILOS = 5;
    public static final int SEGUNDOS_ESPERA = 30;
    public static final int DELAY_INCIAL = 3;
    public static final int DELAY = 5;
    public static final int COLA_TAMAÑO = 10;

    public static void main(String[] args) throws InterruptedException {

        // Imprime la fecha de inicio
        long startTime = System.nanoTime();
        System.out.println("Inicio: " + startTime);

        // Crea un Pool de X hilos con una cola de tamaño fijo
        ScheduledThreadPoolExecutor ejecutorProgramado = new ScheduledThreadPoolExecutor(NUM_HILOS);
        // ejecutorProgramado.setQueueCapacity(COLA_TAMAÑO);

        // Crea un objeto Runnable anónimo que representa la tarea a ejecutar
        Runnable tarea = new Runnable() {
            int ejecuciones = 1;
            @Override
            public void run() {
                long start = System.nanoTime();
                System.out.println("Hora inicio tarea: " + start);
                System.out.println("Tarea en ejecución...");
                System.out.println("Ejecución acabada: " + ejecuciones);
                long endTime = System.nanoTime();
                System.out.println("Diferencia de tiempo:" + (endTime-startTime) + " ns");
                ejecuciones++;
            }
        };

        // Prepara la ejecución con un delay inicial de 3s, después cada 5s
        ejecutorProgramado.scheduleWithFixedDelay(tarea, DELAY_INCIAL, DELAY, TimeUnit.SECONDS);

        // Espera un tiempo para parar la ejecución
        ejecutorProgramado.awaitTermination(SEGUNDOS_ESPERA, TimeUnit.SECONDS);

        // Para la ejecución y muestra el tiempo de ejecución total
        ejecutorProgramado.shutdown();
        long endTime = System.nanoTime();
        System.out.println("Fin: " + endTime);
        System.out.println("Tiempo total: " + (endTime - startTime) + " ns");
    }
}
