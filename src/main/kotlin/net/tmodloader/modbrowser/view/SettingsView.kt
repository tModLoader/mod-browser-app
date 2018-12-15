package net.tmodloader.modbrowser.view

import net.tmodloader.modbrowser.controller.SettingsController
import net.tmodloader.modbrowser.model.setting.AppSetting
import net.tmodloader.modbrowser.view.ui.component.SettingUiComponent
import tornadofx.View
import tornadofx.plusAssign
import tornadofx.vbox

class SettingsView : View() {

	private val controller : SettingsController by inject()

	override val root = vbox()

	override fun onBeforeShow() {
		super.onBeforeShow()

		if (root.children.count() <= 0) {
			controller.loadSettingComponents()
		}
	}

	fun addSettingComponent(appSetting : AppSetting<*>) {
		root += createSettingComponent(appSetting)
	}

	private fun createSettingComponent(appSetting : AppSetting<*>) : SettingUiComponent {
		return SettingUiComponent().apply {
			titleLabel.text = appSetting.title
			this += appSetting.createGfxComponent()
		}
	}
}