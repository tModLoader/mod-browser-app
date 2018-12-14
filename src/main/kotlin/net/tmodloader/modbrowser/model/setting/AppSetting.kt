package net.tmodloader.modbrowser.model.setting

import javafx.scene.Node

/**
 * Defines a setting for the application
 */
abstract class AppSetting<T : Any> {

	abstract val title : String

	abstract var setting : T

	abstract fun createGfxComponent() : Node
}