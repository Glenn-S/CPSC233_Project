

public class GameContainer implements Runnable {

    private Thread thread;

    private boolean running = false;
    private final double UPDATE_CAP = 1.0/60.0;
    private int width = 320, height = 240;
    private float scale = 1f;
    private String title = "My Engine v1.0";


    public GameContainer() {

    }

    public void start() {
        thread = new Thread(this);
        thread.run(); // for creating a main thread (.start() is for side thread)
    }

    public void stop() {

    }

    public void run() {
        running = true;

        boolean render = false;
        double firstTime = 0.0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0.0;
        double unprocessedTime = 0.0;

        double frameTime = 0.0;
        int frames = 0;
        int fps = 0;

        while (running) {
            render = false;
            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;


            while (unprocessedTime >= UPDATE_CAP) {
                unprocessedTime -= UPDATE_CAP;
                render = true; // only render if there is something to update

                // for adjusting if there was a freeze
                // TODO update the game
                if (frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    System.out.println("FPS: " + fps);
                }
            }

            if (render) {
                //TODO render the game
                frames++;

            }
            else {
                try {
                    Thread.sleep(1);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        dispose();

    }

    private void dispose() {

    }

    /**
     * @return the title
     */
    public String getTitle() {
    	return new String(this.title);
    }
    /**
     * @return the width
     */
    public int getWidth() {
    	return this.width;
    }
    /**
     * @return the height
     */
    public int getHeight() {
    	return this.height;
    }
    /**
     * @return the scale
     */
    public float getScale() {
    	return this.scale;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
    	this.title = new String(title);
    }/**
     * @param width the width to set
     */
    public void setWidth(int width) {
    	this.width = width;
    }
    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
    	this.height = height;
    }
    /**
     * @param scale the scale to set
     */
    public void setScale(float scale) {
    	this.scale = scale;
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer();
        gc.start();
    }

}
