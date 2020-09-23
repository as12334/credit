package so.wwb.lotterybox.iservice.manager.sys;

import org.soul.iservice.sys.ISysParamService;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.vo.SysParamVo;

import java.util.Map;

public interface ICustomSysParamService extends ISysParamService{
    @Override
    Map<String, Map<String, SysParam>> load(SysParamVo vo);
}
