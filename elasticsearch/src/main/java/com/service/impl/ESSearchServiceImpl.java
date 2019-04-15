package com.service.impl;

import com.client.ESClientUtils;
import com.service.ESSearchService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;

/**
 * @author liu peng bo
 * @date 2018/8/1
 */
public class ESSearchServiceImpl implements ESSearchService {
    private Client client = ESClientUtils.getTransportClient();

    @Override
    public void testSearch() {
        SearchResponse response = client.prepareSearch("index1", "index2")
                .setTypes("type1", "type2")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.termQuery("multi", "test"))                 // Query
                .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
                .setFrom(0).setSize(60).setExplain(true)
                .get();
    }
}
