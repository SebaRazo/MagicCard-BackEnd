package com.back.MagicCard.service;

import com.back.MagicCard.model.Card;
import com.back.MagicCard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(Long id) {
        return cardRepository.findById(id);
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public Card updateCard(Long id, Card card) {
        if (cardRepository.existsById(id)) {
            card.setId(id);
            return cardRepository.save(card);
        }
        return null; // Manejar el caso en el que la tarjeta con el ID dado no existe
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }
}
