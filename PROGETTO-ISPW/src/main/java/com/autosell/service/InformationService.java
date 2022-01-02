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
            if (null != loginDao.loginUser(bean.getTfEmail().getText())) {
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
        if(informationConcessionariaBean.getTfName().getText().trim().isEmpty()
                || informationConcessionariaBean.getTfEmail().getText().trim().isEmpty()
                || informationConcessionariaBean.getPfPassword().getText().trim().isEmpty()
                || informationConcessionariaBean.getTfAddress().getText().trim().isEmpty()) {
            return true;
        }
        return isPasswordChanged(informationConcessionariaBean);
    }

    public void editUser(Seller loggedUser) throws SQLException {
        informationDAO.editUser(loggedUser);
    }

}
