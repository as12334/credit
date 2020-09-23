package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

public enum DomainTypeEnum implements ICodeEnum {
    MANAGER("1", "管理中心-MANAGER"), //boss,股东
    MERCHANT("2", "商户中心-MERCHANT"), //商户,总代
    HALL("3", "游戏中心-HALL"),
    API("4", "开放中心-API"),
    PAY("5", "支付中心-PAY"),
    PLAYER_AGENT("6", "玩家代理-AGENT");

    private String code;
    private String trans;

    DomainTypeEnum(String code, String trans) {
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
