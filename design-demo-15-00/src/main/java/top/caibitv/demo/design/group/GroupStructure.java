package top.caibitv.demo.design.group;

import top.caibitv.demo.design.lang.Collection;
import top.caibitv.demo.design.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroupStructure implements Collection<Employee, Link> {

    // 组织id，也是一个组织的头部id
    private String groupId;

    // 组织名称
    private String groupName;

    // 雇员列表
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>();

    // 组织架构关系；id->list; 一个节点可以有多个Link
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();

    // 反向关系链，保存组织结构的上级，下级为键，上级为值
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getuId(), employee);
    }

    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getuId());
    }

    @Override
    public boolean addLink(String key, Link link) {
        // 保存组织结构的上级，下级为键，上级为值，在组织结构中下级节点的上级节点只有一个
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key, links);
            return true;
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {

            // 记录节点的下级的游标(索引)
            HashMap<String, Integer> keyMap = new HashMap<>();

            int totalIdx = 0;// 总数，用于判断是否遍历完成

            private String fromId = groupId;  // 雇员ID，From

            private String toId = groupId;   // 雇员ID，To

            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee next() {
                // toId表示当前节点的id, 获取当前节点的树节点链路
                List<Link> links = linkMap.get(toId);
                // 2. 获取当前节点未遍历的游标(索引)
                int cursorIdx = getCursorIdx(toId);

                // 自己为叶子节点，同级节点扫描，如果进入这个判断，当前节点就变为上级节点
                if (null == links) {
                    // 获取上级节点未遍历的游标(索引)
                    cursorIdx = getCursorIdx(fromId);
                    // 获取上级节点的树节点链路，即当前节点的同级节点
                    links = linkMap.get(fromId);
                }

                // 上级节点扫描，索引从0开始，如果未扫描索引大于等于(当前节点的链路数量 -1) ，表示当前节点及其子几点已经遍历完，fromId
                while (cursorIdx > links.size() - 1) {
                    // 注意到这一步，我们需要尝试遍历上级节点的同级节点
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // 获取节点
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                // 返回结果
                return employeeMap.get(link.getToId());
            }

            /**
             * 返回该节点的未遍历的游标(索引)
             * @param key
             * @return
             */
            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }
}
