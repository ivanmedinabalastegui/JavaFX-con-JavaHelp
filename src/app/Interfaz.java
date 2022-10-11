//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
/*
package app;

import help.Help;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;

public class Interfaz extends JFrame {

    public Interfaz() {
        this.initComponents();
    }

    private void initComponents() {
        JButton jButton1 = new JButton();
        this.setDefaultCloseOperation(3);
        jButton1.setText("AYUDA");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Interfaz.this.jButton1ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(323, 32767).addComponent(jButton1).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jButton1).addContainerGap(266, 32767)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        Help help = new Help();
        help.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] arr$ = UIManager.getInstalledLookAndFeels();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                UIManager.LookAndFeelInfo info = arr$[i$];
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Interfaz()).setVisible(true);
            }
        });
    }
}
*/