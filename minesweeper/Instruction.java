/**
 * ICS4UR Computer Science, 12 
 * Brampton, Canada
 *
 * https://github.com/HarisK03/Minesweeper 
 *
 * modified     20201110
 * date         20201104
 * @filename	Instruction.java
 * @author      hkamal
 * @version     1.0
 * @see         Instruction screen
 */

package minesweeper;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Instruction extends javax.swing.JFrame {

    public Instruction() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        instructionTitle = new javax.swing.JLabel();
        stepOne = new javax.swing.JLabel();
        stepTwo = new javax.swing.JLabel();
        stepThree = new javax.swing.JLabel();
        stepThreeA = new javax.swing.JLabel();
        stepFour = new javax.swing.JLabel();
        stepFourA = new javax.swing.JLabel();
        stepFive = new javax.swing.JLabel();
        stepSix = new javax.swing.JLabel();
        stepFourB = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    	int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
    	int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
    	this.setLocation(x, y);
        
        instructionTitle.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        instructionTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionTitle.setText("Instructions");

        stepOne.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepOne.setText("1.\t    Click New Game to begin playing. ");

        stepTwo.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepTwo.setText("2.\t    Start by selecting a tile anywhere on the board.");

        stepThree.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepThree.setText("3.\t    Make your decision on what tile to select next by reviewing the numbers on the tiles that have   ");

        stepThreeA.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepThreeA.setText("       been opened. The number on the tiles indicates the number of mines touching that tile. ");

        stepFour.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepFour.setText("4.\t    Right-click any tiles that you think contain mines. This will put a flag on that tile, so you can keep ");

        stepFourA.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepFourA.setText("       track of what tiles have mines. (Note: Carefully place the flags because it will be difficult to clear   ");

        stepFive.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepFive.setText("5.\t     Win the game by clearing the board of all tiles that do not contain mines. ");

        stepSix.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepSix.setText("6.\t     If you select a tile that contains a mine, then you will lose the game.");

        stepFourB.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        stepFourB.setText("  the board if you flag a tile that does not contain a mine.)");

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
            .addComponent(instructionTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(stepFourB))
                            .addComponent(stepFour)
                            .addComponent(stepFourA)
                            .addComponent(stepOne)
                            .addComponent(stepThree)
                            .addComponent(stepFive)
                            .addComponent(stepSix)
                            .addComponent(stepTwo)
                            .addComponent(stepThreeA)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(instructionTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(stepOne)
                .addGap(42, 42, 42)
                .addComponent(stepTwo)
                .addGap(41, 41, 41)
                .addComponent(stepThree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepThreeA)
                .addGap(42, 42, 42)
                .addComponent(stepFour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepFourA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepFourB)
                .addGap(44, 44, 44)
                .addComponent(stepFive)
                .addGap(54, 54, 54)
                .addComponent(stepSix)
                .addGap(63, 63, 63)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       new MainMenu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        btnBack.setBackground(new java.awt.Color(150, 150, 150));
        btnBack.setFont(new java.awt.Font("Agency FB", 0, 35));
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(new java.awt.Color(200, 200, 200));
        btnBack.setFont(new java.awt.Font("Agency FB", 0, 30));
    }//GEN-LAST:event_btnBackMouseExited

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
            java.util.logging.Logger.getLogger(Instruction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instruction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instruction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instruction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instruction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel instructionTitle;
    private javax.swing.JLabel stepFive;
    private javax.swing.JLabel stepFour;
    private javax.swing.JLabel stepFourA;
    private javax.swing.JLabel stepFourB;
    private javax.swing.JLabel stepOne;
    private javax.swing.JLabel stepSix;
    private javax.swing.JLabel stepThree;
    private javax.swing.JLabel stepThreeA;
    private javax.swing.JLabel stepTwo;
    // End of variables declaration//GEN-END:variables
}
