package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.ItemCat;
import services.ItemService;
import java.util.List;

/**
 * Created by maopr on 2017/1/13.
 */
@Controller
@RequestMapping(value = "item/cat")
public class ItemCatController {
    @Autowired
    private ItemService itemService;

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public List<ItemCat> list(Long id) {
        List<ItemCat> list=itemService.selectItemCatByParentId(id);
        return list;
    }
}