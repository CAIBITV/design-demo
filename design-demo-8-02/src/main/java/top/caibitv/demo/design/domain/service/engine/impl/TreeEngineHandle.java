package top.caibitv.demo.design.domain.service.engine.impl;

import top.caibitv.demo.design.domain.model.aggregates.TreeRich;
import top.caibitv.demo.design.domain.model.vo.EngineResult;
import top.caibitv.demo.design.domain.model.vo.TreeNode;
import top.caibitv.demo.design.domain.service.engine.EngineBase;

import java.util.Map;

public class TreeEngineHandle extends EngineBase {
    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }
}
