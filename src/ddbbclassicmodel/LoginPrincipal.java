/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ddbbclassicmodel;

import Estructura.Aviso;
import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarda
 */
public class LoginPrincipal extends javax.swing.JFrame {
private ArrayList<Aviso> listaAviso=new ArrayList();
DefaultTableModel modelo;
private static String nomUser;
private static String codigoUser;

   
    /**
     * Creates new form LoginPrincipal
     */
    public LoginPrincipal() throws IOException {
        initComponents();
        cargarAvisos();     
    }

    public static String getNomUserL() {
        return nomUser;
    }
     public static String getCodigoUser() {
        return codigoUser;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldEmailLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jTextFieldEmailLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldEmailLoginMouseClicked(evt);
            }
        });

        jLabel1.setText("INTRODUCE ID:");

        jButtonAceptar.setText("LOGIN");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabel2.setText("TIPO:");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------", "CLIENTE", "EMPLEADO" }));
        jComboBoxTipo.setSelectedIndex(1);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/moto1.png"))); // NOI18N

        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmailLogin)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAceptar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        // TODO add your handling code here:
        String jefesupremo="";
        jComboBoxTipo.getSelectedIndex();
        String nombre;
        boolean tipo=true;
        String id;
        id=jTextFieldEmailLogin.getText();
        String vSQL = new String();
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();
        boolean eliminar=false;
        
        /*
        String idAvisoBoss=cogerJefeEmpleado();
        System.out.println(idAvisoBoss);
        */
        if(jComboBoxTipo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "SELECCIONA EL TIPO");
        }else{
            if(jComboBoxTipo.getSelectedIndex()==1){
                vSQL = "SELECT customerNumber,contactFirstName FROM customers WHERE customerNumber='"+id+"'";// esto es lo que cambia
                tipo=false;
            }else{
                vSQL = "SELECT employeeNumber,firstName FROM employees WHERE employeeNumber='"+id+"'";// esto es lo que cambia
                tipo=true;
            }
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(vSQL);
            
            if(!rs.next()){
                JOptionPane.showMessageDialog(this, "IDENTIFICADOR ERRONEO");
            }else{
                if(tipo){
                    jefesupremo=rs.getString(1);
                    id=rs.getString(1);
                    nombre=rs.getString("firstName");
                    nomUser=rs.getString("firstName");
                    codigoUser=id;

                }else{
                    nombre=rs.getString("contactFirstName");
                    nomUser=rs.getString("contactFirstName");
                    codigoUser=id;
                }
                
                JOptionPane.showMessageDialog(this, "BIENVENID@:"+nombre);
            
                if(tipo){
                    cargarAvisosBD();
                    for(int i=0;i<listaAviso.size();i++){
                        if(listaAviso.get(i).getIdJefe().contentEquals(id)){
                            JOptionPane.showMessageDialog(this, "AVISO, ID: "+listaAviso.get(i).getIdCliente()+" Nota: "+listaAviso.get(i).getComment());
                            eliminar=true;
                        }
                    }
                    if(eliminar){
                        borrarArchivo();
                    }
                    empleadoPrincipal ep = new empleadoPrincipal();
                    this.setVisible(false);
                    ep.setVisible(true);
                    if(jefesupremo.contentEquals("1056")){
                     /*
                        for(int i=0;i<listaAviso.size();i++){
                        if(listaAviso.get(i).getIdJefe().contentEquals(id)){
                            JOptionPane.showMessageDialog(this, "AVISO:"+listaAviso.get(i).getIdCliente()+listaAviso.get(i).getComment());
                        }

                    }*/
                        ep.setVisible(false);
                        this.setVisible(false);
                        empleadoJefeSupremo ejs=new empleadoJefeSupremo();
                        ejs.setVisible(true);
                    }
                    }else{
                        classicmodels g=new classicmodels();
                        this.setVisible(false);
                        g.setVisible(true);
                    }
            }              
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButtonAceptarActionPerformed

    public void cargarAvisos() throws FileNotFoundException, IOException{
        String[] parametros = null;
        String vSQL = new String();
        String[] registro = new String[4];
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();
        
        FileReader fileReader = new FileReader("log.csv");//personas que estan para entrar
        CsvReader icsv = new CsvReader(fileReader, ';');// indicamos el separador

/*
        if (icsv.readHeaders()) {//ponemos las cabeceras
            parametros = icsv.getHeaders();//las guardamos en una array de Strings
        }
*/
        while (icsv.readRecord()) { //Mientras se encuentren resultados

            String idEmpleado = icsv.get(0);// en la posicion 0 donde esta nombre guardara lo que haya hasta encontrr un ";"
            String idCliente= icsv.get(1);//al haber guardado los parametros podemos especificar que guardemos en vez d la posicion a traves del String de la cabecera
            String idJefe = icsv.get(2);
            String comment = icsv.get(3);
         
    
            Aviso a=new Aviso(idEmpleado,idCliente,idJefe,comment);
            listaAviso.add(a);
    }
    }
    
    private void jTextFieldEmailLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldEmailLoginMouseClicked
        // TODO add your handling code here:
        jTextFieldEmailLogin.setText("");
    }//GEN-LAST:event_jTextFieldEmailLoginMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarAvisosBD(){
        
        String[] titols = { "ID", "Num. empleado", "Num Cliente", "Num. JEFE", "Comments"};
        String vSQL = new String();
        String[] registro = new String[6];

        modelo = new DefaultTableModel(null, titols);

        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();

        vSQL = "SELECT  idLog, logA.employeeNumber, customerNumber, boss, comments, avisado FROM logA NATURAL JOIN customers NATURAL JOIN employees WHERE boss=(SELECT employeeNumber FROM employees WHERE employeeNumber='"+codigoUser+"') AND avisado=0;";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(vSQL);

            if(rs.next()) {
                JOptionPane.showMessageDialog(this, "Avisos pendientes");
                registro[0] = rs.getString(1);
                registro[1] = rs.getString(2);
                registro[2] = rs.getString(3);
                registro[3] = rs.getString(4);
               // numBoss=rs.getString(4);
                registro[4] = rs.getString(5);
                registro[5] = rs.getString(6);
               // registro[6] = rs.getString(7);
               // registro[7] = rs.getString(8);
                //registro[8] = rs.getString(9);
               // registro[9] = rs.getString(10);
                //registro[10] = rs.getString(11);
               // registro[11] = rs.getString(12);  
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public String cogerJefeEmpleado(){
        String vSQL = new String();
      //  String[] registro = new String[3];
        
        String clientNum="";
        int modOrder;
        
        ConexionMySQL mysql = new ConexionMySQL();
        Connection cn = mysql.conectar();

        vSQL = "SELECT employeeNumber FROM employees WHERE employeeNumber='"+codigoUser+"';";
  
        
        
        try {
       
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(vSQL);
            if(rs.next()){
              
            clientNum=rs.getString(1);
         
            }
            
            
         
          
           
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
    }
    
    
    return clientNum;
}
    
    public boolean existeID(String id){
    boolean existe=false;
    
    
    
    return existe;
}
    public void borrarArchivo(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("log.csv");// selecciono fichero
            pw = new PrintWriter(fichero);// boli para el fichero
            
            String aviso="";
           
            pw.print(aviso);

            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
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
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoginPrincipal().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(LoginPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextFieldEmailLogin;
    // End of variables declaration//GEN-END:variables
}
