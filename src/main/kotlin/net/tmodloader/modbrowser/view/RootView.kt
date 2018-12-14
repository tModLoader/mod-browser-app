package net.tmodloader.modbrowser.view

import net.tmodloader.modbrowser.controller.RootController
import net.tmodloader.modbrowser.fragment.MenuFragment
import net.tmodloader.modbrowser.fragment.StatusFragment
import net.tmodloader.modbrowser.service.FragmentService
import tornadofx.View
import tornadofx.borderpane

class RootView : View() {

	private val controller : RootController by inject()

	private val fragmentService : FragmentService by di()

	override val root = borderpane {

		prefWidth = 750.0
		prefHeight = 600.0

		top<MenuFragment>()
		bottom<StatusFragment>()
	}
}

