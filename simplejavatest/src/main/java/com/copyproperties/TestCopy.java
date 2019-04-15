package com.copyproperties;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/10/11
 */
class Source {
    private String a;

    private List<Source2> list;

    public Source(String a, List<Source2> list) {
        this.a = a;
        this.list = list;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public List<Source2> getList() {
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        return list;
    }

}

class Source2 {
    private String b;

    private List<Source3> list;

    public Source2(String b, List<Source3> list) {
        this.b = b;
        this.list = list;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public List<Source3> getList() {
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        return list;
    }
}

class Source3 {
    private String c;

    public Source3(String c) {
        this.c = c;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}

class Dest {
    private String a;

    private List<Dest2> list;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public List<Dest2> getList() {
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        return list;
    }

    /*public void setList(List<Dest2> list) {
        this.list = list;
    }*/
}

class Dest2 {
    private String b;

    private List<Dest3> list;

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public List<Dest3> getList() {
        if (CollectionUtils.isEmpty(list)) {
            list = new ArrayList<>();
        }
        return list;
    }
}

class Dest3{
    private String c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}

public class TestCopy {
    public static void main(String[] args) {
        Source3 source3=new Source3("s3.1");
        Source3 source31=new Source3("s3.2");
        List<Source3> source3s=new ArrayList<>();
        source3s.add(source3);
        source3s.add(source31);

        Source2 source2 = new Source2("s2",source3s);
        Source2 source21 = new Source2("s2.1",source3s);
        ArrayList<Source2> list = new ArrayList<>();
        list.add(source2);
        list.add(source21);
        Source source = new Source("source", list);
        Dest dest = new Dest();
        MyBeanUtils.myCopyProperties(source, dest);
        System.out.println("1");
    }
}
