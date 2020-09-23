package so.wwb.lotterybox.web.tools;

import org.soul.commons.collections.CollectionTool;
import org.soul.commons.enums.EnumTool;
import org.soul.commons.enums.ICodeEnum;
import org.soul.commons.lang.ArrayTool;
import org.soul.commons.lang.ClassTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.log.Log;
import org.soul.commons.log.LogFactory;
import org.soul.model.log.audit.vo.BaseLog;
import org.soul.model.log.audit.vo.LogVo;
import org.soul.model.sys.po.SysAuditLog;
import so.wwb.lotterybox.model.common.AuditLogEnum;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuditAddLogTool {

    private static final Log LOG = LogFactory.getLog(AuditAddLogTool.class);

    /**
     * 日志
     *
     * @param request
     * @param description 日志描述
     */
    public static void addLog(HttpServletRequest request, String description, List<String> paramList) {
        LogVo logVo = new LogVo();
        BaseLog baseLog = logVo.addBussLog();
        baseLog.setDescription(description);
        if (CollectionTool.isNotEmpty(paramList)) {
            for (String param : paramList) {
                baseLog.addParam(param);
            }
        }
        request.setAttribute(SysAuditLog.AUDIT_LOG, logVo);
    }

    /**
     * 审计日志
     *
     * @param request
     * @param description 国际化信息key
     * @param info        记录内容
     */
    public static void addLog(HttpServletRequest request, String description, String info) {
        LogVo logVo = new LogVo();
        BaseLog baseLog = logVo.addBussLog();
        baseLog.setDescription(description);
        baseLog.addParam(info);
        request.setAttribute(SysAuditLog.AUDIT_LOG, logVo);
    }

    /**
     * 通过 AuditLogEnum 共同管理审计日志，提高可维护性
     * @param request
     * @param logEnum
     * @param paramList
     */
    public static void addLog(HttpServletRequest request, AuditLogEnum logEnum, List<String> paramList) {
        try {
            LogVo logVo = new LogVo();
            BaseLog baseLog = logVo.addBussLog();
            baseLog.setDescription(logEnum.getCode());
            String log = logEnum.getTrans();
            Matcher regex = Pattern.compile("\\{(\\d)}").matcher(log);
            while (regex.find()) {
                log = log.replace(regex.group(), paramList.get(Integer.parseInt(regex.group(1))));
            }
            baseLog.addParam(log);
            request.setAttribute(SysAuditLog.AUDIT_LOG, logVo);
        } catch (Exception e) {
            LOG.error("[" + logEnum.getTrans() + "]保存审计日志错误：{0}", e.getMessage());
        }
    }


    /**
     * 组装枚举信息
     *
     * @param enumClass 枚举类
     * @param param     组装参数key
     * @return
     */
    public static String installEnumMsg(Class<? extends ICodeEnum> enumClass, String param) {
        try {
            String simpleName = ClassTool.getSimpleName(enumClass);
            String packageName = ClassTool.getPackageName(enumClass);
            Class<? extends ICodeEnum> codeEnumClass = EnumTool.getCodeEnumClass(packageName + "." + simpleName);
            ICodeEnum[] enums = codeEnumClass.getEnumConstants();
            if (ArrayTool.isNotEmpty(enums)) {
                for (ICodeEnum codeEnum : enums) {
                    if (StringTool.equals(codeEnum.getCode(), param)) {
                        param = codeEnum.getTrans();
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("保存审计日志匹配枚举信息错误：{0}", e.getMessage());
        } finally {
            return param;
        }
    }

}
