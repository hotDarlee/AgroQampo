package Parte_grafica;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class frm_producto extends javax.swing.JFrame {
    //Para el funcionamiento de la tabla
    DefaultTableModel Productos;    
        
    //Esto es parte del evento que filtra la información de un textfield para que se presente en la tabla 
    TableRowSorter trs;
    
    //Variables globales para la conexión de la base de datos
    PreparedStatement ps;
    ResultSet rs;
    
    //Instancias globales para la conexión de la base de datos
    Connection cn = MyConnection.getConnection();
    MyConnection cc = new MyConnection();

    
    public frm_producto() {
        initComponents();
        
        //Para poner la pantalla centralizada
        this.setLocationRelativeTo(null);
        
        //Parte perteneciente a la tabla
        this.Productos = (DefaultTableModel) table_producto.getModel();
        MostrarDatos("");       
    }
    
    public final void MostrarDatos (String valor){
        //Función para mostrar datos en la tabla
        
        RefrescarTabla();
        
        Productos.addColumn("id_producto");
        Productos.addColumn("nom_producto");  
        Productos.addColumn("categoria");        
        Productos.addColumn("desc_producto");
        Productos.addColumn("id_proveedor");
        Productos.addColumn("fecha_creacion");
        Productos.addColumn("fecha_vencimiento");
        Productos.addColumn("precio_compra");
        Productos.addColumn("precio_venta");
        Productos.addColumn("cantidad");
        
        this.table_producto.setModel(Productos);
        
        String sql;
        if (valor.equals("")){
            sql = "SELECT * FROM producto";
        }
        else{
            sql = "SELECT * FROM producto WHERE nom_producto='"+valor+"'";
        }
        
        String[] datos = new String[10];
        
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
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
                datos[8]=rs.getString(9);
                datos[9]=rs.getString(10);
                
                Productos.addRow(datos);
                
            }
            
            table_producto.setModel(Productos);
        }      
        catch (SQLException ex){
            Logger.getLogger(frm_control_usuario.class.getName()).log(Level.SEVERE,null,ex);
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }
    
    public void RefrescarTabla(){
        //Función para refrescar la tabla
        try{
            Productos.setColumnCount(0);
            Productos.setRowCount(0);
            table_producto.revalidate();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error " + ex);
        }
    }
    
    public boolean RevisarProducto(String nombre){
        //Función para revisar si el producto existe dentro de la base de datos
        boolean checkProd = false;
        String query = "SELECT * FROM `producto` WHERE `nom_producto` =?";
        
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, nombre);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkProd = true;
            }
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        
        return checkProd;
    }
    
    public void Limpiar(){
        //Esta función es para limpiar los valores ingresados en los textfield
        try{
            txt_nombre.setText("");
            txt_categoria.setText("");           
            txt_desc.setText("");
            txt_proveedor.setText("");
            txt_fecha_v.setText("");  
            txt_fecha_c.setText("");  
            txt_precio_v.setText("");            
            txt_precio_c.setText("");    
            txt_cantidad.setText("");
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
        lb_producto = new javax.swing.JLabel();
        img_logo = new javax.swing.JLabel();
        lb_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lb_categoria = new javax.swing.JLabel();
        txt_categoria = new javax.swing.JTextField();
        lb_desc = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        lb_proveedor = new javax.swing.JLabel();
        txt_proveedor = new javax.swing.JTextField();
        lb_fecha_c = new javax.swing.JLabel();
        txt_fecha_c = new javax.swing.JTextField();
        lb_fecha_v = new javax.swing.JLabel();
        txt_fecha_v = new javax.swing.JTextField();
        lb_precio_c = new javax.swing.JLabel();
        txt_precio_c = new javax.swing.JTextField();
        lb_precio_v = new javax.swing.JLabel();
        txt_precio_v = new javax.swing.JTextField();
        lb_cantidad = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_producto = new javax.swing.JTable();
        btn_borrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_imprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Producto");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_bg1.setBackground(new java.awt.Color(255, 255, 255));

        pnl_bg2.setBackground(new java.awt.Color(1, 166, 190));

        line1.setPreferredSize(new java.awt.Dimension(2, 4));

        lb_producto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_producto.setForeground(new java.awt.Color(255, 255, 255));
        lb_producto.setText("Producto");

        javax.swing.GroupLayout pnl_bg2Layout = new javax.swing.GroupLayout(pnl_bg2);
        pnl_bg2.setLayout(pnl_bg2Layout);
        pnl_bg2Layout.setHorizontalGroup(
            pnl_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bg2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnl_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_producto)
                    .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(564, Short.MAX_VALUE))
        );
        pnl_bg2Layout.setVerticalGroup(
            pnl_bg2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bg2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_producto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        img_logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Proyecto_AgroQampo\\src\\Imagenes\\Logo_1.png")); // NOI18N

        lb_nombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_nombre.setText("Nombre:");

        txt_nombre.setBackground(new java.awt.Color(230, 230, 230));
        txt_nombre.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });

        lb_categoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_categoria.setText("Categoría:");

        txt_categoria.setBackground(new java.awt.Color(230, 230, 230));
        txt_categoria.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_desc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_desc.setText("Descripción:");

        txt_desc.setBackground(new java.awt.Color(230, 230, 230));
        txt_desc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_proveedor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_proveedor.setText("Proveedor:");

        txt_proveedor.setBackground(new java.awt.Color(230, 230, 230));
        txt_proveedor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_fecha_c.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_fecha_c.setText("Fecha creación:");

        txt_fecha_c.setBackground(new java.awt.Color(230, 230, 230));
        txt_fecha_c.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_fecha_v.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_fecha_v.setText("Fecha vencimiento:");

        txt_fecha_v.setBackground(new java.awt.Color(230, 230, 230));
        txt_fecha_v.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_precio_c.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_precio_c.setText("Precio de compra:");

        txt_precio_c.setBackground(new java.awt.Color(230, 230, 230));
        txt_precio_c.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_precio_v.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_precio_v.setText("Precio de venta:");

        txt_precio_v.setBackground(new java.awt.Color(230, 230, 230));
        txt_precio_v.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        lb_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_cantidad.setText("Cantidad:");

        txt_cantidad.setBackground(new java.awt.Color(230, 230, 230));
        txt_cantidad.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        table_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_producto.setColumnSelectionAllowed(true);
        table_producto.setUpdateSelectionOnSort(false);
        table_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_producto);

        btn_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Borrar.png"))); // NOI18N
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_modificar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Proyecto_AgroQampo\\src\\Imagenes\\Modificar.png")); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Proyecto_AgroQampo\\src\\Imagenes\\Guardar.png")); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_imprimir.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\NetBeansProjects\\Proyecto_AgroQampo\\src\\Imagenes\\Imprimir.png")); // NOI18N
        btn_imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_bg1Layout = new javax.swing.GroupLayout(pnl_bg1);
        pnl_bg1.setLayout(pnl_bg1Layout);
        pnl_bg1Layout.setHorizontalGroup(
            pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bg1Layout.createSequentialGroup()
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_bg1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_bg1Layout.createSequentialGroup()
                                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_proveedor)
                                    .addComponent(lb_fecha_v)
                                    .addComponent(lb_fecha_c)
                                    .addComponent(lb_precio_c)
                                    .addComponent(lb_cantidad)
                                    .addComponent(lb_precio_v)
                                    .addComponent(lb_desc)
                                    .addComponent(lb_categoria)
                                    .addComponent(lb_nombre)
                                    .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_cantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                        .addComponent(txt_precio_v, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_precio_c, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_fecha_v, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_fecha_c, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_proveedor, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_desc, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_categoria, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_bg1Layout.createSequentialGroup()
                                .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_bg1Layout.createSequentialGroup()
                        .addComponent(pnl_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        pnl_bg1Layout.setVerticalGroup(
            pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bg1Layout.createSequentialGroup()
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pnl_bg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bg1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(lb_nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_bg1Layout.createSequentialGroup()
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_categoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(lb_desc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_proveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_fecha_c, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_bg1Layout.createSequentialGroup()
                                .addComponent(lb_fecha_c)
                                .addGap(30, 30, 30)))
                        .addGap(18, 18, 18)
                        .addComponent(lb_fecha_v)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fecha_v, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_precio_c, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bg1Layout.createSequentialGroup()
                                .addComponent(lb_precio_c)
                                .addGap(30, 30, 30)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_precio_v)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_precio_v, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bg1Layout.createSequentialGroup()
                                .addComponent(lb_cantidad)
                                .addGap(30, 30, 30))))
                    .addComponent(jScrollPane1))
                .addGap(36, 36, 36)
                .addGroup(pnl_bg1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_borrar)
                    .addComponent(btn_guardar)
                    .addComponent(btn_modificar)
                    .addComponent(btn_imprimir))
                .addGap(76, 76, 76))
        );

        getContentPane().add(pnl_bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        //Botón para borrar un registro de la tabla y de la base de datos
        String id = (String) table_producto.getValueAt(table_producto.getSelectedRow(),0) ;
        
        String query = "DELETE FROM producto WHERE id_producto=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, id);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                
                //Funciones para mostrar los datos en la tabla  y para limpiar los textfields
                Limpiar();
                MostrarDatos(""); 
            }           
        } 
        catch (SQLException ex) {
            Logger.getLogger(frm_producto.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        //Botón para registrar datos nuevos a la base de datos
        String nombre = txt_nombre.getText();
        String categoria = txt_categoria.getText();     
        String descripcion = txt_desc.getText();
        String proveedor = txt_proveedor.getText(); 
        String fecha_c = txt_fecha_c.getText();        
        String fecha_v = txt_fecha_v.getText();  
        String precio_c = txt_precio_c.getText();        
        String precio_v = txt_precio_v.getText();
        String cantidad = txt_cantidad.getText();

        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Agrega un nombre de producto");
        }

        else if(categoria.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege una categoría de producto"); 
        }
        
        else if(proveedor.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege un proveedor de producto"); 
        }        
        
        else if(fecha_c.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege una fecha de creación del producto"); 
        }        
        
        else if(fecha_v.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege una fecha de vencimiento del producto"); 
        }        
        
        else if(precio_c.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege el precio de compra"); 
        }
        
        else if(precio_v.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege el precio de venta"); 
        }       

        else if(cantidad.equals("")){
            JOptionPane.showMessageDialog(null, "Agrege la cantidad existente que hay de producto"); 
        }        
        
        else if(RevisarProducto(nombre)){
            JOptionPane.showMessageDialog(null, "Este producto ya existe");
        }
        else{
            PreparedStatement ps;
            String query = "INSERT INTO `producto`(`nom_producto`, `categoria`, `desc_producto`, `proveedor`, `fecha_creacion`, `fecha_vencimiento`, `precio_compra`, `precio_venta`, `cantidad`) VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                ps = MyConnection.getConnection().prepareStatement(query);

                ps.setString(1, nombre);
                ps.setString(2, categoria);
                ps.setString(3, descripcion);
                ps.setString(4, proveedor);                
                ps.setString(5, fecha_c);
                ps.setString(6, fecha_v);
                ps.setString(7, precio_c);
                ps.setString(8, precio_v);                
                ps.setString(9, cantidad);
                
                if(ps.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(null, "Nuevo producto agregado");
                    
                    //Funciones para mostrar los datos en la tabla cuando se guarden y para limpiar los textfields
                    MostrarDatos("");
                    Limpiar();
                }
            }
            catch (SQLException ex){
                Logger.getLogger(frm_main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        //Botón para actualizar o modificar los datos de la base de datos               
        try{
            String id = (String) Productos.getValueAt(table_producto.getSelectedRow(), 0);
            String nombre = txt_nombre.getText();
            String categoria = txt_categoria.getText();
            String descripcion = txt_desc.getText();
            String proveedor = txt_proveedor.getText();
            String fecha_c = txt_fecha_c.getText();
            String fecha_v = txt_fecha_v.getText();
            String precio_c = txt_precio_c.getText();
            String precio_v = txt_precio_v.getText();
            String cantidad = txt_cantidad.getText();
            
            String query = "UPDATE `producto` SET nom_producto='"+nombre+"', categoria='"+categoria+"', desc_producto='"+descripcion+"', proveedor='"+proveedor+"', fecha_creacion='"+fecha_c+"', fecha_vencimiento='"+fecha_v+"', precio_compra='"+precio_c+"', precio_venta='"+precio_v+"', cantidad='"+cantidad+"' WHERE id_producto='"+id+"'";
            
            ps = cn.prepareStatement(query);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Producto actualizado");
            
            //Funciones para mostrar los datos en la tabla cuando se actualicen y para limpiar los textfields
            MostrarDatos("");
            Limpiar();         
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);                     
        }  
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void table_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productoMouseClicked
        //Este evento realiza una accion que al topar un dato de la tabla se rellenan los textfiels
        //Esto también es parte del botón de borrar y actualizar
        this.txt_nombre.setText(Productos.getValueAt(table_producto.getSelectedRow(),1).toString());
        this.txt_categoria.setText(Productos.getValueAt(table_producto.getSelectedRow(),2).toString());
        this.txt_desc.setText(Productos.getValueAt(table_producto.getSelectedRow(),3).toString());
        this.txt_proveedor.setText(Productos.getValueAt(table_producto.getSelectedRow(),4).toString());
        this.txt_fecha_c.setText(Productos.getValueAt(table_producto.getSelectedRow(),5).toString());
        this.txt_fecha_v.setText((String) Productos.getValueAt(table_producto.getSelectedRow(),6));
        this.txt_precio_c.setText((String) Productos.getValueAt(table_producto.getSelectedRow(),7));
        this.txt_precio_v.setText((String) Productos.getValueAt(table_producto.getSelectedRow(),8));
        this.txt_cantidad.setText((String) Productos.getValueAt(table_producto.getSelectedRow(),9));
    }//GEN-LAST:event_table_productoMouseClicked

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        //Evento que filtra la información de un textfield para que se presente en la tabla      
        txt_nombre.addKeyListener(new KeyAdapter(){
        
            @Override
            public void keyReleased(KeyEvent ke){
            
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txt_nombre.getText(), 1));               
            }
        });
        
        trs = new TableRowSorter(Productos);
        table_producto.setRowSorter(trs);
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void btn_imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imprimirActionPerformed
        //Botón para imprimir reporte
        Connection con = MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_producto.class.getResource("/Reportes/Reporte_producto.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("Titulo", "Reporte de producto");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_imprimirActionPerformed

    
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
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_producto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_producto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_imprimir;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel img_logo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_cantidad;
    private javax.swing.JLabel lb_categoria;
    private javax.swing.JLabel lb_desc;
    private javax.swing.JLabel lb_fecha_c;
    private javax.swing.JLabel lb_fecha_v;
    private javax.swing.JLabel lb_nombre;
    private javax.swing.JLabel lb_precio_c;
    private javax.swing.JLabel lb_precio_v;
    private javax.swing.JLabel lb_producto;
    private javax.swing.JLabel lb_proveedor;
    private javax.swing.JSeparator line1;
    private javax.swing.JPanel pnl_bg1;
    private javax.swing.JPanel pnl_bg2;
    private javax.swing.JTable table_producto;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_fecha_c;
    private javax.swing.JTextField txt_fecha_v;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_precio_c;
    private javax.swing.JTextField txt_precio_v;
    private javax.swing.JTextField txt_proveedor;
    // End of variables declaration//GEN-END:variables

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
