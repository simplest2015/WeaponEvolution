import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Created by zhaotuan on 15/2/11.
 */
public class FightingTest {
    @Test
    public void should_show_the_info_when_both_are_player(){
        Player playerA = new Player("张三", 10, 4);
        Player playerB = new Player("李四", 15, 3);
        PrintStream out = mock(PrintStream.class);
        Fighting fighting = new Fighting(playerA, playerB, out);

        fighting.start();

        InOrder inorder =inOrder(out);
        inorder.verify(out).println("普通人张三攻击了普通人李四，李四受到了4点伤害，李四剩余生命：11");
        inorder.verify(out).println("普通人李四攻击了普通人张三，张三受到了3点伤害，张三剩余生命：7");
        inorder.verify(out).println("普通人张三攻击了普通人李四，李四受到了4点伤害，李四剩余生命：7");
        inorder.verify(out).println("普通人李四攻击了普通人张三，张三受到了3点伤害，张三剩余生命：4");
        inorder.verify(out).println("普通人张三攻击了普通人李四，李四受到了4点伤害，李四剩余生命：3");
        inorder.verify(out).println("普通人李四攻击了普通人张三，张三受到了3点伤害，张三剩余生命：1");
        inorder.verify(out).println("普通人张三攻击了普通人李四，李四受到了4点伤害，李四剩余生命：-1");
        inorder.verify(out).println("李四被打败了");

    }

    @Test
    public void should_show_the_info_when_one_is_player_and_other_is_solider() {
        Player solider = new Solider("张三", 10, 4);
        Player player = new Player("李四", 15, 3);

        PrintStream out = mock(PrintStream.class);
        Fighting fighting = new Fighting(solider, player, out);

        fighting.start();

        InOrder inorder =inOrder(out);

        inorder.verify(out).println("战士张三用优质木棒攻击了普通人李四，李四受到了6点伤害，李四剩余生命：9");
        inorder.verify(out).println("普通人李四攻击了战士张三，张三受到了1点伤害，张三剩余生命：9");
        inorder.verify(out).println("战士张三用优质木棒攻击了普通人李四，李四受到了6点伤害，李四剩余生命：3");
        inorder.verify(out).println("普通人李四攻击了战士张三，张三受到了1点伤害，张三剩余生命：8");
        inorder.verify(out).println("战士张三用优质木棒攻击了普通人李四，李四受到了6点伤害，李四剩余生命：-3");
        inorder.verify(out).println("李四被打败了");
    }


}
