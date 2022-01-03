package com.autosell.bean;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterBean {
	private TextField tfName;
	private TextField tfSurname;
	private TextField tfEmail;
	private PasswordField pfPassword;
	private PasswordField pfConfirmPassword;
	private Boolean sellerType;
	private TextField tfAddress;
	private Label labelPwdStrength;

	public RegisterBean() {
		super();
	}

	public RegisterBean(TextField tfName, TextField tfSurnameOrAddress, TextField tfEmail, PasswordField pfPassword,
			PasswordField pfConfirmPassword, Boolean sellerType, Label labelPwdStrength) {
		if (sellerType) {
			this.tfAddress = tfSurnameOrAddress;
		} else {
			this.tfSurname = tfSurnameOrAddress;
		}
		this.tfName = tfName;
		this.tfEmail = tfEmail;
		this.pfPassword = pfPassword;
		this.pfConfirmPassword = pfConfirmPassword;
		this.sellerType = sellerType;
		this.labelPwdStrength = labelPwdStrength;
	}

	public TextField getTfName() {
		return tfName;
	}

	public void setTfName(TextField tfName) {
		this.tfName = tfName;
	}

	public TextField getTfSurname() {
		return tfSurname;
	}

	public void setTfSurname(TextField tfSurname) {
		this.tfSurname = tfSurname;
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

	public PasswordField getPfConfirmPassword() {
		return pfConfirmPassword;
	}

	public void setPfConfirmPassword(PasswordField pfConfirmPassword) {
		this.pfConfirmPassword = pfConfirmPassword;
	}

	public Boolean getSellerType() {
		return sellerType;
	}

	public void setSellerType(Boolean sellerType) {
		this.sellerType = sellerType;
	}

	public TextField getTfAddress() {
		return tfAddress;
	}

	public void setTfAddress(TextField tfAddress) {
		this.tfAddress = tfAddress;
	}

	public Label getLabelPwdStrength() {
		return labelPwdStrength;
	}

	public void setLabelPwdStrength(Label labelPwdStrength) {
		this.labelPwdStrength = labelPwdStrength;
	}

	@Override
	public String toString() {
		if (null == sellerType) {
			return "sellerType is null. Can't print bean";
		}
		if (sellerType) {
			return "RegisterPrivatoBean = [" + tfName.getText() + ", " + tfSurname.getText() + ", " + tfEmail.getText()
					+ ", " + pfPassword.getText() + ", " + pfConfirmPassword.getText() + "]";
		} else {
			return "RegisterConcessionariaBean = [" + tfName.getText() + ", " + tfEmail.getText() + ", "
					+ pfPassword.getText() + ", " + pfConfirmPassword.getText() + ", " + tfAddress.getText() + "]";
		}
	}

}
