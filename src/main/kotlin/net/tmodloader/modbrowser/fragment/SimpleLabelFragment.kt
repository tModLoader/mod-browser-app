package net.tmodloader.modbrowser.fragment

import tornadofx.Fragment
import tornadofx.label

class SimpleLabelFragment : Fragment() {

	val text: String by param()

	override val root = label(text)
}