package org.example.shopee;

import org.example.shopee.model.GetShopInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1/shopee")
public class ShopeeController {
    @Autowired
    private RestClient restClient;

    @GetMapping
    public String getShopInfo(@RequestBody GetShopInfoRequest request) {
        String getShopUrlByUsername = request.url() + "/api/v4/shop/get_shop_detail?username=" + request.username();

        return restClient.get().uri(getShopUrlByUsername).retrieve().body(String.class);
    }
}