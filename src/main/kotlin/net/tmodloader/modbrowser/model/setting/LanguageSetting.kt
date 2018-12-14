package net.tmodloader.modbrowser.model.setting

import javafx.collections.FXCollections
import javafx.scene.Node
import javafx.scene.control.ComboBox
import org.springframework.stereotype.Component
import java.util.prefs.Preferences
import kotlin.properties.Delegates

enum class AppLanguage {
	ENGLISH,
	TEMP_TEST;

	companion object {
		val DEFAULT = ENGLISH
	}
}

@Component
class LanguageSetting : AppSetting<AppLanguage>() {
	override val title : String = "Application language"

	// TODO observables
	override var setting : AppLanguage by Delegates.notNull()

	override fun createGfxComponent() : Node {
		return ComboBox<AppLanguage>().apply {
			items = FXCollections.observableArrayList(AppLanguage.values().toList())

			// TODO settings service
			val prefs = Preferences.userRoot().node(this::class.simpleName)

			this.setOnAction {
				setting = selectionModel.selectedItem
				prefs.put("Locale", selectionModel.selectedItem.name)
			}

			selectionModel.select(AppLanguage.valueOf(prefs.get("Locale", AppLanguage.DEFAULT.name)))
		}
	}
}