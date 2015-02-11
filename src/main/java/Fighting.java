import java.io.PrintStream;

/**
 * Created by zhaotuan on 15/2/11.
 */
public class Fighting {

    private final Player playerA;
    private final Player playerB;
    private final PrintStream out;

    public Fighting(Player playerA, Player playerB, PrintStream out) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.out = out;
    }

    public void start() {
        int sequence = 0;
        int leftHitPointsOfPlayerA = playerA.getHitPoints();
        int leftHibPointsOfPlayerB = playerB.getHitPoints();

        while(leftHibPointsOfPlayerB > 0 && leftHitPointsOfPlayerA > 0){
            if (sequence % 2 == 0) {
                attackOnce(playerA, playerB);
            } else {
                attackOnce(playerB, playerA);
            }

            leftHitPointsOfPlayerA = playerA.getHitPoints();
            leftHibPointsOfPlayerB = playerB.getHitPoints();
            sequence++;
        }

        Player loser = leftHitPointsOfPlayerA <= 0 ? playerA : playerB;

        showLoserTips(loser);
    }

    private void attackOnce(Player attacker, Player target) {
        int targetHitPointsBefore = target.getHitPoints();

        attacker.attack(target);

        StringBuilder attackInfo = new StringBuilder();
        attackInfo.append(attacker.getTitle() + attacker.getName());
        if (attacker.getWeapon() != null && !"".equals(attacker.getWeapon())) {
            attackInfo.append("用" + attacker.getWeapon());
        }
        attackInfo.append("攻击了" + target.getTitle() +target.getName() + "，");
        attackInfo.append(target.getName() + "受到了" + (targetHitPointsBefore - target.getHitPoints()) + "点伤害，");
        attackInfo.append(target.getName() + "剩余生命：" + target.getHitPoints());
        out.println(attackInfo.toString());
    }

    private void showLoserTips(Player loser) {
        out.println(loser.getName() + "被打败了");
    }


}
