package com.example.inclass.rps;

import com.example.inclass.rps.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO extends DataAccessObject<Game> {

    private static final String GET_ONE = "SELECT game_id, p1, p2, winner " +
            "FROM game WHERE game_id=?";


    public GameDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Game findById(Game dto) {
        Game game = new Game();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setInt(1, dto.getGameId());
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                game.setGameId(rs.getInt("game_id"));
                game.setP1(rs.getString("p1"));
                game.setP2(rs.getString("p2"));
                game.setWinner(rs.getString("winner"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return game;
    }

    @Override
    public Game create(Game dto) {
        // TODO
        return dto;
    }

    @Override
    public Game update(Game dto) {
        return dto;
    }

}
