package proxy.springaop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Advisor;
import org.springframework.aop.DynamicIntroductionAdvice;
import org.springframework.aop.IntroductionInterceptor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import proxy.Animal;
import proxy.Behavior;
import proxy.Cat;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/8/21 15:31
 */
public class MyIntroInceptor implements IntroductionInterceptor, Behavior {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (implementsInterface(invocation.getMethod().getDeclaringClass())) {
            System.out.println("MyIntroInceptor invoke");
            return invocation.getMethod().invoke(this, invocation.getArguments());
        }
        return invocation.proceed();
    }

    @Override
    public boolean implementsInterface(Class<?> intf) {
        return intf.isAssignableFrom(Behavior.class);
    }

    @Override
    public void eat() {
        System.out.println("MyIntroInceptor eat");
    }

    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory(new Cat());
        factory.setProxyTargetClass(true); // 强制私用CGLIB 以保证我们的Person方法也能正常调用

        // 此处采用IntroductionInterceptor 这个引介增强的拦截器
        MyIntroInceptor advice = new MyIntroInceptor();

        // 切点+通知（注意：此处放的是复合切面）
        Advisor advisor = new DefaultIntroductionAdvisor(advice, Behavior.class);
        //Advisor advisor = new DefaultPointcutAdvisor(cut, advice);
        factory.addAdvisor(advisor);

        Behavior otherInte = (Behavior) factory.getProxy();
        otherInte.eat();

        System.out.println("===============================");

        // Person本身自己的方法  也得到了保留
        Animal p = (Animal) factory.getProxy();
        p.name();
    }
}
