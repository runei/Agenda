/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usu_Compromisso;

/**
 *
 * @author W7
 */
public class Usu_CompromissoDao extends GenericDao {
    
    public void inserir(Usu_Compromisso uc) throws SQLException {
        String insert = "INSERT INTO usu_compromissos(idUsuario, idCompromisso) VALUES(?,?)";
        save(insert, uc.getIdUsuario(), uc.getIdCompromisso());
    }
     
    public boolean usuarioEmCompromisso(Usu_Compromisso uc) throws SQLException {
        String select = "SELECT count(*) c FROM usu_compromissos "
                + "where idUsuario = ? and "
                + "idCompromisso = ?";
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setLong(1, uc.getIdUsuario());
        stmt.setLong(2, uc.getIdCompromisso());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("c") > 0;
        }
        return false;
    }
    
    public void deletar(Usu_Compromisso uc) throws SQLException {
        String del = "delete from usu_compromissos where idcompromisso = ?";
        delete(del, uc.getIdCompromisso());
    }
    
}
