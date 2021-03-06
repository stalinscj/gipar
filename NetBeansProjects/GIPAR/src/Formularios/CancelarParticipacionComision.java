package Formularios;

import Conexiones.ConexionMYSQL;
import Esencial.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana a través de la cual un usuario puede gestionar su cuenta o gestionar el inicio de una partida.
 * @author Stalin
 */
public class CancelarParticipacionComision extends javax.swing.JFrame {
    
    public static Usuario usuarioActual;
    private Fondo  imagenFondo;
    public static String hostname="";

    /**
     * Creates new form MenuSala
     */
    public CancelarParticipacionComision() {
        imagenFondo = new Fondo("/Imagenes/fondoSala.jpg");
        
        
        
        initComponents();
        
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        
        fondo.add(imagenFondo);
        fondo.setOpaque(false);

        this.setLocationRelativeTo(null);
        cargarEventos();
        cargarMiembros();
        
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
        cboEventos = new javax.swing.JComboBox();
        cboComisiones = new javax.swing.JComboBox();
        lblEvento = new javax.swing.JLabel();
        lblActividad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cboActividades = new javax.swing.JComboBox();
        btnCancelarParticipacion = new javax.swing.JButton();
        lblMiembro = new javax.swing.JLabel();
        cboCedulas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 0));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        cboEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEventosActionPerformed(evt);
            }
        });

        lblEvento.setText("Evento:");

        lblActividad.setText("Actividad:");

        jLabel1.setText("Comisión:");

        cboActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboActividadesActionPerformed(evt);
            }
        });

        btnCancelarParticipacion.setText("Cancelar Participación");
        btnCancelarParticipacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarParticipacionMouseClicked(evt);
            }
        });

        lblMiembro.setText("Miembro:");

        cboCedulas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCedulasActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        txtNombre.setEditable(false);

        lblApellido.setText("Apellido:");

        txtApellido.setEditable(false);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                        .addComponent(btnCancelarParticipacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(lblEvento)
                        .addGap(18, 18, 18)
                        .addComponent(cboEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblActividad)
                        .addGap(18, 18, 18)
                        .addComponent(cboActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cboComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 129, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(lblMiembro)
                    .addGap(18, 18, 18)
                    .addComponent(cboCedulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(lblApellido)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblActividad)
                    .addComponent(cboActividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cboComisiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEvento)
                    .addComponent(cboEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnCancelarParticipacion))
                .addContainerGap())
            .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(fondoLayout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboCedulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMiembro)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(lblApellido)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(127, Short.MAX_VALUE)))
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
        GestionarEventos.hostname = this.hostname;
        GestionarEventos.usuarioActual = this.usuarioActual;
        GestionarEventos.main(args);
        this.dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void cboEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEventosActionPerformed
        cboActividades.removeAllItems();;
        cargarActividades();
    }//GEN-LAST:event_cboEventosActionPerformed

    private void cboActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboActividadesActionPerformed
        cboComisiones.removeAllItems();
        cargarComisiones();
    }//GEN-LAST:event_cboActividadesActionPerformed

    private void btnCancelarParticipacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarParticipacionMouseClicked
        cboComisiones.removeAllItems();
        cargarComisiones();
        eliminarParticipacion();
    }//GEN-LAST:event_btnCancelarParticipacionMouseClicked

    private void cboCedulasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCedulasActionPerformed

        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
        usuario="miembro";
        else
        usuario="miembrogipar";

        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String sentenciaSQL;

        sentenciaSQL = "SELECT nombre,apellido,idMiembro "
        + "FROM miembros "
        + "WHERE cedula='"+cboCedulas.getSelectedItem()+"';";

        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);

            if(RS.next()){
                txtNombre.setText(RS.getString("nombre"));
                txtApellido.setText(RS.getString("apellido"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_cboCedulasActionPerformed

    
    
    public boolean cargarEventos(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String sentenciaSQL = "SELECT nombre FROM eventos;";
           
        
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                cboEventos.addItem(RS.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
      
        return true;
    }
    
    public boolean cargarActividades(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String idEvento,sentenciaSQL = "SELECT idEvento "
                                     + "FROM eventos "
                                     + "WHERE nombre='"+cboEventos.getSelectedItem()+"';";
           
        idEvento="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idEvento = RS.getString("idEvento");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT nombre "
                     + "FROM actividades "
                     + "WHERE idEvento='"+idEvento+"';";
        
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                cboActividades.addItem(RS.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
      
        
        return true;
    }
    
    public boolean cargarComisiones(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String idActividad,idEvento,sentenciaSQL = "SELECT idEvento "
                                     + "FROM eventos "
                                     + "WHERE nombre='"+cboEventos.getSelectedItem()+"';";
           
        idEvento="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idEvento = RS.getString("idEvento");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT idActividad "
                     + "FROM actividades "
                     + "WHERE idEvento='"+idEvento+"' AND nombre='"+cboActividades.getSelectedItem()+"';";
        
        idActividad="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idActividad = RS.getString("idActividad");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT DISTINCT nombre "
                     + "FROM comisiones "
                     + "WHERE idActividad='"+idActividad+"';";
        
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                cboComisiones.addItem(RS.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    
    public boolean cargarMiembros(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String sentenciaSQL;
        
        sentenciaSQL = "SELECT cedula "
                     + "FROM miembros;";
        
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                cboCedulas.addItem(RS.getString("cedula"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    
    public boolean eliminarParticipacion(){
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar","miembrogipar");
        Connection conexion = mysql.conectar();
        String idComision,idMiembro,idActividad,idEvento,sentenciaSQL = "SELECT idEvento "
                                     + "FROM eventos "
                                     + "WHERE nombre='"+cboEventos.getSelectedItem()+"';";
           
        idEvento="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idEvento = RS.getString("idEvento");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT idActividad "
                     + "FROM actividades "
                     + "WHERE idEvento='"+idEvento+"' AND nombre='"+cboActividades.getSelectedItem()+"';";
        
        idActividad="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idActividad = RS.getString("idActividad");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT idMiembro "
                     + "FROM miembros "
                     + "WHERE cedula='"+cboCedulas.getSelectedItem()+"';";
           
        idMiembro="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idMiembro = RS.getString("idMiembro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT idComision "
                     + "FROM comisiones "
                     + "WHERE idActividad='"+idActividad+"' AND nombre='"+cboComisiones.getSelectedItem()+"';";
        
        idComision="";
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idComision = RS.getString("idComision");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "DELETE "
                     + "FROM comisiones "
                     + "WHERE idActividad='"+idActividad+"' AND nombre='"+cboComisiones.getSelectedItem()+"' AND idMiembro='"+idMiembro+"';";
        
        try {
            Statement ST = conexion.createStatement();
            ST = conexion.createStatement();
            ST.executeUpdate(sentenciaSQL);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        JOptionPane.showMessageDialog(this, "Participacion cancelada satisfactoriamente");
        return true;
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
            java.util.logging.Logger.getLogger(CancelarParticipacionComision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CancelarParticipacionComision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CancelarParticipacionComision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CancelarParticipacionComision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new CancelarParticipacionComision().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarParticipacion;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cboActividades;
    private javax.swing.JComboBox cboCedulas;
    private javax.swing.JComboBox cboComisiones;
    private javax.swing.JComboBox cboEventos;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblActividad;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblEvento;
    private javax.swing.JLabel lblMiembro;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
