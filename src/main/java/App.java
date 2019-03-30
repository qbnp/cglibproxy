/**
 * 测试类
 *
 * @author qubin
 * @date 2019-03-27 15:12
 */
public class App {

    public static void main(String[] args) {

        Swan swan = new Swan();
        //创建cglib工厂
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(swan);
        //代理对象
        Swan broker=(Swan)cglibProxyFactory.getProxyInstance();
        broker.work();
    }

}
