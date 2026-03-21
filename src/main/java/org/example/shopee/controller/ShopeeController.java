package org.example.shopee.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopee.dto.GetShopInfoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/shopee")
public class ShopeeController {
    private final RestClient restClient;

    @PostMapping("/get-shop-info")
    public String getShopInfo(@RequestBody GetShopInfoRequest request) {
        String getShopUrlByUsername = request.url() + "/api/v4/shop/get_shop_detail?username=" + request.username();

        return restClient.get().uri(getShopUrlByUsername).retrieve().body(String.class);
    }
}