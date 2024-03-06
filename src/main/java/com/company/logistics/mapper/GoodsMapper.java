package com.company.logistics.mapper;

import com.company.logistics.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<Goods> getGoods(String id);
    int addGoods(Goods goods);
}
