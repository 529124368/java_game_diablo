package lsz.niubi.config;

public class Storage {
    // 动作类型
    public enum Action {
        Idle, Attack, Run, Skill, Died
    }

    // 控制器类型
    public enum ControllerType {
        PC, Mobile
    }

    // 游戏场景分类
    public enum GameScence {
        Start, SelectRooler, Run
    }

    // 常数
    public static final int FPS = 60;
    public static final int IDLE_FPS = 15;
    public static final String GAME_TITLE = "diablo demo";
    public static final Integer RunFrame = 8;
    public static final Integer IdleFrame = 16;
    public static final Integer ScreenWidth = 800;
    public static final Integer ScreenHeight = 600;
    public static final ControllerType controllerType = ControllerType.PC;
}
