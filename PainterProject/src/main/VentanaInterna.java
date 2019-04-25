package main;

import java.awt.Color;
import java.awt.Image;
import sm.jcc.IU.Lienzo2D;

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
        this.setSize(200, 200);
    }
    
    public void assignParent(VentanaPrincipal m)
    {
        this.main = m;
    }
    
    public Lienzo2D getLienzo()
    {
        return this.lienzo;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new sm.jcc.IU.Lienzo2D();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        getContentPane().add(lienzo, java.awt.BorderLayout.CENTER);

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
    private sm.jcc.IU.Lienzo2D lienzo;
    // End of variables declaration//GEN-END:variables
}
