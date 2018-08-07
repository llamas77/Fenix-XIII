package ar.com.fenixxiii.game.lwjgl3;

        import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
        import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
        import ar.com.fenixxiii.game.Main;

/**
 * Ejecuta el juego en escritorio (LWJGL3)
 * TODO: configurar este arranque como en LWJGL2
 */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        createApplication();
    }

    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new Main(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setWindowedMode(1280, 720);
        configuration.setWindowIcon("icon128.png", "icon64.png", "icon32.png", "icon16.png");
        return configuration;
    }
}