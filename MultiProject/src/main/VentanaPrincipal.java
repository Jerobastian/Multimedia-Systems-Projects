package main;

import java.awt.Color;
import sm.jcc.graficos.Tool;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.ConvolveOp;
import java.awt.image.DataBuffer;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sm.image.EqualizationOp;
import sm.image.KernelProducer;
import sm.image.LookupTableProducer;
import sm.image.TintOp;
import sm.jcc.IU.ColorRender;
import sm.jcc.IU.ImagePanel2D;
import sm.jcc.IU.Lienzo2D;
import sm.jcc.image.SepiaOp;
import sm.jcc.image.SinOp;
import sm.jcc.image.UmbralOp;
import sm.jcc.utils.FileTypeFilter;
import sm.sound.SMPlayer;
import sm.sound.SMRecorder;
import sm.sound.SMSoundPlayer;
import sm.sound.SMSoundRecorder;

/**
 *
 * @author jcc
 */

/**
 * Clase de la ventana principal del programa
 * @author jcc
 */
public class VentanaPrincipal extends javax.swing.JFrame 
{
    public VentanaPrincipal()
    {
        initComponents();
    }
    
    /**
     * Método que cambia los atributos del programa principal.
     * @param t Herramienta de dibujo
     * @param c Color actual
     * @param stroke
     * @param edit
     * @param aliasing
     * @param transparency
     * @param fill 
     */
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
        Color c[] = {Color.BLACK, Color.RED, Color.BLUE, Color.WHITE, Color.YELLOW, Color.GREEN};
        colors = new javax.swing.JComboBox<>(c);
        fill = new javax.swing.JToggleButton();
        transparency = new javax.swing.JToggleButton();
        rendering = new javax.swing.JToggleButton();
        attributesSeparator = new javax.swing.JSeparator();
        play = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        playlist = new javax.swing.JComboBox<>();
        record = new javax.swing.JButton();
        bottomPanel = new javax.swing.JPanel();
        atributesPanel = new javax.swing.JPanel();
        brightnessPanel = new javax.swing.JPanel();
        brightness = new javax.swing.JSlider();
        filterPanel = new javax.swing.JPanel();
        filter = new javax.swing.JComboBox<>();
        contrastPanel = new javax.swing.JPanel();
        contrast = new javax.swing.JButton();
        increaseContrast = new javax.swing.JButton();
        decreaseContrast = new javax.swing.JButton();
        sinusoidalPanel = new javax.swing.JPanel();
        sinusoidal = new javax.swing.JButton();
        sepia = new javax.swing.JButton();
        tint = new javax.swing.JButton();
        ecualizer = new javax.swing.JButton();
        colorBandsPanel = new javax.swing.JPanel();
        bands = new javax.swing.JButton();
        colorSpace = new javax.swing.JComboBox<>();
        rotationPanel = new javax.swing.JPanel();
        rotateGrade = new javax.swing.JSlider();
        rotate90 = new javax.swing.JButton();
        rotate180 = new javax.swing.JButton();
        rotate270 = new javax.swing.JButton();
        scalePanel = new javax.swing.JPanel();
        decreaseScale = new javax.swing.JButton();
        increaseScale = new javax.swing.JButton();
        umbralPanel = new javax.swing.JPanel();
        umbral = new javax.swing.JSlider();
        statusPanel = new javax.swing.JPanel();
        toolLabel = new javax.swing.JLabel();
        tool = new javax.swing.JLabel();
        colorLabel = new javax.swing.JLabel();
        color = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();
        rightPanel = new javax.swing.JPanel();
        shapesPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        create = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        fileSeparator = new javax.swing.JPopupMenu.Separator();
        view = new javax.swing.JMenu();
        topToolBar = new javax.swing.JCheckBoxMenuItem();
        imageToolBar = new javax.swing.JCheckBoxMenuItem();
        imageMenu = new javax.swing.JMenu();
        brightnessMenu = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1750, 1000));

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

        colors.setRenderer(new ColorRender());
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

        attributesSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        attributesSeparator.setMaximumSize(new java.awt.Dimension(1, 30));
        attributesSeparator.setMinimumSize(new java.awt.Dimension(1, 30));
        attributesSeparator.setPreferredSize(new java.awt.Dimension(1, 30));
        topPanel.add(attributesSeparator);

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/play24x24.png"))); // NOI18N
        play.setMaximumSize(new java.awt.Dimension(30, 30));
        play.setMinimumSize(new java.awt.Dimension(30, 30));
        play.setPreferredSize(new java.awt.Dimension(30, 30));
        play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playActionPerformed(evt);
            }
        });
        topPanel.add(play);

        stop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stop24x24.png"))); // NOI18N
        stop.setMaximumSize(new java.awt.Dimension(30, 30));
        stop.setMinimumSize(new java.awt.Dimension(30, 30));
        stop.setPreferredSize(new java.awt.Dimension(30, 30));
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });
        topPanel.add(stop);

        playlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playlistActionPerformed(evt);
            }
        });
        topPanel.add(playlist);

        record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/record24x24.png"))); // NOI18N
        record.setMaximumSize(new java.awt.Dimension(30, 30));
        record.setMinimumSize(new java.awt.Dimension(30, 30));
        record.setPreferredSize(new java.awt.Dimension(30, 30));
        record.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordActionPerformed(evt);
            }
        });
        topPanel.add(record);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        bottomPanel.setLayout(new java.awt.BorderLayout());

        atributesPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        brightnessPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Brillo"));

        brightness.setMinimum(-100);
        brightness.setValue(0);
        brightness.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                brightnessStateChanged(evt);
            }
        });
        brightness.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                brightnessFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brightnessFocusLost(evt);
            }
        });
        brightnessPanel.add(brightness);

        atributesPanel.add(brightnessPanel);

        filterPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Filtro"));

        filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Media", "Binomial", "Enfoque", "Relieve", "Laplaciano " }));
        filter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterItemStateChanged(evt);
            }
        });
        filterPanel.add(filter);

        atributesPanel.add(filterPanel);

        contrastPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Contraste"));

        contrast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/contraste.png"))); // NOI18N
        contrast.setMaximumSize(new java.awt.Dimension(25, 25));
        contrast.setMinimumSize(new java.awt.Dimension(5, 5));
        contrast.setPreferredSize(new java.awt.Dimension(25, 25));
        contrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrastActionPerformed(evt);
            }
        });
        contrastPanel.add(contrast);

        increaseContrast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iluminar.png"))); // NOI18N
        increaseContrast.setMaximumSize(new java.awt.Dimension(25, 25));
        increaseContrast.setMinimumSize(new java.awt.Dimension(25, 25));
        increaseContrast.setPreferredSize(new java.awt.Dimension(25, 25));
        increaseContrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseContrastActionPerformed(evt);
            }
        });
        contrastPanel.add(increaseContrast);

        decreaseContrast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/oscurecer.png"))); // NOI18N
        decreaseContrast.setMaximumSize(new java.awt.Dimension(25, 25));
        decreaseContrast.setMinimumSize(new java.awt.Dimension(25, 25));
        decreaseContrast.setPreferredSize(new java.awt.Dimension(25, 25));
        decreaseContrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseContrastActionPerformed(evt);
            }
        });
        contrastPanel.add(decreaseContrast);

        atributesPanel.add(contrastPanel);

        sinusoidalPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        sinusoidal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sinusoidal.png"))); // NOI18N
        sinusoidal.setMaximumSize(new java.awt.Dimension(40, 35));
        sinusoidal.setMinimumSize(new java.awt.Dimension(40, 35));
        sinusoidal.setPreferredSize(new java.awt.Dimension(40, 35));
        sinusoidal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sinusoidalActionPerformed(evt);
            }
        });
        sinusoidalPanel.add(sinusoidal);

        sepia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/sepia.png"))); // NOI18N
        sepia.setMaximumSize(new java.awt.Dimension(45, 35));
        sepia.setMinimumSize(new java.awt.Dimension(45, 35));
        sepia.setPreferredSize(new java.awt.Dimension(45, 35));
        sepia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sepiaActionPerformed(evt);
            }
        });
        sinusoidalPanel.add(sepia);

        tint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tintar.png"))); // NOI18N
        tint.setMaximumSize(new java.awt.Dimension(45, 35));
        tint.setMinimumSize(new java.awt.Dimension(45, 35));
        tint.setPreferredSize(new java.awt.Dimension(45, 35));
        tint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tintActionPerformed(evt);
            }
        });
        sinusoidalPanel.add(tint);

        ecualizer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ecualizar.png"))); // NOI18N
        ecualizer.setMaximumSize(new java.awt.Dimension(45, 35));
        ecualizer.setMinimumSize(new java.awt.Dimension(45, 35));
        ecualizer.setPreferredSize(new java.awt.Dimension(45, 35));
        ecualizer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecualizerActionPerformed(evt);
            }
        });
        sinusoidalPanel.add(ecualizer);

        atributesPanel.add(sinusoidalPanel);

        colorBandsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Color"));

        bands.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bandas.png"))); // NOI18N
        bands.setMaximumSize(new java.awt.Dimension(35, 35));
        bands.setMinimumSize(new java.awt.Dimension(35, 35));
        bands.setPreferredSize(new java.awt.Dimension(35, 35));
        bands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bandsActionPerformed(evt);
            }
        });
        colorBandsPanel.add(bands);

        colorSpace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RBG", "YCC", "Grey" }));
        colorSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorSpaceActionPerformed(evt);
            }
        });
        colorBandsPanel.add(colorSpace);

        atributesPanel.add(colorBandsPanel);

        rotationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Rotación"));

        rotateGrade.setMaximum(360);
        rotateGrade.setMinimum(-360);
        rotateGrade.setValue(0);
        rotateGrade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rotateGradeStateChanged(evt);
            }
        });
        rotateGrade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rotateGradeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rotateGradeFocusLost(evt);
            }
        });
        rotationPanel.add(rotateGrade);

        rotate90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rotacion90.png"))); // NOI18N
        rotate90.setMaximumSize(new java.awt.Dimension(25, 25));
        rotate90.setMinimumSize(new java.awt.Dimension(25, 25));
        rotate90.setPreferredSize(new java.awt.Dimension(25, 25));
        rotate90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotate90ActionPerformed(evt);
            }
        });
        rotationPanel.add(rotate90);

        rotate180.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rotacion180.png"))); // NOI18N
        rotate180.setMaximumSize(new java.awt.Dimension(25, 25));
        rotate180.setMinimumSize(new java.awt.Dimension(25, 25));
        rotate180.setPreferredSize(new java.awt.Dimension(25, 25));
        rotate180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotate180ActionPerformed(evt);
            }
        });
        rotationPanel.add(rotate180);

        rotate270.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rotacion270.png"))); // NOI18N
        rotate270.setMaximumSize(new java.awt.Dimension(25, 25));
        rotate270.setMinimumSize(new java.awt.Dimension(25, 25));
        rotate270.setPreferredSize(new java.awt.Dimension(25, 25));
        rotate270.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotate270ActionPerformed(evt);
            }
        });
        rotationPanel.add(rotate270);

        atributesPanel.add(rotationPanel);

        scalePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Escala"));

        decreaseScale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disminuir.png"))); // NOI18N
        decreaseScale.setMaximumSize(new java.awt.Dimension(25, 25));
        decreaseScale.setMinimumSize(new java.awt.Dimension(25, 25));
        decreaseScale.setPreferredSize(new java.awt.Dimension(25, 25));
        decreaseScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decreaseScaleActionPerformed(evt);
            }
        });
        scalePanel.add(decreaseScale);

        increaseScale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/aumentar.png"))); // NOI18N
        increaseScale.setMaximumSize(new java.awt.Dimension(25, 25));
        increaseScale.setMinimumSize(new java.awt.Dimension(25, 25));
        increaseScale.setPreferredSize(new java.awt.Dimension(25, 25));
        increaseScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseScaleActionPerformed(evt);
            }
        });
        scalePanel.add(increaseScale);

        atributesPanel.add(scalePanel);

        umbralPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Umbralización"));

        umbral.setMaximum(255);
        umbral.setValue(128);
        umbral.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                umbralStateChanged(evt);
            }
        });
        umbral.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                umbralFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                umbralFocusLost(evt);
            }
        });
        umbralPanel.add(umbral);

        atributesPanel.add(umbralPanel);

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

        rightPanel.setLayout(new java.awt.BorderLayout());

        shapesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Figuras"));
        rightPanel.add(shapesPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(rightPanel, java.awt.BorderLayout.LINE_END);

        file.setText("Archivo");

        create.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        create.setText("Nuevo...");
        create.setToolTipText("Nueva imagen");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        file.add(create);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        open.setText("Abrir...");
        open.setToolTipText("Abrir archivo");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        file.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Guardar...");
        save.setToolTipText("Guardar archivo");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);
        file.add(fileSeparator);

        menuBar.add(file);

        view.setText("Ver");

        topToolBar.setSelected(true);
        topToolBar.setText("Barra de herramientas");
        topToolBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topToolBarActionPerformed(evt);
            }
        });
        view.add(topToolBar);

        imageToolBar.setSelected(true);
        imageToolBar.setText("Barra de imagen");
        imageToolBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageToolBarActionPerformed(evt);
            }
        });
        view.add(imageToolBar);

        menuBar.add(view);

        imageMenu.setText("Image");

        brightnessMenu.setText("Brillo");
        imageMenu.add(brightnessMenu);

        menuBar.add(imageMenu);

        help.setText("Ayuda");

        about.setText("Acerca de...");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        menuBar.add(help);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFile()
    {
        JFileChooser dlg = new JFileChooser();
        dlg.addChoosableFileFilter(new FileTypeFilter(".wav", "Ficheros de audio"));
        dlg.addChoosableFileFilter(new FileTypeFilter(".jpg", "Ficheros de imagen"));
        dlg.addChoosableFileFilter(new FileTypeFilter(".png", "Ficheros de imagen con transparencia"));
        int resp = dlg.showOpenDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION)
        {
            File f = new File(dlg.getSelectedFile().getAbsolutePath())
            {
                @Override
                public String toString(){return this.getName();}
            };
            
            try
            {
                if(f.getName().endsWith(".png")||f.getName().endsWith(".jpg"))
                {
                    BufferedImage img = ImageIO.read(f);
                    VentanaInterna vi = new VentanaInterna();
                    vi.assignParent(this);
                    vi.setImage(img);
                    this.desktop.add(vi);
                    vi.setTitle(f.getName() + " [RGB]");
                    vi.setVisible(true);
                }
                else if(f.getName().endsWith(".wav"))
                {
                    this.playlist.addItem(f);
                }
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(this, "No se ha podido abrir el archivo\n", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    private void saveFile()
    {
        JFileChooser dlg = new JFileChooser();
        dlg.addChoosableFileFilter(new FileTypeFilter(".wav", "Ficheros de audio"));
        dlg.addChoosableFileFilter(new FileTypeFilter(".jpg", "Ficheros de imagen"));
        dlg.addChoosableFileFilter(new FileTypeFilter(".png", "Ficheros de imagen con transparencia"));
        int resp = dlg.showSaveDialog(this);
        
        if( resp == JFileChooser.APPROVE_OPTION)
        {
            File f = dlg.getSelectedFile();
            
            if(f.getName().endsWith(".wav"))
            {
                this.recordFile = new File(f.getAbsolutePath())
                {
                    @Override
                    public String toString(){return this.getName();}
                };
                try
                {
                    this.recordFile.createNewFile();
                }
                 catch (IOException ex)
                {
                   JOptionPane.showMessageDialog(this, "No se ha podido guardar el archivo\n", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
            else if(f.getName().endsWith(".png")||f.getName().endsWith(".jpg"))
            {
                VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
                ImagePanel2D lienzo = vi.getLienzo();
                String extension = f.getName().substring(f.getName().lastIndexOf('.') + 1);
                int w = lienzo.getImage().getWidth();
                int h = lienzo.getImage().getHeight();
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = bi.createGraphics();
                lienzo.paint(g);
                try
                {
                    if(!f.exists())
                        f.createNewFile();

                    ImageIO.write(bi, extension, f);
                }
                catch (IOException ex)
                {
                    JOptionPane.showMessageDialog(this, "No se ha podido guardar el archivo\n", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
    
    private void createFile()
    {
        String data;
        String[] attributes = new String[2];
        for(int i = 0; i < 2; i++)
        {
            if(i==0)
               data = "ancho";
            else
                data = "alto";
            attributes[i] = JOptionPane.showInputDialog(this, "Introduzca el " + data + ":", "Datos necesarios", JOptionPane.QUESTION_MESSAGE);
        }

        VentanaInterna vi = new VentanaInterna(Integer.parseInt(attributes[0]), Integer.parseInt(attributes[1]));
        this.desktop.add(vi);
        vi.setTitle("Nueva [RGB]");
        vi.assignParent(this);
        vi.setVisible(true);
    }
    
    private void LookupFilter(int type)
    {
        VentanaInterna vi = (VentanaInterna) (this.desktop.getSelectedFrame());
        if (vi != null)
        {
           BufferedImage imgSource = vi.getLienzo().getImage();

           if(imgSource!=null)
           {
               try
               {
                   LookupTable lt = LookupTableProducer.createLookupTable(type);
                   LookupOp lop = new LookupOp(lt, null);
                   lop.filter(imgSource , imgSource);
                   vi.repaint();
               }
               catch(Exception e)
               {
                   System.err.println(e.getLocalizedMessage());
               }
           }
        }
    }
    
    private void rotateImage(double degrees)
    {
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            image = vi.getLienzo().getImage();
            
            if(image != null)
                rotate(degrees, image, vi);
        }
    }
    
    private void rotate(double degrees, BufferedImage image, VentanaInterna vi)
    {
        double r = Math.toRadians(degrees);
        Point p = new Point(image.getWidth()/2, image.getHeight()/2);
        AffineTransform at = AffineTransform.getRotateInstance(r,p.x,p.y);
        AffineTransformOp atop;
        atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
        BufferedImage imgdest = atop.filter(image, null);
        vi.setImage(imgdest);
        repaint();
    }
    
    private void scale(double scale)
    {
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            image = vi.getLienzo().getImage();
            
            if(image != null)
            {
                AffineTransform at = AffineTransform.getScaleInstance(scale, scale);
                AffineTransformOp atop;
                atop = new AffineTransformOp(at,AffineTransformOp.TYPE_BILINEAR);
                BufferedImage imgdest = atop.filter(image, null);
                vi.setImage(imgdest);
                repaint();
            }
        }
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
            switch(colors.getSelectedIndex())
            {
                case 0:
                    lienzo.setActiveColor(new Color(0, 0, 0));
                    this.color.setText("Negro");
                    break;
                case 1:
                    lienzo.setActiveColor(new Color(255,0,51));
                    this.color.setText("Rojo");
                    break;
                case 2:
                    lienzo.setActiveColor(new Color(0,51,255));
                    this.color.setText("Azul");
                    break;
                case 3:
                    lienzo.setActiveColor(new Color(255,255,255));
                    this.color.setText("Blanco");
                    break;
                case 4:
                    lienzo.setActiveColor(new Color(255,255,0));
                    this.color.setText("Amarillo");
                    break;
                case 5:
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

    private void brightnessFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brightnessFocusGained
         VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
         
         if(vi!=null)
         {
            ColorModel cm = vi.getLienzo().getImage().getColorModel();
            WritableRaster raster = vi.getLienzo().getImage().copyData(null);
            boolean alfaPre = vi.getLienzo().getImage().isAlphaPremultiplied();
            image = new BufferedImage(cm,raster,alfaPre,null);
         }
    }//GEN-LAST:event_brightnessFocusGained

    private void brightnessFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brightnessFocusLost
        image = null;
        brightness.setValue(0);
    }//GEN-LAST:event_brightnessFocusLost

    private void brightnessStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_brightnessStateChanged
        VentanaInterna vi = (VentanaInterna)(desktop.getSelectedFrame());
        
        if(vi!=null && image!=null && brightness.hasFocus())
        {       
            try
            {
                RescaleOp rop;
                if (this.image.getColorModel().hasAlpha())
                {
                    float[] scales = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
                    float bright = this.brightness.getValue();
                    float[] offsets = new float[]{bright, bright, bright, 0.0f};
                    rop = new RescaleOp(scales, offsets, null);
                }
                else if(!image.getColorModel().getColorSpace().isCS_sRGB()
                        &&
                        image.getRaster().getNumBands() > 1)
                {
                    float[] scales = new float[]{1.0f, 1.0f, 1.0f};
                    float bright = this.brightness.getValue();
                    float[] offsets = new float[]{bright, 0.0f, 0.0f};
                    rop = new RescaleOp(scales, offsets, null);
                }
                else
                    rop = new RescaleOp(1.0f, this.brightness.getValue(), null);
                
                rop.filter(image, vi.getLienzo().getImage());
                repaint();
            }
            catch(IllegalArgumentException e)
            {
                System.err.println(e.getLocalizedMessage());
            }    
        }
    }//GEN-LAST:event_brightnessStateChanged

    private void filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterItemStateChanged
        Kernel k;
        ConvolveOp cop;
        
        k = KernelProducer.createKernel(0);
        
        VentanaInterna vi = (VentanaInterna)(desktop.getSelectedFrame());
        
        if(vi!=null)
        {
            image = vi.getLienzo().getImage();
            
            if(image!=null)
            {
                switch(filter.getSelectedIndex())
                {
                    case 0:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_MEDIA_3x3);
                        break;
                    case 1:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_BINOMIAL_3x3);
                        break;
                    case 2:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_ENFOQUE_3x3);
                        break;
                    case 3:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_RELIEVE_3x3);
                        break;
                    case 4:
                        k = KernelProducer.createKernel(KernelProducer.TYPE_LAPLACIANA_3x3);
                }

                cop = new ConvolveOp(k, ConvolveOp.EDGE_NO_OP, null);

                BufferedImage dest = cop.filter(image, null);
                vi.setImage(dest);
                repaint();
            }
        }
    }//GEN-LAST:event_filterItemStateChanged

    private void contrastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrastActionPerformed
        LookupFilter(LookupTableProducer.TYPE_SFUNCION);
    }//GEN-LAST:event_contrastActionPerformed

    private void increaseContrastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseContrastActionPerformed
        LookupFilter(LookupTableProducer.TYPE_LOGARITHM);
    }//GEN-LAST:event_increaseContrastActionPerformed

    private void decreaseContrastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseContrastActionPerformed
        LookupFilter(LookupTableProducer.TYPE_POWER);
    }//GEN-LAST:event_decreaseContrastActionPerformed

    private void sinusoidalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sinusoidalActionPerformed
        VentanaInterna vi = (VentanaInterna)(desktop.getSelectedFrame());
        
        if (vi != null)
        {
            BufferedImage imgSource = vi.getLienzo().getImage();
            if (imgSource != null)
            {
                try
                {
                    LookupOp lop = new LookupOp(SinOp.sinFilter(180.0), null);
                    lop.filter(imgSource, imgSource);
                    repaint();
                }
                catch (Exception e)
                {
                    System.err.println(e.getLocalizedMessage());
                }
            }
        }
    }//GEN-LAST:event_sinusoidalActionPerformed

    private void rotate180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotate180ActionPerformed
        rotateImage(180);
    }//GEN-LAST:event_rotate180ActionPerformed

    private void rotate90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotate90ActionPerformed
        rotateImage(90);
    }//GEN-LAST:event_rotate90ActionPerformed

    private void rotate270ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotate270ActionPerformed
        rotateImage(270);
    }//GEN-LAST:event_rotate270ActionPerformed

    private void rotateGradeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rotateGradeStateChanged
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null && image != null)
            rotate(rotateGrade.getValue(), image, vi);
    }//GEN-LAST:event_rotateGradeStateChanged

    private void rotateGradeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rotateGradeFocusGained
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
            image = vi.getLienzo().getImage();
    }//GEN-LAST:event_rotateGradeFocusGained

    private void rotateGradeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rotateGradeFocusLost
        image = null;
        
        rotateGrade.setValue(0);
    }//GEN-LAST:event_rotateGradeFocusLost

    private void decreaseScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decreaseScaleActionPerformed
        scale(0.75);
    }//GEN-LAST:event_decreaseScaleActionPerformed

    private void increaseScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseScaleActionPerformed
        scale(1.25);
    }//GEN-LAST:event_increaseScaleActionPerformed

    private void bandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bandsActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            this.image = vi.getLienzo().getImage();
            
            if(this.image != null)
            {
                ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
               
                ComponentColorModel cm = new ComponentColorModel(cs, false, false,
                Transparency.OPAQUE,
                DataBuffer.TYPE_BYTE);

                for(int i=0; i < this.image.getRaster().getNumBands(); i++)
                {
                    int bandList[] = {i}; 
                    WritableRaster bandRaster = (WritableRaster)
                            this.image.getRaster().createWritableChild(0,0,
                            this.image.getWidth(), this.image.getHeight(),
                            0, 0, bandList);
                    BufferedImage imgBanda = new BufferedImage(cm, 
                            bandRaster, false, null);
                    VentanaInterna bandWindow = new VentanaInterna();
                    bandWindow.setTitle(vi.getTitle() + " Banda " + i);
                    bandWindow.getLienzo().setImage(imgBanda);
                    this.desktop.add(bandWindow);
                    bandWindow.assignParent(this);
                    bandWindow.setVisible(true);
                }
                
                repaint();
            }
        }
    }//GEN-LAST:event_bandsActionPerformed

    private void colorSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorSpaceActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            image = vi.getLienzo().getImage();
            
            if(image != null)
            {
                ColorSpace cs = null;
                String space = "";
                switch(colorSpace.getSelectedIndex())
                {
                    case 0:
                        if (!image.getColorModel().getColorSpace().isCS_sRGB()
                                &&
                                image.getRaster().getNumBands() > 1)
                        {   
                            cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
                            space = "[RGB]";
                        }
                        break;
                    case 1:
                        if (image.getColorModel().getColorSpace().isCS_sRGB())
                        {
                            cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                            space = "[YCC]";
                        }
                        break;
                    case 2:
                        if (image.getRaster().getNumBands() > 1)
                        {   
                            cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
                            space = "[GRAY]";
                        }
                        break;
                }
                
                if(cs != null)
                {
                    ColorConvertOp cop = new ColorConvertOp(cs, null);
                    BufferedImage imgdest = cop.filter(image, null);
                    VentanaInterna newWindow = new VentanaInterna();
                    newWindow.setTitle(vi.getTitle().substring(0, vi.getTitle().indexOf('[')) + space);
                    newWindow.assignParent(this);
                    newWindow.setImage(imgdest);
                    this.desktop.add(newWindow);
                    newWindow.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_colorSpaceActionPerformed

    private void tintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tintActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            BufferedImage img = vi.getLienzo().getImage();
            if(img != null)
            {
                TintOp tintop = new TintOp(vi.getLienzo().getActiveColor(),0.5f);
                tintop.filter(img, img);
            }
        }
        
        repaint();
    }//GEN-LAST:event_tintActionPerformed

    private void ecualizerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecualizerActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            BufferedImage img = vi.getLienzo().getImage();
            
            if(img != null)
            {
                EqualizationOp ecualization = new EqualizationOp();
                
                ColorSpace cs;
                BufferedImage imgDest;
                if(img.getColorModel().getColorSpace().isCS_sRGB())
                {
                    cs = ColorSpace.getInstance(ColorSpace.CS_PYCC);
                    ColorConvertOp cop = new ColorConvertOp(cs, null);
                    imgDest = cop.filter(img, null);
                }
                else
                {
                    imgDest = img;
                }
                
                if(img.getRaster().getNumBands() > 1)
                {
                    cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);

                    ComponentColorModel cm = new ComponentColorModel(cs,
                            false, false,
                            Transparency.OPAQUE,
                            DataBuffer.TYPE_BYTE);
                    int bandList[] = {0}; 
                    WritableRaster bandRaster = (WritableRaster)
                            imgDest.getRaster().createWritableChild(0,0,
                            imgDest.getWidth(), imgDest.getHeight(),
                            0, 0, bandList);
                    BufferedImage imgBanda = new BufferedImage(cm, 
                            bandRaster, false, null);
                    ecualization.filter(imgBanda, imgBanda);
                    if(img.getColorModel().getColorSpace().isCS_sRGB())
                    {
                        cs = ColorSpace.getInstance(ColorSpace.CS_sRGB);
                        ColorConvertOp cop = new ColorConvertOp(cs, null);
                        cop.filter(imgDest, img);
                    }
                }
                else
                {
                    ecualization.filter(imgDest, img);
                }
            }
        }
        
        repaint();
    }//GEN-LAST:event_ecualizerActionPerformed

    private void playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playActionPerformed
        this.player.play();
    }//GEN-LAST:event_playActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        this.player.stop();
        this.player = null;
    }//GEN-LAST:event_stopActionPerformed

    private void recordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordActionPerformed
        if(this.recorder == null)
        {
            saveFile();
            this.recorder = new SMSoundRecorder(this.recordFile);
            ((SMSoundRecorder) this.recorder).addLineListener(new AudioManager());
            this.recorder.record();
           
        }
        else
        {
            this.recorder.stop();
            this.playlist.addItem(this.recordFile);
            this.recorder = null;
        }
    }//GEN-LAST:event_recordActionPerformed

    private void playlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playlistActionPerformed
        File f = (File)this.playlist.getSelectedItem();
        if(f!=null)
        {
            this.player = new SMSoundPlayer(f);
            ((SMSoundPlayer)this.player).addLineListener(new AudioManager());
        }
    }//GEN-LAST:event_playlistActionPerformed

    private void sepiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sepiaActionPerformed
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
        
        if(vi != null)
        {
            BufferedImage img = vi.getLienzo().getImage();
            if(img != null)
            {
                SepiaOp sepiaop = new SepiaOp();
                sepiaop.filter(img, img);
            }
        }
        
        repaint();
    }//GEN-LAST:event_sepiaActionPerformed

    private void umbralFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_umbralFocusGained
        VentanaInterna vi = (VentanaInterna) this.desktop.getSelectedFrame();
         
        if(vi!=null)
        {
           ColorModel cm = vi.getLienzo().getImage().getColorModel();
           WritableRaster raster = vi.getLienzo().getImage().copyData(null);
           boolean alfaPre = vi.getLienzo().getImage().isAlphaPremultiplied();
           this.image = new BufferedImage(cm,raster,alfaPre,null);
        }
    }//GEN-LAST:event_umbralFocusGained

    private void umbralFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_umbralFocusLost
        this.image = null;
        this.umbral.setValue(0);
    }//GEN-LAST:event_umbralFocusLost

    private void umbralStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_umbralStateChanged
        VentanaInterna vi = (VentanaInterna)this.desktop.getSelectedFrame();
        
        if(vi!=null && this.image!=null && this.umbral.hasFocus())
        {       
            try
            {
                UmbralOp umbralOp;
                umbralOp = new UmbralOp(this.umbral.getValue());
                
                umbralOp.filter(image, vi.getLienzo().getImage());
                repaint();
            }
            catch(IllegalArgumentException e)
            {
                System.err.println(e.getLocalizedMessage());
            }
        }
    }//GEN-LAST:event_umbralStateChanged

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        JOptionPane.showMessageDialog(this, "MultiProject\nVersion: 1.0\nAuthor: Jerónimo Chaves Caballero");
    }//GEN-LAST:event_aboutActionPerformed

    private void topToolBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topToolBarActionPerformed
        this.topPanel.setVisible(this.topToolBar.isSelected());
    }//GEN-LAST:event_topToolBarActionPerformed

    private void imageToolBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageToolBarActionPerformed
        this.atributesPanel.setVisible(this.imageToolBar.isSelected());
    }//GEN-LAST:event_imageToolBarActionPerformed
    
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
    
    private BufferedImage image;
    private boolean yetPlayed;
    private File recordFile;
    private BufferedImage bandedImage;
    private SMPlayer player = null;
    private SMRecorder recorder = null;
    
    public class AudioManager implements LineListener
    {
        @Override
        public void update(LineEvent event)
        {
            if (event.getType() == LineEvent.Type.OPEN)
            {
                yetPlayed = false;
            }
            if (event.getType() == LineEvent.Type.START)
            {
                if("com.sun.media.sound.DirectAudioDevice.DirectTDL".equals(event.getSource().getClass().getCanonicalName()))
                {
                    record.setIcon
                    (
                        new javax.swing.ImageIcon
                        (
                            getClass().getResource("/icons/stopRecord24x24.png")
                        )
                    );
                    play.setEnabled(false);
                    stop.setEnabled(false);
                }
                else if("com.sun.media.sound.DirectAudioDevice.DirectSDL".equals(event.getSource().getClass().getCanonicalName()))
                {
                    yetPlayed = true;
                    play.setIcon
                    (
                        new javax.swing.ImageIcon
                        (
                            getClass().getResource("/icons/pausa24x24.png")
                        )
                    );
                    record.setEnabled(false);
                }
            }
            if (event.getType() == LineEvent.Type.STOP)
            {
                if("com.sun.media.sound.DirectAudioDevice.DirectTDL".equals(event.getSource().getClass().getCanonicalName()))
                {
                    record.setIcon
                    (
                        new javax.swing.ImageIcon
                        (
                            getClass().getResource("/icons/record24x24.png")
                        )
                    );
                    play.setEnabled(true);
                    stop.setEnabled(true);
                }
                else if("com.sun.media.sound.DirectAudioDevice.DirectSDL".equals(event.getSource().getClass().getCanonicalName()))
                {
                    play.setIcon
                    (
                        new javax.swing.ImageIcon
                        (
                            getClass().getResource("/icons/play24x24.png")
                        )
                    );
                    record.setEnabled(true);
                }
            }
            if (event.getType() == LineEvent.Type.CLOSE){}
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem about;
    private javax.swing.JPanel atributesPanel;
    private javax.swing.JSeparator attributesSeparator;
    private javax.swing.JButton bands;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JSlider brightness;
    private javax.swing.JMenuItem brightnessMenu;
    private javax.swing.JPanel brightnessPanel;
    private javax.swing.JLabel color;
    private javax.swing.JPanel colorBandsPanel;
    private javax.swing.JLabel colorLabel;
    private javax.swing.JComboBox<String> colorSpace;
    private javax.swing.JComboBox<Color> colors;
    private javax.swing.JButton contrast;
    private javax.swing.JPanel contrastPanel;
    private javax.swing.JMenuItem create;
    private javax.swing.JButton decreaseContrast;
    private javax.swing.JButton decreaseScale;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JToggleButton draw;
    private javax.swing.JButton ecualizer;
    private javax.swing.JToggleButton editMode;
    private javax.swing.JMenu file;
    private javax.swing.JPopupMenu.Separator fileSeparator;
    private javax.swing.JSeparator fileToolsSeparator;
    private javax.swing.JToggleButton fill;
    private javax.swing.JComboBox<String> filter;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JMenu help;
    private javax.swing.JMenu imageMenu;
    private javax.swing.JCheckBoxMenuItem imageToolBar;
    private javax.swing.JButton increaseContrast;
    private javax.swing.JButton increaseScale;
    private javax.swing.JToggleButton line;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton newFile;
    private javax.swing.JMenuItem open;
    private javax.swing.JButton openFile;
    private javax.swing.JToggleButton oval;
    private javax.swing.JButton play;
    private javax.swing.JComboBox<File> playlist;
    private javax.swing.JButton record;
    private javax.swing.JToggleButton rectangle;
    private javax.swing.JToggleButton rendering;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JButton rotate180;
    private javax.swing.JButton rotate270;
    private javax.swing.JButton rotate90;
    private javax.swing.JSlider rotateGrade;
    private javax.swing.JPanel rotationPanel;
    private javax.swing.JMenuItem save;
    private javax.swing.JButton saveFile;
    private javax.swing.JPanel scalePanel;
    private javax.swing.JButton sepia;
    private javax.swing.JPanel shapesPanel;
    private javax.swing.JButton sinusoidal;
    private javax.swing.JPanel sinusoidalPanel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton stop;
    private javax.swing.JSpinner stroke;
    private javax.swing.JButton tint;
    private javax.swing.JLabel tool;
    private javax.swing.JLabel toolLabel;
    private javax.swing.ButtonGroup tools;
    private javax.swing.JSeparator toolsAtributesSeparator;
    private javax.swing.JPanel topPanel;
    private javax.swing.JCheckBoxMenuItem topToolBar;
    private javax.swing.JToggleButton transparency;
    private javax.swing.JSlider umbral;
    private javax.swing.JPanel umbralPanel;
    private javax.swing.JMenu view;
    // End of variables declaration//GEN-END:variables
}
