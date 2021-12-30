package com.github.shy526.core;

import com.github.shy526.tool.NotificationSend;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * @author Administrator
 */
public class DateSwitchCommand implements Function<JTextArea, String> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final Pattern DATE_FORMAT_PATTERN = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
    private static final Pattern MS_PATTERN = Pattern.compile("\\d+");

    @Override
    public String apply(JTextArea sourceTextArea) {
        boolean flag = false;
        String sourceText = sourceTextArea.getText();
        if (StringUtils.isEmpty(sourceText)) {
            sourceText = System.currentTimeMillis() + "";

        } else {
            sourceText = sourceText.trim();
            flag = DATE_FORMAT_PATTERN.matcher(sourceText).matches();
        }
        String result = "";
        if (flag) {
            try {
                result = DATE_FORMAT.parse(sourceText).getTime() + "";
            } catch (ParseException e) {
                NotificationSend.error(e.getMessage(), 1000);
            }
        } else {
            if (!MS_PATTERN.matcher(sourceText).matches()) {
                NotificationSend.error("input error", 1000);
                return "";
            }
            int sub = 13 - sourceText.length();
            if (sub < 0) {
                NotificationSend.error("input error", 1000);
                return "";
            }
            //不满13位
            sourceText += "0".repeat(13 - sourceText.length());
            sourceTextArea.setText(sourceText);
            result = DATE_FORMAT.format(new Date(Long.parseLong(sourceText)));
        }
        return result;
    }
}
