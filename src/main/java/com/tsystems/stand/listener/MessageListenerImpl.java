package com.tsystems.stand.listener;


import com.tsystems.stand.bean.ejb.TopProducts;
import org.apache.log4j.Logger;

import javax.jms.Message;
import javax.jms.MessageListener;


public class MessageListenerImpl implements MessageListener {


    private TopProducts topProducts;

    public void onMessage(Message message) {
        topProducts.updateTopProducts();

    }
    public void setTopProducts(TopProducts topProducts) {
        this.topProducts = topProducts;
    }
}
