package com.example.interpol.Controllers;

import com.example.interpol.domain.Card;
import com.example.interpol.repo.CardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {
    private final CardsRepo cardsRepo;

    @Autowired
    public CardController(CardsRepo cardsRepo) {
        this.cardsRepo = cardsRepo;
    }

    @GetMapping
    public List<Card> list(){
        return cardsRepo.findAll();
    }

    @GetMapping("{id}")
    public Card getOne(@PathVariable("id") Card card){
        return card;
    }

    @PostMapping
    @ResponseBody
    public Card create(@RequestBody Card card){
        card.setAdded(LocalDateTime.now());
        return cardsRepo.save(card);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id){

        Card card = new Card(id);
        cardsRepo.delete(card);
    }
}
