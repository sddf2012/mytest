package com.message;

/**
 * @author liu peng bo
 * @date 2018/11/7
 */
public class MyMessage implements BaseMessage {
    private String id;

    private String name;

    public MyMessage() {
    }

    public MyMessage(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCorrelationId() {
        return id;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
