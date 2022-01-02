package com.autosell.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class MessageUtil {

    private static MessageUtil INSTANCE = null;

    public static MessageUtil getInstance() {
        if (null==INSTANCE) {
            INSTANCE = new MessageUtil();
        }
        return INSTANCE;
    }

    public static final String EMAIL_ALREADY_REGISTERED = "Email address already registered!";
    public static final String EMAIL_NOT_VALID = "Email address is not valid!";
    public static final String NOT_LOGGED = "You must log in first!";
    public static final String CONFIRM_GO_BACK = "Are you sure you want to discard changes and go back?";

    public void printAlertOk(String alertString) {
        Alert alert = new Alert(Alert.AlertType.NONE, alertString, ButtonType.OK);
        alert.showAndWait();
    }

    public boolean printAlertYesOrNo(String stringAlert) {
        Alert alert = new Alert(Alert.AlertType.NONE, stringAlert, ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
