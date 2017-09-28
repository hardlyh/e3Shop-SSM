package lyh.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.pojo.TbItem;
import lyh.e3.service.ItemDescService;
import lyh.e3.service.ItemService;
import lyh.e3.utils.E3Result;

@Controller
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    @Autowired
    private ItemDescService itemDescService;
    
    
    /**
    * @Description: 根据id返回item
    * @return TbItem    返回类型
    */
    //item/{itemId}  如果url符合这个形式,则可以直接取到{itemId}值,在方法内@PathVariable可以获取到
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem findItemById(@PathVariable long itemId){
        // @PathVariable 直接取到get方法传递进来的值,需要和@RequestMapping设置的相同
        return itemService.findItemById(itemId);
    }
    
    /**
    * @Description: 分页查询
    * @return EasyUiGridResult    返回类型
    */
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUiGridResult list(Integer page,Integer rows){
        return itemService.getItemList(page, rows); 
    }
    
    /**
    * @Description: 保存对象
    * @return E3Result    返回类型
    */
    @RequestMapping(value="/item/save",method=RequestMethod.POST)
    @ResponseBody
    public E3Result saveItem(TbItem item,String desc){
        E3Result e3 = itemService.saveItem(item, desc);
        return e3;
    }
    
    
   
    
    /**
    * @Description: 删除
    * @return E3Result    返回类型
     */
    @RequestMapping(value="/rest/item/delete")
    @ResponseBody
    public E3Result deleteItem(String ids){
        E3Result e3 = itemService.deleteItem(ids);
        return e3;
    }
    
    /**
    * @Description: 下架
    * @return E3Result    返回类型
     */
    @RequestMapping("/rest/item/instock")
    @ResponseBody
    public E3Result instock(String ids){
        E3Result e3 = itemService.updateStatus(ids,TbItem.Instock);
        return e3;
    }
    
    
    /**
    * @Description: 上架
    * @return E3Result    返回类型
     */
    @RequestMapping("/rest/item/reshelf")
    @ResponseBody
    public E3Result reshelf(String ids){
        E3Result e3 = itemService.updateStatus(ids,TbItem.Reshelf);
        return e3;
    }
    
    
    @RequestMapping("/rest/item/query/item/desc/{id}")
    @ResponseBody
    public E3Result findBydesc(@PathVariable String id){
        System.out.println(id);
        E3Result e3 = itemDescService.findItemDesc(id);
        return e3;
    }
    
    @RequestMapping(value="/rest/item/update",method=RequestMethod.POST)
    @ResponseBody
    public E3Result updateItem(TbItem item,String desc){
        return itemService.updateItem(item, desc);
    }

}
