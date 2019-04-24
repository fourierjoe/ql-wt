package yhao.micro.web.surety.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import yhao.micro.service.constants.model.TreeModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: GUO.MAO.LIN
 * Date: 2018-12-20
 * Time: 19:46
 */
public class TreeBuildUtil {

    /**
     * 递归构建树形结构
     *
     * @param treeNodes 节点列表
     * @return 树形结构节点列表
     */
    public static List<TreeModel> buildTree(List<TreeModel> treeNodes) {
        List<TreeModel> treeList = new ArrayList<>();
        List<TreeModel> rootList = findRoots(treeNodes);
        for (TreeModel root : rootList) {
            for (TreeModel treeModel : treeNodes) {
                if (root.getId().equals(treeModel.getId())) {
                    treeList.add(findChildren(treeModel, treeNodes));
                }
            }
        }
        return treeList;
    }

    /**
     * 寻找所有的根节点，即没有父亲节点的节点就算是根节点
     *
     * @param treeNodeList 节点列表
     * @return 所有的根节点
     */
    private static List<TreeModel> findRoots(List<TreeModel> treeNodeList) {
        List<TreeModel> rootList = new ArrayList<>();
        for (TreeModel parent : treeNodeList) {
            if (StringUtils.isBlank(parent.getPid())) {
                rootList.add(parent);
                continue;
            }
            boolean isRoot = true;
            for (TreeModel treeModel : treeNodeList) {
                if (treeModel.getId().equals(parent.getPid())) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                rootList.add(parent);
            }
        }
        return sortByOrder(rootList);
    }

    /**
     * 寻找指定节点的孩子节点
     *
     * @param parent    指定节点
     * @param treeNodes 节点列表
     * @return 包含所有孩子的父亲节点
     */
    private static TreeModel findChildren(TreeModel parent, List<TreeModel> treeNodes) {
        for (TreeModel it : treeNodes) {
            if (parent.getId().equals(it.getPid())) {
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(findChildren(it, treeNodes));
            }
        }
        parent.setChildren(sortByOrder(parent.getChildren()));
        return parent;
    }

    private static List<TreeModel> sortByOrder(List<TreeModel> treeNodeList) {
        if (CollectionUtils.isNotEmpty(treeNodeList)) {
            treeNodeList.sort((o1, o2) -> {
                int order1 = o1.getOrder() == null ? -1 : o1.getOrder();
                int order2 = o2.getOrder() == null ? -1 : o2.getOrder();
                return (order1 - order2);
            });
        }
        return treeNodeList;
    }
}
