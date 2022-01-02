package com.autosell.dao.impl;

import com.autosell.dao.InformationDAO;
import com.autosell.model.DataSource;
import com.autosell.model.Seller;
import com.autosell.util.QueryUtil;

import java.sql.*;

public class InformationDAOImpl implements InformationDAO {

    static DataSource ds = DataSource.getInstance();
    static QueryUtil queryUtil = QueryUtil.getInstance();

    public static InformationDAOImpl INSTANCE;

    public static InformationDAOImpl getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new InformationDAOImpl();
        }
        return INSTANCE;
    }

    @Override
    public void editUser(Seller loggedUser) throws SQLException {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(queryUtil.EDIT_USER);) {
            if (loggedUser.getSellerType()) {
                ps.setString(2, null);
                ps.setString(6, loggedUser.getAddress().trim());
            } else {
                ps.setString(2, loggedUser.getSurname().trim());
                ps.setString(6, null);
            }
            ps.setString(1, loggedUser.getName().trim());
            ps.setString(3, loggedUser.getEmail().trim());
            ps.setString(4, loggedUser.getPassword());
            ps.setBoolean(5, loggedUser.getSellerType());
            ps.setLong(7, loggedUser.getId());
            ps.executeUpdate();
        }
    }
}
