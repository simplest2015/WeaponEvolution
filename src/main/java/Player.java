/**
 * Created by zhaotuan on 15/2/10.
 */
public class Player {
    protected int hitPoints;
    protected int attackPoints;
    protected int defensePoints;
    protected int weaponAttackPoints;
    
    protected String name;
    protected String title;
    protected String weapon;

    public Player(String name, int hitPoints, int attackPoints){
        this.name = name;
        this.hitPoints = hitPoints;
        this.attackPoints = attackPoints;
        this.title = "普通人";
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getWeaponAttackPoints() {
        return weaponAttackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void attack(Player target) {
        target.hitPoints = target.hitPoints + target.defensePoints - attackPoints - weaponAttackPoints;
    }
}
