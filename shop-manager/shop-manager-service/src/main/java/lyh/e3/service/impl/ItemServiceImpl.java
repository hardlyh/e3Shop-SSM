package lyh.e3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.mapper.TbItemMapper;
import lyh.e3.pojo.TbItem;
import lyh.e3.pojo.TbItemExample;
import lyh.e3.service.ItemService;
/**
* @ClassName: ItemServiceImpl
* @Description: 
* @author student.lyh
* @date 2017年9月23日 上午11:11:09
*/
@Service
public class ItemServiceImpl implements ItemService{
    
    @Autowired
    private TbItemMapper ItemMapper;
    /* 
     * 根据主键查询TbItem
     */
    public TbItem findItemById(long itemId) {
        return ItemMapper.selectByPrimaryKey(itemId);
    }
    /* 
     * 分页查询
     */
    public EasyUiGridResult getItemList(int page, int rows) {
        // list是一个page , 但是web层并没有依赖于对应的jar 所以会报找不到类的警告
        // 但是page继承的是ArrayList 所以我们用ArrayList接受没有问题
        // 不会发出异常,但是会出现警告  如果需要解决这个警告只需要将对应的jar依赖进web
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> list = ItemMapper.selectByExample(example);
        PageInfo<TbItem> info = new PageInfo<TbItem>(list);
        EasyUiGridResult easyUiGridResult =new EasyUiGridResult();
        easyUiGridResult.setRows(list);
        easyUiGridResult.setTotal(info.getTotal());
        return easyUiGridResult;
    }

}
