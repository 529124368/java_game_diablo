package com.niubi.config;

public class Define {
    // 动作类型
    public enum Action {
        Idle, Attack, Run
    }

    // 控制器类型
    public enum ControllerType {
        PC, Mobile
    }

    // 常数
    public static final Integer RunFrame = 8;
    public static final Integer IdleFrame = 16;
    public static final Integer ScreenWidth = 1200;
    public static final Integer ScreenHeight = 900;
    public static final ControllerType controllerType = ControllerType.PC;
}
