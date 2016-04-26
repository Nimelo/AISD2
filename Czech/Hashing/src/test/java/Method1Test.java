import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mrnim on 26-Apr-16.
 */
public class Method1Test {
    @Test
    public void getHashIndex() throws Exception {
        int expected = 43;

        int actual = Method1.getHashCeilIndex(1111, 100);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHashIndex2() throws Exception {
        int expected = 4;

        int actual = Method1.getHashCeilIndex(1111, 10);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHashIndex3() throws Exception {
        int expected = 21;

        int actual = Method1.getHashCeilIndex(11, 100);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getHashIndex4() throws Exception {
        int expected = 81;

        int actual = Method1.getHashCeilIndex(9, 100);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getHashIndex5() throws Exception {
        int expected = 0;

        int actual = Method1.getHashCeilIndex(0, 100);

        Assert.assertEquals(expected, actual);

    }

}