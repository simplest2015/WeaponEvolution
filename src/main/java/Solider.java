/**
 * Created by zhaotuan on 15/2/11.
 */
public class Solider extends Player {
    public Solider(String name, int hitPoints, int attackPoints) {
        super(name, hitPoints, attackPoints);
        this.weapon = "优质木棒";
        this.title = "战士";
        this.defensePoints = 2;
        this.weaponAttackPoints = 2;
    }
}
