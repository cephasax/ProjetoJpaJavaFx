package br.ufrn.imd.controller;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;

import br.ufrn.imd.MainApp;
import br.ufrn.imd.dao.Banco;
import br.ufrn.imd.model.Carro;
import br.ufrn.imd.model.Motor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CarroController {

	private MainApp mainApp;

	@FXML
	private TextField txtApelido;

	@FXML
	private TextField txtModelo;

	@FXML
	private TextField txtPlaca;
	
	@FXML
	private Button btnSalvar;

	@FXML
	private Button btnCancelar;

	@FXML
	private DatePicker dateDataFabricacao;

	@FXML
	private TextField txtNumSerie;

	@FXML
	private TextField txtPotencia;

	@FXML
	private TextField txtQtdCilindros;

	@FXML
	void cancelar(ActionEvent event) throws IOException {
		mainApp.showMainView();
	}

	@FXML
	void salvar(ActionEvent event) throws IOException {

		Carro carro = new Carro();
		
		carro.setApelido(txtApelido.getText());
		
		carro.setDataFabricacao(Date.from(dateDataFabricacao.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		carro.setPlaca(txtPlaca.getText());
		carro.setModelo(txtModelo.getText());
		
		Motor motor = new Motor();
		motor.setNumeroSerie(txtNumSerie.getText());
		motor.setPotenciaCavalos(Integer.valueOf(txtPotencia.getText()));
		motor.setQtdCilindros(Integer.valueOf(txtQtdCilindros.getText()));
		motor.setCarro(carro);
		
		Banco banco = Banco.getInstance();
		try{
			banco.getEntityManager().getTransaction().begin();
			banco.getEntityManager().persist(carro);
			banco.getEntityManager().persist(motor);
			banco.getEntityManager().getTransaction().commit();
			
			showCarroSalvarOk();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		mainApp.showMainView();
		
	}

	public void showCarroSalvarOk() {
		Alert dialog = new Alert(AlertType.CONFIRMATION);
		  dialog.setTitle("Status da operação no banco");
		  dialog.setHeaderText(null);
		  dialog.setContentText("Carro inserido no banco com sucesso");
		  dialog.show();
	}
	
	public MainApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
