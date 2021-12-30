package com.github.shy526.gui;

import com.github.shy526.core.SwitchCommandEnum;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.DocumentAdapter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Administrator
 */
public class SwitchGui {
    private static final String LABEL_FORMAT = "length:%s";
    private JTextArea sourceText;
    private JTextArea targetText;
    private JButton switchButton;
    private JPanel manPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel centrePanel;
    private JLabel sourceLabel;
    private JLabel targetLabel;
    private ComboBox<SwitchCommandEnum> switchComboBox;

    public SwitchGui() {
        init();
        switchButton.addActionListener(e -> {
            SwitchCommandEnum commandEnum = switchComboBox.getItem();
            if (commandEnum != null) {
                targetText.setText(commandEnum.execute(sourceText));
            }
        });
        switchComboBox.addActionListener(e -> {
            switchButton.doClick();
        });
        sourceText.getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(@NotNull DocumentEvent e) {
                sourceLabel.setText(String.format(LABEL_FORMAT, sourceText.getText().length()));
            }
        });
        targetText.getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(@NotNull DocumentEvent e) {
                targetLabel.setText(String.format(LABEL_FORMAT, targetText.getText().length()));
            }
        });

    }

    private void init() {
        for (SwitchCommandEnum value : SwitchCommandEnum.values()) {
            switchComboBox.addItem(value);
        }
        sourceLabel.setText(String.format(LABEL_FORMAT, 0));
        targetLabel.setText(String.format(LABEL_FORMAT, 0));
    }

    public JPanel getContent() {
        return manPanel;
    }


}
