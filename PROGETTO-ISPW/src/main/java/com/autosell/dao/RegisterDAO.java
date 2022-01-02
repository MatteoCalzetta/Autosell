package com.autosell.dao;

import com.autosell.model.Seller;

import java.sql.SQLException;

public interface RegisterDAO {

    Seller registerUser(Seller seller) throws SQLException;
}
