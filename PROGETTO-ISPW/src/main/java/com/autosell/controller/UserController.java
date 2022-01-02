package com.autosell.controller;

import com.autosell.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class UserController {

    @FXML
    private Rectangle background;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonFavourites;

    @FXML
    private Button buttonInformation;

    @FXML
    private Button buttonModify;

    @FXML
    private Button buttonMyADS;

    @FXML
    private Label errorConfirmPassword;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorPassword;

    @FXML
    private Label labelRegister;

    public Button getButtonBack() { return buttonBack; }

    public void setButtonBack(Button buttonBack) { this.buttonBack = buttonBack; }

    public Button getButtonFavourites() { return buttonFavourites; }

    public void setButtonFavourites(Button buttonFavourites) { this.buttonFavourites = buttonFavourites; }

    public Button getButtonInformation() { return buttonInformation; }

    public void setButtonInformation(Button buttonInformation) { this.buttonInformation = buttonInformation; }

    public Button getButtonModify() { return buttonModify; }

    public void setButtonModify(Button buttonModify) { this.buttonModify = buttonModify; }

    public Button getButtonMyADS() { return buttonMyADS; }

    public void setButtonMyADS(Button buttonMyADS) { this.buttonMyADS = buttonMyADS; }

    public Label getErrorConfirmPassword() { return errorConfirmPassword; }

    public void setErrorConfirmPassword(Label errorConfirmPassword) { this.errorConfirmPassword = errorConfirmPassword; }

    public Label getErrorEmail() { return errorEmail; }

    public void setErrorEmail(Label errorEmail) { this.errorEmail = errorEmail; }

    public Label getErrorPassword() { return errorPassword; }

    public void setErrorPassword(Label errorPassword) { this.errorPassword = errorPassword; }

    public Label getLabelRegister() { return labelRegister; }

    public void setLabelRegister(Label labelRegister) { this.labelRegister = labelRegister; }

    Main main = Main.getInstance();

    @FXML
    public void setHomepage(ActionEvent event) throws IOException{
        main.changeScene("Homepage.fxml");
    }

    @FXML
    void setInformationPage(ActionEvent event) throws IOException {
        if (main.getLoggedUser().getSellerType()) {
            main.changeScene("InformationConcessionariaPage.fxml");
        } else {
            main.changeScene("InformationPrivatoPage.fxml");
        }
    }
}
