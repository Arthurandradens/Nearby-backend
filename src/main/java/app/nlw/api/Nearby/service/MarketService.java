package app.nlw.api.Nearby.service;

import app.nlw.api.Nearby.dto.MarketDetailsResponse;
import app.nlw.api.Nearby.dto.MarketRequest;
import app.nlw.api.Nearby.dto.MarketResponse;
import app.nlw.api.Nearby.dto.RuleResponse;
import app.nlw.api.Nearby.model.Market;
import app.nlw.api.Nearby.repository.CategoryRepository;
import app.nlw.api.Nearby.repository.MarketRepository;
import app.nlw.api.Nearby.repository.RuleRepository;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

@Service
public class MarketService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    MarketRepository repository;
    @Autowired
    RuleRepository ruleRepository;

    @Transactional
    public Market createMarket(MarketRequest request) {
        try {
            var category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new RuntimeException("this category does not exist"));
            var market = new Market(request,category);
            repository.save(market);
            return market;
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    public List<MarketResponse> getMarketsByCategoryId(UUID categoryId) {
        categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("this category does not exist"));

        return repository.findAllByCategoryId(categoryId)
                .stream()
                .map(MarketResponse::new)
                .toList();
    }

    public MarketDetailsResponse getMarketById(UUID id) {
        var rules = ruleRepository
                .findAllByMarketId(id)
                .stream()
                .map(r -> new RuleResponse(r,id))
                .toList();

        return repository
                .findById(id)
                .map(m -> new MarketDetailsResponse(m,rules))
                .orElseThrow(() -> new RuntimeException("This market id do not exist"));
    }

    @Transactional
    public String updateMarketCoupons(UUID marketId) {
        var market = repository.findById(marketId).orElseThrow(() -> new RuntimeException("This market id do not exist"));
        var hasAnyCouponAvailable = market.useCoupon();
        if (!hasAnyCouponAvailable) return "";

        repository.save(market);
        try{
            var key = String.valueOf(market.getId());
            MessageDigest m = MessageDigest.getInstance("sha-256");

            m.update(key.getBytes(), 0,key.length());
            byte[] digest = m.digest();

            String hex = Hex.encodeHexString(digest);

            String coupon = hex.substring(0,8).toUpperCase();

            return coupon;
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return "";
        }
    }
}
