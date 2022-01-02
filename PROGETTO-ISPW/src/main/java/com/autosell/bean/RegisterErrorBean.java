package com.autosell.bean;

import javafx.scene.control.Label;

public class RegisterErrorBean {

	private Label errorEmail;
	private Label errorPassword;
	private Label errorConfirmPassword;
	private Label errorAddress;

	public RegisterErrorBean() {
		super();
	}

	public RegisterErrorBean(Label errorEmail, Label errorPassword, Label errorConfirmPassword) {
		super();
		this.errorEmail = errorEmail;
		this.errorPassword = errorPassword;
		this.errorConfirmPassword = errorConfirmPassword;
	}

	public RegisterErrorBean(Label errorEmail, Label errorPassword, Label errorConfirmPassword,
							 Label errorAddress) {
		super();
		this.errorEmail = errorEmail;
		this.errorPassword = errorPassword;
		this.errorConfirmPassword = errorConfirmPassword;
		this.errorAddress = errorAddress;
	}

	public Label getErrorAddress() {
		return errorAddress;
	}

	public void setErrorAddress(Label errorAddress) {
		this.errorAddress = errorAddress;
	}

	public Label getErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(Label errorEmail) {
		this.errorEmail = errorEmail;
	}

	public Label getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(Label errorPassword) {
		this.errorPassword = errorPassword;
	}

	public Label getErrorConfirmPassword() {
		return errorConfirmPassword;
	}

	public void setErrorConfirmPassword(Label errorConfirmPassword) {
		this.errorConfirmPassword = errorConfirmPassword;
	}

	@Override
	public String toString() {
		return "RegisterErrorConcessionariaBean = [" + errorEmail.getText() + ", " + errorPassword.getText() + ", "
				+ errorConfirmPassword.getText() + ", " + errorAddress.getText() + "]";
	}

}
