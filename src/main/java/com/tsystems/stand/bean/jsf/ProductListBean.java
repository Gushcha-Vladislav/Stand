package com.tsystems.stand.bean.jsf;

import com.tsystems.stand.bean.ejb.TopProducts;
import com.tsystems.stand.model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name="productList")
@SessionScoped
public class ProductListBean implements Serializable{

    private static final int serialVersionUID = 1;

    @EJB
    private TopProducts topProducts;

    public List<Product> getTopProducts() {
        return topProducts.getTops();
    }
}
