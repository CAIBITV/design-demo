package top.caibitv.demo.design.domain.service.engine;

import top.caibitv.demo.design.domain.service.logic.LogicFilter;
import top.caibitv.demo.design.domain.service.logic.impl.UserAgeFilter;
import top.caibitv.demo.design.domain.service.logic.impl.UserGenderFilter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class EngineConfig {

    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<>();
        logicFilterMap.put("userAge", new UserAgeFilter());
        logicFilterMap.put("userGender", new UserGenderFilter());
    }

    public Map<String, LogicFilter> getLogicFilterMap() {
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String, LogicFilter> logicFilterMap) {
        this.logicFilterMap = logicFilterMap;
    }

}
