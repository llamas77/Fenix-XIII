package ar.com.fenixxiii.game.general

import com.badlogic.gdx.utils.I18NBundle
import ktx.i18n.BundleLine

/**
 * Clase de soporte de idioma nativo (Native Language Support)
 *
 * Sirve para obtener un texto en el idioma correspondiente.
 *
 * El bundle es un objeto que permite obtener un textos en el idioma correspondiente. Estos textos se guardan en
 * archivos 'locale-?.properties'
 * Cada elemento del enum debe coincidir con los 'key', en los archivos 'locale-?.properties'.
 */
enum class Nls : BundleLine {
    volver;

    // Redefine la forma de obtener el bundle
    override val bundle: I18NBundle
        get() = i18nBundle

    // Bundle general para todos los valores del enum.
    companion object {
        lateinit var i18nBundle: I18NBundle
    }
}