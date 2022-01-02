package com.autosell.dao;

import java.sql.SQLException;

public interface MyAdsDAO {

    int getAdNumber(Long sellerId) throws SQLException;

}
