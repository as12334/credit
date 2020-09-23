package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

public enum UserPlayerTransStatusEnum implements ICodeEnum {
    NOTACTIVATION("0", "未激活"),
    ACTIVATION("1", "已激活");

    private String code;
    private String trans;

    UserPlayerTransStatusEnum(String code, String trans) {
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
