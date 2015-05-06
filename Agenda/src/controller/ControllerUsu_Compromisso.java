/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Usu_CompromissoDao;
import java.sql.SQLException;
import model.Usu_Compromisso;

/**
 *
 * @author W7
 */
public class ControllerUsu_Compromisso {
    
    public void cadastrar(Long idUsuario, Long idCompromisso) throws SQLException {
        Usu_Compromisso uc = new Usu_Compromisso();
        uc.setIdCompromisso(idCompromisso);
        uc.setIdUsuario(idUsuario);
        Usu_CompromissoDao compromissoDao = new Usu_CompromissoDao();
        compromissoDao.inserir(uc);
    }
    
    public boolean usuarioEmCompromisso(Long idUsuario, Long idCompromisso) throws SQLException {
        Usu_Compromisso uc = new Usu_Compromisso();
        uc.setIdCompromisso(idCompromisso);
        uc.setIdUsuario(idUsuario);
        Usu_CompromissoDao compromissoDao = new Usu_CompromissoDao();
        return compromissoDao.usuarioEmCompromisso(uc);
    }
    
    public void deletar(Long idCompromisso) throws SQLException {
        Usu_Compromisso uc = new Usu_Compromisso();
        uc.setIdCompromisso(idCompromisso);
        Usu_CompromissoDao compromissoDao = new Usu_CompromissoDao();
        compromissoDao.deletar(uc);
    }
    
}
