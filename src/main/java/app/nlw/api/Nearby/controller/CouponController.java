package app.nlw.api.Nearby.controller;

import app.nlw.api.Nearby.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    MarketService service;

    @PatchMapping("/{marketId}")
    public ResponseEntity<String> update(@PathVariable UUID marketId){

        var coupon = service.updateMarketCoupons(marketId);

        return ResponseEntity.ok(coupon);
    }
}
