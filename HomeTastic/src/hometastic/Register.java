/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometastic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        LastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emailEntered = new javax.swing.JTextField();
        state = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneNum = new javax.swing.JTextField();
        street = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        usernameEntered = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        passwordEntered = new javax.swing.JPasswordField();
        ButtonCancel = new javax.swing.JButton();
        ButtonRegister = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomeTastic");
        setAutoRequestFocus(false);
        setSize(new java.awt.Dimension(960, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 66, 127));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Register as");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 40));

        jLabel4.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("First Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 40));

        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 270, 30));

        jRadioButton1.setBackground(new java.awt.Color(0, 66, 127));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("User");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jRadioButton2.setBackground(new java.awt.Color(0, 66, 127));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Host");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, -1, -1));

        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 270, 30));

        jLabel5.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 40));

        jLabel6.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, 40));

        emailEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEnteredActionPerformed(evt);
            }
        });
        jPanel1.add(emailEntered, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 270, 30));

        state.setText("State");
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });
        jPanel1.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 270, 30));

        jLabel7.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, -1, 40));

        jLabel8.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone No.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, 40));

        phoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumActionPerformed(evt);
            }
        });
        jPanel1.add(phoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 270, 30));

        street.setText("Street");
        street.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetActionPerformed(evt);
            }
        });
        jPanel1.add(street, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 270, 30));

        city.setText("City");
        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });
        jPanel1.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 270, 30));

        jLabel9.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Password");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, 40));

        usernameEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameEnteredActionPerformed(evt);
            }
        });
        jPanel1.add(usernameEntered, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 270, 30));

        jLabel10.setFont(new java.awt.Font("Montserrat Light", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Username");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 40));

        passwordEntered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordEnteredActionPerformed(evt);
            }
        });
        jPanel1.add(passwordEntered, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 270, 30));

        ButtonCancel.setBackground(new java.awt.Color(255, 242, 0));
        ButtonCancel.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        ButtonCancel.setText("Cancel");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 170, 40));

        ButtonRegister.setBackground(new java.awt.Color(255, 242, 0));
        ButtonRegister.setFont(new java.awt.Font("Montserrat Medium", 0, 16)); // NOI18N
        ButtonRegister.setText("Register");
        ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(ButtonRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 170, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 970, 340));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Montserrat Medium", 0, 20)); // NOI18N
        jLabel2.setText("Registration Page");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hometastic/Logo Colored (0.9).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hometastic/Logo Colored (0.7).png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void emailEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailEnteredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailEnteredActionPerformed

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateActionPerformed

    private void phoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumActionPerformed

    private void streetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cityActionPerformed

    private void usernameEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameEnteredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameEnteredActionPerformed

    private void passwordEnteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordEnteredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordEnteredActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
        new Welcome().setVisible(true);
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegisterActionPerformed
        jRadioButton1.setActionCommand("user");
        jRadioButton2.setActionCommand("host");
        String selection = buttonGroup1.getSelection().getActionCommand();
        
        
        String username = usernameEntered.getText();
        String password = passwordEntered.getText();
        String firstName = FirstName.getText();
        String lastName = LastName.getText();
        String streetEntered = street.getText();
        String cityEntered = city.getText();
        String stateEntered = state.getText();
        String email = emailEntered.getText();
        String phoneNumber = phoneNum.getText();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hometastic","root","1234");
            statement = conn.prepareStatement("insert into " + selection + " values(?,?,?,?,?,?,?,?,?)");
            //statement.setString(1, selection);
            statement.setString(1, username);
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
                JOptionPane.showMessageDialog(null, "Data is not saved!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ButtonRegisterActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonRegister;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel Logo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField city;
    private javax.swing.JTextField emailEntered;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JPasswordField passwordEntered;
    private javax.swing.JTextField phoneNum;
    private javax.swing.JTextField state;
    private javax.swing.JTextField street;
    private javax.swing.JTextField usernameEntered;
    // End of variables declaration//GEN-END:variables
}
