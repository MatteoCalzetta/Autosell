package com.autosell.service;

import com.autosell.Main;
import com.autosell.bean.*;
import com.autosell.dao.InformationDAO;
import com.autosell.dao.LoginDAO;
import com.autosell.dao.impl.InformationDAOImpl;
import com.autosell.dao.impl.LoginDAOImpl;
import com.autosell.model.Seller;
import com.autosell.util.MessageUtil;
import com.autosell.util.StringUtil;

import java.sql.SQLException;

public class InformationService {

    Main main = Main.getInstance();
    static StringUtil stringUtil = StringUtil.getInstance();
    static InformationDAO informationDAO = InformationDAOImpl.getInstance();
    static LoginDAO loginDao = LoginDAOImpl.getInstance();
    static MessageUtil messageUtil = MessageUtil.getInstance();

    public static InformationService INSTANCE;

    public static InformationService getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new InformationService();
        }
        return INSTANCE;
    }

    public boolean hasChanges(InformationBean iBean) {
        Seller loggedUser = main.getLoggedUser();
        if (iBean.getSellerType()) {
            return !(iBean.getTfName().getText().trim().equals(loggedUser.getName())
                    && iBean.getTfAddress().getText().trim().equals(loggedUser.getAddress())
                    && iBean.getPfPassword().getText().trim().equals("")
                    && iBean.getPfNewPassword().getText().trim().equals("")
                    && iBean.getPfConfirmNewPassword().getText().trim().equals("")
                    && iBean.getTfEmail().getText().trim().equals(loggedUser.getEmail()));
        }
        return !(iBean.getTfName().getText().trim().equals(loggedUser.getName())
                && iBean.getTfSurname().getText().trim().equals(loggedUser.getSurname())
                && iBean.getPfPassword().getText().trim().equals("")
                && iBean.getPfNewPassword().getText().trim().equals("")
                && iBean.getPfConfirmNewPassword().getText().trim().equals("")
                && iBean.getTfEmail().getText().trim().equals(loggedUser.getEmail()));
    }

    public boolean checkFieldsPrivato(InformationBean pBean, InformationErrorBean pErrorBean) throws SQLException {
        return areCommonCheckPassed(pBean, pErrorBean);
    }

    public boolean checkFieldsConcessionaria(InformationBean cBean, InformationErrorBean cErrorBean) throws SQLException {
        Boolean checkPassed = areCommonCheckPassed(cBean, cErrorBean);
        if (!(stringUtil.containsIgnoreCase(cBean.getTfAddress().getText(), "Via")
                || stringUtil.containsIgnoreCase(cBean.getTfAddress().getText(), "Largo")
                || stringUtil.containsIgnoreCase(cBean.getTfAddress().getText(), "Piazza"))) {
            cErrorBean.getErrorAddress().setVisible(true);
            checkPassed = false;
        }
        return checkPassed;
    }

    private boolean areCommonCheckPassed(InformationBean bean, InformationErrorBean errorBean) throws SQLException {
        // inizia con carattere, contiene chiocciola e . e finisce con carattere
        boolean checkPassed = true;
        errorBean.getErrorEmail().setVisible(false);
        errorBean.getErrorPassword().setVisible(false);
        errorBean.getErrorNewPassword().setVisible(false);
        errorBean.getErrorConfirmNewPassword().setVisible(false);

        if (!(bean.getTfEmail().getText().contains("@") && bean.getTfEmail().getText().contains("."))) {
            errorBean.getErrorEmail().setText(messageUtil.EMAIL_NOT_VALID);
            errorBean.getErrorEmail().setVisible(true);
            checkPassed = false;
        } else {
            //Chiamata al servizio di Login per verificare che l'email non sia già registrata
            Seller seller = loginDao.loginUser(bean.getTfEmail().getText());
            if (null != seller && !seller.getEmail().equals(main.getLoggedUser().getEmail())) {
                errorBean.getErrorEmail().setText(messageUtil.EMAIL_ALREADY_REGISTERED);
                errorBean.getErrorEmail().setVisible(true);
                checkPassed = false;
            }
        }

        if (!bean.getPfNewPassword().getText().equals("") && bean.getPfNewPassword().getText().length() < 6) {
            errorBean.getErrorNewPassword().setVisible(true);
            checkPassed = false;
        }

        if (!bean.getPfNewPassword().getText().equals(bean.getPfConfirmNewPassword().getText())) {
            errorBean.getErrorConfirmNewPassword().setVisible(true);
            checkPassed = false;
        }

        if (!bean.getPfPassword().getText().equals(main.getLoggedUser().getPassword())) {
            errorBean.getErrorPassword().setVisible(true);
            checkPassed = false;
        }
        return checkPassed;
    }

    public boolean enableDisableSavePrivato(InformationBean informationPrivatoBean) {
        checkPasswordStrength(informationPrivatoBean);
        if(informationPrivatoBean.getTfName().getText().trim().isEmpty()
                || informationPrivatoBean.getTfSurname().getText().trim().isEmpty()
                || informationPrivatoBean.getTfEmail().getText().trim().isEmpty()
                || informationPrivatoBean.getPfPassword().getText().trim().isEmpty()) {
            return true;
        }
        return isPasswordChanged(informationPrivatoBean);
    }

    private boolean isPasswordChanged(InformationBean informationPrivatoBean) {
        if (informationPrivatoBean.getPfNewPassword().getText().trim().isEmpty() && informationPrivatoBean.getPfConfirmNewPassword().getText().trim().isEmpty()) {
            return false;
        }
        if (!informationPrivatoBean.getPfNewPassword().getText().trim().isEmpty() && !informationPrivatoBean.getPfConfirmNewPassword().getText().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean enableDisableSaveConcessionaria(InformationBean informationConcessionariaBean) {
        checkPasswordStrength(informationConcessionariaBean);
        if(informationConcessionariaBean.getTfName().getText().trim().isEmpty()
                || informationConcessionariaBean.getTfEmail().getText().trim().isEmpty()
                || informationConcessionariaBean.getPfPassword().getText().trim().isEmpty()
                || informationConcessionariaBean.getTfAddress().getText().trim().isEmpty()) {
            return true;
        }
        return isPasswordChanged(informationConcessionariaBean);
    }

    private void checkPasswordStrength(InformationBean bean) {
        int passwordStrength = stringUtil.calculatePasswordStrength(bean.getPfNewPassword().getText());
        if (passwordStrength < 3) {
            bean.getPfNewPassword().setStyle("-fx-background-color: white; -fx-border-color: black");
            bean.getLabelPwdStrength().setStyle("-fx-text-fill: black");
            bean.getLabelPwdStrength().setText("Too weak");
        } else if (passwordStrength >= 3 && passwordStrength <= 4) {
            bean.getPfNewPassword().setStyle("-fx-background-color: #ffebeb; -fx-border-color: red");
            bean.getLabelPwdStrength().setStyle("-fx-text-fill: red");
            bean.getLabelPwdStrength().setText("Weak");
        } else if (passwordStrength >= 5 && passwordStrength <= 6) {
            bean.getPfNewPassword().setStyle("-fx-background-color: #faf0c3; -fx-border-color: #cfb33a;");
            bean.getLabelPwdStrength().setStyle("-fx-text-fill: #cfb33a;");
            bean.getLabelPwdStrength().setText("Medium");
        } else if (passwordStrength >= 7) {
            bean.getPfNewPassword().setStyle("-fx-background-color: #d6ffd7; -fx-border-color: green;");
            bean.getLabelPwdStrength().setStyle("-fx-text-fill: green;");
            bean.getLabelPwdStrength().setText("Strong");
        }
    }

    public void editUser(Seller loggedUser) throws SQLException {
        informationDAO.editUser(loggedUser);
    }

}
