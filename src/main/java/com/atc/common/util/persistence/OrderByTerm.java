package com.atc.common.util.persistence;

/**
 * Created by Vic.Feng on 18/12/2015.
 */

import java.io.Serializable;

/**
 * Class representing an order by term.
 *
 * @author Alan Ewald
 * @created 7/7/2010
 * @copyright Copyright (c) 2010 American Tower Corporation, All Rights Reserved.
 */

public class OrderByTerm implements Serializable {

    private String field = null;
    private Boolean ascending = true;

    public OrderByTerm() {
        super();
    }

    public OrderByTerm(String f) {
        field = f;
    }

    public OrderByTerm(String f, boolean o) {
        field = f;
        ascending = o;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setAscending(Boolean ascending) {
        this.ascending = ascending;
    }

    public Boolean getAscending() {
        return ascending;
    }

    public boolean isAscending() {
        return ascending;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof OrderByTerm)) {
            return false;
        }
        final OrderByTerm other = (OrderByTerm) object;
        if (!(field == null ? other.field == null : field.equals(other.field))) {
            return false;
        }
        if (!(ascending == null ? other.ascending == null : ascending.equals(other.ascending))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((field == null) ? 0 : field.hashCode());
        result = PRIME * result + ((ascending == null) ? 0 : ascending.hashCode());
        return result;
    }
}
