/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConPaqueteViaje;
import dto.Servicio;
import java.awt.Color;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.JDatePanel;

/**
 *
 * @author luisponce
 */
public class PaqueteListado extends javax.swing.JInternalFrame {
    /**
     * Creates new form UsuarioNuevo
     */
    private JTextField origen, numPasajeros, destino;
    private JDatePanel fechaIda, fechaRegreso;
    private JComboBox transporte;
    private int idPaqueteTuristico = 0;
    
    ConPaqueteViaje controllerPaqueteViaje = new ConPaqueteViaje();
    
    
    public PaqueteListado() {
        initComponents();
        this.actualizar();
    }
    
    public void limpiarTablas(){
        DefaultTableModel model = (DefaultTableModel) this.listadoTransporte.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model = (DefaultTableModel) this.listadoEstadia.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model = (DefaultTableModel) this.listadoSeguros.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
    }
    
    public void clear(){
    }
    
    public void actualizar(){
        DefaultTableModel modelViajes = new DefaultTableModel();
        try {
            modelViajes = controllerPaqueteViaje.listarPaquetes();
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.listadoPaquetes.setModel(modelViajes);
        this.listadoPaquetes.getColumnModel().getColumn(0).setPreferredWidth(60);
        this.listadoPaquetes.getColumnModel().getColumn(1).setPreferredWidth(560);
        this.listadoPaquetes.getColumnModel().getColumn(2).setPreferredWidth(100);
        this.btnBorrar.setEnabled(false);
        this.limpiarTablas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listadoPaquetes = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listadoTransporte = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listadoEstadia = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listadoSeguros = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnBorrar = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setAlignmentX(-5.0F);
        setAlignmentY(-5.0F);
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(150, 765));
        setPreferredSize(new java.awt.Dimension(980, 550));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(980, 765));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("Paquetes");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("|   Listado");

        jPanel6.setBackground(new java.awt.Color(245, 245, 245));

        listadoPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listadoPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadoPaquetesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listadoPaquetes);

        jLabel10.setFont(new java.awt.Font("Roboto", 2, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Haz clic sobre un paquete para ver sus servicios");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel9.setBackground(new java.awt.Color(245, 245, 245));

        jLabel45.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 51));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("*");

        listadoTransporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listadoTransporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadoTransporteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(listadoTransporte);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Transporte");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Estadia");

        listadoEstadia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listadoEstadia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadoEstadiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listadoEstadia);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Seguros");

        listadoSeguros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        listadoSeguros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listadoSegurosMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(listadoSeguros);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(38, 38, 38)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(435, 435, 435)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel45))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel6)))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel8))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(245, 245, 245));

        jLabel49.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 0, 51));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel49.setText("*");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Servicios vinculados al paquete seleccionado:");

        btnBorrar.setBackground(new java.awt.Color(88, 185, 87));
        btnBorrar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnBorrar.setForeground(java.awt.Color.white);
        btnBorrar.setText("Eliminar paquete turístico");
        btnBorrar.setBorderPainted(false);
        btnBorrar.setContentAreaFilled(false);
        btnBorrar.setFocusPainted(false);
        btnBorrar.setIgnoreRepaint(true);
        btnBorrar.setOpaque(true);
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBorrarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBorrarMouseEntered(evt);
            }
        });
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addGap(361, 361, 361)
                .addComponent(btnBorrar)
                .addGap(110, 110, 110)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnBorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarMouseExited

    private void btnBorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarMouseEntered

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int row = this.listadoPaquetes.getSelectedRow();
        try {
            if (this.controllerPaqueteViaje.eliminarPaqueteViaje(this.idPaqueteTuristico)) {
                JOptionPane.showMessageDialog(this, "El paquete turístico ha sido eliminado");
                
                DefaultTableModel usuarioTableModel = (DefaultTableModel) this.listadoPaquetes.getModel();
                usuarioTableModel.removeRow(row);
                this.listadoPaquetes.revalidate();
                this.limpiarTablas();
                this.btnBorrar.setEnabled(false);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void listadoPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoPaquetesMouseClicked
        int paqueteSeleccionado = this.listadoPaquetes.getSelectedRow();
        BigDecimal numeroPaquete = (BigDecimal) this.listadoPaquetes.getModel().getValueAt(paqueteSeleccionado, 0);
        idPaqueteTuristico = numeroPaquete.intValue();
        DefaultTableModel model = (DefaultTableModel) this.listadoTransporte.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model = (DefaultTableModel) this.listadoEstadia.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        model = (DefaultTableModel) this.listadoSeguros.getModel();
        model.setColumnCount(0);
        model.setRowCount(0);
        this.btnBorrar.setEnabled(true);
        try {
            List<Servicio> servicios = this.controllerPaqueteViaje.getServiciosElegidos(numeroPaquete);
            for (Servicio servicio : servicios) {
                int idWs = servicio.getIdWs();
                switch(servicio.getIdTipoServicio()){
                    case 1:
                        //vuelo
                        try {
                            DefaultTableModel modelVuelo = new DefaultTableModel();
                            modelVuelo = this.controllerPaqueteViaje.getVueloConId(idWs);
                            this.listadoTransporte.setModel(modelVuelo);
                        } catch (IOException ex) {
                            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 2:
                        //Bus
                        try {
                            DefaultTableModel modelBus = new DefaultTableModel();
                            modelBus = this.controllerPaqueteViaje.getBusConId(idWs);
                            this.listadoTransporte.setModel(modelBus);
                        } catch (IOException ex) {
                            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 3:
                        //Estadia
                        try {
                            DefaultTableModel modelEstadia = new DefaultTableModel();
                            modelEstadia = this.controllerPaqueteViaje.getEstadiaConId(idWs);
                            this.listadoEstadia.setModel(modelEstadia);
                        } catch (IOException ex) {
                            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 4:
                        //Seguro
                        try {
                            DefaultTableModel modelSeguro = new DefaultTableModel();
                            modelSeguro = this.controllerPaqueteViaje.getSeguroConId(idWs);
                            this.listadoSeguros.setModel(modelSeguro);
                        } catch (IOException ex) {
                            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    case 5:
                        //actividad
                        break;
                }           
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PaqueteListado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_listadoPaquetesMouseClicked

    private void listadoEstadiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoEstadiaMouseClicked
       
    }//GEN-LAST:event_listadoEstadiaMouseClicked

    private void listadoSegurosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoSegurosMouseClicked
        
    }//GEN-LAST:event_listadoSegurosMouseClicked

    private void listadoTransporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listadoTransporteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listadoTransporteMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable listadoEstadia;
    private javax.swing.JTable listadoPaquetes;
    private javax.swing.JTable listadoSeguros;
    private javax.swing.JTable listadoTransporte;
    // End of variables declaration//GEN-END:variables
}
