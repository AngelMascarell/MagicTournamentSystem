package com.magic.player_service.infrastructure.web.controller;

import com.magic.player_service.application.service.PlayerService;
import com.magic.player_service.domain.model.Player;
import com.magic.player_service.infrastructure.web.dto.request.CreatePlayerRequest;
import com.magic.player_service.infrastructure.web.mapper.PlayerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerMapper playerMapper;


    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Player createPlayer(@RequestBody CreatePlayerRequest request) {
        return playerService.createPlayer(playerMapper.fromRequestToDomain(request));
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable UUID id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayerById(@PathVariable UUID id) {
        playerService.deletePlayer(id);
    }
}
