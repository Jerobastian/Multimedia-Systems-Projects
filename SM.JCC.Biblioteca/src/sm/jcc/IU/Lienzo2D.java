package sm.jcc.IU;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import sm.jcc.graficos.*;

/**
 *
 * @author jcc
 */
public class Lienzo2D extends javax.swing.JPanel
{
    public Lienzo2D()
    {
        initComponents();
    }

    private Tool tool = Tool.DRAW;
    private Color activeColor = Color.black;
    private boolean fill = false;
    
    private Point startPoint = new Point(-20, -20);
    private Point endPoint = this.startPoint;
    protected ArrayList<Shape> figures = new ArrayList();
    private float stroke = 1; 
    private Shape actualFigure;
    private int selectedFigure;
    boolean editMode = false;
    boolean renderingMode = false;
    boolean transparency = false;
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        
        setAttributes(g2d);
        
        for(int i = 0; i < figures.size(); i++)
            g2d.draw(figures.get(i));
        
        if(actualFigure != null)
            g2d.draw(actualFigure);
    }
    
    protected void setAttributes(Graphics2D g2d)
    {
        Stroke trazo;
        trazo = new BasicStroke(this.stroke, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_MITER, 1.0f);
        g2d.setStroke(trazo);

        Paint relleno;
        relleno = this.activeColor;
        g2d.setPaint(relleno);
        
        

        if(this.transparency)
        {
            Composite composicion;
            composicion = 
                    AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
            g2d.setComposite(composicion);
        }
        
        if(this.fill)
        {
            for(int i = 0; i < this.figures.size(); i++)
                g2d.fill(figures.get(i));
            
            if(actualFigure != null)
                g2d.fill(actualFigure);
        }
        
        if(this.renderingMode)
        {
            RenderingHints render;
            
            render = new RenderingHints
            (
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2d.setRenderingHints(render);
        }
    }
    
    public void setActiveColor(Color c)
    {
        this.activeColor = c;
        repaint();
    }
    
    public Color getActiveColor()
    {
        return this.activeColor;
    }
    
    public void setTool(Tool t)
    {
        this.tool = t;
    }
    
    public Tool getTool()
    {
        return this.tool;
    }
    
    public void changeFill()
    {
        this.fill = !this.fill;
        repaint();
    }
    
    public boolean isFill()
    {
        return this.fill;
    }
    
    public void setStroke(float str)
    {
        this.stroke = str;
        repaint();
    }
    
    public float getStroke()
    {
        return this.stroke;
    }
    
    public void changeToEditMode()
    {
        this.editMode = !this.editMode;
    }
    
    public boolean isEditMode()
    {
        return this.editMode;
    }
    
    public void changeToRenderingMode()
    {
        this.renderingMode = !this.renderingMode;
        repaint();
    }
    
    public boolean isRenderingMode()
    {
        return this.renderingMode;
    }
    
    public void changeTransparency()
    {
        this.transparency = !this.transparency;
        repaint();
    }
    
    public boolean isTransparency()
    {
        return this.transparency;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

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

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        
        this.endPoint = evt.getPoint();
        
        if(!this.editMode)
        {
            
            switch(this.tool)
            {
                case DRAW:
                    figures.add(new Ellipse2D.Float(this.endPoint.x - 5, this.endPoint.y - 5, 10, 10));
                    break;
                case LINE:
                    ((Line2D)actualFigure).setLine(startPoint, endPoint);
                    break;
                case RECTANGLE:
                    ((Rectangle)actualFigure).setFrameFromDiagonal(startPoint, endPoint);
                    break;
                case OVAL:
                    ((Ellipse2D)actualFigure).setFrameFromDiagonal(startPoint, endPoint);
            }
        }
        else if (this.selectedFigure != -1)
        {
            if(this.figures.get(this.selectedFigure).getClass().equals(new Rectangle().getClass()))
            {
                ((Rectangle)this.figures.get(this.selectedFigure)).setFrameFromDiagonal
                (
                        ((Rectangle)this.figures.get(this.selectedFigure)).getMinX() + (this.endPoint.x - this.startPoint.x),
                        ((Rectangle)this.figures.get(this.selectedFigure)).getMinY() + (this.endPoint.y - this.startPoint.y),
                        ((Rectangle)this.figures.get(this.selectedFigure)).getMaxX() + (this.endPoint.x - this.startPoint.x),
                        ((Rectangle)this.figures.get(this.selectedFigure)).getMaxY() + (this.endPoint.y - this.startPoint.y)
                );
            }
            else if(this.figures.get(this.selectedFigure).getClass().equals(new Ellipse2D.Double().getClass()))
            {
                ((Ellipse2D)this.figures.get(this.selectedFigure)).setFrameFromDiagonal
                (
                        ((Ellipse2D)this.figures.get(this.selectedFigure)).getMinX() + (this.endPoint.x - this.startPoint.x),
                        ((Ellipse2D)this.figures.get(this.selectedFigure)).getMinY() + (this.endPoint.y - this.startPoint.y),
                        ((Ellipse2D)this.figures.get(this.selectedFigure)).getMaxX() + (this.endPoint.x - this.startPoint.x),
                        ((Ellipse2D)this.figures.get(this.selectedFigure)).getMaxY() + (this.endPoint.y - this.startPoint.y)
                );
            }
            
            this.startPoint = this.endPoint;
        }
        
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        this.startPoint = evt.getPoint();
        
        if(!this.editMode)
        {
            switch(this.tool)
            {
                case DRAW:
                    figures.add(new Ellipse2D.Float(this.endPoint.x - 5, this.endPoint.y - 5, 10, 10));
                    break;
                case LINE:
                    actualFigure = new Line2D.Double(startPoint, startPoint);
                    break;
                case RECTANGLE:
                    actualFigure = new Rectangle(startPoint.x, startPoint.y, 0, 0);
                    break;
                case OVAL:
                    actualFigure = new Ellipse2D.Double(startPoint.x, startPoint.y, 0, 0);
            }
        }
        else
        {
            boolean found = false;
            
            for(int i = this.figures.size()-1; i >= 0 && !found; i--)
            {
                if(this.figures.get(i).contains(this.startPoint))
                {
                    this.selectedFigure = i;
                    found = true;
                }
            }
        }
        
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(actualFigure != null)
        {
            this.figures.add(actualFigure);
            actualFigure = null;
        }
        
        this.selectedFigure = -1;
        
        repaint();
    }//GEN-LAST:event_formMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
