package com.autosell.dao.impl;

import com.autosell.dao.MyAdsDAO;
import com.autosell.model.DataSource;
import com.autosell.model.Seller;
import com.autosell.util.QueryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyAdsDAOImpl implements MyAdsDAO {

    static DataSource ds = DataSource.getInstance();
    static QueryUtil queryUtil = QueryUtil.getInstance();

    public static MyAdsDAOImpl INSTANCE;

    public static MyAdsDAOImpl getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new MyAdsDAOImpl();
        }
        return INSTANCE;
    }

    @Override
    public int getAdNumber(Long sellerId) throws SQLException {
        int count = 0;
        try (Connection connection = ds.getConnection();
             PreparedStatement ps = connection.prepareStatement(queryUtil.GET_AD_NUMBER);) {
            ps.setLong(1, sellerId);
            ResultSet rs = ps.executeQuery();
            count = rs.getInt(1);
            rs.close();
        }
        return count;
    }
}
