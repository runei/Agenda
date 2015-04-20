/*
 * Decompiled with CFR 0_100.
 * 
 * Could not load the following classes:
 *  com.toedter.calendar.JCalendar
 */
package view;

import com.toedter.calendar.JCalendar;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AgendaView
extends JFrame {
    private JButton incluirCompromisso;
    private JCalendar jCalendar1;

    public AgendaView() {
        this.initComponents();
    }

    private void initComponents() {
        this.jCalendar1 = new JCalendar();
        this.incluirCompromisso = new JButton();
        this.setDefaultCloseOperation(3);
        this.jCalendar1.setDate(new Date(1428536649000L));
        this.jCalendar1.setMinSelectableDate(new Date(-62135755131000L));
        this.incluirCompromisso.setText("Incluir compromisso");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(328, 328, 328).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.incluirCompromisso).addComponent((Component)this.jCalendar1, -2, 401, -2)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap(26, 32767).addComponent(this.incluirCompromisso).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent((Component)this.jCalendar1, -2, 332, -2).addContainerGap()));
        this.pack();
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
            Logger.getLogger(AgendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            Logger.getLogger(AgendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            Logger.getLogger(AgendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AgendaView.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                new AgendaView().setVisible(true);
            }
        });
    }

}
