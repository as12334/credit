package so.wwb.lotterybox.model.base;

import org.soul.commons.bean.Pair;
import org.soul.commons.init.context.CommonContext;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.commons.param.IParamEnum;
import org.soul.model.sys.po.SysParam;
import so.wwb.lotterybox.model.enums.base.BossParamEnum;
import so.wwb.lotterybox.model.enums.base.SiteParamEnum;

import java.util.Collection;

public class ParamTool extends ParamToolBase {
    private static final Log LOG = LogFactory.getLog(ParamTool.class);
    private static final Integer BOSS_SITE_ID = 0;

    /**
     * 是否开启:访问管理中心IP限制开关
     */
    public static boolean isOpenVisitManagementCenterStatus() {
        Pair<String, String> pair;
        pair = get(SiteParamEnum.SETTING_VISIT_MANAGER_STATUS);
        return toBoolean(pair, false);
    }

    /**
     * 是否开启:访问站点IP限制开关
     */
    public static boolean isOpenVisitSiteStatus() {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, SiteParamEnum.SETTING_VISIT_PLAY_STATUS);
        Pair<String, String> pair = get(SiteParamEnum.SETTING_VISIT_PLAY_STATUS);
        return toBoolean(pair, false);
    }

    /**
     * 获取验证码样式
     */
    public static String getCaptchaStyle() {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, SiteParamEnum.SETTING_CAPTCHA_STYLE);
        Pair<String, String> pair = get(SiteParamEnum.SETTING_CAPTCHA_STYLE);
        return blankThenDefault(pair);
    }

    /**
     * 获取验证码排除字符
     */
    public static String getCaptchaExclusion() {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, SiteParamEnum.SETTING_CAPTCHA_EXCLUSIONS);
        Pair<String, String> pair = get(SiteParamEnum.SETTING_CAPTCHA_EXCLUSIONS);
        return blankThenDefault(pair);
    }

    /**
     * 获取指定站点参数
     */
    public static SysParam getSysParam(SiteParamEnum paramEnum, Integer siteId) {
        checkSiteSiteID(siteId, paramEnum);
        SysParam sysParam = raw(siteId, paramEnum);
        if (sysParam == null) {
            LOG.error("获取Site SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParam;
    }

    /**
     * 获取当前站点参数
     */
    public static Collection<SysParam> getSysParams(SiteParamEnum paramEnum) {
        Integer siteId = CommonContext.get().getSiteId();
        checkSiteSiteID(siteId, paramEnum);
        Collection<SysParam> sysParams = rawByType(siteId, paramEnum);
        if (sysParams.isEmpty()) {
            LOG.error("Site 获取SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParams;
    }

//    /**
//     * 获取是否支持现金取款方式
//     */
//    public static boolean isCash() {
//        SysParam cashParam = ParamTool.getSysParam(SiteParamEnum.SETTING_WITHDRAW_TYPE_IS_CASH);
//        return cashParam != null && "true".equals(cashParam.getParamValue());
//    }

//    /**
//     * 获取指定站点参数
//     */
//    public static SysParam getSysParam(BossParamEnum paramEnum, Integer siteId) {
//        checkCompanySiteID(siteId, paramEnum);
//        SysParam sysParam = raw(siteId, paramEnum);
//        if (sysParam == null) {
//            LOG.error("获取Company SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
//        }
//        return sysParam;
//    }

    /**
     * 获取当前站点参数
     */
    public static SysParam getSysParam(SiteParamEnum paramEnum) {
        Integer siteId = CommonContext.get().getSiteId();
        checkCompanySiteID(siteId, paramEnum);
        SysParam sysParam = raw(siteId, paramEnum);
        if (sysParam == null) {
            LOG.error("获取Company SysParam缓存为空{0},siteId{1}", paramEnum, siteId);
        }
        return sysParam;
    }
//
//    /**
//     * 获取当前站点参数
//     */
//    public static Collection<SysParam> getSysParams(BossParamEnum paramEnum) {
//        Collection<SysParam> sysParams = rawByType(BOSS_SITE_ID, paramEnum);
//        if (sysParams == null || sysParams.isEmpty()) {
//            LOG.error("获取Boss SysParam缓存为空{0},siteId{1}", paramEnum, BOSS_SITE_ID);
//        }
//        return sysParams;
//    }
//
    /**
     * 获取当前站点参数
     */
    public static SysParam getSysParam(BossParamEnum paramEnum) {
        SysParam sysParam = raw(BOSS_SITE_ID, paramEnum);
        if (sysParam == null) {
            LOG.error("获取BossSysParam缓存为空{0},siteId{1}", paramEnum, BOSS_SITE_ID);
        }
        return sysParam;
    }

//    /**
//     * 刷新当前站点参数
//     */
//    public static void refresh(SiteParamEnum paramEnum) {
//        Integer siteId = CommonContext.get().getSiteId();
//        checkSiteSiteID(siteId, paramEnum);
//        refresh(siteId, paramEnum);
//    }
//
//    /**
//     *根据站点刷缓存
//     */
//    public static void refreshBySiteId(SiteParamEnum paramEnum,Integer siteId) {
//        checkSiteSiteID(siteId, paramEnum);
//        refresh(siteId, paramEnum);
//    }
//
//    /**
//     * 刷新指定站点参数
//     */
//    public static void refresh(SiteParamEnum paramEnum, Integer siteId) {
//        checkSiteSiteID(siteId, paramEnum);
//        refresh(siteId, paramEnum);
//    }
//
//    /**
//     * 刷新当前站点参数
//     */
//    public static void refresh(BossParamEnum paramEnum) {
//        Integer siteId = CommonContext.get().getSiteId();
//        checkCompanySiteID(siteId, paramEnum);
//        refresh(siteId, paramEnum);
//    }
//
//    /**
//     * 刷新指定站点参数
//     */
//    public static void refresh(BossParamEnum paramEnum, Integer siteId) {
//        checkCompanySiteID(siteId, paramEnum);
//        refresh(siteId, paramEnum);
//    }
//
    private static void checkSiteSiteID(Integer siteId, IParamEnum paramEnum) {
        if (siteId == null) {
            LOG.error("错误的应用场景,siteid为空,参数为:{0}", paramEnum.toString());
            return;
        }
        if (siteId == 0) {
            LOG.error("错误的应用场景,Boss站点不应刷新Site站点的参数,参数为:{0}", paramEnum.toString());
        } else if (siteId < 0) {
            LOG.error("错误的应用场景,Company站点不应刷新Site站点的参数,参数为:{0}", paramEnum.toString());
        }
    }

    private static void checkCompanySiteID(Integer siteId, IParamEnum paramEnum) {
        if (siteId == null) {
            LOG.error("错误的应用场景,siteid为空,参数为:{0}", paramEnum.toString());
            return;
        }
        if (siteId == 0) {
            LOG.error("错误的应用场景,Boss站点不应刷新Company站点的参数,参数为:{0}", paramEnum.toString());
        } else if (siteId > 0) {
            LOG.error("错误的应用场景,Site站点不应刷新Company站点的参数,参数为:{0}", paramEnum.toString());
        }
    }

}
