package so.wwb.lotterybox.model.manager.pay.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 查询汇率结果po类
 * Created by cherry on 17-6-24.
 */
public class CurrencyRate implements Serializable {
    private static final long serialVersionUID = 7713226137259705251L;

    //卖出汇率
    BigDecimal askRate;
    //买入汇率
    BigDecimal bidRate;
    //汇率转换类型
    String rateType;
    //汇率
    BigDecimal rate;
    //查询时间
    Date queryTime;
    //汇率时间
    Date rateTime;

    public BigDecimal getAskRate() {
        return askRate;
    }

    public void setAskRate(BigDecimal askRate) {
        this.askRate = askRate;
    }

    public BigDecimal getBidRate() {
        return bidRate;
    }

    public void setBidRate(BigDecimal bidRate) {
        this.bidRate = bidRate;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
    }
}
