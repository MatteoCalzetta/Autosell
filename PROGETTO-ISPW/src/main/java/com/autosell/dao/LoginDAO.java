package com.autosell.dao;

import com.autosell.model.Seller;

import java.sql.SQLException;

public interface LoginDAO {

    Seller loginUser(String email) throws SQLException;

}
