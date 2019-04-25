package main;

import java.awt.Color;
import sm.jcc.graficos.Tool;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import sm.jcc.IU.Lienzo2D;
/**
 *
 * @author jcc
 */
public class VentanaPrincipal extends javax.swing.JFrame 
{
    public VentanaPrincipal()
    {
        initComponents();
    }
    
    public void setAttributes(Tool t, int c, float stroke, boolean edit,
            boolean aliasing, boolean transparency, boolean fill)
    {
        switch(t)
        {
            case DRAW:
                this.draw.setSelected(true);
                this.tool.setText("Dibujo Libre");
                break;
            case LINE:
                this.line.setSelected(true);
                this.tool.setText("Línea");
                break;
            case RECTANGLE:
                this.rectangle.setSelected(true);
                this.tool.setText("Rectángulo");
                break;
            case OVAL:
                this.oval.setSelected(true);
                this.tool.setText("Óvalo");
                break;
        }
        
        this.colors.setSelectedIndex(c);
        this.color.setText(this.colors.getSelectedItem().toString());
        
        this.stroke.setValue(stroke);
        this.fill.setSelected(fill);
        this.editMode.setSelected(edit);
        this.rendering.setSelected(aliasing);
        this.transparency.setSelected(transparency);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tools = new javax.swing.ButtonGroup();
        topPanel = new javax.swing.JPanel();
        newFile = new javax.swing.JButton();
        openFile = new javax.swing.JButton();
        saveFile = new javax.swing.JButton();
        fileToolsSeparator = new javax.swing.JSeparator();
        draw = new javax.swing.JToggleButton();
        line = new javax.swing.JToggleButton();
        rectangle = new javax.swing.JToggleButton();
        oval = new javax.swing.JToggleButton();
        editMode = new javax.swing.JToggleButton();
        toolsAtributesSeparator = new javax.swing.JSeparator();
        stroke = new javax.swing.JSpinner();
        colors = new javax.swing.JComboBox<>();
        fill = new javax.swing.JToggleButton();
        transparency = new javax.swing.JToggleButton();
        rendering = new javax.swing.JToggleButton();
        bottomPanel = new javax.swing.JPanel();
        atributesPanel = new javax.swing.JPanel();
        statusPanel = new javax.swing.JPanel();
        toolLabel = new javax.swing.JLabel();
        tool = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        create = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 500));

        topPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        newFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nuevo.png"))); // NOI18N
        newFile.setMinimumSize(new java.awt.Dimension(5, 5));
        newFile.setPreferredSize(new java.awt.Dimension(30, 30));
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        topPanel.add(newFile);

        openFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/abrir.png"))); // NOI18N
        openFile.setMinimumSize(new java.awt.Dimension(5, 5));
        openFile.setPreferredSize(new java.awt.Dimension(30, 30));
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        topPanel.add(openFile);

        saveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/guardar.png"))); // NOI18N
        saveFile.setMinimumSize(new java.awt.Dimension(5, 5));
        saveFile.setPreferredSize(new java.awt.Dimension(30, 30));
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });
        topPanel.add(saveFile);

        fileToolsSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        fileToolsSeparator.setPreferredSize(new java.awt.Dimension(1, 30));
        topPanel.add(fileToolsSeparator);

        tools.add(draw);
        draw.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/punto.png"))); // NOI18N
        draw.setSelected(true);
        draw.setMinimumSize(new java.awt.Dimension(5, 5));
        draw.setPreferredSize(new java.awt.Dimension(30, 30));
        draw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawActionPerformed(evt);
            }
        });
        topPanel.add(draw);

        tools.add(line);
        line.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/linea.png"))); // NOI18N
        line.setMinimumSize(new java.awt.Dimension(5, 5));
        line.setPreferredSize(new java.awt.Dimension(30, 30));
        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineActionPerformed(evt);
            }
        });
        topPanel.add(line);

        tools.add(rectangle);
        rectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rectangulo.png"))); // NOI18N
        rectangle.setMinimumSize(new java.awt.Dimension(5, 5));
        rectangle.setPreferredSize(new java.awt.Dimension(30, 30));
        rectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rectangleActionPerformed(evt);
            }
        });
        topPanel.add(rectangle);

        tools.add(oval);
        oval.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/elipse.png"))); // NOI18N
        oval.setMinimumSize(new java.awt.Dimension(5, 5));
        oval.setPreferredSize(new java.awt.Dimension(30, 30));
        oval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ovalActionPerformed(evt);
            }
        });
        topPanel.add(oval);

        tools.add(editMode);
        editMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/seleccion.png"))); // NOI18N
        editMode.setMinimumSize(new java.awt.Dimension(5, 5));
        editMode.setPreferredSize(new java.awt.Dimension(30, 30));
        editMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editModeActionPerformed(evt);
            }
        });
        topPanel.add(editMode);

        toolsAtributesSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        toolsAtributesSeparator.setPreferredSize(new java.awt.Dimension(1, 30));
        topPanel.add(toolsAtributesSeparator);

        stroke.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                strokeStateChanged(evt);
            }
        });
        topPanel.add(stroke);

        colors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Negro", "Rojo", "Azul", "Blanco", "Amarillo", "Verde" }));
        colors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorsActionPerformed(evt);
            }
        });
        topPanel.add(colors);

        fill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rellenar.png"))); // NOI18N
        fill.setMinimumSize(new java.awt.Dimension(5, 5));
        fill.setPreferredSize(new java.awt.Dimension(30, 30));
        fill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fillActionPerformed(evt);
            }
        });
        topPanel.add(fill);

        transparency.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/transparencia.png"))); // NOI18N
        transparency.setMinimumSize(new java.awt.Dimension(5, 5));
        transparency.setPreferredSize(new java.awt.Dimension(30, 30));
        transparency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transparencyActionPerformed(evt);
            }
        });
        topPanel.add(transparency);

        rendering.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/alisar.png"))); // NOI18N
        rendering.setMinimumSize(new java.awt.Dimension(5, 5));
        rendering.setPreferredSize(new java.awt.Dimension(30, 30));
        rendering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renderingActionPerformed(evt);
            }
        });
        topPanel.add(rendering);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        atributesPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        bottomPanel.add(atributesPanel, java.awt.BorderLayout.CENTER);

        statusPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        toolLabel.setText("Herramienta: ");
        statusPanel.add(toolLabel);

        tool.setText("Dibujo Libre");
        statusPanel.add(tool);

        colorLabel.setText("Color: ");
        statusPanel.add(colorLabel);

        color.setText("Negro");
        statusPanel.add(color);

        bottomPanel.add(statusPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        file.setText("File");

        create.setText("New...");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        file.add(create);

        open.setText("Open...");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        file.add(open);

        save.setText("Save...");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        menuBar.add(file);

        edit.setText("Edit");
        menuBar.add(edit);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFile()
    {
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showOpenDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION)
        {
            VentanaInterna vi = new VentanaInterna();
            File f = dlg.getSelectedFile();
            Image image = new ImageIcon(f.getAbsolutePath()).getImage();
            this.desktop.add(vi);
            vi.assignParent(this);
            vi.setVisible(true);
            repaint();
        }
    }
    
    private void saveFile()
    {
        JFileChooser dlg = new JFileChooser();
        int resp = dlg.showSaveDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION)
        {
            VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
            Lienzo2D lienzo = vi.getLienzo();
            File f = dlg.getSelectedFile();
            int w = lienzo.getWidth();
            int h = lienzo.getHeight();
            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bi.createGraphics();
            lienzo.paint(g);
            try
            {
                ImageIO.write(bi, "png", f);
            }
            catch (IOException ex)
            {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void createFile()
    {
        VentanaInterna vi = new VentanaInterna();
        this.desktop.add(vi);
        vi.assignParent(this);
        vi.setVisible(true);
    }
    
    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        openFile();
    }//GEN-LAST:event_openActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        saveFile();
    }//GEN-LAST:event_saveActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        createFile();
    }//GEN-LAST:event_createActionPerformed

    private void drawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.setTool(Tool.DRAW);
            this.tool.setText("Dibujo Libre");
            
            if(lienzo.isEditMode())
                lienzo.changeToEditMode();
        }
    }//GEN-LAST:event_drawActionPerformed

    private void lineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.setTool(Tool.LINE);
            this.tool.setText("Línea");
            
            if(lienzo.isEditMode())
                lienzo.changeToEditMode();
        }
    }//GEN-LAST:event_lineActionPerformed

    private void rectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rectangleActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.setTool(Tool.RECTANGLE);
            this.tool.setText("Rectángulo");
            
            if(lienzo.isEditMode())
                lienzo.changeToEditMode();
        }
    }//GEN-LAST:event_rectangleActionPerformed

    private void ovalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ovalActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.setTool(Tool.OVAL);
            this.tool.setText("Óvalo");
            
            if(lienzo.isEditMode())
                lienzo.changeToEditMode();
        }
    }//GEN-LAST:event_ovalActionPerformed

    private void strokeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_strokeStateChanged
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            float str = Float.parseFloat(this.stroke.getValue().toString());
            lienzo.setStroke(str);
        }
    }//GEN-LAST:event_strokeStateChanged

    private void fillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fillActionPerformed
         VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.changeFill();
        }
    }//GEN-LAST:event_fillActionPerformed

    private void transparencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transparencyActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.changeTransparency();
        }
    }//GEN-LAST:event_transparencyActionPerformed

    private void renderingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renderingActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.changeToRenderingMode();
        }
    }//GEN-LAST:event_renderingActionPerformed

    private void colorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorsActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            switch(colors.getSelectedItem().toString())
            {
                case "Negro":
                    lienzo.setActiveColor(new Color(0, 0, 0));
                    this.color.setText("Negro");
                    break;
                case "Rojo":
                    lienzo.setActiveColor(new Color(255,0,51));
                    this.color.setText("Rojo");
                    break;
                case "Azul":
                    lienzo.setActiveColor(new Color(0,51,255));
                    this.color.setText("Azul");
                    break;
                case "Blanco":
                    lienzo.setActiveColor(new Color(255,255,255));
                    this.color.setText("Blanco");
                    break;
                case "Amarillo":
                    lienzo.setActiveColor(new Color(255,255,0));
                    this.color.setText("Amarillo");
                    break;
                case "Verde":
                    lienzo.setActiveColor(new Color(51,255,0));
                    this.color.setText("Verde");
                    break;
            }
        }
    }//GEN-LAST:event_colorsActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        createFile();
    }//GEN-LAST:event_newFileActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        openFile();
    }//GEN-LAST:event_openFileActionPerformed

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        saveFile();
    }//GEN-LAST:event_saveFileActionPerformed

    private void editModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editModeActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        if(vi != null)
        {
            Lienzo2D lienzo = vi.getLienzo();
            lienzo.changeToEditMode();
            this.tool.setText("Modo Edición");
        }
    }//GEN-LAST:event_editModeActionPerformed

    public static void main(String args[])
    {
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        new VentanaPrincipal().setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atributesPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel color;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JComboBox<String> colors;
    private javax.swing.JMenuItem create;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JToggleButton draw;
    private javax.swing.JMenu edit;
    private javax.swing.JToggleButton editMode;
    private javax.swing.JMenu file;
    private javax.swing.JSeparator fileToolsSeparator;
    private javax.swing.JToggleButton fill;
    private javax.swing.JToggleButton line;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newFile;
    private javax.swing.JMenuItem open;
    private javax.swing.JButton openFile;
    private javax.swing.JToggleButton oval;
    private javax.swing.JToggleButton rectangle;
    private javax.swing.JToggleButton rendering;
    private javax.swing.JMenuItem save;
    private javax.swing.JButton saveFile;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JSpinner stroke;
    private javax.swing.JLabel tool;
    private javax.swing.JLabel toolLabel;
    private javax.swing.ButtonGroup tools;
    private javax.swing.JSeparator toolsAtributesSeparator;
    private javax.swing.JPanel topPanel;
    private javax.swing.JToggleButton transparency;
    // End of variables declaration//GEN-END:variables
}
