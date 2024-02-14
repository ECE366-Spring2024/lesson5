package com.example.inclass.rpsjpa.data;

import jakarta.persistence.*;
import org.springframework.data.domain.Persistable;

@Entity
@Table(name="PLAYER")
public class Player implements Persistable<String> {
    @Id
    @Column(name="PLAYER_NAME")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String playerName;

    @Override
    public String getId() {
        return this.playerName;
    }

    @Transient
    private boolean update;
    public void setUpdate(boolean update) {
        this.update = update;
    }
    @Override
    public boolean isNew() {
        return !this.update;
    }

    @Column(name="PASSWORD")
    private String password;

    @Column(name="win")
    private Integer win;

    @Column(name="loss")
    private Integer loss;

    @Column(name="draw")
    private Integer draw;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLoss() {
        return loss;
    }

    public void setLoss(Integer loss) {
        this.loss = loss;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", password='" + password + '\'' +
                ", win=" + win +
                ", loss=" + loss +
                ", draw=" + draw +
                '}';
    }
}
