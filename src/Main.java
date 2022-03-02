public class Main {
    public static void main(String[] args) {
        Window.getInstance().setTitle("Bouncers");
        new Thread(new Board()).start();
    }
}
