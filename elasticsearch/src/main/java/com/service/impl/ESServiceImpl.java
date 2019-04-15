package com.service.impl;

import com.client.BulkProcessorUtils;
import com.client.ESClientUtils;
import com.model.DocMO;
import com.service.ESService;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentType;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/1
 */
public class ESServiceImpl implements ESService {
    private Client client = ESClientUtils.getTransportClient();

    @Override
    public IndexResponse indexJson(String index, String type, String id, String json) {
        return client.prepareIndex(index, type, id).setSource(json, XContentType.JSON).get();
    }

    @Override
    public void bulkIndex(List<DocMO> docMOS) {
        BulkProcessor bulkProcessor = BulkProcessorUtils.getBulkProcessor();
        docMOS.forEach(
                docMO -> {
                    bulkProcessor.add(new IndexRequest(docMO.getIndex(), docMO.getType(), docMO.getId()).source(docMO.getJson(), XContentType.JSON));
                }
        );
        // Flush any remaining requests
        bulkProcessor.flush();

        // Or close the bulkProcessor if you don't need it anymore
        bulkProcessor.close();

       // Refresh your indices
        client.admin().indices().prepareRefresh().get();

    }

    @Override
    public GetResponse get(String index, String type, String id) {
        return client.prepareGet(index, type, id).get();
    }

    @Override
    public DeleteResponse delete(String index, String type, String id) {
        return client.prepareDelete(index, type, id).get();
    }

    @Override
    public UpdateResponse update(String index, String type, String id, String json) {
        return client.prepareUpdate(index, type, id).setDoc(json, XContentType.JSON).get();
    }
}
