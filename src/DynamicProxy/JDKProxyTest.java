package DynamicProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    /**
     * 在运行时加上虚拟机参数-Dsun.misc.ProxyGenerator.saveGeneratedFiles=true
     * 就能够将动态生成的代理类保存到本地，之后可以通过反编译来查看动态代理类，进一步理解JDK动态代理
     *
     * @param args
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //这里有两种写法，我们采用略微复杂的一种写法，这样更有助于大家理解。
        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), HelloWorld.class);
        final Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler ih = new MyInvocationHandler(new HelloworldImpl());
        HelloWorld helloWorld = (HelloWorld) cons.newInstance(ih);
        helloWorld.sayHello();

        //下面是更简单的一种写法，本质上和上面是一样的
        /*
        HelloWorld helloWorld=(HelloWorld)Proxy.
                 newProxyInstance(JDKProxyTest.class.getClassLoader(),
                        new Class<?>[]{HelloWorld.class},
                        new MyInvocationHandler(new HelloworldImpl()));
        helloWorld.sayHello();
        */
    }

}
