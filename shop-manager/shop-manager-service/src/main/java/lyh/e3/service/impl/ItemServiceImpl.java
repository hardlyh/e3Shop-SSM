package lyh.e3.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.mapper.TbItemDescMapper;
import lyh.e3.mapper.TbItemMapper;
import lyh.e3.pojo.TbItem;
import lyh.e3.pojo.TbItemDesc;
import lyh.e3.pojo.TbItemExample;
import lyh.e3.service.ItemService;
import lyh.e3.utils.E3Result;
import lyh.e3.utils.IDUtils;

/**
 * @ClassName: ItemServiceImpl
 * @Description:
 * @author student.lyh
 * @date 2017年9月23日 上午11:11:09
 */
@Service
public class ItemServiceImpl implements ItemService {
    
    

    @Autowired
    private TbItemMapper ItemMapper;
    @Autowired
    private TbItemDescMapper descMapper;

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
        // 不会发出异常,但是会出现警告 如果需要解决这个警告只需要将对应的jar依赖进web
        PageHelper.startPage(page, rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> list = ItemMapper.selectByExample(example);
        PageInfo<TbItem> info = new PageInfo<TbItem>(list);
        EasyUiGridResult easyUiGridResult = new EasyUiGridResult();
        easyUiGridResult.setRows(list);
        easyUiGridResult.setTotal(info.getTotal());
        return easyUiGridResult;
    }

    /*
     * 保存对象
     */
    public E3Result saveItem(TbItem item, String desc) {
        try {
            // 存储item对象
            long itemId = IDUtils.genItemId();
            item.setId(itemId);
            item.setStatus((byte) 1); // 1-正常 2-下架 3-删除
            item.setCreated(new Date());
            item.setUpdated(new Date());
            ItemMapper.insert(item);
            // 存储item_desc对象
            TbItemDesc itemDesc = new TbItemDesc();
            itemDesc.setItemId(itemId);
            itemDesc.setCreated(new Date());
            itemDesc.setUpdated(new Date());
            itemDesc.setItemDesc(desc);
            descMapper.insert(itemDesc);
            return E3Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return E3Result.build(2002, e.toString());
        }
    }

    /*
     * 删除商品
     */
    public E3Result deleteItem(String ids) {
        try {
            String[] arrId = ids.split(",");
            ItemMapper.deleteByMatch(arrId);
            return E3Result.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return E3Result.build(2002, e.toString());
        }
    }
    

    /*
     * 上架商品/下架商品
     */
    public E3Result updateStatus(String ids,int status) {
        if (StringUtils.isNotBlank(ids)) {
            String[] arrId = ids.split(",");
            TbItem tbItem = new TbItem();
            try {
                for (String str : arrId) {
                    tbItem.setId(Long.parseLong(str));
                    tbItem.setStatus((byte) status);
                    ItemMapper.updateByPrimaryKeySelective(tbItem);
                }
                return E3Result.ok();
            } catch (Exception e) {
                e.printStackTrace();
                return E3Result.build(2002, e.toString());
            }
        }
        return null;
    }

  
    /* 
     * 更新商品信息
     */
    public E3Result updateItem(TbItem item, String desc) {
        try{
            // 更新item
            ItemMapper.updateByPrimaryKeySelective(item);
            // 更新itemDesc
            TbItemDesc desc2 =new TbItemDesc();
            desc2.setItemId(item.getId());
            desc2.setItemDesc(desc);
            desc2.setUpdated(new Date());
            descMapper.updateByPrimaryKeySelective(desc2);
            return E3Result.ok();
        }catch (Exception e) {
            e.printStackTrace();
            return E3Result.build(2002, e.toString());
        }
    }

    

}
