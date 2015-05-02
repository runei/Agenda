/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompromissoDao;
import java.sql.SQLException;
import java.util.Calendar;
import model.Compromisso;

/**
 *
 * @author UCS
 */
public class ControllerCompromisso {

    public void cadastrar(Long id, String titulo, String descricao, int importancia, Calendar dataInicio, Calendar dataFim) 
            throws SQLException {
        Compromisso c = new Compromisso();
        //c.setAutor(usuario);
        c.setDataFim(dataFim);
        c.setDataInicio(dataInicio);
        c.setImportancia(importancia);
        c.setParticipantes(null);
        c.setTipo(null);
        c.setDescricao(descricao);
        c.setTitulo(titulo);
        c.setId(id);
        new CompromissoDao().inserir(c);
    }

}
