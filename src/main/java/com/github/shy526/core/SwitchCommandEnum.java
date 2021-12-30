package com.github.shy526.core;

import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.function.Function;

/**
 * @author Administrator
 */

public enum SwitchCommandEnum {
    /**
     * 时间转换
     */
    DATE_SWITCH("dateSwitch", new DateSwitchCommand()),
    /**
     * json字符串美化
     */
    JSON_SWITCH("jsonFormat", new JsonSwitchCommand());
    /**
     * 名称
     */
    private final String name;
    /**
     * 具体的指令
     */
    private final Function<JTextArea, String> command;

    SwitchCommandEnum(String name, Function<JTextArea, String> command) {
        this.name = name;
        this.command = command;
    }

    @Override
    public String toString() {
        return name;
    }

    public String execute(JTextArea sourceTextArea) {
        String apply = command.apply(sourceTextArea);
        if (StringUtils.isNotEmpty(apply)) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(apply), null);
        }
        return apply;
    }
}
