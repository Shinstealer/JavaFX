package shinstealer.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import shinstealer.address.MainApp;
import shinstealer.address.model.Person;

public class PersonOverViewController {

	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	private MainApp mainApp;




	/**
	 * 생성자.
	 * initialize() 메서드 이전에 호출된다.
	 */
	public PersonOverViewController() {
    }

	/**
	 * 컨트롤러 클래스를 초기화한다.
	 * fxml 파일이 로드되고 나서 자동으로 호출된다.
	 */

	@FXML
	private void initialize() {
		// 연락처 테이블의 두 열을 초기화한다.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// 테이블에 observable 리스트 데이터를 추가한다.
        personTable.setItems(mainApp.getPersonData());
	}

}
