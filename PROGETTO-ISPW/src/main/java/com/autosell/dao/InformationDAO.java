package com.autosell.dao;

import com.autosell.model.Seller;

import java.sql.SQLException;

public interface InformationDAO {

    void editUser(Seller loggedUser) throws SQLException;

}
