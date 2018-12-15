/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author luisponce
 */
public class Home extends javax.swing.JFrame {
    static JPanel principal = new JPanel();

    static void setNewPanel(JPanel listado) {
        listado.setLocation(0, 0);
        Home.principal.removeAll();
        Home.principal.add(listado, BorderLayout.CENTER);
        Home.principal.repaint();
        Home.principal.revalidate();
    }
    
    public Home() {
        initComponents(); 
        this.setLocationRelativeTo(this);
        this.setBackground(Color.white);
        this.setState(this.NORMAL);
        this.setExtendedState( this.getExtendedState()|this.MAXIMIZED_BOTH );
        principal = this.mainContainer;
    }
    
    public static JPanel getParentPanel(){
        return Home.principal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        btnPaquetesTuristicos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainContainer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(51, 153, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ontour-inside-logo.png"))); // NOI18N
        jLabel1.setOpaque(true);

        btnUsuarios.setBackground(new java.awt.Color(0, 0, 0));
        btnUsuarios.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUsuarios.setForeground(java.awt.Color.white);
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-usuarios.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setFocusPainted(false);
        btnUsuarios.setOpaque(true);
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseExited(evt);
            }
        });
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPaquetesTuristicos.setBackground(new java.awt.Color(0, 0, 0));
        btnPaquetesTuristicos.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnPaquetesTuristicos.setForeground(java.awt.Color.white);
        btnPaquetesTuristicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-usuarios.png"))); // NOI18N
        btnPaquetesTuristicos.setText("Paquetes turísticos");
        btnPaquetesTuristicos.setBorderPainted(false);
        btnPaquetesTuristicos.setContentAreaFilled(false);
        btnPaquetesTuristicos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPaquetesTuristicos.setFocusPainted(false);
        btnPaquetesTuristicos.setOpaque(true);
        btnPaquetesTuristicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPaquetesTuristicosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPaquetesTuristicosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPaquetesTuristicosMouseEntered(evt);
            }
        });
        btnPaquetesTuristicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaquetesTuristicosActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSalir.setForeground(java.awt.Color.white);
        btnSalir.setText("Salir");
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusPainted(false);
        btnSalir.setMaximumSize(new java.awt.Dimension(202, 31));
        btnSalir.setMinimumSize(new java.awt.Dimension(202, 31));
        btnSalir.setPreferredSize(new java.awt.Dimension(202, 31));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnPaquetesTuristicos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 554, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
            .addComponent(btnPaquetesTuristicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setMinimumSize(new java.awt.Dimension(600, 600));
        mainContainer.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(mainContainer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        btnUsuarios.setBackground(new Color(91,91,91));
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseExited
        btnUsuarios.setBackground(Color.black);
    }//GEN-LAST:event_btnUsuariosMouseExited

    private void btnUsuariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseEntered
        btnUsuarios.setBackground(new Color(91,91,91));
    }//GEN-LAST:event_btnUsuariosMouseEntered

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        UsuarioListado listadoUsuarios = new UsuarioListado();
        listadoUsuarios.setLocation(0, 0);
        this.mainContainer.removeAll();
        this.mainContainer.add(listadoUsuarios, BorderLayout.CENTER);
        this.mainContainer.repaint();
        this.mainContainer.revalidate();
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnPaquetesTuristicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaquetesTuristicosMouseClicked
        btnPaquetesTuristicos.setBackground(new Color(91,91,91));
    }//GEN-LAST:event_btnPaquetesTuristicosMouseClicked

    private void btnPaquetesTuristicosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaquetesTuristicosMouseExited
        btnPaquetesTuristicos.setBackground(Color.black);
        
    }//GEN-LAST:event_btnPaquetesTuristicosMouseExited

    private void btnPaquetesTuristicosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaquetesTuristicosMouseEntered
        btnPaquetesTuristicos.setBackground(new Color(91,91,91));
    }//GEN-LAST:event_btnPaquetesTuristicosMouseEntered

    private void btnPaquetesTuristicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaquetesTuristicosActionPerformed
        PaqueteListado paqueteListado = new PaqueteListado();
        paqueteListado.setLocation(0, 0);
        this.mainContainer.removeAll();
        this.mainContainer.add(paqueteListado, BorderLayout.CENTER);
        this.mainContainer.repaint();
        this.mainContainer.revalidate();
    }//GEN-LAST:event_btnPaquetesTuristicosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        
//        System.exit(0);
        IniciarSesion login;
        login = new view.IniciarSesion();
        login.setState(login.NORMAL);
        login.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPaquetesTuristicos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainContainer;
    // End of variables declaration//GEN-END:variables
}
