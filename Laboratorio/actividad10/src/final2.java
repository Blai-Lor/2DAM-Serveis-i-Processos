import java.io.IOException;

class Final2 {
    public static void main(String[] args) {
        try {
            String pidFinal = args[0];
            System.out.println("final2: PID del final = " + pidFinal);

            ProcessBuilder pb = new ProcessBuilder("java", "final3.java", pidFinal);
            pb.inheritIO();
            Process proceso = pb.start();
            proceso.waitFor();

        } catch(IOException ex) {
            System.err.println("Excepcion de E/S!");
            System.exit(-1);
        } catch(InterruptedException ex) {
            System.err.println("El proceso hijo ha tenido un error.");
            System.exit(-1);
        }
    }
}
