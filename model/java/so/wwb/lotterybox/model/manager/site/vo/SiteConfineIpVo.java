package so.wwb.lotterybox.model.manager.site.vo;

import org.soul.commons.query.Criteria;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.site.po.SiteConfineIp;
import so.wwb.lotterybox.model.manager.site.so.SiteConfineIpSo;


/**
 * 限制/允许访问站点/管理中心的IP表值对象
 *
 * @author block
 * @time 2020-9-24 14:21:00
 */
//region your codes 1
public class SiteConfineIpVo extends BaseObjectVo<SiteConfineIp, SiteConfineIpSo, SiteConfineIpVo.SiteConfineIpQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 7083891516883019483L;
    //endregion your codes 5

    /**
     *  限制/允许访问站点/管理中心的IP表查询逻辑
     */
    public static class SiteConfineIpQuery extends AbstractQuery<SiteConfineIpSo> {

        //region your codes 6
        private static final long serialVersionUID = 1705173899843309825L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            return null;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3

    }

    //region your codes 4

    //endregion your codes 4

}