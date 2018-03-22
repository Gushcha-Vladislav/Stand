package com.tsystems.stand.bean.ejb;


import com.tsystems.stand.model.Product;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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
       tops=new ArrayList<>();
       tops.add(new Product(1,"Хлеб",120,"",12));
        tops.add(new Product(2,"Мясо",12,"",24));
    }

}
