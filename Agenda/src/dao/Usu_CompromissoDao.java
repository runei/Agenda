/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
    
}
