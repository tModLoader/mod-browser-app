package net.tmodloader.modbrowser.fragment

import io.reactivex.schedulers.Schedulers
import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Label
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
import tornadofx.singleAssign
import tornadofx.toolbar

class StatusFragment : Fragment() {

	private var statusText : Label by singleAssign()
	private val statusProperty = SimpleStringProperty("Status")

	var status : String
		get() = statusProperty.get()
		set(value) = statusProperty.set(value)

	override val root = toolbar {
		statusText = label {
			textAlignment = TextAlignment.CENTER
			textProperty().bindBidirectional(statusProperty)
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

	init {
		with(find(LoadingFragment::class.java)) {
			this.getProgressSubject()
					.subscribeOn(Schedulers.single())
					.doOnNext {
						status = "Loading: ${it.toDouble() * 100.0}%"
					}
					.doOnComplete {
						status = "Finished loading mods"
					}
					.subscribe()
		}
	}

	private fun openSettings() {
		find(SettingsView::class.java).openWindow()
	}
}