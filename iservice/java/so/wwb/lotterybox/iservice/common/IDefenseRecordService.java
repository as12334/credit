package so.wwb.lotterybox.iservice.common;

import org.soul.iservice.support.IBaseService;
import so.wwb.lotterybox.model.merchant.setting.po.DefenseRecord;
import so.wwb.lotterybox.model.merchant.setting.vo.DefenseRecordListVo;
import so.wwb.lotterybox.model.merchant.setting.vo.DefenseRecordVo;


/**
 * 防御记录表服务接口
 *
 * @author longer
 * @time Jan 17, 2016 4:47:58 PM
 */
public interface IDefenseRecordService extends IBaseService<DefenseRecordListVo, DefenseRecordVo, DefenseRecord, Long> {

    /**
     * 更新防御记录
     */
    int updateRecord(DefenseRecordVo defenseRecordVo);

    /**
     * 重置
     */
    int reset(DefenseRecordVo defenseRecordVo);

    Integer ipOpUserCount(DefenseRecordVo defenseRecordVo);

}