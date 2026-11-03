import sun.misc.Signal;

public class A {
    public static void main(String[] args) {
        try {
            System.out.println("el Pid de A es " + ProcessHandle.current().pid());

            Signal.handle(new Signal("ALRM"), signal -> {
                System.out.println("A ha recibido SIGALRM");
            });
            Signal.handle(new Signal("HUP"), signal -> {
                System.out.println("A ha recibido SIGHUP");
            });

            for (int i = 1; i <= 15; i++) {
                Thread.sleep(1000);
            }
            System.out.println("A ha acabado");
        } catch (InterruptedException e) {
            System.err.println("El proces ha tenido un error");
            System.exit(-1);
        }
    }
}
