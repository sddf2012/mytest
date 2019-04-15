package com.reflect.fx;

/**
 * @author liu peng bo
 * @date 2019/1/2
 */
public class A<T> implements I{
  private   T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Class<A> aClass=A.class;
        /*Type[] types=aClass.getGenericInterfaces();
        Type types2=aClass.getGenericSuperclass();
        Type[] types3= ((ParameterizedType)types2).getActualTypeArguments();*/
        Class<?> types1= aClass.getComponentType();
        System.out.println(aClass.getGenericSuperclass().getTypeName());

    }
}
