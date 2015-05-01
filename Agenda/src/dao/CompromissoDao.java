/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import model.Compromisso;

/**
 *
 * @author UCS
 */
public class CompromissoDao extends GenericDao {
    
    public void inserir(Compromisso c) throws SQLException {
        String insert = "INSERT INTO compromisso(descricao, importancia, dataInicio, dataFim) VALUES(?,?,?,?)";
        save(insert, c.getDescricao(), c.getImportancia(), c.getDataInicio(), c.getDataFim());
    }
    
    public void alterar(Compromisso c) throws SQLException {
        String update = "UPDATE compromisso " +
                        "SET descricao = ?, importancia = ?, dataInicio = ?, dataFim = ?  " +
                        "WHERE id = ?";
        update(update, c.getId(), c.getDescricao(), c.getImportancia(), c.getDataInicio(), c.getDataFim());
    }
    
}
