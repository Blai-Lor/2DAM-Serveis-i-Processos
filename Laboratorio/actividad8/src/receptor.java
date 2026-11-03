import sun.misc.Signal;
import sun.misc.SignalHandler;

public class receptor {
    public static void main(String[] args) {
        try {
            System.out.println("PID: " + ProcessHandle.current().pid());

            SignalHandler handler = signal -> {
                System.out.println("He recibido la señal: SIG" + signal.getName());
            };

            Signal.handle(new Signal("TERM"), handler);
            Signal.handle(new Signal("HUP"), handler);
            Signal.handle(new Signal("INT"), handler);

            while (true) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.err.println("El proces ha tenido un error");
            System.exit(-1);
        }
    }
}
