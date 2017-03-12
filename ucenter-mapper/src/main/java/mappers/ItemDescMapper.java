package mappers;

import pojo.ItemDesc;

public interface ItemDescMapper {
    int insert(ItemDesc record);

    int insertSelective(ItemDesc record);
}