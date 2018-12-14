package net.tmodloader.modbrowser

import net.tmodloader.modbrowser.view.RootView
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import tornadofx.singleAssign
import kotlin.reflect.KClass

@SpringBootApplication
class ModBrowserApplication : App(RootView::class) {

	companion object {
		// TODO can make val?
		var applicationContext : ApplicationContext by singleAssign()
	}

	override fun init() {
		super.init()

		applicationContext = SpringApplication.run(ModBrowserApplication::class.java)

		/*
			The following is needed (overriding the di() option)
			to use spring's getBean functionality to inject beans by
			autowiring
		 */
		FX.dicontainer = object : DIContainer {
			override fun <T : Any> getInstance(type : KClass<T>) : T = applicationContext.getBean(type.java)
			override fun <T : Any> getInstance(type : KClass<T>, name : String) : T = applicationContext.getBean(type.java, name)
		}
	}
}


