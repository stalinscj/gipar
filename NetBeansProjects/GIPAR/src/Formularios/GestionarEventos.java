/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Esencial.Usuario;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana a través de la cual un usuario puede gestionar su cuenta o gestionar el inicio de una partida.
 * @author Stalin
 */
public class GestionarEventos extends javax.swing.JFrame {
    
    public static Usuario usuarioActual;
    private Fondo  imagenFondo;
    public static String hostname="";

    /**
     * Creates new form MenuSala
     */
    public GestionarEventos() {
        imagenFondo = new Fondo("/Imagenes/fondoSala.jpg");
        
        
        
        initComponents();
        
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        
        fondo.add(imagenFondo);
        fondo.setOpaque(false);

        this.setLocationRelativeTo(null); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        btnVerEventos = new javax.swing.JButton();
        btnGenerarEvento = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnAgregarActividad = new javax.swing.JButton();
        btnEliminarActividad = new javax.swing.JButton();
        btnEliminarComision = new javax.swing.JButton();
        btnParticiparEnComision = new javax.swing.JButton();
        btnGestionarAsistencia = new javax.swing.JButton();
        btnPresentarArticulo = new javax.swing.JButton();
        btnCancelarArticulo = new javax.swing.JButton();
        btnVerComisiones = new javax.swing.JButton();
        btnCancelarParticipacionComision = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 0));

        btnVerEventos.setText("Ver Eventos");
        btnVerEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerEventosMouseClicked(evt);
            }
        });

        btnGenerarEvento.setText("Generar Evento");
        btnGenerarEvento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGenerarEventoMouseClicked(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        btnAgregarActividad.setText("Agregar Actividad");
        btnAgregarActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarActividadMouseClicked(evt);
            }
        });

        btnEliminarActividad.setText("Eliminar Actividad");
        btnEliminarActividad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarActividadMouseClicked(evt);
            }
        });

        btnEliminarComision.setText("Eliminar Comisión");
        btnEliminarComision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarComisionMouseClicked(evt);
            }
        });

        btnParticiparEnComision.setText("Participar en Comisión");
        btnParticiparEnComision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParticiparEnComisionMouseClicked(evt);
            }
        });

        btnGestionarAsistencia.setText("Gestionar Asistencia");
        btnGestionarAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGestionarAsistenciaMouseClicked(evt);
            }
        });

        btnPresentarArticulo.setText("Presentar Artículo");
        btnPresentarArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPresentarArticuloMouseClicked(evt);
            }
        });

        btnCancelarArticulo.setText("Cancelar Artículo");
        btnCancelarArticulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarArticuloMouseClicked(evt);
            }
        });

        btnVerComisiones.setText("Ver Comisiones");
        btnVerComisiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerComisionesMouseClicked(evt);
            }
        });

        btnCancelarParticipacionComision.setText("Cancelar Participacion");
        btnCancelarParticipacionComision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarParticipacionComisionMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(btnAgregarActividad)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarActividad)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminarComision))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(btnVerEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerarEvento)
                                .addGap(18, 18, 18)
                                .addComponent(btnGestionarAsistencia))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(btnVerComisiones)
                                .addGap(18, 18, 18)
                                .addComponent(btnParticiparEnComision)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelarParticipacionComision))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(btnPresentarArticulo)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelarArticulo)))
                        .addGap(0, 36, Short.MAX_VALUE)))
                .addContainerGap())
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerEventos)
                    .addComponent(btnGenerarEvento)
                    .addComponent(btnGestionarAsistencia))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParticiparEnComision)
                    .addComponent(btnVerComisiones)
                    .addComponent(btnCancelarParticipacionComision))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarActividad)
                    .addComponent(btnEliminarActividad)
                    .addComponent(btnEliminarComision))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPresentarArticulo)
                    .addComponent(btnCancelarArticulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked

        String[] args=null;
        Sala.hostname = this.hostname;
        Sala.usuarioActual = this.usuarioActual;
        Sala.main(args);
        this.dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnVerEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerEventosMouseClicked
       
        String[] args = null;
        VerEventos.hostname = this.hostname;
        VerEventos.usuarioActual = this.usuarioActual;
        VerEventos.main(args);
        this.dispose(); 
    }//GEN-LAST:event_btnVerEventosMouseClicked

    private void btnGenerarEventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarEventoMouseClicked
        
        String[] args = null;
        GenerarEvento.hostname = this.hostname;
        GenerarEvento.usuarioActual=this.usuarioActual;
        GenerarEvento.main(args);
        this.dispose();
        
    }//GEN-LAST:event_btnGenerarEventoMouseClicked

    private void btnAgregarActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarActividadMouseClicked
        String[] args = null;
        AgregarActividad.hostname = this.hostname;
        AgregarActividad.usuarioActual=this.usuarioActual;
        AgregarActividad.main(args);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActividadMouseClicked

    private void btnEliminarActividadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarActividadMouseClicked
        String[] args = null;
        EliminarActividad.hostname = this.hostname;
        EliminarActividad.usuarioActual=this.usuarioActual;
        EliminarActividad.main(args);
        this.dispose();
    }//GEN-LAST:event_btnEliminarActividadMouseClicked

    private void btnEliminarComisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarComisionMouseClicked
        String[] args = null;
        EliminarComision.hostname = this.hostname;
        EliminarComision.usuarioActual=this.usuarioActual;
        EliminarComision.main(args);
        this.dispose();
    }//GEN-LAST:event_btnEliminarComisionMouseClicked

    private void btnGestionarAsistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGestionarAsistenciaMouseClicked
        String[] args = null;
        GestionarAsistencia.hostname = this.hostname;
        GestionarAsistencia.usuarioActual=this.usuarioActual;
        GestionarAsistencia.main(args);
        this.dispose();
    }//GEN-LAST:event_btnGestionarAsistenciaMouseClicked

    private void btnParticiparEnComisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParticiparEnComisionMouseClicked
        String[] args = null;
        ParticiparComision.hostname = this.hostname;
        ParticiparComision.usuarioActual=this.usuarioActual;
        ParticiparComision.main(args);
        this.dispose();
    }//GEN-LAST:event_btnParticiparEnComisionMouseClicked

    private void btnPresentarArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPresentarArticuloMouseClicked
        String[] args = null;
        PresentarArticulo.hostname = this.hostname;
        PresentarArticulo.usuarioActual=this.usuarioActual;
        PresentarArticulo.main(args);
        this.dispose();
    }//GEN-LAST:event_btnPresentarArticuloMouseClicked

    private void btnCancelarArticuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarArticuloMouseClicked
        String[] args = null;
        CancelarArticulos.hostname = this.hostname;
        CancelarArticulos.usuarioActual=this.usuarioActual;
        CancelarArticulos.main(args);
        this.dispose();
    }//GEN-LAST:event_btnCancelarArticuloMouseClicked

    private void btnVerComisionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerComisionesMouseClicked
        String[] args = null;
        VerComisiones.hostname = this.hostname;
        VerComisiones.usuarioActual=this.usuarioActual;
        VerComisiones.main(args);
        this.dispose();
    }//GEN-LAST:event_btnVerComisionesMouseClicked

    private void btnCancelarParticipacionComisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarParticipacionComisionMouseClicked
        String[] args = null;
        CancelarParticipacionComision.hostname = this.hostname;
        CancelarParticipacionComision.usuarioActual=this.usuarioActual;
        CancelarParticipacionComision.main(args);
        this.dispose();
    }//GEN-LAST:event_btnCancelarParticipacionComisionMouseClicked

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
            java.util.logging.Logger.getLogger(GestionarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarEventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarEventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarActividad;
    private javax.swing.JButton btnCancelarArticulo;
    private javax.swing.JButton btnCancelarParticipacionComision;
    private javax.swing.JButton btnEliminarActividad;
    private javax.swing.JButton btnEliminarComision;
    private javax.swing.JButton btnGenerarEvento;
    private javax.swing.JButton btnGestionarAsistencia;
    private javax.swing.JButton btnParticiparEnComision;
    private javax.swing.JButton btnPresentarArticulo;
    private javax.swing.JButton btnVerComisiones;
    private javax.swing.JButton btnVerEventos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel fondo;
    // End of variables declaration//GEN-END:variables

    
}
