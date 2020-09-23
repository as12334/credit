package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

public enum UserTypeEnum implements ICodeEnum{
    BOSS("0", "总控"),
    BOSS_SUB("01", "总控子账号"),
    SHAREHOLDER("1", "股东"),
    SHAREHOLDER_SUB("11", "股东子账号"),
    MERCHANT("2", "商户"),
    MERCHANT_SUB("21", "商户子账号"),
    DISTRIBUTOR("22", "总代"),
    DISTRIBUTOR_SUB("221", "总代子账号"),
    PLAYER("23", "玩家");

    private String code;
    private String trans;

    UserTypeEnum(String code, String trans) {
        this.code = code;
        this.trans = trans;
    }

    public String getCode() {
        return code;
    }

    public String getTrans() {
        return trans;
    }
}
