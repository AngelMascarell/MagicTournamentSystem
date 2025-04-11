package com.magic.player_service.infrastructure.persistence.repositoryImpl;

import com.magic.player_service.domain.model.Player;
import com.magic.player_service.domain.port.out.PlayerRepository;
import com.magic.player_service.infrastructure.persistence.repository.JpaPlayerRepository;
import com.magic.player_service.infrastructure.web.mapper.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    @Autowired
    private JpaPlayerRepository jpa;

    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public Player save(Player player) {
        jpa.save(playerMapper.fromDomainToEntity(player));
        return player;
    }

    @Override
    public Optional<Player> findById(UUID id) {
        return jpa.findById(id).map(e -> new Player(e.getId(), e.getName(), e.getEmail()));
    }

    @Override
    public List<Player> findAll() {
        return jpa.findAll().stream()
                .map(e -> new Player(e.getId(), e.getName(), e.getEmail()))
                .toList();
    }

    @Override
    public HttpStatus delete(UUID id) {
        jpa.deleteById(id);
        return HttpStatus.OK;
    }
}
