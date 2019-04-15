package com.service.impl;

import com.service.QueryBuildService;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * @author liu peng bo
 * @date 2018/8/7
 */
public class QueryBuildServiceImpl implements QueryBuildService {
    public void s(){
        QueryBuilders.matchAllQuery();
    }
}
