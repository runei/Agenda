/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import agenda.Funcoes;
import dao.CompromissoDao;
import dao.UsuarioDao;
import exception.AgendaException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Date;
import model.Compromisso;
import model.Usuario;

/**
 *
 * @author UCS
 */
public class ControllerCompromisso {

    public void cadastrar(Long id, String descricao, Date dataFim, Date dataInicio, int importancia) throws SQLException, AgendaException, NoSuchAlgorithmException {
        Compromisso c = new Compromisso();
        //c.setAutor(usuario);
        c.setDataFim(dataFim);
        c.setDataInicio(dataInicio);
        c.setImportancia(importancia);
        c.setParticipantes(null);
        c.setTipo(null);
        c.setDescricao(descricao);
        c.setId(id);
        new CompromissoDao().inserir(c);
    }

}
