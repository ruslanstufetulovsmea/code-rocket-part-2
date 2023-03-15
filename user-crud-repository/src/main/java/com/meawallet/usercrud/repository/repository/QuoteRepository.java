package com.meawallet.usercrud.repository.repository;

import com.meawallet.usercrud.repository.entity.QuoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<QuoteEntity, Integer> {
}
