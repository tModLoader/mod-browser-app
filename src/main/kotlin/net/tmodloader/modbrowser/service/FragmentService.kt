package net.tmodloader.modbrowser.service

import javafx.stage.StageStyle
import org.springframework.stereotype.Service
import tornadofx.Fragment
import tornadofx.find
import tornadofx.label


@Service
class FragmentService {

    fun openSimpleFragment(text: String) {
        find<SimpleFragment>(params = mapOf(SimpleFragment::text to text))
                .openWindow(StageStyle.UTILITY)
    }
}

class SimpleFragment : Fragment() {

    val text: String by param()

    override val root = label(text)
}