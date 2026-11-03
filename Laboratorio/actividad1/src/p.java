public class p {
    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();
        System.out.println("PID del proceso actual: " + pid);

        try {
            System.out.println("Esperando 10 segundos antes de acabar");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.err.println("Error en el PID");
        }

        System.out.println("El proceso ha finalizado");
    }
}