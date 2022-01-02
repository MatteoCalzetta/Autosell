package com.autosell.service;

import java.io.IOException;
import java.sql.SQLException;

import com.autosell.Main;
import com.autosell.bean.LoginBean;
import com.autosell.dao.LoginDAO;
import com.autosell.dao.impl.LoginDAOImpl;
import com.autosell.model.Seller;

public class LoginService {

	Main main = Main.getInstance();
	static LoginDAO loginDao = LoginDAOImpl.getInstance();

	public static LoginService INSTANCE;

	public static LoginService getInstance() {
		if (null == INSTANCE) {
			INSTANCE = new LoginService();
		}
		return INSTANCE;
	}

	public Seller loginUser(LoginBean loginBean) throws IOException, SQLException {
		loginBean.getTfEmail().setText("luigi.talamo31@gmail.com");
		loginBean.getPfPassword().setText("luigii");
		if (loginBean.getTfEmail().getText().trim().isEmpty()) {
			throw new SQLException("Il campo email è vuoto!");
		}
		Seller seller = loginDao.loginUser(loginBean.getTfEmail().getText());
		if (null == seller) {
			throw new SQLException("Utente non presente! Login non avvenuto");
		}
		if (!seller.getPassword().equals(loginBean.getPfPassword().getText())) {
			throw new SQLException("Le password è errata! Login non avvenuto");
		}
		return seller;
	}

}
