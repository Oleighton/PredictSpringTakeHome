package org.example.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SolrService {

    SolrClient client = new HttpSolrClient.Builder("http://localhost:8983/solr/ps_products").build();


    public void insertProduct(SolrProduct product) throws IOException, SolrServerException {
        client.addBean(product);
        client.commit();
    }
}
