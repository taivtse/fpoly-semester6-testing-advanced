package com.connectnow.paging;

import com.connectnow.constant.SystemConstant;
import org.hibernate.criterion.Order;

public class Sorter {
    private String propertyName;
    private String direction;

    public Sorter(String sortExpression, String sortDirection) {
        this.propertyName = sortExpression;
        this.direction = sortDirection;
    }

    public Order getOrder() {
        if (direction.equals(SystemConstant.SORT_ASC)) {
            return Order.asc(propertyName);
        } else {
            return Order.desc(propertyName);
        }
    }

    public String getPropertyName() {
        return propertyName;
    }
    public String getDirection() {
        return direction;
    }
}
