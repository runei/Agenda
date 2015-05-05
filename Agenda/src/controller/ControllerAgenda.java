/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompromissoDao;
import java.util.ArrayList;
import java.util.Date;
import model.Compromisso;
import model.Usuario;

/**
 *
 * @author UCS
 */
public class ControllerAgenda {
    
    public ArrayList<Compromisso> obterCompromissosDia(Usuario u, Date dia) {
        CompromissoDao cdao = new CompromissoDao();
        ArrayList<Compromisso> aCompromissos = new ArrayList<>();
        try {
            aCompromissos = cdao.obterCompromissosDia(u, dia);
        } catch (Exception e) {

        }
        return aCompromissos;
    }

	public void excluirCompromisso(Compromisso c) {
		CompromissoDao cdao = new CompromissoDao();
		try {
			cdao.excluirCompromisso(c);
		} catch (Exception e) {
			
		}
	}
	
}
