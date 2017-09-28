package lyh.e3.service;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.common.pojo.EasyUiTreeNode;
import lyh.e3.pojo.TbItem;
import lyh.e3.utils.E3Result;

public interface ItemService {
   
    TbItem findItemById(long itemId);
    EasyUiGridResult getItemList(int page,int rows);
    E3Result saveItem(TbItem item,String desc);
    E3Result deleteItem(String ids);
    E3Result updateStatus(String ids,int status);
    E3Result updateItem(TbItem item,String desc);
    
}
