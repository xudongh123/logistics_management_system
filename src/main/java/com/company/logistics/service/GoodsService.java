package com.company.logistics.service;

import com.company.logistics.controller.dto.order.SetOrderRequest;
import com.company.logistics.mapper.GoodsMapper;
import com.company.logistics.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsService(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    public int addGoods(SetOrderRequest.GoodsRequest goodsRequest, String randomUUIDString) {
        Goods goods = new Goods();

        goods.setId(randomUUIDString);
        goods.setNumber(goodsRequest.getNumber());
        goods.setRemark(goodsRequest.getRemark());
        goods.setSize(goodsRequest.getSize());
        goods.setName(goodsRequest.getName());
        goods.setWeight(goodsRequest.getWeight());

        return goodsMapper.addGoods(goods);
    }
}
