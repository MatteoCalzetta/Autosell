package com.autosell.bean;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class InformationBean {

    private TextField tfName;
    private TextField tfSurname;
    private TextField tfEmail;
    private PasswordField pfPassword;
    private PasswordField pfNewPassword;
    private PasswordField pfConfirmNewPassword;
    private Boolean sellerType;
    private TextField tfAddress;

    public InformationBean() {
    }

    public InformationBean(TextField tfName, TextField tfSurnameOrAddress, TextField tfEmail, PasswordField tfOldPassword, PasswordField tfPassword, PasswordField tfConfirmPassword, Boolean sellerType) {
        super();
        if (sellerType) {
            this.tfAddress = tfSurnameOrAddress;
        } else {
            this.tfSurname = tfSurnameOrAddress;
        }
        this.tfName = tfName;
        this.tfEmail = tfEmail;
        this.pfPassword = tfOldPassword;
        this.pfNewPassword = tfPassword;
        this.pfConfirmNewPassword = tfConfirmPassword;
        this.sellerType = sellerType;
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

    public PasswordField getPfNewPassword() {
        return pfNewPassword;
    }

    public void setPfNewPassword(PasswordField pfNewPassword) {
        this.pfNewPassword = pfNewPassword;
    }

    public PasswordField getPfConfirmNewPassword() {
        return pfConfirmNewPassword;
    }

    public void setPfConfirmNewPassword(PasswordField pfConfirmNewPassword) {
        this.pfConfirmNewPassword = pfConfirmNewPassword;
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

    @Override
    public String toString() {
        if (null == sellerType) {
            return "sellerType is null. Can't print bean";
        }
        if (sellerType) {
            return "InformationPrivatoBean = [" + tfName.getText() + ", " + tfSurname.getText() + ", " + tfEmail.getText() + ", " + pfPassword.getText() + ", "
                    + ", " + pfNewPassword.getText() + ", " + pfConfirmNewPassword.getText() + "]";
        } else {
            return "InformationConcessionariaBean = [" + tfName.getText() + ", " + tfEmail.getText() + ", " + pfPassword.getText() + ", "
                    + pfNewPassword.getText() + ", " + pfConfirmNewPassword.getText() + ", " + tfAddress.getText() + "]";
        }
    }
}
