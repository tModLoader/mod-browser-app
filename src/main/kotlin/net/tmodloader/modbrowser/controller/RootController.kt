package net.tmodloader.modbrowser.controller

import javafx.application.Platform
import net.tmodloader.modbrowser.view.SettingsView
import tornadofx.Controller

class RootController : Controller() {

	fun openSettings() {
		find(SettingsView::class.java).openWindow()
	}

	fun quitApp() {
		Platform.exit()
		System.exit(0)
	}

}