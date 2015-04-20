/*
 * Decompiled with CFR 0_100.
 */
package controller;

import agenda.Funcoes;
import dao.UsuarioDao;
import exception.AgendaException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import model.Usuario;

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
