package ar.com.fenixxiii.game.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ar.com.fenixxiii.game.Main;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * Ejecuta el juego en escritorio (LWJGL2)
 */
public class DesktopLauncher {

    public static void main(String[] args) {
        createApplication();
    }


    /**
     * Crea e inicia el juego
     */
    private static LwjglApplication createApplication() {

        // Se define un trozo de código encargado de reiniciar el juego
        final Runnable rebootable = () -> {
            if (Gdx.app != null) Gdx.app.exit();
            start();
        };

        return new LwjglApplication(new Main(rebootable), getDefaultConfiguration());
    }

    /**
     * Configura la ventana de LWJGL
     */
    private static LwjglApplicationConfiguration getDefaultConfiguration() {

        //DesktopConfig.Companion.getInstance().load();

        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
        configuration.width = 1280;
        configuration.height = 720;
        for (int size : new int[] { 128, 64, 32, 16 }) {
            configuration.addIcon("icon" + size + ".png", FileType.Internal);
        }
        return configuration;
    }


    /**
     * Inicia la aplicación nuevamente
     *
     * (inserta un nuevo comando, indicando de abrir el juego)
     */
    public static void start() {
        System.out.println("REBOTEAAA");
        final StringBuilder cmd = new StringBuilder();
        cmd.append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("java ");
        for (final String jvmArg : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            cmd.append(jvmArg).append(" ");
        }
        cmd.append("-cp \"").append(ManagementFactory.getRuntimeMXBean().getClassPath()).append("\" ");
        cmd.append(DesktopLauncher.class.getName()).append(" ");

        try {
            System.out.println(cmd.toString());
            Runtime.getRuntime().exec(cmd.toString());
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}