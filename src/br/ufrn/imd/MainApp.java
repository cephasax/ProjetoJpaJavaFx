package br.ufrn.imd;

import java.io.IOException;

import br.ufrn.imd.controller.CarroController;
import br.ufrn.imd.controller.MainViewController;
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

		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Sistema de Gerenciamento  de Carros");

			showMainView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showMainView() throws IOException {
		// Carrega a tela principal
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/MainView.fxml"));
		rootLayout = (BorderPane) loader.load();

		// Mostra a cena
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

		MainViewController mainViewController = loader.getController();
		mainViewController.setMainApp(this);

	}

	public void cadastrarCarro() throws IOException {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainApp.class.getResource("view/CarroView.fxml"));
		
		AnchorPane newScreen = (AnchorPane) loader.load();

		rootLayout.setCenter(newScreen);
		
		CarroController controller = loader.getController();
		controller.setMainApp(this);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
