package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

/**
 * 平台参数客服枚举
 * @author cogo
 * @time 2016-01-13 20:47:30
 */
public enum SiteCustomerServiceEnum implements ICodeEnum {
    PCSIDE("1", "PC端"),
    MOBILETERMINAL("2", "手机端");
    private String code;
    private String trans;

    SiteCustomerServiceEnum(String code, String trans) {
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