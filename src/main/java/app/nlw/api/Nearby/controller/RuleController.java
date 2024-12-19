package app.nlw.api.Nearby.controller;

import app.nlw.api.Nearby.dto.RuleRequest;
import app.nlw.api.Nearby.model.Rule;
import app.nlw.api.Nearby.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")
public class RuleController {

    @Autowired
    RuleService service;

    @PostMapping
    public ResponseEntity<Rule> create(@RequestBody RuleRequest request){
        var rule = service.createRule(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(rule);
    }
}
