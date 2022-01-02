package com.autosell.bean;

import javafx.scene.control.Label;

public class InformationErrorBean {

    private Label errorEmail;
    private Label errorPassword;
    private Label errorNewPassword;
    private Label errorConfirmNewPassword;
    private Label errorAddress;

    public InformationErrorBean() {
    }

    public InformationErrorBean(Label errorEmail, Label errorPassword, Label errorNewPassword, Label errorConfirmNewPassword) {
        this.errorEmail = errorEmail;
        this.errorPassword = errorPassword;
        this.errorNewPassword = errorNewPassword;
        this.errorConfirmNewPassword = errorConfirmNewPassword;
    }

    public InformationErrorBean(Label errorEmail, Label errorPassword, Label errorNewPassword, Label errorConfirmNewPassword, Label errorAddress) {
        this.errorEmail = errorEmail;
        this.errorPassword = errorPassword;
        this.errorNewPassword = errorNewPassword;
        this.errorConfirmNewPassword = errorConfirmNewPassword;
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

    public Label getErrorNewPassword() {
        return errorNewPassword;
    }

    public void setErrorNewPassword(Label errorNewPassword) {
        this.errorNewPassword = errorNewPassword;
    }

    public Label getErrorConfirmNewPassword() {
        return errorConfirmNewPassword;
    }

    public void setErrorConfirmNewPassword(Label errorConfirmNewPassword) {
        this.errorConfirmNewPassword = errorConfirmNewPassword;
    }

    public Label getErrorAddress() {
        return errorAddress;
    }

    public void setErrorAddress(Label errorAddress) {
        this.errorAddress = errorAddress;
    }
}
