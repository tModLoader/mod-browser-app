package net.tmodloader.modbrowser.service

import javafx.stage.StageStyle
import org.springframework.stereotype.Service
import tornadofx.Fragment
import tornadofx.find


@Service
class FragmentService {

	final inline fun <reified T : Fragment> openSimpleFragment(text : String,
	                                                          textParamName : String = "text",
	                                                          stageStyle : StageStyle = StageStyle.DECORATED) {
		find<T>(params = mapOf(textParamName to text))
				.openWindow(stageStyle)
	}
}

