package net.tmodloader.modbrowser

import net.tmodloader.modbrowser.view.RootView
import org.springframework.boot.SpringApplication
import org.springframework.boot.WebApplicationType
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
		var applicationContext : ApplicationContext by singleAssign()
	}

	override fun init() {
		super.init()

		val spring = SpringApplication(ModBrowserApplication::class.java)
		spring.webApplicationType = WebApplicationType.NONE
		applicationContext = spring.run()

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


