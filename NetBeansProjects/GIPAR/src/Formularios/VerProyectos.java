package Formularios;

import Conexiones.ConexionMYSQL;
import Esencial.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana a través de la cual un usuario puede gestionar su cuenta o gestionar el inicio de una partida.
 * @author Stalin
 */
public class VerProyectos extends javax.swing.JFrame {
    
    public static Usuario usuarioActual;
    private Fondo  imagenFondo;
    public static String hostname="";

    /**
     * Creates new form MenuSala
     */
    public VerProyectos() {
        imagenFondo = new Fondo("/Imagenes/fondoRegistro.jpg");
        
        
        
        initComponents();
        
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        
        fondo.add(imagenFondo);
        fondo.setOpaque(false);

        this.setLocationRelativeTo(null);
        cargarProyectos();
        
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
        lblProyecto = new javax.swing.JLabel();
        cboProyectos = new javax.swing.JComboBox();
        lblCoordinador = new javax.swing.JLabel();
        txtCoordinador = new javax.swing.JTextField();
        lblAreaAccion = new javax.swing.JLabel();
        txtAreaAccion = new javax.swing.JTextField();
        lblAvance = new javax.swing.JLabel();
        txtAvance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtParticipantes = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRecursos = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtFases = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 0));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblProyecto.setText("Proyecto:");

        cboProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProyectosActionPerformed(evt);
            }
        });

        lblCoordinador.setText("Coordinador:");

        txtCoordinador.setEditable(false);

        lblAreaAccion.setText("Área de Acción");

        txtAreaAccion.setEditable(false);

        lblAvance.setText("Avance");

        txtAvance.setEditable(false);

        jLabel1.setText("Participantes");

        txtParticipantes.setEditable(false);
        txtParticipantes.setColumns(20);
        txtParticipantes.setRows(5);
        jScrollPane1.setViewportView(txtParticipantes);

        jLabel2.setText("Recursos");

        txtRecursos.setEditable(false);
        txtRecursos.setColumns(20);
        txtRecursos.setRows(5);
        jScrollPane2.setViewportView(txtRecursos);

        jLabel3.setText("Fases");

        txtFases.setEditable(false);
        txtFases.setColumns(20);
        txtFases.setRows(5);
        jScrollPane3.setViewportView(txtFases);

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(lblAreaAccion)
                                .addGap(18, 18, 18)
                                .addComponent(txtAreaAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnVolver)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(lblProyecto)
                                .addGap(18, 18, 18)
                                .addComponent(cboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCoordinador)
                                .addGap(18, 18, 18)
                                .addComponent(txtCoordinador, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAvance)
                                .addGap(18, 18, 18)
                                .addComponent(txtAvance, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(113, Short.MAX_VALUE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(125, 125, 125))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProyecto)
                    .addComponent(cboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCoordinador)
                    .addComponent(txtCoordinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvance)
                    .addComponent(txtAvance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAreaAccion)
                    .addComponent(txtAreaAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverMouseClicked
        String[] args=null;
        GestionarProyectos.hostname = this.hostname;
        GestionarProyectos.usuarioActual = this.usuarioActual;
        GestionarProyectos.main(args);
        this.dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cboProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProyectosActionPerformed
        txtFases.setText("");
        txtParticipantes.setText("");
        txtRecursos.setText("");
        llenarDatos();
    }//GEN-LAST:event_cboProyectosActionPerformed

    public boolean cargarProyectos(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String sentenciaSQL = "SELECT nombre FROM proyectos;";
           
        
        try {
            Statement ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                cboProyectos.addItem(RS.getString("nombre"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
      
        return true;
    }
    
    public boolean llenarDatos(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        
        String idProyecto="";
        String sentenciaSQL = "SELECT idProyecto FROM proyectos WHERE nombre='"+cboProyectos.getSelectedItem()+"';";
        Statement ST;
        ResultSet RS;
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idProyecto= RS.getString("idProyecto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        
        
        sentenciaSQL = "SELECT miembros.nombre, proyectos.areaaccion, miembros.apellido  "
                     + "FROM proyectos INNER JOIN miembros ON proyectos.idMiembro=miembros.idMiembro "
                     + "WHERE idProyecto='"+idProyecto+"';";
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                txtCoordinador.setText(RS.getString("miembros.nombre")+" "+RS.getString("miembros.apellido"));
                txtAreaAccion.setText(RS.getString("proyectos.areaaccion"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT nombre, cedula, apellido  "
                     + "FROM participaciones_proyectos INNER JOIN miembros ON participaciones_proyectos.idMiembro=miembros.idMiembro "
                     + "WHERE idProyecto='"+idProyecto+"';";
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                txtParticipantes.setText(txtParticipantes.getText()+"Nombre: "+RS.getString("nombre")+"\n");
                txtParticipantes.setText(txtParticipantes.getText()+"Apellido: "+RS.getString("apellido")+"\n");
                txtParticipantes.setText(txtParticipantes.getText()+"Cedula: "+RS.getString("cedula")+"\n\n");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        sentenciaSQL = "SELECT recurso "
                     + "FROM recursos_proyectos "
                     + "WHERE idProyecto='"+idProyecto+"';";
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                txtRecursos.setText(txtRecursos.getText()+RS.getString("recurso")+"\n");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        int suma=0,cantidad=0;
        float avance=0;
        
        sentenciaSQL = "SELECT nombre, descripcion, fechainicio, fechafin, progreso "
                     + "FROM fases_proyectos "
                     + "WHERE idProyecto='"+idProyecto+"';";
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                txtFases.setText(txtFases.getText()+"Nombre: "+RS.getString("nombre")+"\n");
                txtFases.setText(txtFases.getText()+"Descripcion: "+RS.getString("descripcion")+"\n");
                txtFases.setText(txtFases.getText()+"FechaInicio: "+RS.getString("fechaInicio")+"\n");
                txtFases.setText(txtFases.getText()+"FechaFin: "+RS.getString("fechafin")+"\n");
                txtFases.setText(txtFases.getText()+"Progreso: "+RS.getString("progreso")+"\n\n");
                cantidad++;
                suma = suma + Integer.parseInt(RS.getString("progreso"));
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        try {
            DecimalFormat formato = new DecimalFormat("0.00");
            if(cantidad!=0)
                avance = (float)suma/(float)cantidad;
            avance= avance *100;
            txtAvance.setText(formato.format(avance)+" %");
        } catch (Exception e) {
            txtAvance.setText("0.00 %");
        }
      
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
            java.util.logging.Logger.getLogger(VerProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new VerProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cboProyectos;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAreaAccion;
    private javax.swing.JLabel lblAvance;
    private javax.swing.JLabel lblCoordinador;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JTextField txtAreaAccion;
    private javax.swing.JTextField txtAvance;
    private javax.swing.JTextField txtCoordinador;
    private javax.swing.JTextArea txtFases;
    private javax.swing.JTextArea txtParticipantes;
    private javax.swing.JTextArea txtRecursos;
    // End of variables declaration//GEN-END:variables

    
}
