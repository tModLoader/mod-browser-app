package net.tmodloader.modbrowser.view

import net.tmodloader.modbrowser.ModBrowserApplication
import net.tmodloader.modbrowser.model.setting.AppSetting
import net.tmodloader.modbrowser.service.resolver.ClassResolver
import net.tmodloader.modbrowser.view.ui.component.SettingUiComponent
import tornadofx.View
import tornadofx.plusAssign
import tornadofx.vbox

class SettingsView : View() {

	private val classResolver : ClassResolver by di()

	override val root = vbox()

	init {
		classResolver.getClasses("net.tmodloader.modbrowser.model.setting")
				.filter { it.superclass == AppSetting::class.java }
				.map { it.cast(ModBrowserApplication.applicationContext.getBean(it)) as AppSetting<*> }
				.forEach {
					with(root) {
						this += SettingUiComponent().apply {
							titleLabel.text = it.title
							this += it.createGfxComponent()
						}
					}
				}
	}
}