package com.carracing.sdk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface JdbcResultMapper<T extends Entity> {
    List<T> mapResult(ResultSet rs) throws SQLException;
}
