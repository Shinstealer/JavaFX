package shinstealer.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shinstealer.address.model.Person;
import shinstealer.address.utils.DateUtil;

public class PersonEditDialogController {

	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField streetField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField postalCodeField;
	@FXML
	private TextField birthdayField;

	private Stage dialogStage;
	private Person person;
	private Boolean okClicked = false;

	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;

	}

	public void setPerson(Person person) {
		this.person = person;

		firstNameField.setText(person.getFirstName());
		lastNameField.setText(person.getLastName());
		streetField.setText(person.getStreet());
		postalCodeField.setText(Integer.toString(person.getPostalCode()));
		cityField.setText(person.getCity());
		birthdayField.setText(DateUtil.format(person.getBirthday()));

	}

	public Boolean isOkClicked() {
		return okClicked;

	}

	@FXML
	public void handleOk() {
		if (isOkClicked()) {
			person.setFirstName(firstNameField.getText());
			person.setLastName(lastNameField.getText());
			person.setStreet(streetField.getText());
			person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
			person.setCity(cityField.getText());
			person.setBirthday(DateUtil.parse(birthdayField.getText()));

			okClicked = true;
			dialogStage.close();

		}
	}

	@FXML
	public void handleCancel() {
		dialogStage.close();
	}

	private Boolean inputValid() {
		String errMSG = "";
		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errMSG += "No valid first name! \n ";
		}
		if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
			errMSG += "No valid last name!\n";
		}
		if (streetField.getText() == null || streetField.getText().length() == 0) {
			errMSG += "No valid street!\n";
		}
		if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
			errMSG += "No valid postal code!\n";
		} else {
			try {
				Integer.parseInt(postalCodeField.getText());
			} catch (NumberFormatException e) {
				errMSG += "No valid postal code (must be number)\n";
			}
		}

		if (cityField.getText() == null || cityField.getText().length() == 0) {
			errMSG += "No valid city!\n";
		}

		if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
			errMSG += "No valid birthday!\n";
		} else {
			if (!DateUtil.validDate(birthdayField.getText())) {
				errMSG += "No valid birthday. Use the format dd-mm-yyyy!\n";
			}
		}

		if (errMSG.length() == 0) {
			return true;
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Field");
			alert.setHeaderText("Please collect invalid field");
			alert.setContentText(errMSG);

			alert.showAndWait();
		}
		return false;
	}

}
