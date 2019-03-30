import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理类工厂
 *
 * @author qubin
 * @date 2019-03-27 13:54
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Swan target;

    public CglibProxyFactory(Swan target) {
        this.target = target;
    }

    //创建代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("经纪人安排今日行程");
        //执行目标对象的方法
        Object invoke = method.invoke(target, objects);
        System.out.println("经纪人安排后面的行程");
        return invoke;

    }
}
