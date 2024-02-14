package com.example.inclass.rpsjpa.business;

import com.example.inclass.rpsjpa.data.Player;
import com.example.inclass.rpsjpa.data.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List getPlayers(){
        Iterable players = this.playerRepository.findAll();
        List playerList = new ArrayList<>();
        players.forEach(player->{playerList.add(player);});
        return playerList;
    }

    public boolean createNewPlayer(String playerName, String password, Integer loss) {
        Player player = new Player();
        player.setPlayerName(playerName);
        player.setPassword(password);
        player.setLoss(loss);
        System.out.println(player);
        this.playerRepository.save(player);
        return true;
    }

}
