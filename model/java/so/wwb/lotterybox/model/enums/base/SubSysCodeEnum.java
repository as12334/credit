package so.wwb.lotterybox.model.enums.base;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;

public enum SubSysCodeEnum implements ICodeEnum {
    BOSS("boss", "总控"),
    SHAREHOLDER("shareholder", "股东"),
    MANAGER("manager","后台"),
    MERCHANT("merchant", "商户"),
    DISTRIBUTOR("distributor", "总代"),
    HALL("hall", "玩家"),
    API("api", "开放平台"),
    API_CALL("api-call", "商户回调");
    
    private String code;
    private String trans;

    SubSysCodeEnum(String code, String trans) {
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

    public static SubSysCodeEnum enumOf(String code) {
        return EnumTool.enumOf(SubSysCodeEnum.class, code);
    }
}