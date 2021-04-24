package Algorithm;

import Algorithm.sort.Quick;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;


/**
 * @description:
 * @author: 文琛
 * @time: 2021/4/24 11:29
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Quick.class)
public class TreeNodeTest {
    @Mock
    private  TreeNode treeNode;

    @Test
    public void testPowerMock(){
        mockStatic(Quick.class);
        when(Quick.partition(any(), anyInt(), anyInt())).thenReturn(5);
        Assert.assertEquals(5, Quick.partition(new int[]{1, 1}, 0,1));
    }

}
