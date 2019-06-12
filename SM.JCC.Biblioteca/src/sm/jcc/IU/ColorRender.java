/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.jcc.IU;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author jcc
 */
public class ColorRender extends javax.swing.JPanel implements ListCellRenderer<Color>
{
    public ColorRender()
    {
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        color = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());
        add(color, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus)
    {
        color.setBackground(value);
        return this;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton color;
    // End of variables declaration//GEN-END:variables
}
