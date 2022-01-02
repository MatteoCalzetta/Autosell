package com.autosell.bean;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginBean {
	private TextField tfEmail;
	private PasswordField pfPassword;

	public LoginBean() {
		super();
	}

	public LoginBean(TextField tfEmail, PasswordField pfPassword) {
		this.tfEmail = tfEmail;
		this.pfPassword = pfPassword;
	}

	public TextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(TextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public PasswordField getPfPassword() {
		return pfPassword;
	}

	public void setPfPassword(PasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}

	@Override
	public String toString() {
		return "LoginBean = [" + tfEmail.getText() + ", " + pfPassword.getText() + "]";
	}

}
