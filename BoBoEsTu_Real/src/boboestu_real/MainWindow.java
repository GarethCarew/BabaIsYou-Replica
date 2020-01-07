package boboestu_real;

import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.Logger;
import java.awt.event.KeyEvent;

/**
 *
 * @author scien
 */
public class MainWindow extends javax.swing.JFrame {
    
    private TreeMap<String,Level> LevelList;
    private String currentLevel = "";
    
    /**
     * Creates new form MainWindow
     * @throws java.io.IOException
     */
    public MainWindow() throws IOException {
        this.LevelList = new TreeMap<>();
        
        Level lev = new Level(35,20);
        
        lev.addBlock(Block.text_BABA, 1, 1);
        lev.addBlock(Block.text_IS, 2, 1);
        lev.addBlock(Block.text_YOU, 3, 1);
        lev.addBlock(Block.object_BABA, 2, 3);
        
        LevelList.put("00", lev);
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        panelGame = new javax.swing.JPanel();
        button_up = new javax.swing.JButton();
        button_down = new javax.swing.JButton();
        button_left = new javax.swing.JButton();
        button_right = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1258, 730));
        setResizable(false);
        setSize(new java.awt.Dimension(1258, 730));

        button_up.setText("UP");

        button_down.setText("DOWN");

        button_left.setText("LEFT");

        button_right.setText("RIGHT");
        button_right.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                button_rightActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGameLayout = new javax.swing.GroupLayout(panelGame);
        panelGame.setLayout(panelGameLayout);
        panelGameLayout.setHorizontalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameLayout.createSequentialGroup()
                .addGroup(panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGameLayout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(button_up))
                    .addGroup(panelGameLayout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(button_down))
                    .addGroup(panelGameLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(button_left)
                        .addGap(147, 147, 147)
                        .addComponent(button_right)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        panelGameLayout.setVerticalGroup(
            panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGameLayout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(button_up)
                .addGap(42, 42, 42)
                .addGroup(panelGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_left)
                    .addComponent(button_right))
                .addGap(34, 34, 34)
                .addComponent(button_down)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            jButton1.setBounds(-10, -10, 1, 1);
            runGame();
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button_rightActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_button_rightActionPerformed
    {//GEN-HEADEREND:event_button_rightActionPerformed
        move2( "right" );
    }//GEN-LAST:event_button_rightActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainWindow().setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_down;
    private javax.swing.JButton button_left;
    private javax.swing.JButton button_right;
    private javax.swing.JButton button_up;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel panelGame;
    // End of variables declaration//GEN-END:variables

    private void runGame() throws IOException {

        LevelBuilder lb = new LevelBuilder();
        
        Level level = LevelList.get("00");
        currentLevel = "00";
        
        lb.paint(panelGame.getGraphics(), level);
        
        

    }
    
    private void move(KeyEvent e)
    {
        Mover m = new Mover();
        
        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
            m.moveLeft(LevelList, currentLevel);
    }
    
    private void move2(String dir)
    {
        Mover m = new Mover();
        
        if ( dir.equals( "right" ) )
            m.moveRight(LevelList, currentLevel);
    }
}