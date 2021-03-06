package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.*;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteManage;
import so.wwb.lotterybox.model.manager.sys.so.VSysSiteManageSo;

import java.util.List;


/**
 * 值对象
 *
 * @author jerry
 * @time 2017-4-6 22:23:42
 */
public class VSysSiteManageVo extends BaseObjectVo<VSysSiteManage, VSysSiteManageSo, VSysSiteManageVo.VSysSiteManagerQuery> {

    private static final long serialVersionUID = -3563426502125448164L;

    // 开站的站长信息
    private VSiteMasterManage vSiteMasterManage;
    //彩种
    private String[] lotteries;
//    //赔率
//    private List<LotteryOddSet> lotteryOdds;
//    //限额
//    private List<LotteryQuotaSet> lotteryQuotas;
    // 运营商域名
    private String parentDomain;
    // 创建用户
    private Integer createUser;
    // 站点域名
    private String siteDomain;
    // 站长管理中心地址
    private String manageDomain;
    // 验证页面标识
    private String currentPage;
    // 查询此站点sysuserid 属于商户 还是股东
    private String sysSubType;
    private String lastTimeSearch;

    /**
     *  查询逻辑
     */
    public static class VSysSiteManagerQuery extends AbstractQuery<VSysSiteManageSo> {

        private static final long serialVersionUID = 7982083643488754678L;

        @Override
        public Criteria getCriteria() {
            return Criteria.add(VSysSiteManage.PROP_ID, Operator.EQ, searchObject.getId());
        }

    }

    private SysSite sysSite;

    public VSiteMasterManage getvSiteMasterManage() {
        return vSiteMasterManage;
    }

    public void setvSiteMasterManage(VSiteMasterManage vSiteMasterManage) {
        this.vSiteMasterManage = vSiteMasterManage;
    }

    public String getParentDomain() {
        return parentDomain;
    }

    public void setParentDomain(String parentDomain) {
        this.parentDomain = parentDomain;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getSiteDomain() {
        return siteDomain;
    }

    public void setSiteDomain(String siteDomain) {
        this.siteDomain = siteDomain;
    }

    public String getManageDomain() {
        return manageDomain;
    }

    public void setManageDomain(String manageDomain) {
        this.manageDomain = manageDomain;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public SysSite getSysSite() {
        return sysSite;
    }

    public void setSysSite(SysSite sysSite) {
        this.sysSite = sysSite;
    }

    public String getSysSubType() {
        return sysSubType;
    }

    public void setSysSubType(String sysSubType) {
        this.sysSubType = sysSubType;
    }

    public String getLastTimeSearch() {
        return this.lastTimeSearch;
    }

    public void setLastTimeSearch(String lastTimeSearch) {
        this.lastTimeSearch=lastTimeSearch;
    }

    public String[] getLotteries() {
        return lotteries;
    }

    public void setLotteries(String[] lotteries) {
        this.lotteries = lotteries;
    }

//    public List<LotteryOddSet> getLotteryOdds() {
//        return lotteryOdds;
//    }
//
//    public void setLotteryOdds(List<LotteryOddSet> lotteryOdds) {
//        this.lotteryOdds = lotteryOdds;
//    }
//
//    public List<LotteryQuotaSet> getLotteryQuotas() {
//        return lotteryQuotas;
//    }
//
//    public void setLotteryQuotas(List<LotteryQuotaSet> lotteryQuotas) {
//        this.lotteryQuotas = lotteryQuotas;
//    }

    //endregion your codes 4

}