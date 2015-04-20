/*
 * Decompiled with CFR 0_100.
 */
package view;

import controller.ControllerUsuario;
import exception.AgendaException;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import view.LoginView;

public class CadastrarUsuarioView
extends JFrame {
    private static final long serialVersionUID = 6323560354638458173L;
    private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField pwdConfirmeASenha;
    private JPasswordField pwdSenha;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    CadastrarUsuarioView frame = new CadastrarUsuarioView();
                    frame.setVisible(true);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CadastrarUsuarioView() {
        this.setType(Window.Type.UTILITY);
        this.setDefaultCloseOperation(3);
        this.setBounds(100, 100, 450, 247);
        this.getContentPane().setLayout(null);
        JLabel lblCadastrese = new JLabel("Cadastre-se");
        lblCadastrese.setBounds(0, 0, 434, 20);
        lblCadastrese.setHorizontalAlignment(0);
        lblCadastrese.setFont(new Font("Tahoma", 1, 16));
        this.getContentPane().add((Component)lblCadastrese, "North");
        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 57, 46, 14);
        this.getContentPane().add(lblNome);
        this.txtNome = new JTextField();
        this.txtNome.setBounds(105, 54, 319, 20);
        this.getContentPane().add(this.txtNome);
        this.txtNome.setColumns(10);
        JLabel lblLogin = new JLabel("Login");
        lblLogin.setBounds(10, 85, 46, 14);
        this.getContentPane().add(lblLogin);
        this.txtLogin = new JTextField();
        this.txtLogin.setColumns(10);
        this.txtLogin.setBounds(105, 82, 319, 20);
        this.getContentPane().add(this.txtLogin);
        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setBounds(10, 113, 46, 14);
        this.getContentPane().add(lblSenha);
        JLabel lblConfirmeASenha = new JLabel("Confirme a Senha");
        lblConfirmeASenha.setBounds(10, 141, 85, 14);
        this.getContentPane().add(lblConfirmeASenha);
        this.pwdConfirmeASenha = new JPasswordField();
        this.pwdConfirmeASenha.setBounds(105, 138, 319, 20);
        this.getContentPane().add(this.pwdConfirmeASenha);
        this.pwdSenha = new JPasswordField();
        this.pwdSenha.setBounds(105, 110, 319, 20);
        this.getContentPane().add(this.pwdSenha);
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent event) {
                CadastrarUsuarioView.this.onClickBtnCancelar();
            }
        });
        btnCancelar.setBounds(349, 175, 75, 23);
        this.getContentPane().add(btnCancelar);
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent event) {
                CadastrarUsuarioView.this.onClickBtnConfirmar();
            }
        });
        btnConfirmar.setBounds(254, 175, 85, 23);
        this.getContentPane().add(btnConfirmar);
        this.setVisible(true);
    }

    protected void ShowMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    protected void onClickBtnConfirmar() {
        if (this.txtNome.getText().equals("")) {
            this.ShowMessage("Falta digitar o campo Nome");
            this.txtNome.requestFocus();
        } else if (this.txtLogin.getText().equals("")) {
            this.ShowMessage("Falta digitar o campo Login");
            this.txtLogin.requestFocus();
        } else if (this.pwdSenha.getPassword().length <= 0) {
            this.ShowMessage("Falta digitar o campo Senha");
            this.pwdSenha.requestFocus();
        } else if (this.pwdConfirmeASenha.getPassword().length <= 0) {
            this.ShowMessage("Falta digitar o campo Confirmar Senha");
            this.pwdConfirmeASenha.requestFocus();
        } else if (this.pwdSenha.getPassword().equals(this.pwdConfirmeASenha.getPassword())) {
            this.ShowMessage("As senhas n\ufffdo conferem!");
            this.pwdConfirmeASenha.requestFocus();
        } else {
            ControllerUsuario controllerUsuario = new ControllerUsuario();
            try {
                controllerUsuario.cadastrar(this.txtNome.getText(), this.txtLogin.getText(), this.pwdSenha.getPassword());
            }
            catch (AgendaException | NoSuchAlgorithmException | SQLException e) {
                this.ShowMessage(e.getMessage());
            }
            this.onClickBtnCancelar();
        }
    }

    protected void onClickBtnCancelar() {
        this.dispose();
        new LoginView();
    }

}
