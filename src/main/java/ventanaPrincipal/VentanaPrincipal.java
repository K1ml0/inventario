/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanaPrincipal;

import Login.Diseño_login;
import static Login.Diseño_login.Estado_ventana_Principal;
import static Login.crearCuenta.mostrarMensajeError;
import static Login.crearCuenta.mostrarMensajeExito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Ventana_productos.Ventana_ingreso_productos;
import com.mycompany.main.main;
import conex.conexion;
import static conex.conexion.PASSWORD;
import java.awt.AWTException;
import java.awt.CardLayout;
import java.awt.Choice;
import java.awt.Font;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Properties;



import javax.swing.*;
import org.jdatepicker.impl.*;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;




/**
 *
 * @author juand
 */
public class VentanaPrincipal extends javax.swing.JFrame 
{

    /**
     * Creates new form VentanaPrincipal
     */
    private JDatePickerImpl datePicker;
    public VentanaPrincipal() {
       
        initComponents();
       customInitComponents(); 
       STOKaGOTADO();
       
        jPanel6.setVisible(false);
        jPanel15.setVisible(false);
      
        //cargamos la ruta de la imagen
        ImageIcon logo = new ImageIcon("");
        //establecemos la imagen como icono
        setIconImage(logo.getImage());

  

        setLocationRelativeTo(null);
        SetImageLabel(jLabel2, "src/main/java/imagenes/fondo1.jpg");
     
        SetImageLabel(jLabel9, "src/main/java/imagenes/Cliente.png");
        SetImageLabel(jLabel10, "src/main/java/imagenes/provedores.png");
        SetImageLabel(jLabel11, "src/main/java/imagenes/empleados.png");
      
        
        Estado_ventana_Principal = true;
    }
     private void customInitComponents() {
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("F Entrada");
            model.addColumn("F Fabricacion");
            model.addColumn("F Vencimiento");
            model.addColumn("Nombre");
            model.addColumn("Precio");
            model.addColumn("Categoria");
            model.addColumn("Cantidad");
            model.addColumn("Precio");
            model.addColumn("Lote");
            model.addColumn("Descripcion");
            model.addColumn("Codigo");
            model.addColumn("Detalles");

            // Crear la tabla y configurar el renderizador y editor de botones
            JTable table = new JTable(model);
            table.getColumnModel().getColumn(12).setCellRenderer(new ButtonRenderer());
            table.getColumnModel().getColumn(12).setCellEditor(new ButtonEditor(new JCheckBox()));

            table.setRowHeight(25);
            table.setFont(new Font("Arial", Font.PLAIN, 10));

            JScrollPane jScrollPane = new JScrollPane(table);
            jPanel3.setLayout(new BorderLayout()); // Asegurarse de que el layout sea BorderLayout
            jPanel3.add(jScrollPane, BorderLayout.CENTER);

            // Crear un temporizador para actualizar los datos
            Timer timer = new Timer(5000, new ActionListener() { // Actualiza cada 5000 ms (5 segundos)
                @Override
                public void actionPerformed(ActionEvent e) {
                    loadDataFromDatabase(model);
                }
            });
            timer.start(); // Iniciar el temporizador
        // Actualizar el panel para reflejar los cambios
        jPanel16.revalidate();
        jPanel16.repaint();
    }
    private void STOKaGOTADO() {
        DefaultTableModel modelSTOCK = new DefaultTableModel();
            modelSTOCK.addColumn("ID");
            modelSTOCK.addColumn("Nombre");
            modelSTOCK.addColumn("cantidad");
            modelSTOCK.addColumn("codigoProducto");
            modelSTOCK.addColumn("Detalles");

            // Crear la tabla y configurar el renderizador y editor de botones
            JTable tableSTOCK = new JTable(modelSTOCK);
            tableSTOCK.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
            tableSTOCK.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JCheckBox()));

            tableSTOCK.setRowHeight(25);
            tableSTOCK.setFont(new Font("Arial", Font.PLAIN, 10));

            JScrollPane jScrollPane = new JScrollPane(tableSTOCK);
            jPanel4.setLayout(new BorderLayout()); // Asegurarse de que el layout sea BorderLayout
            jPanel4.add(jScrollPane, BorderLayout.CENTER);
            
             Timer timer = new Timer(5000, new ActionListener() { // Actualiza cada 5000 ms (5 segundos)
                @Override
                public void actionPerformed(ActionEvent e) {
                    STOKSAGOTADOS(modelSTOCK);
                   
                }
            });
            timer.start(); // Iniciar el temporizador
            // Crear un temporizador para actualizar los datos
           
        
                    
              
        // Actualizar el panel para reflejar los cambios
        jPanel16.revalidate();
        jPanel16.repaint();
    }
     
     
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        choice1 = new java.awt.Choice();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        choice2 = new java.awt.Choice();
        jLabel36 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 140, 150));

        jButton11.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton11.setText("Punto de venta");
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 163, 207));

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Realizar factura");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 32, 770, 50));
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 140, 150));

        jButton14.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton14.setText("Proveedores");
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setInheritsPopupMenu(true);
        jButton14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 160, 210));

        jTextPane2.setText("Aqui se lleva a cabo la facturacion de tus clientes empleados, punto de venta y tambien se realiza la facturacion a los proveedores.");
        jScrollPane3.setViewportView(jTextPane2);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 88, 780, 50));
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 140, 150));

        jButton15.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton15.setText("Empledos");
        jButton15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, 160, 210));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 780, 610));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jButton5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton5.setText("Auto proveedor");
        jButton5.setToolTipText("");
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("Atencion a tus clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton4.setText("Facturacion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton8.setText("Salir");
        jButton8.setToolTipText("");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton10.setText("Contavilidad");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setText("Inventario");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setText("Cotización");

        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setText("Clientes y proveedores");

        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setText("Configuracón");

        jButton19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton19.setText("Cuentas pendientes");

        jButton20.setText("Cuentas por cobrar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jButton6)
                .addGap(12, 12, 12)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton20)
                .addGap(115, 115, 115)
                .addComponent(jButton8)
                .addGap(29, 29, 29))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 620));

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, -20, 780, 640));

        jPanel15.setBackground(new java.awt.Color(102, 102, 102));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(102, 102, 102));

        jTabbedPane2.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("STOK AGOTADO", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("NOTIFICACIONES", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("PROVEEDORES", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("CATEGORIAS", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("EMPLEADOS", jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("ESTADISTICAS", jPanel10);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("PRINCIPAL", jPanel19);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("CONTROL DE STOCK", jPanel21);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ENTRADAS Y SALIDAS", jPanel22);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel18.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 190, 250, 27));

        jLabel29.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Código de producto");
        jPanel18.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 54, 250, -1));
        jPanel18.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 72, 250, 27));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel18.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 200, 299));

        choice1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        choice1.setFocusable(false);
        jPanel18.add(choice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 131, 160, 26));

        jLabel31.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Categoria");
        jPanel18.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 105, 240, 23));

        jLabel32.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Cantidad");
        jPanel18.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 167, 250, 23));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel18.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 256, 250, 27));

        jLabel33.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Precio");
        jPanel18.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 223, 250, 21));
        jPanel18.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 256, 250, 30));

        jLabel34.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Fecha de entrada");
        jPanel18.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 223, 250, 21));

        jLabel35.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Proveedor");
        jPanel18.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 304, 250, 23));
        jPanel18.add(choice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 337, 150, 28));

        jLabel36.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Numero de Lote");
        jPanel18.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 304, 250, 23));
        jPanel18.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 338, 250, 27));

        jButton21.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton21.setText("GUARDAR");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, -1, -1));

        jButton22.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton22.setText("LIMPIAR");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, -1, -1));

        jButton23.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jButton23.setText("CANCELAR");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, -1, -1));

        jButton27.setText("INSERTAR");
        jPanel18.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        jButton28.setText("INSERTAR");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel18.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 339, -1, -1));
        jPanel18.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 72, 250, 27));

        jLabel27.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Nombre");
        jPanel18.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 47, 250, -1));
        jPanel18.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 132, 250, 25));

        jLabel37.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Fecha Fabricacion");
        jPanel18.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 105, 250, 23));
        jPanel18.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 190, 250, 27));

        jLabel38.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Fecha Vencimiento");
        jPanel18.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 167, 250, 19));

        jLabel30.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Descripcion de producto");
        jPanel18.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 200, -1));

        jTabbedPane1.addTab("INSERTAR PRODUCTO", jPanel18);

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 530));

        jButton9.setText("BUSCAR");
        jPanel16.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 20));

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel16.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, 20));

        jTabbedPane1.addTab("GESTION DE PRODUCTOS", jPanel16);

        jPanel15.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 800, 610));

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 780, 620));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 720, -1));

        jMenu1.setText("Inventario");

        jMenuItem1.setText("Ingresar productos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Importar desde excel");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Ver inventario");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Importar");

        jMenuItem4.setText("Base de datos");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Importar productos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exportar");

        jMenu9.setText("Inventario");

        jMenuItem6.setText(".ZIP");
        jMenu9.add(jMenuItem6);

        jMenuItem7.setText(".PDF");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem7);

        jMenu3.add(jMenu9);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Buscar producto");
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Fechas");

        jMenuItem8.setText("Pagos a realizar");
        jMenu7.add(jMenuItem8);

        jMenuItem9.setText("pagos publicos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(validacion){
            Facturas();
        }else{
            ventana_login();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Atencion a clientes
        if(validacion){
            Atencion_clientes();
        }else{
            ventana_login();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
   
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        if(validacion){
            Autoproveedor();
        }else{
            ventana_login();
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String[] args = null;
       Ventana_ingreso_productos.main(args);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        //facturas autoproveedor
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new punto_Venta().setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fillChoice(choice1, "categoria", "nombre");
        fillChoice(choice2, "proveedor", "nombreEmpresa");
        inventario();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        guardarProducto();
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
        jDateChooser3.setDate(null);
        jTextField1.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField2.setText("");
        jTextField5.setText("");
        jTextArea2.setText("");  
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
         jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

 
    
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }
       void SetImageLabel(JLabel labelName, String root){
        ImageIcon image = new ImageIcon(root);
	Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(),labelName.getHeight(), Image.SCALE_DEFAULT));
        labelName.setIcon(icon);
        this.repaint();
    } 
    public static void fillChoice(Choice choice, String nombreTabla, String nombreColubna) {
        String url = conex.conexion.URL;
        String user = conex.conexion.USER;
        String password = conex.conexion.PASSWORD;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establecer conexión con la base de datos
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

            // Ejecutar consulta SQL
            String query = "SELECT "+nombreColubna+" FROM "+nombreTabla+"";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString(nombreColubna);
                choice.add(name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
      private void loadDataFromDatabase(DefaultTableModel model) {
         model.setRowCount(0);
        // Configuración de la base de datos
        String url = conex.conexion.URL;
        String user = conex.conexion.USER;
        String password = conex.conexion.PASSWORD;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT "
                     + "idProducto,"
                     + "fechaentrada, "
                     + "fechaFabricacion, "
                     + "fechaVencimiento, "
                     + "nombre, "
                     + "precio , "
                     + "categoria, "
                     + "proveedor, "
                     + "numeroLote, "
                     + "descripcion, "
                     + "codigoProducto "
                     + "cantidad, "
                     + "codigoProducto "
                     + "FROM producto")) {

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                Date fechaentrada =  rs.getDate("fechaentrada");
                Date fechaFabricacion = rs.getDate("fechaFabricacion");
                Date fechaVencimiento = rs.getDate("fechaVencimiento");
                String nombre = rs.getString("nombre");
                String precio = rs.getString("precio");
                String categoria = rs.getString("categoria");
                int cantidad = rs.getInt("cantidad");
                String proveedor = rs.getString("proveedor");
                int numeroLote =rs.getInt("numeroLote");
                String descripcion = rs.getString("descripcion");
                int codigoProducto =rs.getInt("codigoProducto");
                model.addRow(new Object[]{
                    idProducto,
                    fechaentrada,
                    fechaFabricacion,
                    fechaVencimiento,
                    nombre,
                    precio,
                    categoria,
                    cantidad,
                    proveedor,
                    numeroLote, 
                    descripcion,
                    codigoProducto, 
                    "Detalles"});
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String STOKSAGOTADOS(DefaultTableModel model) {
        model.setRowCount(0);
        String nombreProducto = null;
        // Configuración de la base de datos
        String url = conex.conexion.URL;
        String user = conex.conexion.USER;
        String password = conex.conexion.PASSWORD;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT "
                     + "idProducto, "
                     + "nombre, "
                     + "cantidad, "
                     + "codigoProducto "
                     + "FROM producto "
                     + "WHERE cantidad BETWEEN 1 AND 3")) {

            int contadorProductos = 0;

            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("nombre"); // Guardar el nombre del producto
                int cantidad = rs.getInt("cantidad");
                int codigoProducto = rs.getInt("codigoProducto");

                // Agregar una fila al modelo de la tabla
                model.addRow(new Object[]{
                    idProducto,
                    nombre,
                    cantidad,
                    codigoProducto,
                    "Detalles"
                });

                // Incrementar el contador
                contadorProductos++;
            }
            if (contadorProductos == 1 && !contadorProductosAgotados){
                TrayNotification.showTrayNotification("se ha agotado " + contadorProductos + " producto");
                contadorProductosAgotados = true;
            }else  if (contadorProductos >= 2 && !contadorProductosAgotados){
                TrayNotification.showTrayNotification("se han agotado " + contadorProductos + " productos");
                contadorProductosAgotados = true;
            }
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombreProducto;
    }
     //notificacion
    
        public static void showTrayNotification(String message) {
        if (!SystemTray.isSupported()) {
            System.out.println("System tray not supported");
            return;
        }

        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage("path/to/icon.png"); // Cambia el icono si lo deseas
        TrayIcon trayIcon = new TrayIcon(image, "Notification");

        trayIcon.setImageAutoSize(true);
        trayIcon.setToolTip("Notification");

        trayIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tray icon clicked");
            }
        });

        try {
            tray.add(trayIcon);
            trayIcon.displayMessage("Notificación", message, TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
     private void ventana_login(){
         if(!Estado_ventana_Login){//! negación lógica. Básicamente, invierte el valor booleano de una expresión.
               new Login.Diseño_login().setVisible(true);
         }
         
     }
     private void guardarProducto() {
        // Recuperar nombres de las columnas y tabla desde la configuración
        String tabla = conex.conexion.nombreTablaProducto;        
        String fechaEntradaProducto = conex.conexion.fechaEntradaProducto;
        String fechaFabricacion = conex.conexion.fechaFabricacion;
        String fechaVencimiento = conex.conexion.fechaVencimiento;
        String nombreProducto = conex.conexion.nombreProducto;
        String precioProducto = conex.conexion.precioProducto;
        String categoriaProducto = conex.conexion.categoriaProducto;
        String cantidadProducto = conex.conexion.cantidadProducto;
        String proveedorProducto = conex.conexion.proveedorProducto;
        String numeroLoteProducto = conex.conexion.numeroLoteProducto;
        String descripcionProducto = conex.conexion.descripcionProducto;
        String codigoProducto = conex.conexion.codigoProducto;

        // Obtener valores de los campos
        Date fechaEntrada = jDateChooser1.getDate();
        Date fechaFabricacionP = jDateChooser2.getDate();
        Date fechaVencimientoP = jDateChooser3.getDate();
        

        if (fechaEntrada == null || fechaFabricacionP == null || fechaVencimientoP == null) {
            mostrarMensajeError("Una o más fechas no han sido seleccionadas.");
            return; // Detener la ejecución si falta alguna fecha
        }

        // Validar y convertir los campos de texto
        String textField1Text = jTextField1.getText().trim();
        String textField3Text = jTextField3.getText().trim();
        String textField4Text = jTextField4.getText().trim();
        String textField2Text = jTextField2.getText().trim();
        String nombreP = jTextField5.getText().trim();
        String categoria = choice1.getSelectedItem();
        String proveedor = choice2.getSelectedItem();
        String descripcion = jTextArea2.getText();
        
        if (nombreP.isEmpty()) {
            mostrarMensajeError("El campo nombre no puede estar vacío.");
            return; 
        }
      
        int cant = parseInteger(textField1Text, "Cantidad");
        if (cant == -1) return;

        Double precio = parseDouble(textField3Text, "Precio");
        if (precio == -1) return;

        int lote = parseInteger(textField4Text, "Lote");
        if (lote == -1) return;

        int codProducto = parseInteger(textField2Text, "Código de producto");
        if (codProducto == -1) return;



        // Convertir fechas
        java.sql.Date fechaentradaSelecionada = new java.sql.Date(fechaEntrada.getTime());
        java.sql.Date fechaFabricacionconv = new java.sql.Date(fechaFabricacionP.getTime());
        java.sql.Date fechaVencimientoPconv = new java.sql.Date(fechaVencimientoP.getTime());

        String insertQuery = "INSERT INTO " + tabla + " (" +
                fechaEntradaProducto + ", " +
                fechaFabricacion + ", " +
                fechaVencimiento + ", " +
                nombreProducto + ", " +
                precioProducto + ", " +
                categoriaProducto + ", " +
                cantidadProducto + ", " +
                proveedorProducto + ", " +
                numeroLoteProducto + ", " +
                descripcionProducto + ", " +
                codigoProducto + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = conexion.getConnection();
            System.out.println("Conexión establecida.");

            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setDate(1, fechaentradaSelecionada);
            preparedStatement.setDate(2, fechaFabricacionconv);
            preparedStatement.setDate(3, fechaVencimientoPconv);
            preparedStatement.setString(4, nombreP);
            preparedStatement.setDouble(5, precio);
            preparedStatement.setString(6, categoria);
            preparedStatement.setInt(7, cant);
            preparedStatement.setString(8, proveedor);
            preparedStatement.setInt(9, lote);
            preparedStatement.setString(10, descripcion);
            preparedStatement.setInt(11, codProducto);

            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                mostrarMensajeExito("Producto creado exitosamente.");
                main.usuario_registrado = true;
            } else {
                mostrarMensajeError("Error al insertar el producto.");
                main.usuario_registrado = false;
            }

        } catch (ClassNotFoundException e) {
            mostrarMensajeError("No se encontró el driver JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            mostrarMensajeError("Fallo la conexión a la base de datos.");
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Métodos auxiliares para validar y convertir datos
    private int parseInteger(String text, String fieldName) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            mostrarMensajeError(fieldName + " debe ser un número válido.");
            return -1;
        }
    }

    private Double parseDouble(String text, String fieldName) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            mostrarMensajeError(fieldName + " debe ser un número válido.");
            return -1.0;
        }
    }
     private  void Autoproveedor(){
        jLabel2.setVisible(false);
   
        jPanel6.setVisible(false);
    
        jPanel15.setVisible(false);
        
     }
     private void Atencion_clientes(){
        jLabel2.setVisible(false);
      
        jPanel6.setVisible(false);
       
        jPanel15.setVisible(false);
     }
     private void Facturas(){
        jLabel2.setVisible(false);
      
        jPanel6.setVisible(true);

        jPanel15.setVisible(false);
     }
     private void Historial_facturas(){
        jLabel2.setVisible(false);
        
        jPanel6.setVisible(false);
       
        jPanel15.setVisible(false);
     }
     private void Notificaciones(){
        jLabel2.setVisible(false);
       
        jPanel6.setVisible(false);
      
        jPanel15.setVisible(false);
     }
     private void Estadisticas(){
        jLabel2.setVisible(false);
       
        jPanel6.setVisible(false);
    
        jPanel15.setVisible(false);
     }
     private void Ventas_a_contado(){
        jLabel2.setVisible(false);
      
        jPanel6.setVisible(false);
        
        jPanel15.setVisible(false);
     }
     private void Cotizacion(){
        jLabel2.setVisible(false);
       
        jPanel6.setVisible(false);
    
        jPanel15.setVisible(false);
         
     }
     private void Inventario(){
        jLabel2.setVisible(false);
       
        jPanel6.setVisible(false);
       
        jPanel15.setVisible(false);
         
     }
     private void Clientes_y_Proveedores(){
        jLabel2.setVisible(false);
        
        jPanel6.setVisible(false);
       
        jPanel15.setVisible(false);
         
     }
     private void Configuracion(){
        jLabel2.setVisible(false);
       
        jPanel6.setVisible(false);
      
        jPanel15.setVisible(false);
         
     }
     private void Cuentas_pendientes(){
        jLabel2.setVisible(false);
     
        jPanel6.setVisible(false);
    
        jPanel15.setVisible(false);
         
     }
     private void Cuentas_por_Cobrar(){
        jLabel2.setVisible(false);
       
        jPanel6.setVisible(false);
      
        jPanel15.setVisible(false);
     }
    private void inventario(){
        jPanel15.setVisible(true);
        jLabel2.setVisible(false);
        jPanel6.setVisible(false);
        jPanel16.setVisible(false);  
        jPanel18.setVisible(false); 
       
     }
       private void tablaProductos(){
 
        jPanel18.setVisible(false);
       
       
     }
       private void insertarProducto(){
     
        jPanel18.setVisible(true);
        
       
     }
      private void estadisticasYreportes(){
      
        jPanel18.setVisible(false);
       
       
     }
       
    public static boolean Estado_ventana_Token= false;//este es el estado abierta/cerrado
    public static boolean Estado_ventana_Login = false;
    public static boolean validacion = false;
    public static String nombreProductocot = "";
    public static boolean contadorProductosAgotados =false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice1;
    private java.awt.Choice choice2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables
}
