package ar.com.fenixxiii.game


import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.scenes.scene2d.Stage


class Main : Game {

    var stage: Stage? = null

    constructor(runnable: Runnable) {

    }

    override fun create() {
        Gdx.graphics.setTitle("Fénix XII")
    }


    fun salir() {
        Gdx.app.exit()
    }

}