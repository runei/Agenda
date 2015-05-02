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
        String insert = "INSERT INTO compromissos "
                + "(titulo, descricao, importancia, dataInicio, dataFim) "
                + "VALUES(?, ?, ?, ?, ?)";
        save(insert, c.getTitulo(), c.getDescricao(), c.getImportancia(), c.getDataInicio().getTime(), c.getDataFim().getTime());
    }
    
    public void alterar(Compromisso c) throws SQLException {
        String update = "UPDATE compromissos " +
                        "SET titulo = ?, descricao = ?, importancia = ?, dataInicio = ?, dataFim = ?, " +
                        "WHERE id = ?";
        update(update, c.getTitulo(), c.getDescricao(), c.getImportancia(), c.getDataInicio(), c.getDataFim(), c.getId());
    }
    
}
