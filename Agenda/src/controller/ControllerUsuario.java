/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import agenda.Funcoes;
import model.Usuario;
import dao.UsuarioDao;
import exception.AgendaException;

/**
 *
 * @author UCS
 */
public class ControllerUsuario {

	private Usuario usuarioLogado;

	public void logar(String login, char[] senha) throws SQLException, AgendaException, NoSuchAlgorithmException {
            Usuario usuario = new Usuario();
            usuario.setLogin(login);
            usuario.setSenha(Funcoes.Criptar(new String(senha)));
            usuarioLogado = new UsuarioDao().logar(usuario);
            if (usuarioLogado == null) {
                throw new AgendaException("O usuário não está cadastrado!");
            }
	}
	
	public void cadastrar(String nome, String login, char[] senha) throws SQLException, AgendaException, NoSuchAlgorithmException {
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setSenha(Funcoes.Criptar(new String(senha)));
            new UsuarioDao().inserir(usuario);
	}

}
