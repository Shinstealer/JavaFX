package shinstealer.address.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import shinstealer.address.MainApp;

public class RootLayoutController {

	private MainApp main;


	public void setMain(MainApp main) {
		this.main = main;
	}

	@FXML
	public void handleNew() {
		main.getPersonData().clear();
		main.setPersonFilePath(null);
	}

	@FXML
	public void handleOpen() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFileter = new FileChooser.ExtensionFilter("xml files (*.xml)", "*.xml");

		fileChooser.getExtensionFilters().add(extFileter);

		File file = fileChooser.showOpenDialog(main.getPrimaryStage());

		if (file != null) {
			main.loadPersonDataFromFile(file);
		}

	}

	@FXML
	public void handleSave() {
		File personFile = main.getPersonFilePath();
		if (personFile != null) {
			main.savePersonDataToFile(personFile);
		} else {
			handleSaveAs();
		}
	}

	@FXML
	public void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("xml files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		File file = fileChooser.showSaveDialog(main.getPrimaryStage());

		if(file != null) {
			if(file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}

			main.savePersonDataToFile(file);
		}
	}

	@FXML
	public void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Address App");
		alert.setHeaderText("About");
        alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");

        alert.showAndWait();
	}
	@FXML
	public void handleExit() {
		System.exit(0);
	}

}
