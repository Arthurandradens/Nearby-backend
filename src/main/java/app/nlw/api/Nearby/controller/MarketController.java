package app.nlw.api.Nearby.controller;

import app.nlw.api.Nearby.dto.MarketDetailsResponse;
import app.nlw.api.Nearby.dto.MarketRequest;
import app.nlw.api.Nearby.dto.MarketResponse;
import app.nlw.api.Nearby.model.Market;
import app.nlw.api.Nearby.service.MarketService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/markets")
public class MarketController {
    @Autowired
    MarketService service;

    @PostMapping
    public ResponseEntity<Market> create(@RequestBody @Valid MarketRequest request, UriComponentsBuilder builder){

       var market = service.createMarket(request);

        final URI uri = builder
                .path("/{id}")
                .buildAndExpand(market.getId()).toUri();

        return ResponseEntity.created(uri).body(market);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<MarketResponse>>getMarketsPerCategory(@PathVariable UUID categoryId){
        var markets = service.getMarketsByCategoryId(categoryId);

        return ResponseEntity.ok(markets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarketDetailsResponse> show(@PathVariable UUID id){
        var market = service.getMarketById(id);

        return ResponseEntity.ok(market);
    }

}
