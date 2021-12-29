package com.github.shy526.gui;

import com.github.shy526.core.SwitchCommandEnum;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class SwitchGui {
    private JTextArea sourceText;
    private JTextArea targetText;
    private JButton switchButton;
    private JPanel manPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centrePanel;
    private JComboBox<SwitchCommandEnum> switchComboBox;

    public SwitchGui() {
        switchButton.addActionListener(e -> {
            SwitchCommandEnum selectedItem = ((SwitchCommandEnum) switchComboBox.getSelectedItem());
            targetText.setText(selectedItem.execute(sourceText));
        });
        for (SwitchCommandEnum value : SwitchCommandEnum.values()) {
            switchComboBox.addItem(value);
        }

    }

    public JPanel getContent() {
        return manPanel;
    }

    public static JFrame getFrame(SwitchGui switchGui) {
        JFrame frame = new JFrame("MainForm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(switchGui.getContent());
        frame.setSize(600, 500);
        frame.setPreferredSize(new Dimension(600, 500));
        frame.pack();
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {
        getFrame(new SwitchGui());
    }
}
