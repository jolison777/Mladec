package com.test.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.model.Player;

@Repository
public class PlayerDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Player> getAllPlayers() {
        String sql = "SELECT * FROM player";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Player p = new Player();
            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setRole(rs.getString("role"));
            p.setRuns(rs.getInt("runs"));
            p.setMatches(rs.getInt("matches"));
            p.setBalls(rs.getInt("balls"));
            p.setWickets(rs.getInt("wickets"));
            p.setRunsConceded(rs.getInt("runs_conceded"));
            return p;
        });
    }
    public void seedIfEmpty() {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM player", Integer.class);
        if (count != null && count > 0) return;

        String insert = "INSERT INTO player (name, role, runs, matches, balls, wickets, runs_conceded) VALUES (?,?,?,?,?,?,?)";
        List<Object[]> batch = List.of(
        	    new Object[]{"MS Dhoni",          "WICKET_KEEPER",  10500, 350,  12000,  1,   200},
        	    new Object[]{"AB de Villiers",    "BATTER",          9500, 228,  9800,   2,    40},
        	    new Object[]{"Steve Smith",       "BATTER",          7800, 170,  8200,   1,    25},
        	    new Object[]{"Chris Gayle",       "BATTER",         10400, 301,  11000,  5,   120},
        	    new Object[]{"Martin Guptill",    "BATTER",          7200, 198,  7600,   0,     0},
        	    new Object[]{"Faf du Plessis",    "BATTER",          6400, 143,  6900,   0,     0},
        	    new Object[]{"Glenn Maxwell",     "ALL_ROUNDER",     3400, 128,  3100,  45,  2100},
        	    new Object[]{"Andre Russell",     "ALL_ROUNDER",     2800,  90,  2600,  95,  4000},
        	    new Object[]{"Ravindra Jadeja",   "ALL_ROUNDER",     2700, 180,  2500, 190,  5200},
        	    new Object[]{"Shakib Al Hasan",   "ALL_ROUNDER",     4200, 220,  3900, 270,  6100},
        	    new Object[]{"Pat Cummins",       "BOWLER",          220,  85,   350, 180,  3900},
        	    new Object[]{"Trent Boult",       "BOWLER",          190,  92,   310, 175,  3700},
        	    new Object[]{"Kagiso Rabada",     "BOWLER",          210,  97,   330, 190,  4100},
        	    new Object[]{"Tim Southee",       "BOWLER",          250, 120,   400, 210,  4800},
        	    new Object[]{"Mujeeb Ur Rahman",  "BOWLER",          140,  65,   280, 115,  2900}
        	);

        jdbcTemplate.batchUpdate(insert, batch);
    }
}
