package com.github.shy526.core;

import javax.swing.*;
import java.util.function.Function;

/**
 * @author Administrator
 */

public enum SwitchCommandEnum {
    /**
     * 时间转换
     */
    DATE_SWITCH("s/m<-->yyyy-MM-dd HH:mm:ss", new DateSwitchFunc());
    /**
     * 名称
     */
    private final String name;
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
        return command.apply(sourceTextArea);
    }
}
