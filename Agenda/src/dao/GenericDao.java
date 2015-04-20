/*
 * Decompiled with CFR 0_100.
 */
package dao;

import dao.ConnectionDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class GenericDao {
    private Connection connection = ConnectionDataBase.getConnection();

    protected GenericDao() {
    }

    protected Connection getConnection() {
        return this.connection;
    }

    protected /* varargs */ void save(String insertSql, Object ... parametros) throws SQLException {
        PreparedStatement pstmt = this.getConnection().prepareStatement(insertSql);
        for (int i = 0; i < parametros.length; ++i) {
            pstmt.setObject(i + 1, parametros[i]);
        }
        pstmt.execute();
        pstmt.close();
    }

    protected /* varargs */ void update(String updateSql, Object id, Object ... parametros) throws SQLException {
        PreparedStatement pstmt = this.getConnection().prepareStatement(updateSql);
        for (int i = 0; i < parametros.length; ++i) {
            pstmt.setObject(i + 1, parametros[i]);
        }
        pstmt.setObject(parametros.length + 1, id);
        pstmt.execute();
        pstmt.close();
    }

    protected /* varargs */ void delete(String deleteSql, Object ... parametros) throws SQLException {
        PreparedStatement pstmt = this.getConnection().prepareStatement(deleteSql);
        for (int i = 0; i < parametros.length; ++i) {
            pstmt.setObject(i + 1, parametros[i]);
        }
        pstmt.execute();
        pstmt.close();
    }
}
