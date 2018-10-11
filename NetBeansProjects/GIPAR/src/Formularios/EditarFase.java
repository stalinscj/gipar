package Formularios;

import Conexiones.ConexionMYSQL;
import Esencial.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana a través de la cual un usuario puede gestionar su cuenta o gestionar el inicio de una partida.
 * @author Stalin
 */
public class EditarFase extends javax.swing.JFrame {
    
    public static Usuario usuarioActual;
    private Fondo  imagenFondo;
    public static String hostname="";

    /**
     * Creates new form MenuSala
     */
    public EditarFase() {
        imagenFondo = new Fondo("/Imagenes/fondoSala.jpg");
        
        
        
        initComponents();
        
        
        this.setSize(imagenFondo.getWidth(),imagenFondo.getHeight());
        
        fondo.add(imagenFondo);
        fondo.setOpaque(false);

        this.setLocationRelativeTo(null);
        cargarProyectos();
        inicializarProgreso();
        
    }
    
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
    
    public void inicializarProgreso(){
        
        for(int i=0;i<=100;i++)
            cboProgreso.addItem(i);
    }
    
    public boolean validarFecha() {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse((String)cboDia.getSelectedItem()+"/"+(String)cboMes.getSelectedItem()+"/"+(String)cboAno.getSelectedItem());
            formatoFecha.parse((String)cboDia1.getSelectedItem()+"/"+(String)cboMes1.getSelectedItem()+"/"+(String)cboAno1.getSelectedItem());
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        
        Calendar tiempo = new GregorianCalendar();
        
        if(Integer.parseInt((String)cboAno.getSelectedItem())<tiempo.get(Calendar.YEAR))
            return false;
        else
            if(Integer.parseInt((String)cboAno.getSelectedItem())>tiempo.get(Calendar.YEAR))
                return true;
            else
                if(Integer.parseInt((String)cboMes.getSelectedItem())<tiempo.get(Calendar.MONTH)+1)
                    return false;
                else
                    if(Integer.parseInt((String)cboMes.getSelectedItem())>tiempo.get(Calendar.MONTH)+1)
                        return true;
                    else
                        if(Integer.parseInt((String)cboDia.getSelectedItem())<tiempo.get(Calendar.DAY_OF_MONTH))
                            return false;
                        else
                            if(Integer.parseInt((String)cboDia.getSelectedItem())>tiempo.get(Calendar.DAY_OF_MONTH))
                                return true;
        
        if(Integer.parseInt((String)cboAno1.getSelectedItem())<Integer.parseInt((String)cboAno.getSelectedItem()))
            return false;
        else
            if(Integer.parseInt((String)cboAno1.getSelectedItem())>Integer.parseInt((String)cboAno.getSelectedItem()))
                return true;
            else
                if(Integer.parseInt((String)cboMes1.getSelectedItem())<Integer.parseInt((String)cboMes.getSelectedItem()))
                    return false;
                else
                    if(Integer.parseInt((String)cboMes1.getSelectedItem())>Integer.parseInt((String)cboMes.getSelectedItem()))
                        return true;
                    else
                        if(Integer.parseInt((String)cboDia1.getSelectedItem())<Integer.parseInt((String)cboDia.getSelectedItem()))
                            return false;
                        else
                            if(Integer.parseInt((String)cboDia1.getSelectedItem())>Integer.parseInt((String)cboDia.getSelectedItem()))
                                return true;
                            
        return true;
    }
    
    public boolean cargarFases(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        
        String idProyecto="";
        String sentenciaSQL = "SELECT idProyecto FROM proyectos WHERE nombre='"+cboProyectos.getSelectedItem()+"'";
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
        
        sentenciaSQL = "SELECT nombre FROM fases_proyectos WHERE idProyecto='"+idProyecto+"'";
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            while(RS.next()){
                cboFase.addItem(RS.getString("nombre"));
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
        
        sentenciaSQL = "SELECT * "
                     + "FROM fases_proyectos "
                     + "WHERE idProyecto='"+idProyecto+"' AND nombre='"+cboFase.getSelectedItem()+"';";
        String fechaInicio[],fechaFin[];
        try {
            ST = conexion.createStatement();
            RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                txtNombre.setText(RS.getString("nombre"));
                txtDescripcion.setText(RS.getString("descripcion"));
                cboProgreso.setSelectedItem(RS.getString("progreso"));
                fechaFin = RS.getString("fechaFin").split("-");
                fechaInicio = RS.getString("fechainicio").split("-");
                cboAno.setSelectedItem(fechaInicio[0]);
                cboAno1.setSelectedItem(fechaFin[0]);
                cboMes.setSelectedItem(fechaInicio[1]);
                cboMes1.setSelectedItem(fechaFin[1]);
                cboDia.setSelectedItem(fechaInicio[2]);
                cboDia1.setSelectedItem(fechaFin[2]);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        
        
      
        return true;
    }
    
    
    
    public boolean guardar(){
        
        String usuario;
        if(this.usuarioActual.getCargo().equalsIgnoreCase("Miembro"))
            usuario="miembro";
        else
            usuario="miembrogipar";
        
        String idProyecto,idFase;
        ConexionMYSQL mysql = new ConexionMYSQL(hostname,"bdgipar",usuario);
        Connection conexion = mysql.conectar();
        String sentenciaSQL = "";
        
        idProyecto="";
        sentenciaSQL = "SELECT idProyecto FROM proyectos WHERE nombre='"+cboProyectos.getSelectedItem()+"'";
        Statement ST;
        try {
            ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idProyecto= RS.getString("idProyecto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        idFase="";
        sentenciaSQL = "SELECT idFase FROM fases_proyectos WHERE idProyecto='"+idProyecto+"' AND nombre='"+cboFase.getSelectedItem()+"'";
        try {
            ST = conexion.createStatement();
            ResultSet RS = ST.executeQuery(sentenciaSQL);
            
            if(RS.next()){
                idFase= RS.getString("idFase");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        String fechaInicio = cboAno.getSelectedItem()+"-"+cboMes.getSelectedItem()+"-"+cboDia.getSelectedItem();
        String fechaFin = cboAno1.getSelectedItem()+"-"+cboMes1.getSelectedItem()+"-"+cboDia1.getSelectedItem();
        
        sentenciaSQL = "UPDATE fases_proyectos "
                     + "SET nombre = '"+txtNombre.getText()+"', descripcion='"+txtDescripcion.getText()
                     + "', fechainicio='"+fechaInicio+"', fechafin='"+fechaFin+"', progreso='"+cboProgreso.getSelectedItem()+"' "
                     + "WHERE idFase = '"+idFase+"';";
        
        PreparedStatement PST;
        try {
            PST = conexion.prepareStatement(sentenciaSQL);
            
            if(PST.executeUpdate()>0){
                JOptionPane.showMessageDialog(this, "Fase editada satisfactoriamente");
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Ha ocurrido un ERROR a la hora de editar la fase");
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return false;
        }
        return true;
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
        btnGuardar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        cboDia = new javax.swing.JComboBox();
        lblMes = new javax.swing.JLabel();
        cboMes = new javax.swing.JComboBox();
        lblAno = new javax.swing.JLabel();
        cboAno = new javax.swing.JComboBox();
        lblDia1 = new javax.swing.JLabel();
        cboDia1 = new javax.swing.JComboBox();
        lblMes1 = new javax.swing.JLabel();
        cboMes1 = new javax.swing.JComboBox();
        lblAno1 = new javax.swing.JLabel();
        cboAno1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        lblFase = new javax.swing.JLabel();
        cboFase = new javax.swing.JComboBox();
        lblProgreso = new javax.swing.JLabel();
        cboProgreso = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(0, 153, 0));

        btnVolver.setText("Volver");
        btnVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVolverMouseClicked(evt);
            }
        });

        lblProyecto.setText("Proyecto:");

        cboProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProyectosActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        lblNombre.setText("Nuevo Nombre:");

        jLabel1.setText("Descripcion");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel2.setText("Fecha de Inicio");

        lblDia.setText("Dia:");

        cboDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDiaActionPerformed(evt);
            }
        });

        lblMes.setText("Mes:");

        cboMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        lblAno.setText("Año:");

        cboAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        lblDia1.setText("Dia:");

        cboDia1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cboDia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboDia1ActionPerformed(evt);
            }
        });

        lblMes1.setText("Mes:");

        cboMes1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        lblAno1.setText("Año:");

        cboAno1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025" }));

        jLabel3.setText("Fecha de Fin");

        lblFase.setText("Fase:");

        cboFase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboFaseActionPerformed(evt);
            }
        });

        lblProgreso.setText("Progreso:");

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jLabel2))
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel3))
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblFase)
                                            .addGroup(fondoLayout.createSequentialGroup()
                                                .addComponent(lblDia)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblMes)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lblAno)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cboFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(fondoLayout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addComponent(lblProyecto)
                        .addGap(18, 18, 18)
                        .addComponent(cboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(lblDia1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMes1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAno1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboAno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(lblProgreso)
                                .addGap(18, 18, 18)
                                .addComponent(cboProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProyecto)
                    .addComponent(cboProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblFase)
                    .addComponent(cboFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMes)
                            .addComponent(lblAno)
                            .addComponent(lblDia)
                            .addComponent(cboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMes1)
                    .addComponent(lblAno1)
                    .addComponent(lblDia1)
                    .addComponent(cboDia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProgreso)
                    .addComponent(cboProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
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
        GestionarProyectos.hostname = this.hostname;
        GestionarProyectos.usuarioActual = this.usuarioActual;
        GestionarProyectos.main(args);
        this.dispose();
    }//GEN-LAST:event_btnVolverMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if(validarFecha()){
            guardar();
            cboFase.removeAllItems();
            cargarFases();
        }
        else
            JOptionPane.showMessageDialog(this, "Fechas invalidas");
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void cboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDiaActionPerformed

    private void cboDia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboDia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboDia1ActionPerformed

    private void cboProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProyectosActionPerformed
        cboFase.removeAllItems();
        cargarFases();
    }//GEN-LAST:event_cboProyectosActionPerformed

    private void cboFaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboFaseActionPerformed
        llenarDatos();
    }//GEN-LAST:event_cboFaseActionPerformed

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
            java.util.logging.Logger.getLogger(EditarFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarFase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new EditarFase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cboAno;
    private javax.swing.JComboBox cboAno1;
    private javax.swing.JComboBox cboDia;
    private javax.swing.JComboBox cboDia1;
    private javax.swing.JComboBox cboFase;
    private javax.swing.JComboBox cboMes;
    private javax.swing.JComboBox cboMes1;
    private javax.swing.JComboBox cboProgreso;
    private javax.swing.JComboBox cboProyectos;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblAno1;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblDia1;
    private javax.swing.JLabel lblFase;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblMes1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JLabel lblProyecto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    
}
