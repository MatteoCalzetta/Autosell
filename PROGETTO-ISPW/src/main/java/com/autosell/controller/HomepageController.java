package com.autosell.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.autosell.Main;
import com.autosell.model.Seller;

import com.autosell.util.MessageUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class HomepageController implements Initializable {

    private static HomepageController INSTANCE;

    public static HomepageController getInstance() {
        if (null==INSTANCE) {
            INSTANCE = new HomepageController();
        }
        return INSTANCE;
    }

    static String UTENTE = "Utente: ";

    static Main main = Main.getInstance();
    static MessageUtil messageUtil = MessageUtil.getInstance();

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelLoggedUser;

    @FXML
    private Button buttonInsertButton;

    @FXML
    private MenuItem ricercaAvanzata;

    @FXML
    private MenuButton menuButtonProfile;

    @FXML
    private MenuItem menuItemLogout;

    @FXML
    private MenuItem menuItemProfile;

    public MenuItem getMenuItemProfile() { return menuItemProfile; }

    public void setMenuItemProfile(MenuItem menuItemProfile) { this.menuItemProfile = menuItemProfile; }

    public MenuItem getMenuItemLogout() { return menuItemLogout; }

    public void setMenuItemLogout(MenuItem menuItemLogout) { this.menuItemLogout = menuItemLogout; }

    public Button getButtonLogin() { return buttonLogin; }

    public void setButtonLogin(Button buttonLogin) { this.buttonLogin = buttonLogin; }

    public Label getLabelLoggedUser() { return labelLoggedUser; }

    public void setLabelLoggedUser(Label labelLoggedUser) { this.labelLoggedUser = labelLoggedUser; }

    public Button getButtonInsertButton() { return buttonInsertButton; }

    public void setButtonInsertButton(Button buttonInsertButton) { this.buttonInsertButton = buttonInsertButton; }

    public MenuButton getMenuButtonProfile() { return menuButtonProfile; }

    public void setMenuButtonProfile(MenuButton menuButtonProfile) { this.menuButtonProfile = menuButtonProfile; }

    @FXML
    private void userLogin(ActionEvent event) throws IOException {
        main.changeScene("LoginPage.fxml");
    }

    @FXML
    void setAdvancedResearch(ActionEvent event) throws IOException {
        main.changeScene("AdvancedResearch.fxml");
    }

    @FXML
    void setUserPage(ActionEvent event) throws IOException{
        main.changeScene("UserPage.fxml");
    }

    @FXML
    void insert(ActionEvent event) throws IOException {
        if (main.getLoggedUser().isLogged()) {
            main.changeScene("InsertPage.fxml");
        } else {
            messageUtil.printAlertOk(messageUtil.NOT_LOGGED);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Seller loggedUser = main.getLoggedUser();
        loginOrLogout(loggedUser);
    }

    private void loginOrLogout(Seller loggedUser) {
        buttonLogin.setVisible(!loggedUser.isLogged());
        labelLoggedUser.setText(UTENTE + loggedUser.getFullName());
        labelLoggedUser.setVisible(loggedUser.isLogged());
        menuButtonProfile.setVisible(loggedUser.isLogged());

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        loginOrLogout(new Seller());
    }

}
