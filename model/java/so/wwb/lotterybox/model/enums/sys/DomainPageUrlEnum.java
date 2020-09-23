package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

public enum DomainPageUrlEnum implements ICodeEnum {
    MANAGER("/manager/passport/login.html", "manager page"),//后台
    HALL("/index.html", "hall index page"),//前端
    PAY("/onlinePay","支付线路"),//支付
    DETECTION("/netLine/findLines.html", "线路检测");
    private String code;
    private String trans;

    DomainPageUrlEnum(String code, String trans) {
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

    public static DomainPageUrlEnum getDomainPageUrlEnumByCode(String code) {
        for (DomainPageUrlEnum pageUrlEnum : DomainPageUrlEnum.values()) {
            if (pageUrlEnum.getCode().equals(code)) {
                return pageUrlEnum;
            }
        }
        return null;
    }
}