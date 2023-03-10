package Parte_grafica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * 
 *
 * @author User
 */

public class frm_control_usuario extends javax.swing.JFrame {

    //Declarando el nombre de la tabla
    DefaultTableModel Usuarios;
    
    public frm_control_usuario() {
        initComponents();
        
        this.Usuarios = (DefaultTableModel) table_usuario.getModel();
        Mostrardatos("");
        
    }
    
    public final void Mostrardatos (String valor){
        //Función para mostrar datos en la tabla
        MyConnection cc = new MyConnection();
        Connection cn = MyConnection.getConnection();
        
        Refrescartabla();
        
        Usuarios.addColumn("id_usuario"); 
        Usuarios.addColumn("usuario");
        Usuarios.addColumn("contrasena");
        Usuarios.addColumn("nombre"); 
        Usuarios.addColumn("apellido");
        Usuarios.addColumn("correo");
        Usuarios.addColumn("rol");
        
        this.table_usuario.setModel(Usuarios);
        
        String sql;
        if (valor.equals("")){
            sql = "SELECT * FROM usuarios";
        }
        else{
            sql = "SELECT * FROM usuarios WHERE usuario='"+valor+"'";
        }
        
        String[] datos = new String[6];
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                datos[5]=rs.getString(6);
                
                Usuarios.addRow(datos);
                
            }
            
            table_usuario.setModel(Usuarios);
        } 
        
        catch (SQLException ex){
            Logger.getLogger(frm_control_usuario.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }
    
    public void Refrescartabla(){
        //Función para refrescar la tabla
        try{
            Usuarios.setColumnCount(0);
            Usuarios.setRowCount(0);
            table_usuario.revalidate();
        }
        
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }
    

    public boolean RevisarUsuario(String usuario){
        //Función para revisar si el usuario existe dentro de la base de datos
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `usuarios` WHERE `usuario` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, usuario);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
        }   
        
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        
        return checkUser;
    }
    
    
    public void Borrar(){
    //Esta función es para limpiar los valores ingresados en los text field
        try{
            txt_usuario.setText("");
            txt_contrasena.setText("");
            txt_nombre.setText("");
            txt_apellido.setText("");
            txt_correo.setText("");
            cmb_rol.setSelectedIndex(0);
        }

        catch (Exception ex){
            JOptionPane.showInternalMessageDialog(null, "Error" +ex);
        }
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_bg1 = new javax.swing.JPanel();
        pnl_bg2 = new javax.swing.JPanel();
        line1 = new javax.swing.JSeparator();
        lb_control_usuario = new javax.swing.JLabel();
        img_logo = new javax.swing.JLabel();
        lb_usuario = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        line2 = new javax.swing.JSeparator();
        lb_contrasena = new javax.swing.JLabel();
        line3 = new javax.swing.JSeparator();
        lb_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        line4 = new javax.swing.JSeparator();
        lb_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        line5 = new javax.swing.JSeparator();
        lb_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        line6 = new javax.swing.JSeparator();
        lb_rol = new javax.swing.JLabel();
        cmb_rol = new javax.swing.JComboBox<>();
        pnl_btn_borrar = new javax.swing.JPanel();
        lb_borrar = new javax.swing.JLabel();
        pnl_btn_guardar = new javax.swing.JPanel();
        lb_guardar = new javax.swing.JLabel();
        txt_contrasena = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_usuario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de usuario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_bg1.setBackground(new java.awt.Color(255, 255, 255));

        pnl_bg2.setBackground(new java.awt.Color(1, 166, 190));

        line1.setPreferredSize(new java.awt.Dimension(2, 4));

        lb_control_usuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_control_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lb_control_usuario.setText("Control de usuario");

        javax.swing.GroupLayout pnl_bg2Layout = new javax.swing.GroupLayout(pnl_bg2);
        pnl_bg2.setLayout(pnl_bg2Layout);
        pnl_bg2Layout.setHorizontalGroup(
            pnl_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bg2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_control_usuario)
                    .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(465, Short.MAX_VALUE))
        );
        pnl_bg2Layout.setVerticalGroup(
            pnl_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bg2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_control_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lb_usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_usuario.setText("Usuario:");

        txt_usuario.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txt_usuario.setBorder(null);
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });

        line2.setForeground(new java.awt.Color(0, 0, 0));

        lb_contrasena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_contrasena.setText("Contraseña:");

        line3.setForeground(new java.awt.Color(0, 0, 0));

        lb_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nombre.setText("Nombre:");

        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txt_nombre.setBorder(null);

        line4.setForeground(new java.awt.Color(0, 0, 0));

        lb_apellido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_apellido.setText("Apellido:");

        txt_apellido.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txt_apellido.setBorder(null);

        line5.setForeground(new java.awt.Color(0, 0, 0));

        lb_correo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_correo.setText("Correo:");

        txt_correo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txt_correo.setBorder(null);

        line6.setForeground(new java.awt.Color(0, 0, 0));

        lb_rol.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_rol.setText("Rol:");

        cmb_rol.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        cmb_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        pnl_btn_borrar.setBackground(new java.awt.Color(1, 166, 190));
        pnl_btn_borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_btn_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_btn_borrarMousePressed(evt);
            }
        });

        lb_borrar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lb_borrar.setForeground(new java.awt.Color(255, 255, 255));
        lb_borrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_borrar.setText("BORRAR");
        lb_borrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_borrarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnl_btn_borrarLayout = new javax.swing.GroupLayout(pnl_btn_borrar);
        pnl_btn_borrar.setLayout(pnl_btn_borrarLayout);
        pnl_btn_borrarLayout.setHorizontalGroup(
            pnl_btn_borrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnl_btn_borrarLayout.setVerticalGroup(
            pnl_btn_borrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_btn_borrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_borrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_btn_guardar.setBackground(new java.awt.Color(1, 166, 190));
        pnl_btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnl_btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnl_btn_guardarMousePressed(evt);
            }
        });

        lb_guardar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lb_guardar.setForeground(new java.awt.Color(255, 255, 255));
        lb_guardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_guardar.setText("GUARDAR");
        lb_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lb_guardarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnl_btn_guardarLayout = new javax.swing.GroupLayout(pnl_btn_guardar);
        pnl_btn_guardar.setLayout(pnl_btn_guardarLayout);
        pnl_btn_guardarLayout.setHorizontalGroup(
            pnl_btn_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnl_btn_guardarLayout.setVerticalGroup(
            pnl_btn_guardarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_btn_guardarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_guardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_contrasena.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txt_contrasena.setBorder(null);

        table_usuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_usuario);

        javax.swing.GroupLayout pnl_bg1Layout = new javax.swing.GroupLayout(pnl_bg1);
        pnl_bg1.setLayout(pnl_bg1Layout);
        pnl_bg1Layout.setHorizontalGroup(
            pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bg1Layout.createSequentialGroup()
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                        .addComponent(pnl_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                                        .addComponent(lb_contrasena)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_contrasena))
                                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                                        .addComponent(lb_apellido)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addComponent(line4)
                                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                                        .addComponent(lb_usuario)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_usuario))
                                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                                        .addComponent(lb_nombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_nombre))
                                    .addComponent(line2)
                                    .addComponent(line5)
                                    .addComponent(line3))
                                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(line6, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                                        .addComponent(lb_correo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_correo))
                                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                                        .addComponent(lb_rol)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(pnl_bg1Layout.createSequentialGroup()
                                .addComponent(pnl_btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnl_btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnl_bg1Layout.setVerticalGroup(
            pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bg1Layout.createSequentialGroup()
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pnl_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_usuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_contrasena)
                            .addComponent(txt_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(line3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_apellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_correo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(line6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_rol)
                            .addComponent(cmb_rol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl_btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(304, 304, 304))
        );

        getContentPane().add(pnl_bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_btn_borrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_btn_borrarMousePressed
       Borrar();    
    }//GEN-LAST:event_pnl_btn_borrarMousePressed

    private void lb_borrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_borrarMousePressed
        Borrar();
    }//GEN-LAST:event_lb_borrarMousePressed

    private void pnl_btn_guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_btn_guardarMousePressed
        //Botón para registrar datos nuevos a la BD
        String usu = txt_usuario.getText();
        String cont = String.valueOf(txt_contrasena.getPassword());
        String nom = txt_nombre.getText();
        String ape = txt_apellido.getText();
        String cor = txt_correo.getText();
        String rol = String.valueOf(cmb_rol.getSelectedIndex());

                
        if(usu.equals("")){
            JOptionPane.showMessageDialog(null, "Agrega un Usuario");
        }
        
        else if(cont.equals("")){
            JOptionPane.showMessageDialog(null, "Agrega una Contraseña");
        }      
        else if(RevisarUsuario(usu)){
            JOptionPane.showMessageDialog(null, "Este Usuario ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `usuarios`(`usuario`, `contrasena`, `nombre`, `apellido`, `correo`, `rol`) VALUES (?,?,?,?,?,?)";
       
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, usu);
            ps.setString(2, cont);
            ps.setString(3, nom);
            ps.setString(4, ape);
            ps.setString(5, cor);
            ps.setString(6, rol);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Nuevo Usuario Agregado");
                Mostrardatos("");
                Borrar();
            }
            } 
        
        catch (SQLException ex){
            Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }//GEN-LAST:event_pnl_btn_guardarMousePressed

    private void lb_guardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_guardarMousePressed
       //Botón para registrar datos nuevos a la BD
        String usu = txt_usuario.getText();
        String cont = String.valueOf(txt_contrasena.getPassword());
        String nom = txt_nombre.getText();
        String ape = txt_apellido.getText();
        String cor = txt_correo.getText();
        String rol = String.valueOf(cmb_rol.getSelectedIndex());

                
        if(usu.equals("")){
            JOptionPane.showMessageDialog(null, "Agrega un Usuario");
        }
        
        else if(cont.equals("")){
            JOptionPane.showMessageDialog(null, "Agrega una Contraseña");
        }      
        else if(RevisarUsuario(usu)){
            JOptionPane.showMessageDialog(null, "Este Usuario ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `usuarios`(`usuario`, `contrasena`, `nombre`, `apellido`, `correo`, `rol`) VALUES (?,?,?,?,?,?)";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
            ps.setString(1, usu);
            ps.setString(2, cont);
            ps.setString(3, nom);
            ps.setString(4, ape);
            ps.setString(5, cor);
            ps.setString(6, rol);
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Nuevo Usuario Agregado");
                Mostrardatos("");
                Borrar();
            }
            } 
        
        catch (SQLException ex){
            Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }//GEN-LAST:event_lb_guardarMousePressed

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

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
            java.util.logging.Logger.getLogger(frm_control_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_control_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_control_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_control_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_control_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_rol;
    private javax.swing.JLabel img_logo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_apellido;
    private javax.swing.JLabel lb_borrar;
    private javax.swing.JLabel lb_contrasena;
    private javax.swing.JLabel lb_control_usuario;
    private javax.swing.JLabel lb_correo;
    private javax.swing.JLabel lb_guardar;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_rol;
    private javax.swing.JLabel lb_usuario;
    private javax.swing.JSeparator line1;
    private javax.swing.JSeparator line2;
    private javax.swing.JSeparator line3;
    private javax.swing.JSeparator line4;
    private javax.swing.JSeparator line5;
    private javax.swing.JSeparator line6;
    private javax.swing.JPanel pnl_bg1;
    private javax.swing.JPanel pnl_bg2;
    private javax.swing.JPanel pnl_btn_borrar;
    private javax.swing.JPanel pnl_btn_guardar;
    private javax.swing.JTable table_usuario;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JPasswordField txt_contrasena;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
