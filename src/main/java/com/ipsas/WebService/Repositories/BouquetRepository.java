package com.ipsas.WebService.Repositories;

import com.ipsas.WebService.Models.Bouquet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BouquetRepository extends JpaRepository<Bouquet, Long> {
}
