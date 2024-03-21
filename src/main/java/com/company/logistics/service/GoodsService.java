package com.company.logistics.service;

import com.company.logistics.controller.dto.order.SetOrderRequest;
import com.company.logistics.mapper.GoodsMapper;
import com.company.logistics.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 标识为Service组件，用于业务逻辑处理
@Service
public class GoodsService {
    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsService(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }

    // 添加货物信息
    public int addGoods(SetOrderRequest.GoodsRequest goodsRequest, String randomUUIDString) {
        Goods goods = new Goods();

        goods.setId(randomUUIDString);  // 设置货物ID
        goods.setNumber(goodsRequest.getNumber());  // 设置货物数量
        goods.setRemark(goodsRequest.getRemark());  // 设置备注
        goods.setSize(goodsRequest.getSize());  // 设置尺寸
        goods.setName(goodsRequest.getName());  // 设置货物名称
        goods.setWeight(goodsRequest.getWeight());  // 设置重量

        return goodsMapper.addGoods(goods);  // 调用Mapper添加货物信息
    }
}
