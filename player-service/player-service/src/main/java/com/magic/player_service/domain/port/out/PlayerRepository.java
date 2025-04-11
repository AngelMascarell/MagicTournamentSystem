package com.magic.player_service.domain.port.out;

import com.magic.player_service.domain.model.Player;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository {

    public Player save(Player player);

    public Optional<Player> findById(UUID id);

    public List<Player> findAll();

    public HttpStatus delete(UUID id);
}