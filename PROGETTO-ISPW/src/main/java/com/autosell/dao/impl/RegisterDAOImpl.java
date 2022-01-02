package com.autosell.dao.impl;

import com.autosell.dao.RegisterDAO;
import com.autosell.model.DataSource;
import com.autosell.model.Seller;
import com.autosell.util.QueryUtil;
import com.autosell.util.StringUtil;

import java.sql.*;

public class RegisterDAOImpl implements RegisterDAO {

    static DataSource ds = DataSource.getInstance();
    static QueryUtil queryUtil = QueryUtil.getInstance();
    static StringUtil stringUtil = StringUtil.getInstance();

    public static RegisterDAOImpl INSTANCE;

    public static RegisterDAOImpl getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new RegisterDAOImpl();
        }
        return INSTANCE;
    }

    @Override
    public Seller registerUser(Seller user) throws SQLException {
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(queryUtil.REGISTER_USER, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, user.getName().trim());
            ps.setString(2, user.getSurname().trim());
            ps.setString(3, user.getEmail().trim());
            ps.setString(4, user.getPassword());
            ps.setBoolean(5, user.getSellerType());
            ps.setString(6, user.getAddress());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getLong(1));
            }
            rs.close();
        }
        return user;
    }

}
