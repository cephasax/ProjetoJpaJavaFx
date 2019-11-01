package br.ufrn.imd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.dao.CarroDao;
import br.ufrn.imd.model.Carro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainViewController {

	private MainApp mainApp;

	private ObservableList<Carro> observableList;
	private ArrayList<Carro> data;

	@FXML
	private Menu menuSistema;
	
	@FXML
    private MenuBar menuBar;
	
	@FXML
	private MenuItem menuListarCarros;

	@FXML
	private MenuItem menuCadastrarCarro;

	@FXML
	private Menu menuAjuda;

	@FXML
	private MenuItem menuSobre;

	@FXML
	private TableView<Carro> tabelaCarro;

	@FXML
	private TableColumn<Carro, String> colunaApelido;

	@FXML
	private TableColumn<Carro, String> colunaModelo;

	@FXML
	private TableColumn<Carro, Date> colunaDataFabricacao;

	@FXML
	private TableColumn<Carro, String> colunaPlaca;

	@FXML
	void MenuSobre(ActionEvent event) {

	}

	@FXML
	void cadastrarCarro(ActionEvent event) throws IOException {
		mainApp.cadastrarCarro();
	}

	@FXML
	void listarCarros(ActionEvent event) {
		tabelaCarro.setVisible(true);
		
		CarroDao carroDao = new CarroDao();
		this.data = new ArrayList<Carro>();
		data = carroDao.listar();
		
		System.out.println(data.toString());
		
		this.observableList = FXCollections.observableArrayList(data);
		populateTable();

	}

	@FXML
	void menuAjuda(ActionEvent event) {

		Alert dialog = new Alert(AlertType.INFORMATION);
		  dialog.setTitle("Ajuda");
		  dialog.setHeaderText(null);
		  dialog.setContentText("Sistema para exemplificar uso de JafaFX e banco de dados Postgres utilizando Hibernate JPA e Maven");
		  dialog.show();
	}

	private void populateTable() {

		colunaApelido.setCellValueFactory(new PropertyValueFactory<Carro, String>("Apelido"));
		colunaModelo.setCellValueFactory(new PropertyValueFactory<Carro, String>("Modelo"));
		colunaDataFabricacao.setCellValueFactory(new PropertyValueFactory<Carro, Date>("dataFabricacao"));
		colunaPlaca.setCellValueFactory(new PropertyValueFactory<Carro, String>("Placa"));

		tabelaCarro.setItems(observableList);

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
