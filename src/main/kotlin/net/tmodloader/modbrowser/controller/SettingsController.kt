package net.tmodloader.modbrowser.controller

import net.tmodloader.modbrowser.ext.Spring
import net.tmodloader.modbrowser.model.setting.AppSetting
import net.tmodloader.modbrowser.service.resolver.ClassResolver
import net.tmodloader.modbrowser.view.SettingsView
import tornadofx.Controller

class SettingsController : Controller() {

	private val view : SettingsView by inject()
	private val classResolver : ClassResolver by di()

	fun loadSettingComponents() {
		runAsync {
			classResolver.getClasses("net.tmodloader.modbrowser.model.setting")
					.filter { it.superclass == AppSetting::class.java }
					.map { it.cast(Spring.getBean(it.kotlin)) as AppSetting<*> }
		} ui {
			it.forEach { appSetting -> view.addSettingComponent(appSetting) }
		}
	}
}