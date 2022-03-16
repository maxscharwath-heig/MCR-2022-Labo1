public abstract class LoopedThread extends Thread {
    private final double fps;

    LoopedThread(int fps) {
        super();
        this.fps = fps;
    }

    @Override
    public void run() {
        super.run();
        final double delay = 1000000000.0 / fps; // 60 fps
        long lastTime = System.nanoTime();
        double delta = 0;
        while (this.isAlive()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / delay;
            lastTime = now;
            while (delta >= 1) {
                this.update();
                delta--;
            }
        }
    }

    abstract protected void update();
}
