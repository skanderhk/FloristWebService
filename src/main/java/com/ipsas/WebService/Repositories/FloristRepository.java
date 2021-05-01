package com.ipsas.WebService.Repositories;

import com.ipsas.WebService.Models.Florist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloristRepository extends JpaRepository<Florist, Long> {
}
