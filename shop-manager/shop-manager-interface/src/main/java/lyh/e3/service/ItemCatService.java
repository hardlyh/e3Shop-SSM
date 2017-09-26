package lyh.e3.service;

import java.util.List;

import lyh.e3.common.pojo.EasyUiTreeNode;

public interface ItemCatService {
    List<EasyUiTreeNode> getTreeNodeById(long id);
}
