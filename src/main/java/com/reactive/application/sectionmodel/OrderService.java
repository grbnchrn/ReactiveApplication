package com.reactive.application.sectionmodel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

  public static  Map<Integer, List<PurchaseOrder>> mapDB = new HashMap<>();

  static {
    List<PurchaseOrder> purchaseOrderList1 = List.of(new PurchaseOrder(1), new PurchaseOrder(1));

    List<PurchaseOrder> purchaseOrderList2 =
            List.of(new PurchaseOrder(2), new PurchaseOrder(2), new PurchaseOrder(2));

    mapDB =
            Map.ofEntries(Map.entry(1, purchaseOrderList1), Map.entry(2, purchaseOrderList2));

  }
}
