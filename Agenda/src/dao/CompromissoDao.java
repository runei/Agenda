/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Compromisso;
import model.Usuario;

/**
 *
 * @author UCS
 */
public class CompromissoDao extends GenericDao {
    
    public void inserir(Compromisso c) throws SQLException {
        String insert = "INSERT INTO compromissos " +
                        "(titulo, descricao, importancia, dataInicio, dataFim, idUsuario) " +
                        "VALUES(?, ?, ?, ?, ?, ?)";
        save(insert, c.getTitulo(), c.getDescricao(), c.getImportancia(), c.getDataInicio().getTime(), c.getDataFim().getTime(), c.getIdUsuario());
    }
    
    public void alterar(Compromisso c) throws SQLException {
        String update = "UPDATE compromissos " +
                        "SET titulo = ?, descricao = ?, importancia = ?, dataInicio = ?, dataFim = ?, " +
                        "WHERE id = ?";
        update(update, c.getTitulo(), c.getDescricao(), c.getImportancia(), c.getDataInicio(), c.getDataFim(), c.getId());
    }
    
    public ArrayList<Compromisso> obterCompromissosDia(Usuario u, Date dia) throws SQLException {
        String select = "SELECT * FROM compromissos WHERE idUsuario = ? AND date(dataInicio) = ?";
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setLong(1, u.getId());
        stmt.setDate(2, new java.sql.Date(dia.getTime()));
        ResultSet rs = stmt.executeQuery();
	ArrayList<Compromisso> aCompromissos = new ArrayList<>();
        while (rs.next()) {
            Compromisso c = new Compromisso();
            c.setId(rs.getLong("id"));
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(rs.getTimestamp("dataFim").getTime()));
            c.setDataFim(cal);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(new Date(rs.getTimestamp("dataInicio").getTime()));
            c.setDataInicio(cal2);
            c.setDescricao(rs.getString("descricao"));
            c.setTitulo(rs.getString("titulo"));
            aCompromissos.add(c);
        }
        rs.close();
        stmt.close();
        return aCompromissos;
    }    

	
}
