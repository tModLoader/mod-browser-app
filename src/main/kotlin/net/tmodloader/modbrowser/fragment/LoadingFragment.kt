package net.tmodloader.modbrowser.fragment

import io.reactivex.subjects.BehaviorSubject
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.control.Label
import javafx.scene.control.ProgressIndicator
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import tornadofx.Fragment
import tornadofx.label
import tornadofx.progressindicator
import tornadofx.singleAssign
import tornadofx.style
import tornadofx.useMaxHeight
import tornadofx.useMaxWidth
import tornadofx.vbox

class LoadingFragment : Fragment() {

	private var progressIndicator : ProgressIndicator by singleAssign()
	private var infoLabel : Label by singleAssign()
	private var progressLabel : Label by singleAssign()

	private val progressSubject = BehaviorSubject.create<Double>()

	private var info : String = "Loading mods..."
		set(value) {
			infoLabel.text = value
		}

	private var progress : Double = 0.0
		set(value) {
			field = value
			progressLabel.text = "${value * 100}%"
			progressSubject.onNext(value)
			when (value) {
				1.0 -> progressSubject.onComplete()
			}
		}

	override val root : Parent = vbox {
		useMaxWidth = true
		useMaxHeight = true
		maxWidth = Double.NEGATIVE_INFINITY
		maxHeight = Double.NEGATIVE_INFINITY
		minWidth = Double.NEGATIVE_INFINITY
		minHeight = Double.NEGATIVE_INFINITY
		padding = Insets(16.0, 16.0, 16.0, 16.0)
		alignment = Pos.CENTER

		infoLabel = label()

		progressIndicator = progressindicator {
			style {
				progressColor = Paint.valueOf(Color.GREEN.toString())
			}
		}

		progressLabel = label()

		progressSubject.test().assertEmpty()
	}

	init {
		info = "Loading mods..."
		progress = 0.0
	}

	fun getProgressSubject() = progressSubject.hide()!!
}