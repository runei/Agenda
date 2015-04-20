/*
 * Decompiled with CFR 0_100.
 */
package view;

import controller.ControllerUsuario;
import exception.AgendaException;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import view.AgendaView;
import view.CadastrarUsuarioView;

public class LoginView
extends JFrame {
    private static final long serialVersionUID = -357066838637244105L;
    private JButton btEntrar;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField txtLogin;
    private JPasswordField txtSenha;
    private JButton btCadastrar;

    public LoginView() {
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jLabel2 = new JLabel();
        this.txtLogin = new JTextField();
        this.btCadastrar = new JButton();
        this.btCadastrar.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                LoginView.this.onClickCadastrar(evt);
            }
        });
        this.btEntrar = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setText("Login");
        this.jLabel2.setText("Senha");
        this.txtLogin.setName("");
        this.btCadastrar.setText("Cadastrar-se");
        this.btEntrar.setText("Entrar");
        this.btEntrar.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                LoginView.this.onClickEntrar(evt);
            }
        });
        this.txtSenha = new JPasswordField();
        this.txtSenha.setName("txtSenha");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addContainerGap(19, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.txtLogin).addGroup(layout.createSequentialGroup().addComponent(this.btEntrar, -2, 75, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.btCadastrar)).addComponent(this.txtSenha, -2, 255, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(29).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.txtLogin, -2, -1, -2)).addGap(18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.txtSenha, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.btCadastrar).addComponent(this.btEntrar)).addContainerGap(179, 32767)));
        this.getContentPane().setLayout(layout);
        this.pack();
    }

    private void onClickCadastrar(MouseEvent evt) {
        this.dispose();
        new CadastrarUsuarioView();
    }

    private void onClickEntrar(MouseEvent evt) {
        ControllerUsuario cu = new ControllerUsuario();
        try {
            cu.logar(this.txtLogin.getText(), this.txtSenha.getPassword());
            this.dispose();
            AgendaView av = new AgendaView();
            av.setVisible(true);
        }
        catch (NoSuchAlgorithmException | SQLException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (AgendaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (!"Nimbus".equals(info.getName())) continue;
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginView.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

}
