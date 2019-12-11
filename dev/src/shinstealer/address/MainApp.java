package shinstealer.address;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import shinstealer.address.model.Person;
import shinstealer.address.view.PersonEditDialogController;
import shinstealer.address.view.PersonOverViewController;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		initRootLayout();

		showPersonOverView();

	}

	/**
	 * 연락처에 대한 observable 리스트
	 */
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	/**
	 * 생성자
	 */
	public MainApp() {
		personData.add(new Person("kim", "sungmin"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}

	/**
	* 상위 레이아웃을 초기화한다.
	*/
	public void initRootLayout() {
		try {
			// fxml 파일에서 상위 레이아웃을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			// 상위 레이아웃을 포함하는 scene을 보여준다.

			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* 상위 레이아웃 안에 연락처 요약(person overview)을 보여준다.
	*/
	public void showPersonOverView() {
		try {
			// 연락처 요약을 가져온다.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverView = (AnchorPane) loader.load();

			// 연락처 요약을 상위 레이아웃 가운데로 설정한다.
			rootLayout.setCenter(personOverView);

			PersonOverViewController controller = loader.getController();
			controller.setMainApp(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean showPersonEditDialog(Person person) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// make new stage
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			PersonEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	* 메인 스테이지를 반환한다.
	* @return
	*/
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 연락처에 대한 observable 리스트를 반환한다.
	 * @return
	 */
	public ObservableList<Person> getPersonData() {
		return personData;
	}

}
