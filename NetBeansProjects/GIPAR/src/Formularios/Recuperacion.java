/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Formularios;

import Conexiones.ConexionMYSQL;
import Esencial.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;


/**
 *
 * @author Usuario
 */
public class Recuperacion extends javax.swing.JFrame {
     private Fondo  imagenFondo;
     private String hostname;
     private String cedula;
     private String correo;
     private String claveTemporal;

    /**
     * Creates new form Recuperacion
     */
    public Recuperacion() {
        
        imagenFondo = new Fondo("/Imagenes/fondoSala.jpg");
        claveTemporal = "";
        
        initComponents();
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        this.setResizable(false);
        fondo.add(imagenFondo);
        fondo.setOpaque(false);
        //titulo.setOpaque(false);
        
       txtServidor.setVisible(false);
       cboServidor.setVisible(false);
       
        this.setLocationRelativeTo(null);
        
    }
    
    
    public boolean enviarCorreo(String usuarioCorreo,String claveCorreo,String destinatario,String asunto, String mensaje, String rutaArchivo, String nombreArchivo){
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            if (!rutaArchivo.equals("")){
                 adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(rutaArchivo)));
                adjunto.setFileName(nombreArchivo);                
            }

            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!rutaArchivo.equals("")){
                multiParte.addBodyPart(adjunto);
            }

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, claveCorreo);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
            return false;
        }
    }
    
    public String generarClaveTemporal(){
        
       Random aleatorio = new Random();
       int numeroAlAzar=0;
       char caracter;
       boolean valido=false;
       String claveTemporal="";
       
       for(int i=0;i<10;i++){
           
           do{
               numeroAlAzar = aleatorio.nextInt(75)+48;
               
               if(numeroAlAzar<=57){
                   valido = true;
                   break;
               }
               
               if(numeroAlAzar>=65 && numeroAlAzar<=90){
                   valido = true;
                   break;
               }
               
               if(numeroAlAzar>=97){
                   valido = true;
                   break;
               }
               
               
           }while(!valido);
           valido = false;
           
           caracter = ((char) numeroAlAzar);
           
           claveTemporal = claveTemporal +caracter;
       }
       
        return claveTemporal;
    }
    
    public boolean actualizarClave(String cedula,String claveTemporal){
        
        ConexionMYSQL mysql = null;
        Connection conexion = null;
        String sentenciaSQL = "";
        
        claveTemporal = DigestUtils.md5Hex(claveTemporal);
        
        mysql = new ConexionMYSQL("localhost","bdgipar","miembrogipar");
        conexion = mysql.conectar();
            
        
        if(conexion!=null)
            try{
                sentenciaSQL = " UPDATE miembros SET clave = '"+claveTemporal+"' WHERE cedula = '"+cedula+"'";
                                
                PreparedStatement PST = conexion.prepareStatement(sentenciaSQL);
            
                PST.executeUpdate();
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
        return false;
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
        txtServidor = new javax.swing.JLabel();
        cboServidor = new javax.swing.JComboBox();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtServidor.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        txtServidor.setForeground(new java.awt.Color(0, 255, 204));
        txtServidor.setText("  Servidor");

        cboServidor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Puerto Ordaz" }));

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        lblCedula.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        lblCedula.setText("Cédula");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblCorreo.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        lblCorreo.setText("Correo");

        btnEnviar.setText("Enviar");
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEnviarMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtServidor)))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(lblCedula)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEnviar)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(lblCorreo)
                        .addGap(135, 135, 135))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(txtServidor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        txtCorreo.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        
        
        
        
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked

        String[] args=null;
        Login.main(args);
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnEnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseClicked
       
        cedula = txtCedula.getText();
        correo = txtCorreo.getText();
        
        if(confirmarRecuperacion()){
            if(cboServidor.getSelectedItem().toString().equalsIgnoreCase("Puerto Ordaz"))
                hostname = "puertoordazcj.ddns.net";
            else
                hostname = "elcallaocj.ddns.net";    
            
            if(verificarUsuario(hostname, cedula, correo)){
                claveTemporal = generarClaveTemporal();
                if(enviarCorreo("JuegoUnoUneg@gmail.com","nziziaqnqesoneaf",correo , "Clave temporal GIPAR", 
                                "Utiliza esta clave temporal para ingresar a tu cuenta: "+claveTemporal+" Te recomendamos "+
                                "cambiarla de inmediato en el módulo de modificacíon de datos", "", "")){
                    
                    if(actualizarClave(cedula, claveTemporal)){
                        
                        JOptionPane.showMessageDialog(this, "Tu clave ha sido cambiada por una clave temporal y\n"
                                                          + "se ha enviado tu correo exitosamente. Existe la\n"
                                                          + "posibilidad de que se encuentre tu carpeta de spam.");
                        
                        String[] args=null;
                        Login.main(args);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error al actulizar tu clave.\n"
                                                          + "Tu clave no ha sido cambiada.");
                    }
                
                
                }else{
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error al enviar la clave temporal.\n"
                                                      + "Tu clave no ha sido cambiada.");
                }
                
                
                
            }else{
                JOptionPane.showMessageDialog(this, "Los  datos  ingresados\nson inválidos. Por favor\nverifique  su  cedula,\n"
                                                  + "correo y/o servidor.","Usuario inválido",1,new ImageIcon(getClass().getResource("/Imagenes/accesoDenegado.gif")));
            }

        }
    }//GEN-LAST:event_btnEnviarMouseClicked

    
    
    public boolean verificarUsuario(String hostname, String cedula, String correo){
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar","miembrogipar");
        Connection conexion = mysql.conectar();
        String sentenciaSQL = "";
        
        if(conexion!=null)
            try {
                sentenciaSQL = "SELECT cedula, correo FROM miembros WHERE cedula='"+cedula+"'";
                Statement ST = conexion.createStatement();
                ResultSet RS = ST.executeQuery(sentenciaSQL);

                if(RS.next()){
                    if(cedula.equalsIgnoreCase(RS.getString("cedula")) && correo.equals(RS.getString("correo")))
                        return true;
                }

                return false;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return false;
            }
        else
            return false;
    }
    
    
    
    public boolean confirmarRecuperacion(){
        
        String opciones[] = new String[] {"Sí","No"};
        int opcion = JOptionPane.showOptionDialog(null, "¿Desea recuperar su cuenta\n"
                                                        + "enviado una contraseña\n"
                                                        + "temporal a su correo?\n"
                                                        + "Si dice que si ya no\n"
                                                        + "podrá ingresar usando\n"
                                                        + "su antigua contraseña.\n"
                                                        , "Confirmacion de cambio clave",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                                        new ImageIcon(getClass().getResource("/Imagenes/piensa.gif")), opciones, opciones[0]);
        
        switch(opcion){
            
            case 0:{
                return true;
            }
            
            case 1:{
                return false;   
            }
            
            default:{
                return confirmarRecuperacion();
            }
        }
    }
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Recuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recuperacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recuperacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JComboBox cboServidor;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JLabel txtServidor;
    // End of variables declaration//GEN-END:variables
}
