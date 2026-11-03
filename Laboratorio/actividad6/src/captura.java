import sun.misc.Signal;

public class captura {
    public static void main(String[] args) {
        try {
            System.out.println("PID: " + ProcessHandle.current().pid());

            Signal.handle(new Signal("INT"), signal -> {
                System.out.println("He recibido SIGINT, no puedes parar!");
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
