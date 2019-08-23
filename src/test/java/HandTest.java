import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HandTest {

    Hand hand;

    @Before
    public void before() throws Exception {
        hand = new Hand();
    }
    @After
    public void after(){
        hand = null;
    }

    @Test
    public void testCheckForFlush() {

    }


}
