package net.tmodloader.modbrowser.view

import javafx.collections.FXCollections
import net.tmodloader.modbrowser.service.FragmentService
import tornadofx.*

class MyView : View() {

    private val controller: MyController by inject()

    private val fragmentService: FragmentService by di()

    override val root = vbox {
        label("My items")
        listview(controller.values)
        button("Click me") {
            action {
                fragmentService.openSimpleFragment("test modal")
            }
        }
    }


}

class MyController : Controller() {
    val values = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")
}