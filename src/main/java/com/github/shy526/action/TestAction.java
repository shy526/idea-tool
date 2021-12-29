package com.github.shy526.action;

import com.github.shy526.tool.NotificationSend;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author Administrator
 */
public class TestAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        NotificationSend.error("测试");
    }
}
