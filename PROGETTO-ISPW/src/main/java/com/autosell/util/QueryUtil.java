package com.autosell.util;

import com.autosell.model.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryUtil {

    private static QueryUtil INSTANCE = null;

    public static QueryUtil getInstance() {
        if (null==INSTANCE) {
            INSTANCE = new QueryUtil();
        }
        return INSTANCE;
    }

    public String TABLE_AD = " annuncio";
    public String TABLE_SELLER = " venditore";
    public String TABLE_FAVORITE = " preferiti";
    public String TABLE_CAR = " automobile";
    public String SELECT_ALL = "SELECT * FROM ";
    public String SELECT = "SELECT ";
    public String UPDATE = "UPDATE ";
    public String INSERT = "INSERT INTO ";
    public String FROM = " FROM ";
    public String WHERE = " WHERE ";
    public String AND = " AND ";
    public String SET = " SET ";
    public String SELLER_VALUES =  " (nome, cognome, email, password, tipo_venditore, indirizzo) ";
    public String VALUES = " VALUES ";
    public String PARAM = " ? ";
    public String PARAM_COMMA = PARAM + " , ";
    public String EQ = " = ";
    public String EQ_PARAM = EQ + PARAM;
    public String EQ_PARAMS_COMMA = EQ + PARAM_COMMA;
    public String COUNT = " COUNT(*) ";
    public String ID = ".id ";
    public String SELLER_ID = ".id_venditore ";
    public String EMAIL = ".email";
    public String STAR = ".*";

    public String SELECT_ALL_ADS = SELECT + TABLE_AD + STAR + FROM + TABLE_AD;
    public String SELECT_ALL_SELLERS = SELECT + TABLE_SELLER + STAR + FROM + TABLE_SELLER;
    public String SELECT_ALL_FAVORITES = SELECT + TABLE_FAVORITE + STAR + FROM + TABLE_FAVORITE;
    public String SELECT_ALL_CARS = SELECT + TABLE_CAR + STAR + FROM + TABLE_CAR;
    public String LOGIN_USER = SELECT_ALL_SELLERS + WHERE + TABLE_SELLER + EMAIL + EQ_PARAM;
    public String REGISTER_USER = INSERT + TABLE_SELLER + SELLER_VALUES + VALUES + "(" + PARAM_COMMA + PARAM_COMMA + PARAM_COMMA + PARAM_COMMA + PARAM_COMMA + PARAM + ")";
    public String EDIT_USER = UPDATE + TABLE_SELLER + SET + "nome" + EQ_PARAMS_COMMA + "cognome" + EQ_PARAMS_COMMA + "email" + EQ_PARAMS_COMMA + "password" + EQ_PARAMS_COMMA + "tipo_venditore" + EQ_PARAMS_COMMA + "indirizzo" + EQ_PARAM +
            WHERE + TABLE_SELLER + ID + EQ_PARAM;
    public String GET_ADS_BY_ID = SELECT + TABLE_AD + STAR + FROM + TABLE_AD + WHERE + TABLE_AD + SELLER_ID + EQ_PARAM;

}
