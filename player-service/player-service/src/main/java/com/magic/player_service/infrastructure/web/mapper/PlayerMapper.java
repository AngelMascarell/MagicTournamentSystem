package com.magic.player_service.infrastructure.web.mapper;

import com.magic.player_service.domain.model.Player;
import com.magic.player_service.infrastructure.persistence.entity.PlayerEntity;
import com.magic.player_service.infrastructure.web.dto.request.CreatePlayerRequest;
import com.magic.player_service.infrastructure.web.dto.response.CreatePlayerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {


    Player fromRequestToDomain(CreatePlayerRequest request);

    CreatePlayerResponse fromDomainToResponse(Player player);

    Player fromEntityToDomain(PlayerEntity playerEntity);

    PlayerEntity fromDomainToEntity(Player player);


}
