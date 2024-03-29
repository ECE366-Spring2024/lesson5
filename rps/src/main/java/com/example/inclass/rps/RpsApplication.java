package com.example.inclass.rps;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
@RestController
public class RpsApplication {

	@GetMapping("/helloClass")
	public String helloClass() {
		System.out.println("HELLO VAIBHAV");
		return "Hello Vaibhav";
	}

	@GetMapping("/getByPlayerName/{playerName}")
	public Player getByPlayerName(@PathVariable("playerName") String playerName) {
		System.out.println(playerName);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps2", "postgres", "password");
		Player player = new Player();
		player.setPlayerName(playerName);
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);

			player = playerDAO.findById(player);
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	@PostMapping("/createNewPlayer")
	public Player createNewPlayer(@RequestBody String json) throws JsonProcessingException {
		System.out.println(json);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, String> inputMap = objectMapper.readValue(json, Map.class);
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("db",
				"rps2", "postgres", "password");
		Player player = new Player();
		try {
			Connection connection = dcm.getConnection();
			PlayerDAO playerDAO = new PlayerDAO(connection);
			player.setPlayerName(inputMap.get("playerName"));
			player.setPassword(inputMap.get("password"));
			player.setWins(Integer.parseInt(inputMap.get("win")));
			player = playerDAO.create(player);
			System.out.println(player);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return player;
	}

	public static void main(String[] args) {

		SpringApplication.run(RpsApplication.class, args);
	}

}
