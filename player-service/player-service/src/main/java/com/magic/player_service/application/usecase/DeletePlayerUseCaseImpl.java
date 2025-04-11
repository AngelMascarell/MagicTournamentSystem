package com.magic.player_service.application.usecase;

import com.magic.player_service.domain.model.Player;
import com.magic.player_service.domain.port.in.CreatePlayerUseCase;
import com.magic.player_service.domain.port.in.DeletePlayerUseCase;
import com.magic.player_service.domain.port.out.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeletePlayerUseCaseImpl implements DeletePlayerUseCase {

    @Autowired
    private PlayerRepository repository;

    public HttpStatus execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El id es obligatorio");
        }

        return repository.delete(id);
    }
}
