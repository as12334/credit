package so.wwb.lotterybox.iservice.manager.sys;

import org.soul.iservice.sys.ISysAuditLogService;
import org.soul.model.sys.po.SysAuditLog;
import org.soul.model.sys.so.SysAuditLogSo;
import org.soul.model.sys.vo.SysAuditLogListVo;

import java.util.List;

/**
 * Created by eagle on 16-1-7.
 */
public interface ICustomSysAuditLogService extends ISysAuditLogService {

    /**
     *  登录日志，默认按时间倒序获取最近10条记录
     *  需要设置的属性
     *  search.operatorId           操作ID
     *  ModuleType.PASSPORT_LOGIN   日志类型(默认参数)
     *
     *  add by eagle
     * @param sysAuditLogListVo
     * @return
     */
    List<SysAuditLog> searchPlayerLoginLog(SysAuditLogListVo sysAuditLogListVo);

    /**
     * 根据ip 获取操作id
     * 需要设置的属性
     * search.operator_ip
     * search.module_type         非必须
     * search.operator_user_type  非必须
     *
     * add by Bruce.Q
     * @param sysAuditLogSo
     * @return
     */
    List<Integer> searchOperatorIdByIp(SysAuditLogSo sysAuditLogSo);

    /**
     * 运营商中心　查询站点日志
     *
     * add byu Bruce.Q
     * @param listVo
     * @return
     */
    SysAuditLogListVo searchSysAuditLog(SysAuditLogListVo listVo);
}
