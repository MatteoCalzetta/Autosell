package com.autosell.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.autosell.Main;
import com.autosell.bean.LoginBean;
import com.autosell.model.Seller;
import com.autosell.service.LoginService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

public class LoginController {

	@FXML
	private Button autosell;

	@FXML
	private ImageView buttonFacebook;

	@FXML
	private ImageView buttonGoogle;

	@FXML
	private Button buttonLogin;

	@FXML
	private Button buttonRegisterPrivato;

	@FXML
	private Button buttonRegisterConcessionaria;

	@FXML
	private ImageView logoAutosell;

	@FXML
	private TextField tfEmail;

	@FXML
	private PasswordField pfPassword;

	static LoginService loginService = new LoginService();
	static Main main = Main.getInstance();

	@FXML
	void setHomepage(ActionEvent event) throws IOException {
		main.changeScene("Homepage.fxml");
	}

	@FXML
	void setRegisterPrivato(ActionEvent event) throws IOException {
		main.changeScene("RegisterPrivatoPage.fxml");
	}

	@FXML
	void setRegisterConcessionaria(ActionEvent event) throws IOException {
		main.changeScene("RegisterConcessionariaPage.fxml");
	}

	@FXML
	void login() {
		Seller seller = null;
		try {
			LoginBean loginBean = buildLoginBean();
			seller = loginService.loginUser(loginBean);
			seller.setLogged(true);
			main.setLoggedUser(seller);
			main.changeScene("Homepage.fxml");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			Alert alert = new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK);
			alert.showAndWait();
		}
	}

	private LoginBean buildLoginBean() {
		return new LoginBean(tfEmail, pfPassword);
	}

}