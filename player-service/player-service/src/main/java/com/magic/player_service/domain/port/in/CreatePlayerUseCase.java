package com.magic.player_service.domain.port.in;

import com.magic.player_service.domain.model.Player;

public interface CreatePlayerUseCase {

    Player execute(Player player);

}
