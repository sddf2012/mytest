package proxy;

/**
 * 整个代码文件描述
 *
 * @author liu peng bo
 * date: 2019/4/24 15:13
 */
public class TestProxy {
    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Animal animal = new Cat();
        AnimalProxy animalProxy = new AnimalProxy();
        Animal proxy = (Animal) animalProxy.bind(animal);
        proxy.name();
    }
}
