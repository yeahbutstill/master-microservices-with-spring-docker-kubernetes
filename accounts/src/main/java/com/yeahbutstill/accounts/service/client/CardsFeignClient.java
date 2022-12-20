package com.yeahbutstill.accounts.service.client;

import com.yeahbutstill.accounts.model.Cards;
import com.yeahbutstill.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {

    @PostMapping(value = "/api/v1/card/myCards", consumes = "application/json")
    List<Cards> getCardDetails(@RequestBody Customer customer);


}
