package Formularios;

import Esencial.Usuario;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana a través de la cual un usuario puede gestionar su cuenta o gestionar el inicio de una partida.
 * @author Stalin
 */
public class Estadisticas extends javax.swing.JFrame {
    
    public static Usuario usuarioActual;
    private Fondo  imagenFondo;
    public static String hostname="";

    /**
     * Creates new form MenuSala
     */
    public Estadisticas() {
        imagenFondo = new Fondo("/Imagenes/fondoSala.jpg");
        
        
        
        initComponents();
        
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        
        fondo.add(imagenFondo);
        fondo.setOpaque(false);

        this.setLocationRelativeTo(null);
        btnEventos.setVisible(false);
        btnActividades.setVisible(false);
        
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
        btnVolver = new javax.swing.JButton();
        btnReuniones = new javax.swing.JButton();
        btnActividades = new javax.swing.JButton();
        btnEventos = new javax.swing.JButton();
        btnPoyectos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 0));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        btnReuniones.setText("Reuniones");
        btnReuniones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReunionesMouseClicked(evt);
            }
        });

        btnActividades.setText("Actividades");
        btnActividades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActividadesMouseClicked(evt);
            }
        });

        btnEventos.setText("Eventos");
        btnEventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEventosMouseClicked(evt);
            }
        });

        btnPoyectos.setText("Proyectos");
        btnPoyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPoyectosMouseClicked(evt);
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
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(btnReuniones)
                                .addGap(0, 352, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVolver)))
                        .addContainerGap())
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEventos)
                            .addComponent(btnActividades)
                            .addComponent(btnPoyectos))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReuniones)
                .addGap(28, 28, 28)
                .addComponent(btnPoyectos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btnEventos)
                .addGap(27, 27, 27)
                .addComponent(btnActividades)
                .addGap(58, 58, 58)
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

    private void btnReunionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReunionesMouseClicked
        String[] args=null;
        EstadisticasReuniones.hostname = this.hostname;
        EstadisticasReuniones.usuarioActual = this.usuarioActual;
        EstadisticasReuniones.main(args);
        this.dispose();
    }//GEN-LAST:event_btnReunionesMouseClicked

    private void btnPoyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPoyectosMouseClicked
        String[] args=null;
        EstadisticasProyectos.hostname = this.hostname;
        EstadisticasProyectos.usuarioActual = this.usuarioActual;
        EstadisticasProyectos.main(args);
        this.dispose();
    }//GEN-LAST:event_btnPoyectosMouseClicked

    private void btnEventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEventosMouseClicked
        /*String[] args=null;
        EstadisticasEventos.hostname = this.hostname;
        EstadisticasEventos.usuarioActual = this.usuarioActual;
        EstadisticasEventos.main(args);
        this.dispose();*/
    }//GEN-LAST:event_btnEventosMouseClicked

    private void btnActividadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActividadesMouseClicked
        /*String[] args=null;
        EstadisticasActividades.hostname = this.hostname;
        EstadisticasActividades.usuarioActual = this.usuarioActual;
        EstadisticasActividades.main(args);
        this.dispose();*/
    }//GEN-LAST:event_btnActividadesMouseClicked

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
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estadisticas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Estadisticas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActividades;
    private javax.swing.JButton btnEventos;
    private javax.swing.JButton btnPoyectos;
    private javax.swing.JButton btnReuniones;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel fondo;
    // End of variables declaration//GEN-END:variables

    
}
