package com.tsystems.stand.bean.ejb;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.tsystems.stand.model.Product;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Singleton
public class TopProducts implements Serializable {

    private List<Product> tops = new ArrayList<>();


    public TopProducts() {
    }

    @PostConstruct
    public void init() {
        updateTopProducts();
    }

    public List<Product> getTops() {
        return tops;
    }

    public void setTops(List<Product> tops) {
        this.tops = tops;
    }

    public void updateTopProducts() {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);

        Client client = Client.create(clientConfig);
        WebResource webResource = client.resource("http://localhost:8081/advertising/stand");


        ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .type(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);

        List list = response.getEntity(ArrayList.class);
        try {
            tops = parseListOfProducts(list);
        } catch (Exception e) {

        }
    }

    private List<Product> parseListOfProducts(List<Map<String, String>> list) {
        List<Product> tops = new ArrayList<>(10);
        for(Map<String, String> product : list) {
            Product temp= new Product();
            for(Map.Entry<String, String> attribute : product.entrySet()) {
                if (attribute.getKey().equals("id")) {
                    temp.setId(new Integer(attribute.getValue()));
                }
                if (attribute.getKey().equals("name")) {
                    temp.setNameProduct(attribute.getValue());
                }
                if (attribute.getKey().equals("price")) {
                    temp.setPrice(new Integer(attribute.getValue()));
                }
                if (attribute.getKey().equals("image")) {
                    temp.setImage(attribute.getValue());
                }
                if (attribute.getKey().equals("numberOfSales")) {
                    temp.setNumberOfSales(new Integer(attribute.getValue()));
                }
            }
            tops.add(temp);
        }
        return tops;
    }
}
