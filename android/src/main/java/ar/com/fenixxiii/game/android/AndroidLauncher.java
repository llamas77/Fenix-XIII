package ar.com.fenixxiii.game.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import ar.com.fenixxiii.game.Main;

/** Corre la aplicación en Android */
public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
        configuration.useWakelock = true;
        configuration.hideStatusBar = true;
        configuration.useImmersiveMode = true;
        initialize(new Main(null), configuration);
    }
}