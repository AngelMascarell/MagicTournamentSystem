package com.magic.player_service.application.service;

import com.magic.player_service.application.usecase.CreatePlayerUseCaseImpl;
import com.magic.player_service.domain.model.Player;
import com.magic.player_service.domain.port.out.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CreatePlayerUseCaseImpl registerPlayerUseCase;


    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player createPlayer(Player player) {
        return registerPlayerUseCase.execute(player);
    }

    public Player getPlayerById(UUID id) {
        return playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
    }
}
