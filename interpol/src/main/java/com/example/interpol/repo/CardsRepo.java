package com.example.interpol.repo;


import com.example.interpol.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepo extends JpaRepository<Card , Long> {
}
