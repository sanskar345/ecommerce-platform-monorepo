package com.sanskar.ecommerce.repo.party;

import com.sanskar.ecommerce.entity.party.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long> {
    Optional<Party> findByEmail(String email);
}
