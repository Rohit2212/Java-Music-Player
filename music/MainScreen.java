package com.music;

import com.database.DBase;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainScreen extends javax.swing.JFrame {

     MusicPlayer obj=new MusicPlayer();
     DBase db =new DBase();
     String s;
      public int x=1;
   
     
     
     
     
    public MainScreen() {
        initComponents();
        Color background=new Color(255,255,255);
        this.getContentPane().setBackground(background);
        setVisible(true);
        setResizable(false);
    }
     

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblplay = new javax.swing.JLabel();
        lblpause = new javax.swing.JLabel();
        lblnext = new javax.swing.JLabel();
        lblprev = new javax.swing.JLabel();
        lblstop = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lblplay.setBackground(new java.awt.Color(0, 153, 153));
        lblplay.setForeground(new java.awt.Color(0, 153, 153));
        lblplay.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sony_Owner\\Desktop\\Java Mini Project\\playpaint.png")); // NOI18N
        lblplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblplayMouseReleased(evt);
            }
        });

        lblpause.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sony_Owner\\Desktop\\Java Mini Project\\pausepaint.png")); // NOI18N
        lblpause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblpauseMouseReleased(evt);
            }
        });

        lblnext.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sony_Owner\\Desktop\\Java Mini Project\\Nextpaint.png")); // NOI18N
        lblnext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblnextMouseReleased(evt);
            }
        });

        lblprev.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sony_Owner\\Desktop\\Java Mini Project\\previouspaint1.jpg")); // NOI18N
        lblprev.setToolTipText("");
        lblprev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblprevMouseReleased(evt);
            }
        });

        lblstop.setIcon(new javax.swing.ImageIcon("C:\\Users\\Sony_Owner\\Desktop\\Java Mini Project\\stoppaint.png")); // NOI18N
        lblstop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblstopMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblprev)
                .addGap(18, 18, 18)
                .addComponent(lblstop, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(lblplay)
                .addGap(18, 18, 18)
                .addComponent(lblpause, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblnext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnext, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpause, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblplay)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblprev, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblstop, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblstopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblstopMouseReleased
       obj.stop();
    }//GEN-LAST:event_lblstopMouseReleased

    private void lblplayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblplayMouseReleased
     if(obj.songTotalLength==obj.pauseLocation){
         try {
             
             
             s=db.getSongPath(x);
           
        obj.play(s);
         } catch (SQLException ex) {
            
         }
        
        
        
       
     }
     else      
obj.resume();
    }//GEN-LAST:event_lblplayMouseReleased

    private void lblpauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblpauseMouseReleased
        obj.pause();
    }//GEN-LAST:event_lblpauseMouseReleased

    private void lblnextMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblnextMouseReleased
        
        obj.stop();
        x++;
        try {
             s=db.getSongPath(x);
         } catch (SQLException ex) {
             
         }
        obj.next(s);
    }//GEN-LAST:event_lblnextMouseReleased

    private void lblprevMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblprevMouseReleased
        obj.stop();
        x--;
        try {
             s=db.getSongPath(x);
         } catch (SQLException ex) {
             
         }
        obj.next(s);
    }//GEN-LAST:event_lblprevMouseReleased

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblnext;
    private javax.swing.JLabel lblpause;
    private javax.swing.JLabel lblplay;
    private javax.swing.JLabel lblprev;
    private javax.swing.JLabel lblstop;
    // End of variables declaration//GEN-END:variables
}
