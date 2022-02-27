package com.reactive.application.sectionmodel;

import com.reactive.application.sectionutil.UtilClass;
import lombok.Data;

@Data
public class PurchaseOrder {
    private String item;
    private String price;
    private int userId;

    public PurchaseOrder(int userId) {
        this.item = UtilClass.faker().commerce().productName();
        this.price = UtilClass.faker().commerce().price();
        this.userId = userId;
    }
}
