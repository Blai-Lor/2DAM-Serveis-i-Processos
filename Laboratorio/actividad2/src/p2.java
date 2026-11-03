public class p2 {
    public static void main(String[] args) {
        long pidFill = ProcessHandle.current().pid();
        long pidPare = ProcessHandle.current().parent().get().pid();

        System.out.println("PID Hijo: " + pidFill);
        System.out.println("PID Padre: " + pidPare);
    }
}
