package lyh.e3.service;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.pojo.TbItem;

public interface ItemService {
   
    TbItem findItemById(long itemId);
    EasyUiGridResult getItemList(int page,int rows);
    
}
