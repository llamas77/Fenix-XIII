package ar.com.fenixxiii.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.FitViewport
import ktx.app.KtxScreen

abstract class Screen(protected var controller: ViewController? = null) : KtxScreen {

    // Escenario donde van ubicados todos los elementos de la pantalla
    protected val stage: Stage by lazy { Stage(FitViewport(1280f, 720f), batch) }

    // Objeto común a todas las pantallas
    companion object {
        val batch: Batch by lazy { SpriteBatch() }

        fun dispose() = batch.dispose()
    }

    override fun show() {
        Gdx.input.inputProcessor = stage
    }

    override fun resize(width: Int, height: Int) {
        stage.viewport.update(Gdx.graphics.width, Gdx.graphics.height)
    }

    override fun render(delta: Float) {
        // Actualizar la pantalla
        controller?.update()

        // Actualizar los actores del escenario
        stage.act()

        // Limpiar la pantalla
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // Dibujar los actores del escenario
        stage.draw()
    }

    override fun hide() {
        Gdx.input.inputProcessor = null
    }

    override fun dispose() {
        Gdx.input.inputProcessor = null
    }
}
