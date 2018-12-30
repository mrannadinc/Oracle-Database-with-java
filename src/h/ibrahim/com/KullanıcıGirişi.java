/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h.ibrahim.com;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.JDBCType;
import java.sql.Types;
import java.util.ArrayList;
import oracle.jdbc.*;
import oracle.jdbc.*;
import oracle.jdbc.oracore.OracleType;
/**
 *
 * @author hibra
 */
public final class KullanıcıGirişi extends javax.swing.JFrame {
Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pstmt =null;
    String kadi=null;
    String sifre=null ;
   
    /**
     * Creates new form KullanıcıGirişi
     */
    public KullanıcıGirişi() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.darkGray);
        
        
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void baglan()throws ClassNotFoundException, SQLException
    {
        //veritabanının bağlantı 
        Class.forName("oracle.jdbc.OracleDriver");
       conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "GAZI", "123456");
    }
   
 public boolean giris () throws SQLException { 
        String ıd =tfKullanıcıAdı.getText();
        String sifre = pfSifre.getText();
        Connection conn = null;
        
        
    try {
       
        Class.forName("oracle.jdbc.OracleDriver");
       conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "GAZI", "123456");
      
                
                
               CallableStatement sta = conn.prepareCall("{CALL HASTANERANDEVU.SP_KULLANICIGIRIS(?,?,?)}"); 
               
                
                sta.setString(1, ıd);
               
                
                sta.setString(2, sifre);
               
                
                sta.registerOutParameter(3,  OracleTypes.CURSOR);
                sta.executeQuery();
                rs= (ResultSet) sta.getObject(3);
                
                while(rs.next()){
                    
                
                if(rs.getString("KULLANICIADI").equals(ıd) && rs.getString("SIFRE").equals(sifre)){
                  
                   
                    return true;
                    
                   }
                  
                
                
                }
                
                conn.close();
                
                return false;
              
 }catch(Exception ex)
               {
               JOptionPane.showMessageDialog(null,"VERİ TABANINA BAĞLANAMADINIZ!");
               Logger.getLogger(KullanıcıKaydı.class.getName()).log(Level.SEVERE, null, ex);
               return false;
               }  
 }      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfKullanıcıAdı = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        pfSifre = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setPreferredSize(new java.awt.Dimension(1000, 10000));
        setSize(new java.awt.Dimension(500, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("MHRS KULLANICI GİRİŞİ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 650, 51));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KULLANICI ADI :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ŞİFRE             :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 110, 17));
        getContentPane().add(tfKullanıcıAdı, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, 160, 30));

        jButton1.setBackground(new java.awt.Color(0, 232, 171));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jButton1.setText("GİRİŞ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 90, 40));

        jButton2.setBackground(new java.awt.Color(0, 255, 249));
        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jButton2.setText("TEMİZLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 90, 40));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 102));
        jLabel4.setText("**SİSTEME KAYITLI DEĞİLSENİZ \"KAYIT OL\" BUTONUNA BASINIZ!**");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 520, 33));

        jButton3.setBackground(new java.awt.Color(0, 186, 232));
        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton3.setText("KAYIT OL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 331, 83));
        getContentPane().add(pfSifre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 160, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/h/ibrahim/com/atatürk.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 550, 150));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 440, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jButton4.setText("ŞİFREMİ UNUTTUM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 190, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try{
         
            if((giris())){
                 Class.forName("oracle.jdbc.OracleDriver");
                 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "GAZI", "123456");
      
               CallableStatement sta = conn.prepareCall("{CALL HASTANERANDEVU.SP_GIRISKONTROL(?)}"); 
               
                sta.setString(1, tfKullanıcıAdı.getText());
                
                sta.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "GİRİŞ BAŞARILI, MENÜYE YÖNLENDİRİLİYORSUNUZ!");
                     
                  
                RandevuMenü n1=new RandevuMenü();
                    n1.setVisible(true);
                    this.hide();
            }else
                JOptionPane.showMessageDialog(rootPane, "KULLANICI ADI VEYA ŞİFRE YANLIŞ!"); 
            
      }catch(Exception ex)
        {
            
            Logger.getLogger(KullanıcıGirişi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       tfKullanıcıAdı.setText("");
        pfSifre.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      KullanıcıKaydı n1=new KullanıcıKaydı();
      n1.setVisible(true);
          this.hide();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       ŞifremiUnuttum e1=new ŞifremiUnuttum();
       e1.setVisible(true);
       this.hide();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(KullanıcıGirişi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullanıcıGirişi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullanıcıGirişi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullanıcıGirişi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullanıcıGirişi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField pfSifre;
    private javax.swing.JTextField tfKullanıcıAdı;
    // End of variables declaration//GEN-END:variables

   
}
