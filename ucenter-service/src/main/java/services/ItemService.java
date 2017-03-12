package services;

import mappers.ItemCatMapper;
import mappers.ItemDescMapper;
import mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Item;
import pojo.ItemCat;
import pojo.ItemDesc;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Created by maopr on 2017/1/30.
 */
@Service
public class ItemService {
    @Autowired
    private ItemCatMapper itemCatMapper;
    @Autowired
    private ItemDescMapper itemDescMapper;
    @Autowired
    private ItemMapper itemMapper;

    private Logger logger=Logger.getLogger(this.getClass());

    public List<ItemCat> selectItemCatByParentId(Long parentId) {
        if (parentId == null) {
            parentId = 0L;
        }
        List<ItemCat> list = itemCatMapper.selectByParentId(parentId);
        return list;
    }

    public int saveItem(Item item,String desc){
        try{
            item.setStatus((byte)1);
            item.setCreated(new Date());
            item.setUpdated(item.getCreated());
            itemMapper.insertForId(item);

            ItemDesc itemDesc=new ItemDesc();
            itemDesc.setItemId(item.getId());
            itemDesc.setItemDesc(desc);
            itemDesc.setCreated(new Date());
            itemDesc.setUpdated(itemDesc.getCreated());
            itemDescMapper.insertSelective(itemDesc);
            return 1;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
