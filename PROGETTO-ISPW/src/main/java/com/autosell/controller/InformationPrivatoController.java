package com.autosell.controller;

import com.autosell.Main;
import com.autosell.bean.InformationBean;
import com.autosell.bean.InformationErrorBean;
import com.autosell.model.Seller;
import com.autosell.service.AdsService;
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
    static AdsService adsService = AdsService.getInstance();

    private InformationBean buildInformationBean() {
        return new InformationBean(tfName, tfSurname, tfEmail,pfPassword, pfNewPassword, pfConfirmNewPassword, false, labelPwdStrength);
    }

    public InformationErrorBean buildInformationErrorBean(){
        return new InformationErrorBean(errorEmail, errorPassword, errorNewPassword, errorConfirmNewPassword);
    }

    @FXML
    private Rectangle background;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonEdit;

    @FXML
    private Button buttonSave;

    @FXML
    private Label errorConfirmNewPassword;

    @FXML
    private Label errorEmail;

    @FXML
    private Label errorNewPassword;

    @FXML
    private Label errorPassword;

    @FXML
    private Label labelAccountData;

    @FXML
    private Label labelAdsNumber;

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
    private Label labelPwdStrength;

    @FXML
    private Label labelSurname;

    @FXML
    private PasswordField pfConfirmNewPassword;

    @FXML
    private PasswordField pfNewPassword;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private TextField tfAdsNumber;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSurname;

    @FXML
    void goBack(ActionEvent event) {
        try {
            if (buttonEdit.isVisible()) {
                main.changeScene("UserPage.fxml");
            } else {
                if (hasChanges()) {
                    boolean result = messageUtil.printAlertYesOrNo(messageUtil.CONFIRM_GO_BACK);
                    if (result) {
                        setTextFieldsEditable(false);
                        setTfAndLabelsVisible(false);
                        resetData();
                    }
                } else {
                    setTextFieldsEditable(false);
                    setTfAndLabelsVisible(false);
                    resetData();
                }
            }
        }  catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.NONE, messageUtil.GENERIC_ERROR, ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    void setEditable(ActionEvent event) {
        setTextFieldsEditable(true);
        setTfAndLabelsVisible(true);
        setButtonsDisable(true);
    }

    private void setButtonsDisable(boolean disabled) {
        buttonSave.setDisable(disabled);
    }

    @FXML
    void save(ActionEvent event) {
        try {
            if(hasChanges() && checkFieldsPrivato()) {
                String password = pfNewPassword.getText().isEmpty() ? pfPassword.getText() : pfNewPassword.getText();
                Seller loggedUser = new Seller(main.getLoggedUser().getId(), tfName.getText().trim(), tfSurname.getText().trim(),
                        tfEmail.getText().trim(), password, false);
                informationService.editUser(loggedUser);
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
        tfAdsNumber.setText(""+loggedUser.getAdsList().size());
        tfName.setText(loggedUser.getName());
        tfSurname.setText(loggedUser.getSurname());
        tfEmail.setText(loggedUser.getEmail());
        pfPassword.setText("");
        pfConfirmNewPassword.setText("");
        pfNewPassword.setText("");
        setTfAndLabelsVisible(false);
        setTextFieldsEditable(false);
    }

    private void setTextFieldsEditable(boolean editable) {
        tfName.setEditable(editable);
        tfSurname.setEditable(editable);
        tfEmail.setEditable(editable);
        pfPassword.setEditable(editable);
    }

    private void setTfAndLabelsVisible(boolean visible) {
        buttonSave.setVisible(visible);
        buttonEdit.setVisible(!visible);
        pfConfirmNewPassword.setVisible(visible);
        labelConfirmNewPassword.setVisible(visible);
        pfNewPassword.setVisible(visible);
        labelNewPassword.setVisible(visible);
        labelPwdStrength.setVisible(visible);
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
