package top.caibitv.demo.design.domain.service.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.caibitv.demo.design.domain.model.aggregates.TreeRich;
import top.caibitv.demo.design.domain.model.vo.EngineResult;
import top.caibitv.demo.design.domain.model.vo.TreeNode;
import top.caibitv.demo.design.domain.model.vo.TreeRoot;
import top.caibitv.demo.design.domain.service.logic.LogicFilter;

import java.util.Map;

public abstract class EngineBase extends EngineConfig implements IEngine {

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public abstract EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter);

    /**
     *
     * @param treeRich 规则树聚合
     * @param treeId 规则树ID
     * @param userId 用户ID
     * @param decisionMatter 决策物料(被判断对象)
     * @return
     */
    protected TreeNode engineDecisionMaker(TreeRich treeRich, Long treeId, String userId, Map<String, String> decisionMatter) {
        // 树信息
        TreeRoot treeRoot = treeRich.getTreeRoot();
        // 规则树节点信息
        Map<Long, TreeNode> treeNodeMap = treeRich.getTreeNodeMap();
        // 规则树 根ID
        Long rootNodeId = treeRoot.getTreeRootNodeId();
        // 根节点
        TreeNode treeNodeInfo = treeNodeMap.get(rootNodeId);
        //节点类型[NodeType]；1子叶、2果实
        while (treeNodeInfo.getNodeType().equals(1)) {
            // 根节点规则key
            String ruleKey = treeNodeInfo.getRuleKey();
            // 获取对应规则的过滤器
            LogicFilter logicFilter = logicFilterMap.get(ruleKey);
            // 获取决策值，获取对应属性
            String matterValue = logicFilter.matterValue(treeId, userId, decisionMatter);
            // 过滤器决策 获取下一个节点
            Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLinkList());
            treeNodeInfo = treeNodeMap.get(nextNode);
            logger.info("决策树引擎=>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), userId, treeId, treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
        }
        return treeNodeInfo;
    }

}
