package net.tmodloader.modbrowser.view.ui.component

import javafx.scene.control.Label
import tornadofx.UIComponent
import tornadofx.label
import tornadofx.plusAssign
import tornadofx.singleAssign
import tornadofx.vbox

class SettingUiComponent : UIComponent() {

	var titleLabel : Label by singleAssign()

	override val root = vbox()

	init {
		with(root) {
			titleLabel = label("Title")
			this += titleLabel
		}
	}
}