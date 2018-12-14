package net.tmodloader.modbrowser.fragment

import javafx.scene.layout.Priority
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import net.tmodloader.modbrowser.view.SettingsView
import tornadofx.Fragment
import tornadofx.action
import tornadofx.button
import tornadofx.hgrow
import tornadofx.label
import tornadofx.pane
import tornadofx.toolbar

class StatusFragment : Fragment() {

	override val root = toolbar {
		label("status") {
			textAlignment = TextAlignment.CENTER
		}

		// Fills remaining gap, makes settings float to right side
		pane {
			hgrow = Priority.ALWAYS
		}

		button("Settings") {
			textFill = Color.BLACK
			action {
				openSettings()
			}
		}
	}

	private fun openSettings() {
		find(SettingsView::class.java).openWindow()
	}
}