
package com.test.main;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.test.config.DBConfig;
import com.test.dao.PlayerDao;
import com.test.model.Player;

public class PlayerDemo { 
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class)) {
             PlayerDao dao = ctx.getBean(PlayerDao.class);
            dao.seedIfEmpty();
            List<Player> players = dao.getAllPlayers();
            players.sort((p1, p2) -> Double.compare(score(p2), score(p1)));
            System.out.println("Final World Cup Team :");
            players.stream().limit(11).forEach(p ->
                System.out.printf("%s (%s) - BatAvg: %.2f, BowlAvg: %.2f%n",
                    p.getName(), p.getRole(), p.getBattingAverage(), p.getBowlingAverage())
            );
        }
    }
    private static double score(Player p) {
        return p.getBattingAverage() * 0.6 + (100 - p.getBowlingAverage()) * 0.4;
    }
}
