package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Item;
import pojo.ItemCat;
import services.ItemService;
import java.util.List;

/**
 * Created by maopr on 2017/1/13.
 */
@Controller
@RequestMapping(value = "item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    private Logger logger=Logger.getLogger(this.getClass());

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<ItemCat> add(Item item,String desc) {
        int result=itemService.saveItem(item,desc);
        return null;
    }
}