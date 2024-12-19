package app.nlw.api.Nearby.service;

import app.nlw.api.Nearby.dto.RuleRequest;
import app.nlw.api.Nearby.model.Rule;
import app.nlw.api.Nearby.repository.MarketRepository;
import app.nlw.api.Nearby.repository.RuleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    RuleRepository repository;
    @Autowired
    MarketRepository marketRepository;

    @Transactional
    public Rule createRule(RuleRequest request) {
        try{
            var market = marketRepository.findById(request.marketId()).orElseThrow(() -> new RuntimeException("This market id do not exist"));
            var rule = new Rule(request,market);
            repository.save(rule);

            return rule;
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }
}
