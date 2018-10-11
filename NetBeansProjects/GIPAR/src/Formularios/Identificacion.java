/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Esencial.Imagen;
import Esencial.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jbarcodebean.JBarcodeBean;
import net.sourceforge.jbarcodebean.model.Code39;
import net.sourceforge.jbarcodebean.model.Interleaved25;

/**
 * Clase que representa una ventana a través de la cual un usuario puede gestionar su cuenta o gestionar el inicio de una partida.
 * @author Stalin
 */
public class Identificacion extends javax.swing.JFrame {
    
    public static Usuario usuarioActual;
    private Fondo  imagenFondo;
    public static String hostname="";

    /**
     * Creates new form MenuSala
     */
    public Identificacion() {
        imagenFondo = new Fondo("/Imagenes/fondoSala.jpg");
        
        
        
        initComponents();
        
        
        llenarFicha();
        generarCodigoDeBarras();
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        
        fondo.add(imagenFondo);
        fondo.setOpaque(false);

        this.setLocationRelativeTo(null); 
        
    }
    
    
    public void llenarFicha(){
        lblNombre.setText("Nombre: "+ usuarioActual.getNombre());
        lblApellido.setText("Apellido: "+ usuarioActual.getApellido());
        lblCedula.setText("Cedula: "+ usuarioActual.getCedula());
        lblCargo.setText("Cargo: "+ usuarioActual.getCargo() );
        panelImagen.add(new Fondo(150,150,new ImageIcon(Imagen.decodeToImage(usuarioActual.getImagen()))));
        lblGipar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/gipar.jpg")));
    }
    
    public void generarCodigoDeBarras(){
        
        JBarcodeBean barcode = new JBarcodeBean();

        // nuestro tipo de codigo de barra
        //barcode.setCodeType(new Interleaved25());
        barcode.setCodeType(new Code39());

        // nuestro valor a codificar y algunas configuraciones mas
        barcode.setCode("123455432198");
        //barcode.setCheckDigit(true);
        barcode.setShowText(false);
        
        
        //TYPE_4BYTE_ABGR

        BufferedImage bufferedImage = barcode.draw(new BufferedImage(200, 50, BufferedImage.TYPE_4BYTE_ABGR_PRE));
        
        
      
        
        lblCodigoDeBarras.setIcon(new ImageIcon(bufferedImage));
        
        
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
        jpnIdentificacion = new javax.swing.JPanel();
        panelImagen = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        lblGipar = new javax.swing.JLabel();
        lblCodigoDeBarras = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 0));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        jpnIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        jpnIdentificacion.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        lblNombre.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        lblNombre.setText("Nombre:");

        lblApellido.setFont(new java.awt.Font("Kristen ITC", 1, 16)); // NOI18N
        lblApellido.setText("Apellido:");

        lblCedula.setFont(new java.awt.Font("Kristen ITC", 1, 16)); // NOI18N
        lblCedula.setText("Cédula:");

        lblCargo.setFont(new java.awt.Font("Kristen ITC", 1, 16)); // NOI18N
        lblCargo.setText("Cargo:");

        lblGipar.setBackground(new java.awt.Color(0, 0, 204));
        lblGipar.setFont(new java.awt.Font("Kristen ITC", 1, 16)); // NOI18N
        lblGipar.setForeground(new java.awt.Color(240, 240, 240));
        lblGipar.setText(".");

        lblCodigoDeBarras.setBackground(new java.awt.Color(255, 255, 255));
        lblCodigoDeBarras.setFont(new java.awt.Font("Kristen ITC", 1, 16)); // NOI18N
        lblCodigoDeBarras.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigoDeBarras.setText(".");

        javax.swing.GroupLayout jpnIdentificacionLayout = new javax.swing.GroupLayout(jpnIdentificacion);
        jpnIdentificacion.setLayout(jpnIdentificacionLayout);
        jpnIdentificacionLayout.setHorizontalGroup(
            jpnIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnIdentificacionLayout.createSequentialGroup()
                .addGroup(jpnIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnIdentificacionLayout.createSequentialGroup()
                        .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpnIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCargo)
                            .addComponent(lblNombre)
                            .addComponent(lblCedula)
                            .addComponent(lblApellido)))
                    .addGroup(jpnIdentificacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodigoDeBarras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGipar)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jpnIdentificacionLayout.setVerticalGroup(
            jpnIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnIdentificacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpnIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnIdentificacionLayout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addGap(18, 18, 18)
                        .addComponent(lblApellido)
                        .addGap(18, 18, 18)
                        .addComponent(lblCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCargo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnIdentificacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoDeBarras)
                    .addComponent(lblGipar))
                .addGap(18, 18, 18))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpnIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jpnIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnVolver))
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
        GestionUsuario.hostname = this.hostname;
        GestionUsuario.usuarioActual = this.usuarioActual;
        GestionUsuario.main(args);
        this.dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        
        int ancho = jpnIdentificacion.getWidth();
        int alto = jpnIdentificacion.getHeight();
        BufferedImage imagen = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D grafico = imagen.createGraphics();
        jpnIdentificacion.paint(grafico);
        
        
        try {
            File archivo = new File("Identificacion "+this.usuarioActual.getCedula()+".jpg");
            ImageIO.write(imagen, "jpg", archivo);
            JOptionPane.showMessageDialog(this, "Imagen guardada satisfactoriamente");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        
        
        
    }//GEN-LAST:event_btnGuardarMouseClicked

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
            java.util.logging.Logger.getLogger(Identificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Identificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Identificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Identificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Identificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel jpnIdentificacion;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCodigoDeBarras;
    private javax.swing.JLabel lblGipar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel panelImagen;
    // End of variables declaration//GEN-END:variables

    
}