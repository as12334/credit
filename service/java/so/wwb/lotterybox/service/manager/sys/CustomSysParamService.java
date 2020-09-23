package so.wwb.lotterybox.service.manager.sys;

import org.soul.commons.cache.CacheKey;
import org.soul.commons.collections.CollectionTool;
import org.soul.commons.lang.string.StringTool;
import org.soul.commons.query.sort.Direction;
import org.soul.commons.query.sort.Order;
import org.soul.model.sys.po.SysParam;
import org.soul.model.sys.so.SysParamSo;
import org.soul.model.sys.vo.SysParamVo;
import org.soul.service.sys.SysParamService;
import so.wwb.lotterybox.iservice.manager.sys.ICustomSysParamService;

import java.util.*;

public class CustomSysParamService extends SysParamService implements ICustomSysParamService {
    @Override
    public Map<String, Map<String, SysParam>> load(SysParamVo vo) {
        SysParamSo entity = vo.getSearch();
        if (entity == null) {
            throw new IllegalArgumentException("参数对象不能为空！");
        } else {
            String module = entity.getModule();
            String type = entity.getParamType();
            List<SysParam> list = null;
            Map<String, Map<String, SysParam>> cacheMap = new LinkedHashMap();
            Order[] orders = new Order[]{new Order("module", Direction.ASC), new Order("paramType", Direction.ASC), new Order("orderNum", Direction.ASC)};
            if (StringTool.isNotBlank(module) && StringTool.isNotBlank(type)) {

                if ((vo.getSearch()).getSiteId() != null) {
                    if (StringTool.isNotBlank((vo.getSearch()).getParamCode())) {
                        list = (this.mapper).search((vo.getQuery()).byModuleAndTypeAndCodeAndSiteId(), orders);
                    } else {
                        list = (this.mapper).search((vo.getQuery()).byModuleAndTypeAndSiteId(), orders);
                    }
                } else {
                    list = null;
                }

                Map<String, SysParam> beCached = (LinkedHashMap) CollectionTool.toEntityMap(list, "paramCode");
                String cacheKey = CacheKey.getCacheKey(module, type);
                cacheMap.put(cacheKey, beCached);
            } else {
                list = (this.mapper).allSearch(orders);
                List<SysParamSo> cacheVos = CacheKey.toCacheVo(list, SysParamSo.class);
                Map<String, List<SysParamSo>> groupByed = CollectionTool.groupByProperty(cacheVos, "cacheKey", String.class);
                Iterator var10 = groupByed.keySet().iterator();

                while(var10.hasNext()) {
                    String key = (String)var10.next();
                    LinkedHashMap<String, SysParam> beCached = (LinkedHashMap)CollectionTool.toEntityMap((Collection)groupByed.get(key), "paramCode");
                    cacheMap.put(key, beCached);
                }
            }

            return cacheMap;
        }
    }
}
