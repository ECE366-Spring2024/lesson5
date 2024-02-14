package com.example.inclass.rps;

import com.example.inclass.rps.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO extends DataAccessObject<Player> {

    private static final String GET_ONE = "SELECT player_name, password, win " +
            "FROM player WHERE player_name=?";

    private static final String INSERT = "INSERT INTO player (player_name, password, win) " +
            " VALUES (?, ?, ?)";

    private static final String UPDATE = "UPDATE player SET win=win+1 WHERE player_name=?";


    public PlayerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Player findById(Player dto) {
        Player player = new Player();
        try(PreparedStatement statement = this.connection.prepareStatement(GET_ONE);) {
            statement.setString(1, dto.getPlayerName());
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                player.setPlayerName(rs.getString("player_name"));
                player.setPassword(rs.getString("password"));
                player.setWins(rs.getInt("win"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return player;
    }

    @Override
    public Player create(Player dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
            // counts from 1!!
            statement.setString(1, dto.getPlayerName());
            statement.setString(2, dto.getPassword());
            statement.setInt(3, dto.getWins());
            statement.execute();
            return this.findById(dto);
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Player update(Player dto) {
        try(PreparedStatement statement = this.connection.prepareStatement(UPDATE);) {
            // counts from 1!!
            statement.setString(1, dto.getPlayerName());
            statement.execute();
            return this.findById(dto);
        } catch(SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}