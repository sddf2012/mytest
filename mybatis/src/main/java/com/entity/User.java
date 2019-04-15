package com.entity;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
public class User {
    private long id;
    private String code;
    private String name;
    private String pwd;
    private Address address;
    private List<Hobby> hobbys;

    public User(Long id) {
        this.id = id;
    }

    public User(long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Hobby> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<Hobby> hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address=" + address +
                ", hobbys=" + hobbys +
                '}';
    }
}
