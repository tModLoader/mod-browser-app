package net.tmodloader.modbrowser.ext

import tornadofx.FX
import kotlin.reflect.KClass

class Spring {
	companion object {
		fun <T : Any> getBean(type : KClass<T>) : T = FX.applicationContext().getBean(type.java)
		fun <T : Any> getBean(type : KClass<T>, name : String) : T = FX.applicationContext().getBean(type.java, name)
	}
}