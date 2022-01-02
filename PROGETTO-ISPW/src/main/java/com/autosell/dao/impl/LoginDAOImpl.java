package com.autosell.dao.impl;

import com.autosell.dao.LoginDAO;
import com.autosell.model.DataSource;
import com.autosell.model.Seller;
import com.autosell.util.QueryUtil;
import com.autosell.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOImpl implements LoginDAO {

    static DataSource ds = DataSource.getInstance();
    static QueryUtil queryUtil = QueryUtil.getInstance();
    static StringUtil stringUtil = StringUtil.getInstance();

    public static LoginDAOImpl INSTANCE;

    public static LoginDAOImpl getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new LoginDAOImpl();
        }
        return INSTANCE;
    }

    @Override
    public Seller loginUser(String email) throws SQLException {
            Seller seller = null;
            try (Connection connection = ds.getConnection(); PreparedStatement ps = connection.prepareStatement(queryUtil.LOGIN_USER);) {
                ps.setString(1, email.trim());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    seller = mapVenditore(rs);
                }
                rs.close();
            }
            return seller;

    }

    private Seller mapVenditore(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String nome = rs.getString(2);
        String cognome = rs.getString(3);
        String email = rs.getString(4);
        String password = rs.getString(5);
        Boolean tipoVenditore = rs.getBoolean(6);
        String indirizzo = rs.getString(7);
        if (tipoVenditore) {
            return new Seller(id, nome, indirizzo, email, password, true);
        }
        return new Seller(id, nome, cognome, email, password, false);
    }
}
