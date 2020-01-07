package com.jarvis.gmall.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.util
 *
 * @author jarvis
 * @create 2020-01-07 22:29
 */
public class MySolrUtil {
    public static <T> List<T> query(String condition, Class<T> typeClass) {
        String url = MyPropertyUtil.getProperty("solr.properties", "solr_sku");
        HttpSolrServer solr = new HttpSolrServer(url);
        solr.setParser(new XMLResponseParser());

        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setQuery(condition);

        QueryResponse query = null;
        try {
            query = solr.query(solrQuery);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }

        List<T> beans = query.getBeans(typeClass);
        return beans;
    }
}
