package com.magic.player_service.application.usecase;

import com.magic.player_service.domain.model.Player;
import com.magic.player_service.domain.port.in.CreatePlayerUseCase;
import com.magic.player_service.domain.port.out.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePlayerUseCaseImpl implements CreatePlayerUseCase {

    @Autowired
    private PlayerRepository repository;

    public Player execute(Player player) {
        if (player.getEmail() == null || player.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El correo electrónico es obligatorio");
        }

        return repository.save(player);
    }
}
