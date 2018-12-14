package net.tmodloader.modbrowser.fragment

import net.tmodloader.modbrowser.controller.RootController
import tornadofx.Fragment
import tornadofx.action
import tornadofx.item
import tornadofx.menu
import tornadofx.menubar
import tornadofx.useMaxWidth

class MenuFragment : Fragment() {

	private val controller : RootController by inject()

	override val root = menubar {
		useMaxWidth = true

		menu("Options") {
			menu("Application") {
				item("Settings") {
					// TODO can we bind this automatically?
					action {
						controller.openSettings()
					}
				}
				item("Quit") {
					action {
						controller.quitApp()
					}
				}
			}
		}
	}
}