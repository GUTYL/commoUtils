package org.example;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.doReturn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockPrivateJunit4.class)
public class MockPrivateJunit4Test {

    private MockPrivateJunit4 mockPrivateJunit4;

    /**
     * 测试mock private方法，并捕捉异常
     *
     * @throws Exception mock异常
     */
    @Test(expected = RuntimeException.class)
    public void test_with_except() throws Exception {
        mockPrivateJunit4 = PowerMockito.spy(new MockPrivateJunit4());
        doReturn(true).when(mockPrivateJunit4, "doTheGamble", anyString(), anyInt());
        mockPrivateJunit4.meaningfulPublicApi();
    }

    /**
     * 测试mock private方法，入参为Integer
     *
     * @throws Exception mock异常
     */
    @Test
    public void test_with_int() throws Exception {
        mockPrivateJunit4 = PowerMockito.spy(new MockPrivateJunit4());
        doReturn(3).when(mockPrivateJunit4, "privateMethod", anyInt());
        mockPrivateJunit4.publicMethod();
    }

    /**
     * 测试private方法
     *
     * @throws NoSuchMethodException     无此方法
     * @throws InvocationTargetException 方法调用异常
     * @throws IllegalAccessException    无访问权限
     */
    @Test
    public void test_with_privateMethod()
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = MockPrivateJunit4.class.getDeclaredMethod("privateMethod",
            Integer.class);
        method.setAccessible(true);
        Assert.assertEquals(2, method.invoke(new MockPrivateJunit4(), 3));
    }
}
