/**
 * ICS4UR Computer Science, 12 
 * Brampton, Canada
 *
 * https://github.com/HarisK03/Minesweeper 
 *
 * modified     20201110
 * date         20201104
 * @filename	Setting.java
 * @author      hkamal
 * @version     1.0
 * @see         About screen
 */

package minesweeper;

import java.awt.Dimension;
import java.awt.Toolkit;

public class About extends javax.swing.JFrame {

    /**
     * Creates new form Setting
     */
    public About() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAbout = new javax.swing.JLabel();
        lblInformation = new javax.swing.JLabel();
        sepInformation = new javax.swing.JSeparator();
        lblVersion = new javax.swing.JLabel();
        lblVersionA = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        lblAuthorA = new javax.swing.JLabel();
        lblBuild = new javax.swing.JLabel();
        lblBuildA = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblNameA = new javax.swing.JLabel();
        lblUpdate = new javax.swing.JLabel();
        sepUpdate = new javax.swing.JSeparator();
        lblLatest = new javax.swing.JLabel();
        lblLatestA = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    	int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
    	this.setLocation(x, y);

        lblAbout.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        lblAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAbout.setText("About");

        lblInformation.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblInformation.setText("Information");

        lblVersion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblVersion.setText("Version:");

        lblVersionA.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblVersionA.setText("1.0");

        lblAuthor.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblAuthor.setText("Author:");

        lblAuthorA.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblAuthorA.setText("vmsoGroup2");

        lblBuild.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblBuild.setText("Build:");

        lblBuildA.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblBuildA.setText("Public Release One");

        lblName.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblName.setText("Name:");

        lblNameA.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblNameA.setText("Minesweeper");

        lblUpdate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblUpdate.setText("Updates");

        lblLatest.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblLatest.setText("Last Updated:");

        lblLatestA.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblLatestA.setText("11/09/2020");

        btnBack.setBackground(new java.awt.Color(200, 200, 200));
        btnBack.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btnBack.setText("Back");
        btnBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAbout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInformation)
                    .addComponent(lblUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sepUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNameA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAuthor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAuthorA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblVersion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVersionA))
                    .addComponent(sepInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblBuild)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBuildA))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLatest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLatestA)))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(243, 243, 243))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblAbout)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblInformation)
                    .addComponent(sepInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVersion)
                    .addComponent(lblVersionA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthor)
                    .addComponent(lblAuthorA))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuild)
                    .addComponent(lblBuildA))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblNameA))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUpdate)
                    .addComponent(sepUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLatest)
                    .addComponent(lblLatestA))
                .addGap(94, 94, 94)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBackground(new java.awt.Color(150, 150, 150));
        btnBack.setFont(new java.awt.Font("Agency FB", 0, 35));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(new java.awt.Color(200, 200, 200));
        btnBack.setFont(new java.awt.Font("Agency FB", 0, 30));
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        new MainMenu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(About.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new About().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel lblAbout;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblAuthorA;
    private javax.swing.JLabel lblBuild;
    private javax.swing.JLabel lblBuildA;
    private javax.swing.JLabel lblInformation;
    private javax.swing.JLabel lblLatest;
    private javax.swing.JLabel lblLatestA;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameA;
    private javax.swing.JLabel lblUpdate;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JLabel lblVersionA;
    private javax.swing.JSeparator sepInformation;
    private javax.swing.JSeparator sepUpdate;
    // End of variables declaration//GEN-END:variables
}
