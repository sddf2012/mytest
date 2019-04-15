package com.server;

import com.server.bo.RepBO;

import javax.jws.WebService;

/**
 * @author liu peng bo
 * @date 2018/9/19
 */
@WebService
public interface MyService {
    String hello();

    public RepBO hello2();
}
