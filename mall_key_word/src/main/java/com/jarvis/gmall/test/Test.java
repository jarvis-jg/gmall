package com.jarvis.gmall.test;

import com.jarvis.gmall.dto.Keywords_T_MALL_SKU;
import com.jarvis.gmall.factory.MySqlSessionFactory;
import com.jarvis.gmall.mapper.ClassMapper;
import com.jarvis.gmall.util.MyPropertyUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.io.IOException;
import java.util.List;

public class Test {

	public static void main(String[] args) throws IOException, SolrServerException {

		SqlSessionFactory myF = MySqlSessionFactory.getMyF();

		ClassMapper mapper = myF.openSession().getMapper(ClassMapper.class);

		List<Keywords_T_MALL_SKU> list_sku = mapper.select_list_by_flbh2(28);
	
		System.out.println(list_sku);
		
		// 想solr中导入sku数据
		String url = MyPropertyUtil.getProperty("solr.properties", "solr_sku");
		HttpSolrServer solr = new HttpSolrServer(url);
		solr.setParser(new XMLResponseParser());
		//solr.deleteByQuery("*:*");
		solr.addBeans(list_sku);
		solr.commit();

		//solr查询
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("sku_mch:小明");

		QueryResponse query = solr.query(solrQuery);
		List<Keywords_T_MALL_SKU> beans = query.getBeans(Keywords_T_MALL_SKU.class);
		System.out.println(beans);

	}

}
