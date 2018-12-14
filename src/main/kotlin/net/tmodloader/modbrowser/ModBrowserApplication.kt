package net.tmodloader.modbrowser

import net.tmodloader.modbrowser.view.MyView
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import tornadofx.App
import tornadofx.DIContainer
import tornadofx.FX
import kotlin.reflect.KClass

@SpringBootApplication
class ModBrowserApplication : App(MyView::class) {
    override fun init() {
        super.init()

        /*
            The following is needed (overriding the di() option)
            to use spring's getBean functionality to inject beans by
            autowiring
         */
        val applicationContext = SpringApplication.run(ModBrowserApplication::class.java)
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = applicationContext.getBean(type.java)
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = applicationContext.getBean(type.java, name)
        }
    }
}


