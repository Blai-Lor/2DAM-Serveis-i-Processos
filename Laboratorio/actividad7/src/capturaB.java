import sun.misc.Signal;

public class capturaB {
    public static void main(String[] args) {
        try {
            System.out.println("PID: " + ProcessHandle.current().pid());

            Signal.handle(new Signal("INT"), signal -> {
                System.out.println("He recibido SIGINT, no puedes parar!");
            });

            Signal.handle(new Signal("ALRM"), signal -> {
                System.out.println("He recibido una alarma.");
            });

            Signal.handle(new Signal("TERM"), signal -> {
                System.out.println("El proceso ha finalizado.");
                System.exit(0);
            });

            Signal.handle(new Signal("HUP"), signal -> {
                System.out.println("Señal ignorada.");
            });

            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("El proces se ha interrumpido");
            System.exit(-1);
        }
    }
}
