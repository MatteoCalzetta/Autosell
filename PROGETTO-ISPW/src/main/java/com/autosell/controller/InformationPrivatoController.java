package com.autosell.controller;

import com.autosell.Main;
import com.autosell.bean.InformationBean;
import com.autosell.bean.InformationErrorBean;
import com.autosell.model.Seller;
import com.autosell.service.InformationService;
import com.autosell.util.MessageUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class InformationPrivatoController implements Initializable {

    private static InformationPrivatoController INSTANCE;

    public static InformationPrivatoController getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new InformationPrivatoController();
        }
        return INSTANCE;
    }

    static Main main = Main.getInstance();
    static InformationService informationService = InformationService.getInstance();
    static MessageUtil messageUtil = MessageUtil.getInstance();

    private InformationBean buildInformationBean() {
        return new InformationBean(tfName, tfSurname, tfEmail,pfPassword, pfNewPassword, pfConfirmNewPassword, false);
    }

    public InformationErrorBean buildInformationErrorBean(){
        return new InformationErrorBean(errorEmail, errorOldPassword, errorPassword, errorConfirmPassword);
    }

    @FXML
    private Button buttonBack;

    @FXML
    private Rectangle background;

    @FXML
    private Button buttonEdit;

    @FXML
    private Label errorConfirmPassword;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorPassword;

    @FXML
    private Label errorOldPassword;

    @FXML
    private Label labelAccountData;

    @FXML
    private Label labelAdNumber;

    @FXML
    private Label labelConfirmNewPassword;

    @FXML
    private Label labelEmail;

    @FXML
    private Label labelName;

    @FXML
    private Label labelNewPassword;

    @FXML
    private Label labelPassword;

    @FXML
    private Label labelPersonalData;

    @FXML
    private Label labelProfile;

    @FXML
    private Label labelSurname;

    @FXML
    private Button buttonSave;

    @FXML
    private TextField tfAdNumber;

    @FXML
    private PasswordField pfConfirmNewPassword;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private PasswordField pfNewPassword;

    @FXML
    private TextField tfSurname;

    @FXML
    void goBack(ActionEvent event) throws IOException {
        if (buttonEdit.isVisible()) {
            main.changeScene("UserPage.fxml");
        } else {
            if (hasChanges()) {
                boolean result = messageUtil.printAlertYesOrNo(messageUtil.CONFIRM_GO_BACK);
                if (!result) {
                    main.changeScene("UserPage.fxml");
                }
            }
            pfConfirmNewPassword.setText("");
            setTextFieldsEditable(false);
            setTfAndLabelsVisible(false);
            resetData();
        }
    }

    private void setTextFieldsEditable(boolean editable) {
        tfName.setEditable(editable);
        tfSurname.setEditable(editable);
        tfEmail.setEditable(editable);
        pfNewPassword.setEditable(editable);
    }

    private void setTfAndLabelsVisible(boolean visible) {
        buttonSave.setVisible(visible);
        buttonEdit.setVisible(!visible);
        pfConfirmNewPassword.setVisible(visible);
        labelConfirmNewPassword.setVisible(visible);
        pfPassword.setVisible(visible);
        labelPassword.setVisible(visible);
    }

    @FXML
    void setEditable(ActionEvent event) {
        setTextFieldsEditable(true);
        setTfAndLabelsVisible(true);
    }

    @FXML
    void save(ActionEvent event) {
        try {
            if(hasChanges() && checkFieldsPrivato()) {
                String password = pfNewPassword.getText().isEmpty() ? pfPassword.getText() : pfNewPassword.getText();
                Seller loggedUser = new Seller(main.getLoggedUser().getId(), tfName.getText().trim(), tfSurname.getText().trim(), tfEmail.getText().trim(), password, false);
                informationService.editUser(loggedUser);
                loggedUser.setLogged(true);
                main.setLoggedUser(loggedUser);
                resetData();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean checkFieldsPrivato() throws SQLException {
        return informationService.checkFieldsPrivato(buildInformationBean(), buildInformationErrorBean());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetData();
    }


    private void resetData() {
        Seller loggedUser = main.getLoggedUser();
        tfName.setText(loggedUser.getName());
        tfSurname.setText(loggedUser.getSurname());
        tfEmail.setText(loggedUser.getEmail());
        pfNewPassword.setText("");
        pfConfirmNewPassword.setText("");
        pfPassword.setText("");
        setTfAndLabelsVisible(false);
        setTextFieldsEditable(false);
    }

    private boolean hasChanges() {
        InformationBean iBean = buildInformationBean();
        return informationService.hasChanges(iBean);
    }

    @FXML
    void enableDisableSave(KeyEvent event) {
        buttonSave.setDisable(informationService.enableDisableSavePrivato(buildInformationBean()));
    }
}
