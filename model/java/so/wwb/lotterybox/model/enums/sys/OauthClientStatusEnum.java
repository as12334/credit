package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by jeremy on 18-5-18.
 */
public enum OauthClientStatusEnum implements ICodeEnum {
    NORMAL("0","启用"),
    DISABLE("1","禁用");

    private String code;
    private String trans;

    OauthClientStatusEnum(String code, String trans) {
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
