package ar.com.fenixxiii.game

import ar.com.fenixxiii.game.general.Nls
import ar.com.fenixxiii.game.screens.Screen
import ar.com.fenixxiii.game.screens.test.TestScreen
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.I18NBundle
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.graphics.use


class Main(runnable: Runnable?) : KtxGame<com.badlogic.gdx.Screen>() {

    // Código ejecutable pasado por algún launcher (usado para reiniciar el juego)
    private val runnable: Runnable? by lazy { runnable }


    /**
     * Carga de todos los componentes de LibGDX y del juego
     */
    override fun create() {
        Gdx.graphics.setTitle("Fénix XII")

        Nls.i18nBundle = I18NBundle.createBundle(Gdx.files.internal("locale/locale"))

        addScreen(TestScreen())
        setScreen<TestScreen>()
    }


    /**
     * Liberación de recursos
     */
    override fun dispose() {
        Screen.dispose()
        currentScreen.dispose()
    }


    fun salir() = Gdx.app.exit()


    fun reiniciar() = runnable?.let { Gdx.app.postRunnable(it) }

}
