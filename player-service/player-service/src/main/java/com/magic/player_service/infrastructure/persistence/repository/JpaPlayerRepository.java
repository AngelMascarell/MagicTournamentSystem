package com.magic.player_service.infrastructure.persistence.repository;

import com.magic.player_service.infrastructure.persistence.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JpaPlayerRepository extends JpaRepository<PlayerEntity, UUID> {

    List<PlayerEntity> findByName(String name);

}
