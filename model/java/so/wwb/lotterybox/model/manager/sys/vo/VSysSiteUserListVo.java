package so.wwb.lotterybox.model.manager.sys.vo;

import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.commons.query.sort.Order;
import org.soul.commons.query.sort.Sort;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseListVo;
import so.wwb.lotterybox.model.manager.sys.po.VSysSiteUser;
import so.wwb.lotterybox.model.manager.sys.so.VSysSiteUserSo;


/**
 * 用户站点表列表页值对象
 *
 * @author longer
 * @time Nov 17, 2015 2:22:29 PM
 */
//region your codes 1
public class VSysSiteUserListVo extends BaseListVo<VSysSiteUser, VSysSiteUserSo, VSysSiteUserListVo.VSysUserSiteQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = -608104035520622402L;
    //endregion your codes 5

    /**
     *  用户站点表列表查询逻辑
     */
    public static class VSysUserSiteQuery extends AbstractQuery<VSysSiteUserSo> {

        private static final long serialVersionUID = -5434103326429436634L;

        @Override
        public Criteria getCriteria() {
            return Criteria.add(VSysSiteUser.PROP_SYS_USER_ID,Operator.EQ,searchObject.getSysUserId())
                    .addAnd(VSysSiteUser.PROP_SUBSYS_CODE,Operator.EQ,searchObject.getSubsysCode())
                    .addAnd(VSysSiteUser.PROP_USERNAME,Operator.LIKE_S,searchObject.getUsername())
                    .addAnd(VSysSiteUser.PROP_SITE_NAME,Operator.EQ,searchObject.getSiteName())
                    .addAnd(VSysSiteUser.PROP_OWNER_ID,Operator.EQ,searchObject.getOwnerId())
                    .addAnd(VSysSiteUser.PROP_STATUS,Operator.EQ,searchObject.getStatus());
        }

        @Override
        public Sort getDefaultSort() {
            Sort sort = new Sort(Order.asc(VSysSiteUser.PROP_ID));
            return sort;
        }
    }


}