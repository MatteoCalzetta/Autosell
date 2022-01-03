package com.autosell.service;

import java.sql.SQLException;

import com.autosell.bean.RegisterBean;
import com.autosell.bean.RegisterErrorBean;
import com.autosell.dao.LoginDAO;
import com.autosell.dao.RegisterDAO;
import com.autosell.dao.impl.LoginDAOImpl;
import com.autosell.dao.impl.RegisterDAOImpl;
import com.autosell.model.Seller;
import com.autosell.util.MessageUtil;
import com.autosell.util.StringUtil;

public class RegisterService {

	static StringUtil stringUtil = StringUtil.getInstance();
	static RegisterDAO registerDAO = RegisterDAOImpl.getInstance();
	static LoginDAO loginDao = LoginDAOImpl.getInstance();
	static MessageUtil messageUtil = MessageUtil.getInstance();

	private static RegisterService INSTANCE;

	public static RegisterService getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new RegisterService();
		}
		return INSTANCE;
	}

	public boolean checkFieldsPrivato(RegisterBean pBean, RegisterErrorBean pErrorBean) throws SQLException {
		return areCommonCheckPassed(pBean, pErrorBean);
	}

	public boolean checkFieldsConcessionaria(RegisterBean cBean, RegisterErrorBean cErrorBean) throws SQLException {
		cErrorBean.getErrorAddress().setVisible(false);
		boolean checkPassed = areCommonCheckPassed(cBean, cErrorBean);
		if (!(stringUtil.containsIgnoreCase(cBean.getTfAddress().getText(), "Via")
				|| stringUtil.containsIgnoreCase(cBean.getTfAddress().getText(), "Largo")
				|| stringUtil.containsIgnoreCase(cBean.getTfAddress().getText(), "Piazza"))) {
			cErrorBean.getErrorAddress().setVisible(true);
			checkPassed = false;
		}
		return checkPassed;
	}

	private boolean areCommonCheckPassed(RegisterBean bean, RegisterErrorBean errorBean) throws SQLException {
		// inizia con carattere, contiene chiocciola e . e finisce con carattere
		boolean checkPassed = true;
		errorBean.getErrorEmail().setVisible(false);
		errorBean.getErrorPassword().setVisible(false);
		errorBean.getErrorConfirmPassword().setVisible(false);

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

		if (bean.getPfPassword().getText().length() < 6) {
			errorBean.getErrorPassword().setVisible(true);
			checkPassed = false;
		}

		if (!bean.getPfPassword().getText().equals(bean.getPfConfirmPassword().getText())) {
			errorBean.getErrorConfirmPassword().setVisible(true);
			checkPassed = false;
		}
		return checkPassed;
	}

	public boolean enableDisableRegisterPrivato(RegisterBean registerPrivatoBean) {
		checkPasswordStrength(registerPrivatoBean);
		return registerPrivatoBean.getTfName().getText().trim().isEmpty()
				|| registerPrivatoBean.getTfSurname().getText().trim().isEmpty()
				|| registerPrivatoBean.getTfEmail().getText().trim().isEmpty()
				|| registerPrivatoBean.getPfPassword().getText().trim().isEmpty()
				|| registerPrivatoBean.getPfConfirmPassword().getText().trim().isEmpty();
				
	}

	public boolean enableDisableRegisterConcessionaria(RegisterBean registerConcessionariaBean) {
		checkPasswordStrength(registerConcessionariaBean);
		return registerConcessionariaBean.getTfEmail().getText().trim().isEmpty()
				|| registerConcessionariaBean.getTfName().getText().trim().isEmpty()
				|| registerConcessionariaBean.getPfPassword().getText().trim().isEmpty()
				|| registerConcessionariaBean.getPfConfirmPassword().getText().trim().isEmpty()
				|| registerConcessionariaBean.getTfAddress().getText().trim().isEmpty();
	}

	private void checkPasswordStrength(RegisterBean bean) {
		int passwordStrength = stringUtil.calculatePasswordStrength(bean.getPfPassword().getText());
		if (passwordStrength < 3) {
			bean.getPfPassword().setStyle("-fx-background-color: white; -fx-border-color: black");
			bean.getLabelPwdStrength().setStyle("-fx-text-fill: black");
			bean.getLabelPwdStrength().setText("Too weak");
		} else if (passwordStrength >= 3 && passwordStrength <= 4) {
			bean.getPfPassword().setStyle("-fx-background-color: #ffebeb; -fx-border-color: red");
			bean.getLabelPwdStrength().setStyle("-fx-text-fill: red");
			bean.getLabelPwdStrength().setText("Weak");
		} else if (passwordStrength >= 5 && passwordStrength <= 6) {
			bean.getPfPassword().setStyle("-fx-background-color: #faf0c3; -fx-border-color: #cfb33a;");
			bean.getLabelPwdStrength().setStyle("-fx-text-fill: #cfb33a;");
			bean.getLabelPwdStrength().setText("Medium");
		} else if (passwordStrength >= 7) {
			bean.getPfPassword().setStyle("-fx-background-color: #d6ffd7; -fx-border-color: green;");
			bean.getLabelPwdStrength().setStyle("-fx-text-fill: green;");
			bean.getLabelPwdStrength().setText("Strong");
		}
	}

	public Seller registerUser(Seller user) throws SQLException {
		return registerDAO.registerUser(user);
	}
}
