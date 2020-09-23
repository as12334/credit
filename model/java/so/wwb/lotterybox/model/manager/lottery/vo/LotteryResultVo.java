package so.wwb.lotterybox.model.manager.lottery.vo;

import org.soul.commons.enums.EnumTool;
import org.soul.commons.query.Criteria;
import org.soul.commons.query.enums.Operator;
import org.soul.model.common.AbstractQuery;
import org.soul.model.common.BaseObjectVo;
import so.wwb.lotterybox.model.manager.lottery.po.LotteryResult;
import so.wwb.lotterybox.model.manager.lottery.so.LotteryResultSo;

import java.util.Date;
import java.util.List;

//region your codes 1
public class LotteryResultVo extends BaseObjectVo<LotteryResult, LotteryResultSo, LotteryResultVo.LotteryResultQuery> {
//endregion your codes 1

    //region your codes 5
    private static final long serialVersionUID = 5079006800891603579L;
    //endregion your codes 5

    //操作类型
    public static final String OPERATE_TYPE_AUTO="auto";
    public static final String OPERATE_TYPE_MANUAL="manual";

    //操作类型
    private String operateType;

    //billItem类型
    private String item;

    //操作人
    private String operator;



    //---------分隔符-------

    private String nextExpect;

    private Date nextOpenTime;


    private String codes;



    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }


    public static class LotteryResultQuery extends AbstractQuery<LotteryResultSo> {

        //region your codes 6
        private static final long serialVersionUID = -3815259242538346916L;
        //endregion your codes 6

        @Override
        public Criteria getCriteria() {
            //region your codes 2
            Criteria criteria = Criteria.add(LotteryResult.PROP_CODE, Operator.EQ,searchObject.getCode());
            criteria.addAnd(LotteryResult.PROP_EXPECT,Operator.EQ,searchObject.getExpect());
            return criteria;
            //endregion your codes 2
        }

        //region your codes 3

        //endregion your codes 3
    }

    //region your codes 4

    public String getNextExpect() {
        return nextExpect;
    }

    public void setNextExpect(String nextExpect) {
        this.nextExpect = nextExpect;
    }

    public Date getNextOpenTime() {
        return nextOpenTime;
    }

    public void setNextOpenTime(Date nextOpenTime) {
        this.nextOpenTime = nextOpenTime;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }


    //endregion your codes 4
}