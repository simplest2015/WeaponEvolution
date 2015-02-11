import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by zhaotuan on 15/2/10.
 */
public class PlayerTest {

    @Test
    public void should_return_5_hitPoints_when_attack_given_attacker_has_15_attackPoints_and_target_has_20_hitPoints() {
        Player attacker = new Player("attacker", 20, 15);
        Player target = new Player("target", 20, 10);

        attacker.attack(target);

        assertThat(target.getHitPoints()).isEqualTo(5);

    }
}
