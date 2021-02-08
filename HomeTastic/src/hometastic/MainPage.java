/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometastic;


import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import static javax.swing.UIManager.get;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class MainPage extends javax.swing.JFrame {
    /**
     * Creates new form MainPage
     */
    String username;
    public MainPage() {
        initComponents();
        show_report();
    }
    
    public MainPage(String username) {
        initComponents();
        this.username = username;
        FullName1.setText(username);
        show_report();
    }
    
    
    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hometastic","root","1234");
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Property> getSearchedList(){
        ArrayList<Property> searchlist = new ArrayList<Property>();
        Connection connection = getConnection();
        
        //"select  USER_ID, USER_PASS from user where USER_ID LIKE '%"+jTextFieldEmail.getText()+"%'";  +" or property.CITY LIKE '%"+SearchField1.getText()+"%'" 
        String query = "select property.PROPERTY_ID, property.PROPERTY_NAME, property.CITY, property.STATE, property.PRICE, property.MAX_PERSON from property where property.STATE LIKE '%"+SearchField1.getText()+
                        "%' " + " or property.CITY LIKE '%"+SearchField1.getText()+"%'";
        Statement st;
        ResultSet rs;
        
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Property property;
            int i=0;
            while(rs.next()){
                property = new Property(rs.getInt("PROPERTY_ID"),rs.getString("PROPERTY_NAME"),rs.getString("CITY"),rs.getString("STATE"),rs.getDouble("PRICE"),rs.getInt("MAX_PERSON"));
                //int pid = property.getPropertyID();
                searchlist.add(property);
                //propertylist.get(i).setPropertyID(pid);
                //System.out.println(propertylist.get(i).getPropertyID());
                //i++;
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return searchlist;
    }
    
    public void updateSearchTable(){
        String query = "select property.PROPERTY_ID, property.PROPERTY_NAME, property.CITY, property.STATE, property.PRICE, property.MAX_PERSON from property where property.STATE LIKE '%"+SearchField1.getText()+
                        "%'" + " or property.CITY LIKE '%"+SearchField1.getText()+"%'";
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            TableReport.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<Property> getPropertyList(){
        ArrayList<Property> propertylist = new ArrayList<Property>();
        Connection connection = getConnection();
        
        String query = "SELECT * FROM PROPERTY";
        Statement st;
        ResultSet rs;
        
        try{
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Property property;
            while(rs.next()){
                property = new Property(rs.getInt("PROPERTY_ID"),rs.getString("PROPERTY_NAME"),rs.getString("CITY"),rs.getString("STATE"),rs.getDouble("PRICE"),rs.getInt("MAX_PERSON"));
                //int pid = property.getPropertyID();
                propertylist.add(property);
                //propertylist.get(i).setPropertyID(pid);
                //System.out.println(propertylist.get(i).getPropertyID());
                //i++;
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        return propertylist;
    }
    
    //Display Data
    
    public void update_table(){
        String query = "select * from report";
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            TableReport.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void show_report(){
        ArrayList<Property> list = getPropertyList();
        DefaultTableModel model = (DefaultTableModel)TableReport.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size(); i++){
            //System.out.println(list.get(i).getPropertyID());
            row[0] = list.get(i).getPropertyID();
            row[1] = list.get(i).getPropertyName();
            row[2] = list.get(i).getCity();
            row[3] = list.get(i).getState();
            row[4] = list.get(i).getPrice();
            row[5] = list.get(i).getMaxPerson();
            
            model.addRow(row);
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

        jPanel3 = new javax.swing.JPanel();
        HomeMenu2 = new javax.swing.JPanel();
        Menu = new javax.swing.JLabel();
        HomeMenu1 = new javax.swing.JButton();
        HomeMenu4 = new javax.swing.JButton();
        HomeMenu6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MakeReview = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        FullName1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        CheckOutField = new javax.swing.JTextField();
        SearchField1 = new javax.swing.JTextField();
        CheckInField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ButtonSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        FullName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableReport = new javax.swing.JTable();
        jViewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomeTastic");
        setAutoRequestFocus(false);
        setSize(new java.awt.Dimension(960, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 96, 166));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HomeMenu2.setBackground(new java.awt.Color(0, 66, 127));
        HomeMenu2.setMinimumSize(new java.awt.Dimension(233, 45));
        HomeMenu2.setPreferredSize(new java.awt.Dimension(240, 55));
        HomeMenu2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        Menu.setForeground(new java.awt.Color(255, 255, 255));
        HomeMenu2.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        HomeMenu1.setBackground(new java.awt.Color(0, 96, 166));
        HomeMenu1.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        HomeMenu1.setForeground(new java.awt.Color(255, 255, 255));
        HomeMenu1.setText("Home");
        HomeMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HomeMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeMenu1ActionPerformed(evt);
            }
        });
        HomeMenu2.add(HomeMenu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 60));

        HomeMenu4.setBackground(new java.awt.Color(0, 96, 166));
        HomeMenu4.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        HomeMenu4.setForeground(new java.awt.Color(255, 255, 255));
        HomeMenu4.setText("My Booking");
        HomeMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeMenu4ActionPerformed(evt);
            }
        });
        HomeMenu2.add(HomeMenu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 60));

        HomeMenu6.setBackground(new java.awt.Color(0, 96, 166));
        HomeMenu6.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        HomeMenu6.setForeground(new java.awt.Color(255, 255, 255));
        HomeMenu6.setText("Account Settings");
        HomeMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeMenu6ActionPerformed(evt);
            }
        });
        HomeMenu2.add(HomeMenu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 340, 60));

        jPanel3.add(HomeMenu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 340, 180));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        MakeReview.setBackground(new java.awt.Color(0, 96, 166));
        MakeReview.setFont(new java.awt.Font("Montserrat", 1, 16)); // NOI18N
        MakeReview.setForeground(new java.awt.Color(255, 255, 255));
        MakeReview.setText("Make Report");
        MakeReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MakeReviewActionPerformed(evt);
            }
        });
        jPanel3.add(MakeReview, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 340, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hometastic/Logo3a.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 130, 120));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 550));

        jPanel4.setBackground(new java.awt.Color(0, 66, 127));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FullName1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        FullName1.setForeground(new java.awt.Color(255, 255, 255));
        FullName1.setText("User's Username");
        jPanel4.add(FullName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        CheckOutField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckOutFieldActionPerformed(evt);
            }
        });
        jPanel4.add(CheckOutField, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 250, 40));

        SearchField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchField1ActionPerformed(evt);
            }
        });
        jPanel4.add(SearchField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 640, 40));

        CheckInField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckInFieldActionPerformed(evt);
            }
        });
        jPanel4.add(CheckInField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 250, 40));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Enter location");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Check-in Date(YYYY-MM-DD)");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        ButtonSearch.setBackground(new java.awt.Color(255, 242, 0));
        ButtonSearch.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        ButtonSearch.setText("Search");
        ButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchActionPerformed(evt);
            }
        });
        jPanel4.add(ButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 120, 40));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Check-out Date(YYYY-MM-DD)");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        FullName.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        FullName.setForeground(new java.awt.Color(255, 255, 255));
        FullName.setText("Log Out");
        FullName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FullNameMouseClicked(evt);
            }
        });
        jPanel4.add(FullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hometastic/user2w.png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 760, 180));

        TableReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID. No", "Property Name", "City", "State", "Price/Night", "Max Person"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableReport.setRowHeight(40);
        jScrollPane1.setViewportView(TableReport);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 710, 290));

        jViewButton.setBackground(new java.awt.Color(0, 66, 127));
        jViewButton.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jViewButton.setForeground(new java.awt.Color(255, 255, 255));
        jViewButton.setText("View Property");
        jViewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jViewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 500, 140, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void HomeMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeMenu1ActionPerformed

    private void MakeReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MakeReviewActionPerformed
        // TODO add your handling code here:
        dispose();
        new MakeReport(username).setVisible(true);
    }//GEN-LAST:event_MakeReviewActionPerformed

    private void HomeMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeMenu4ActionPerformed

    private void jViewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewButtonActionPerformed
        int row = TableReport.getSelectedRow();
        String cell = TableReport.getModel().getValueAt(row, 0).toString();
        int propid = Integer.parseInt(cell);
        System.out.println(cell);
        Property property = null;
        //p.setPropertyID()
        dispose();
        ViewProperty viewpage = new ViewProperty(username,propid);
        viewpage.setVisible(true);
        System.out.println(viewpage.getPropid());
        viewpage.getData();
    }//GEN-LAST:event_jViewButtonActionPerformed

    private void CheckOutFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckOutFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckOutFieldActionPerformed

    private void SearchField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchField1ActionPerformed

    private void CheckInFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckInFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckInFieldActionPerformed

    private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchActionPerformed

        String location = SearchField1.getText();
        String checkIn = CheckInField.getText();
        String checkOut = CheckOutField.getText();
        Connection conn = null;
        PreparedStatement statement = null;

        try{ // Execute SQL statement
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hometastic","root","1234");
            getSearchedList();
            updateSearchTable();
            //statement = conn.prepareStatement("insert into " + selection + " values(?,?,?,?,?,?,?,?,?)");
            //statement.setString(1, selection);
            /*statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5, phoneNumber);
            statement.setString(6, email);
            statement.setString(7, streetEntered);
            statement.setString(8, cityEntered);
            statement.setString(9, stateEntered);
            int i = statement.executeUpdate();

            if(i > 0){
                JOptionPane.showMessageDialog(null, "Data is saved!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Data is not saved!");*/
            //}
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ButtonSearchActionPerformed

    private void FullNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FullNameMouseClicked
        // TODO add your handling code here:
        dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_FullNameMouseClicked

    private void HomeMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomeMenu6ActionPerformed

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
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSearch;
    private javax.swing.JTextField CheckInField;
    private javax.swing.JTextField CheckOutField;
    private javax.swing.JLabel FullName;
    private javax.swing.JLabel FullName1;
    private javax.swing.JButton HomeMenu1;
    private javax.swing.JPanel HomeMenu2;
    private javax.swing.JButton HomeMenu4;
    private javax.swing.JButton HomeMenu6;
    private javax.swing.JButton MakeReview;
    private javax.swing.JLabel Menu;
    private javax.swing.JTextField SearchField1;
    private javax.swing.JTable TableReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jViewButton;
    // End of variables declaration//GEN-END:variables
}
