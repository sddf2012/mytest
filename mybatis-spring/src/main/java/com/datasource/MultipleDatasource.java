package com.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author liu peng bo
 * @date 2018/8/31
 */
public class MultipleDatasource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DatasourceContext.getDatasource();
    }

}
