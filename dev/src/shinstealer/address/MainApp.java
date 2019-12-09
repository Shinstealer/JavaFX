package shinstealer.address;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
		} catch (Exception e) {
			e.printStackTrace();
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
}
