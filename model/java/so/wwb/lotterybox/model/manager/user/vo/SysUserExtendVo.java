package so.wwb.lotterybox.model.manager.user.vo;


import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import org.soul.model.gameapi.param.RegisterParam;
import org.soul.model.msg.notice.po.NoticeContactWay;
import org.soul.model.security.privilege.po.SysUser;
import so.wwb.lotterybox.model.manager.sys.po.SysSite;
import so.wwb.lotterybox.model.manager.user.po.SysUserExtend;
import so.wwb.lotterybox.model.manager.user.so.SysUserExtendSo;


/**
 * 系统用户值对象
 *
 * @author jerry
 * @time 2017-3-28 20:34:18
 */
public class SysUserExtendVo extends BaseObjectVo<SysUserExtend, SysUserExtendSo, SysUserExtendVo.SysUserExtendQuery> {

    private static final long serialVersionUID = 6345574264795463363L;

    /*角色ids*/
    private Integer[] roleIds = null;
    private SysSite site;
    private Integer groupLimitId;
    private Integer groupOpenId;
    private Integer dataSourceId;
    private String updateUser;
    private Double money;
    /**  失败原因内容 */
    private String reasonContent;

    private Integer loginUserId;

    private String lastTimeSearch;
    private RegisterParam registerParam;

//    private UserPlayer player;

    /**
     * 系统用户查询逻辑
     */
    public static class SysUserExtendQuery extends AbstractQuery<SysUserExtendSo> {

        private static final long serialVersionUID = -2391404298076725416L;

        @Override
        public Criteria getCriteria() {
            Criteria criteria = new Criteria();
            if(null != searchObject.getCode()){
                criteria.addAnd(SysUserExtend.PROP_CODE,Operator.EQ,searchObject.getCode());
            }
            if(null != searchObject.getId()){
                criteria.addAnd(SysUserExtend.PROP_ID,Operator.EQ,searchObject.getId());
            }
            if(null != searchObject.getUsername()){
                criteria.addAnd(SysUserExtend.PROP_USERNAME,Operator.EQ,searchObject.getUsername());
            }
            return criteria;
        }

        public Criteria likeUserNameAndSubSysCodeAndSiteId() {
            return Criteria.and(
                    Criteria.add(SysUser.PROP_USERNAME, Operator.LIKE, searchObject.getUsername()),
                    Criteria.add(SysUser.PROP_SUBSYS_CODE, Operator.EQ, searchObject.getSubsysCode()),
                    Criteria.add(SysUser.PROP_SITE_ID, Operator.EQ, searchObject.getSiteId())
            );
        }

    }

    public Integer[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Integer[] roleIds) {
        this.roleIds = roleIds;
    }

    public SysSite getSite() {
        return site;
    }

    public void setSite(SysSite site) {
        this.site = site;
    }

    public Integer getGroupOpenId() {
        return groupOpenId;
    }

    public void setGroupOpenId(Integer groupOpenId) {
        this.groupOpenId = groupOpenId;
    }

    public Integer getGroupLimitId() {
        return groupLimitId;
    }

    public void setGroupLimitId(Integer groupLimitId) {
        this.groupLimitId = groupLimitId;
    }

    private NoticeContactWay noticeContactWay;

    public NoticeContactWay getNoticeContactWay() {
        return noticeContactWay;
    }

    public void setNoticeContactWay(NoticeContactWay noticeContactWay) {
        this.noticeContactWay = noticeContactWay;
    }

    public Integer getDataSourceId() {
        _setDataSourceId(dataSourceId);
        return dataSourceId;
    }

    public void setDataSourceId(Integer dataSourceId) {
        _setDataSourceId(dataSourceId);
        this.dataSourceId = dataSourceId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Integer loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLastTimeSearch() {
        return this.lastTimeSearch;
    }

    public void setLastTimeSearch(String lastTimeSearch) {
        this.lastTimeSearch=lastTimeSearch;
    }

    public RegisterParam getRegisterParam() {
        return registerParam;
    }

    public void setRegisterParam(RegisterParam registerParam) {
        this.registerParam = registerParam;
    }

    public String getReasonContent() {
        return this.reasonContent;
    }

    public void setReasonContent(String reasonContent) {
        this.reasonContent = reasonContent;
    }
//
//    public UserPlayer getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(UserPlayer player) {
//        this.player = player;
//    }

}