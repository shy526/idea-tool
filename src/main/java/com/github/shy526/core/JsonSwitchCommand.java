package com.github.shy526.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.util.function.Function;

public class JsonSwitchCommand implements Function<JTextArea, String> {
    @Override
    public String apply(JTextArea jTextArea) {
        final String text = jTextArea.getText();
        String result = "";
        if (StringUtils.isEmpty(text)) {
            return result;
        }
        JSONObject object = JSONObject.parseObject(text);
        result = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        return result;
    }
}
