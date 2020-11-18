package com.carracing.sdk.dao;

import com.carracing.sdk.exception.DataAccessException;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public abstract class JdbcWrapper {

    private Connection getConnection() throws Exception {
        Properties prop = new Properties();
        InputStream input = null;

        input = new FileInputStream("database.properties");

        // load a properties file
        prop.load(input);

        return DriverManager.getConnection(
                prop.getProperty("db.url"),
                prop.getProperty("db.user"),
                prop.getProperty("db.password"));
    }

    protected <T extends Entity> List<T> executeQuery(String sql, JdbcResultMapper<T> mapper){
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            return mapper.mapResult(resultSet);

        } catch (Exception e) {
            throw new DataAccessException("Could not execute query", e);
        }
    }
}
