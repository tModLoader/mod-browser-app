package net.tmodloader.modbrowser.fragment

import javafx.scene.Parent
import tornadofx.Fragment
import tornadofx.pane
import tornadofx.useMaxHeight
import tornadofx.useMaxWidth

class BrowserFragment : Fragment() {
	override val root : Parent = pane {
		useMaxWidth = true
		useMaxHeight = true
	}
}