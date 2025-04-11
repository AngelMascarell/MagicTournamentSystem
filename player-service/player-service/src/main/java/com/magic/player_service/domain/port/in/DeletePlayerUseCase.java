package com.magic.player_service.domain.port.in;

import com.magic.player_service.domain.model.Player;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public interface DeletePlayerUseCase {

    HttpStatus execute(UUID id);

}
