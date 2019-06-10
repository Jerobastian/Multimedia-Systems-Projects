package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import sm.jcc.IU.ImagePanel2D;

/**
 *
 * @author jcc
 */
public class VentanaInterna extends javax.swing.JInternalFrame
{
    private VentanaPrincipal main;
    
    public VentanaInterna()
    {
        initComponents();
        
        BufferedImage blank;
        blank = new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = blank.createGraphics();
        g.setPaint(Color.WHITE);

        g.fillRect(0, 0, blank.getWidth(), blank.getHeight());

        lienzo.setImage(blank);
    }
    
    public void assignParent(VentanaPrincipal m)
    {
        this.main = m;
    }
    
    public void setImage(BufferedImage image)
    {
        this.lienzo.setImage(image);
        
        if(image!=null)
            setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
    }
    
    public ImagePanel2D getLienzo()
    {
        return this.lienzo;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        lienzo = new sm.jcc.IU.ImagePanel2D();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(600, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 382, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(lienzo);

        getContentPane().add(scrollPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        int color = 0;
        
        if(this.lienzo.getActiveColor().equals(new Color(0, 0, 0)))
        {
            color = 0;
        }
        else if(this.lienzo.getActiveColor().equals(new Color(255,0,51)))
        {
            color = 1;
        }
        else if(this.lienzo.getActiveColor().equals(new Color(0,51,255)))
        {
            color = 2;
        }
        else if(this.lienzo.getActiveColor().equals(new Color(255,255,255)))
        {
            color = 3;
        }
        else if(this.lienzo.getActiveColor().equals(new Color(255,255,0)))
        {
            color = 4;
        }
        else if(this.lienzo.getActiveColor().equals(new Color(51,255,0)))
        {
            color = 5;
        }
        
        this.main.setAttributes(this.lienzo.getTool(), color,
                this.lienzo.getStroke(), this.lienzo.isEditMode(),
                this.lienzo.isRenderingMode(), this.lienzo.isTransparency(),
                this.lienzo.isFill());
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sm.jcc.IU.ImagePanel2D lienzo;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
