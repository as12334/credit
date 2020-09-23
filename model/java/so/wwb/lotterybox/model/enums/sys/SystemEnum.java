package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

public enum SystemEnum implements ICodeEnum {
    MANAGER("/manager", "管理中心"),
    GAME("/", "游戏中心");

    private String code;
    private String trans;

    SystemEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
