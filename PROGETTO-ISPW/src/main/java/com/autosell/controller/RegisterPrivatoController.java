package com.autosell.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.autosell.Main;
import com.autosell.bean.RegisterBean;
import com.autosell.bean.RegisterErrorBean;
import com.autosell.model.Seller;
import com.autosell.service.RegisterService;

import com.autosell.util.MessageUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class RegisterPrivatoController {

    @FXML
    private Rectangle background;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonRegister;

    @FXML
    private Label errorConfirmPassword;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorPassword;

    @FXML
    private Label labelAccountData;

    @FXML
    private Label labelConfirmPassword;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelMandatoryFields;

    @FXML
    private Label labelName;

    @FXML
    private Label labelPassword;

    @FXML
    private Label labelPersonalData;

    @FXML
    private Label labelRegister;

    @FXML
    private Label labelSurname;

    @FXML
    private PasswordField pfConfirmPassword;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfSurname;

    private static RegisterPrivatoController INSTANCE;

    public static RegisterPrivatoController getInstance() {
        if (null==INSTANCE) {
            INSTANCE = new RegisterPrivatoController();
        }
        return INSTANCE;
    }

    static Main main = Main.getInstance();
    static RegisterService registerService = RegisterService.getInstance();
    static MessageUtil messageUtil = MessageUtil.getInstance();

    public RegisterBean buildRegisterBean(){
        return new RegisterBean(tfName, tfSurname, tfEmail, pfPassword, pfConfirmPassword, false);
    }

    public RegisterErrorBean buildRegisterErrorBean(){
        return new RegisterErrorBean(errorEmail, errorPassword, errorConfirmPassword);
    }

    public boolean checkFieldsPrivato() throws SQLException {
        return registerService.checkFieldsPrivato(buildRegisterBean(), buildRegisterErrorBean());
    }

    @FXML
    void userRegister(ActionEvent event) {
        try {
            if(checkFieldsPrivato()) {
                Seller user = new Seller(tfName.getText().trim(), tfSurname.getText().trim(), tfEmail.getText().trim(), pfPassword.getText(), false);
                user = registerService.registerUser(user);
                user.setLogged(true);
                main.setLoggedUser(user);
                main.changeScene("Homepage.fxml");
            }
        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void enableDisableRegister(KeyEvent event) {
        buttonRegister.setDisable(registerService.enableDisableRegisterPrivato(buildRegisterBean()));
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        main.changeScene("LoginPage.fxml");
    }


}