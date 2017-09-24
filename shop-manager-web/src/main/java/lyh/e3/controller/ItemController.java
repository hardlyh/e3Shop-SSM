package lyh.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lyh.e3.common.pojo.EasyUiGridResult;
import lyh.e3.pojo.TbItem;
import lyh.e3.service.ItemService;

@Controller
public class ItemController {
    
    @Autowired
    private ItemService itemService;
    
    ///item/{itemId}  如果url符合这个形式,则可以直接取到{itemId}值,在方法内@PathVariable可以获取到
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem findItemById(@PathVariable long itemId){
        // @PathVariable 直接取到get方法传递进来的值,需要和@RequestMapping设置的相同
        return itemService.findItemById(itemId);
    }
    
    @RequestMapping("/item/list")
    @ResponseBody
    public EasyUiGridResult list(Integer page,Integer rows){
        return itemService.getItemList(page, rows); 
    }
    
    
    

}
