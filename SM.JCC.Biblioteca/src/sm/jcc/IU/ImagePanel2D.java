package sm.jcc.IU;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author jcc
 */
public class ImagePanel2D extends Lienzo2D
{
    private BufferedImage image = null;
    
    public ImagePanel2D()
    {
        initComponents();
    }

    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(image!=null) g.drawImage(image,0,0,this);
    }    
        
    public void setImage(BufferedImage newImage)
    {
        this.image = newImage;
        if(image!=null)
            setPreferredSize(new Dimension(image.getWidth(),image.getHeight()));
    }
    
    public BufferedImage getImage()
    {
        return this.image;
    }
    
    public BufferedImage getImage(boolean drawVector)
    {
        if(drawVector)
        {
            int w = this.getWidth();
            int h = this.getHeight();
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = bi.createGraphics();
            paint(g);
            
            return bi;
        }
        else
        {
            return this.image;
        }
            
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
