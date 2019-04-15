package com.service;

import com.model.DocMO;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateResponse;

import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/1
 */
public interface ESService {
    IndexResponse indexJson(String index, String type, String id, String json);

    void bulkIndex(List<DocMO> docMOS);

    GetResponse get(String index, String type, String id);

    DeleteResponse delete (String index, String type, String id);

    UpdateResponse update(String index, String type, String id, String json);
}
