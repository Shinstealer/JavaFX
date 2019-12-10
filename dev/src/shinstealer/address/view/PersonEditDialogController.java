package shinstealer.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shinstealer.address.model.Person;

public class PersonEditDialogController {

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField LastNameField;
	@FXML
	private TextField StreetField;
	@FXML
	private TextField CityField;
	@FXML
	private TextField PostalCodeField;
	@FXML
	private TextField BirthdayField;

	public PersonEditDialogController() {

	}

	public void setDialogStage(Stage dialogStage) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setPerson(Person person) {
		// TODO
	}

}
