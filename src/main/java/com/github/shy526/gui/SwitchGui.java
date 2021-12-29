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
            if (selectedItem != null) {
                targetText.setText(selectedItem.execute(sourceText));
            }

        });
        for (SwitchCommandEnum value : SwitchCommandEnum.values()) {
            switchComboBox.addItem(value);
        }

    }

    public JPanel getContent() {
        return manPanel;
    }

}
