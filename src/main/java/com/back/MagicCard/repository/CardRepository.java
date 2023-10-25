package com.back.MagicCard.repository;

import com.back.MagicCard.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
