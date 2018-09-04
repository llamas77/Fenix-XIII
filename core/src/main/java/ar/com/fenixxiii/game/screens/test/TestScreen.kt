package ar.com.fenixxiii.game.screens.test

import ar.com.fenixxiii.game.general.Nls.*
import ar.com.fenixxiii.game.screens.Screen
import com.badlogic.gdx.graphics.g2d.BitmapFont
import ktx.graphics.use

class TestScreen : Screen(TestController()) {

    val font = BitmapFont()

    override fun render(delta: Float) {
        super.render(delta)

        batch.use {
            font.draw(it, "Hola ${volver.nls}", 100f, 100f)
        }
    }

    override fun dispose() {
        super.dispose()
        font.dispose()
    }
}
