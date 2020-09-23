package so.wwb.lotterybox.model.enums.sys;

import org.soul.commons.enums.ICodeEnum;

/**
 * Created by jeremy on 18-5-17.
 */
public enum  AppUpdateTypeEnum implements ICodeEnum {
    ANDROID("android","安卓系统"),
    IOS("ios","苹果系统"),
    H5("h5", "H5"),
    APP_IOS("app_ios","苹果"),
    APP_ANDROID("app_android","安卓");
    private String code;
    private String trans;


    AppUpdateTypeEnum(String code, String trans) {
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
