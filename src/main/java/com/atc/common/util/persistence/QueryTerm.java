package com.atc.common.util.persistence;

/**
 * Created by Vic.Feng on 18/12/2015.
 */

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;

/**
 * Class representing a query term.
 *
 * @author Alan Ewald
 * @created 2/22/2010
 * @copyright Copyright (c) 2010 American Tower Corporation, All Rights Reserved.
 */

public class QueryTerm implements Serializable {

    // RelOp
    //
    public final static String OP_EQUALS = "Equals";
    public final static String OP_NOT_EQUALS = "Does not equal";
    public final static String OP_CONTAINS = "Contains";
    public final static String OP_NOT_CONTAINS = "Does not contain";
    public final static String OP_GREATER_THAN = "Greater than";
    public final static String OP_GREATER_THAN_OR_EQUAL_TO = "Greater than or equal to";
    public final static String OP_LESS_THAN = "Less than";
    public final static String OP_LESS_THAN_OR_EQUAL_TO = "Less than or equal to";
    public final static String OP_IS_NULL = "Is null";
    public final static String OP_IS_NOT_NULL = "Is not null";
    public final static String OP_IN = "In";
    public final static String OP_NOT_IN = "Not in";
    public final static String OP_STARTS_WITH = "Starts with";
    public final static String OP_NOT_STARTS_WITH = "Does not start with";

    // CondOp
    //
    public final static String OP_AND = "AND";
    public final static String OP_OR = "OR";

    // Types
    //
    public final static String TYPE_STRING = "String";
    public final static String TYPE_NUMBER = "Number";
    public final static String TYPE_DATE = "Date";
    public final static String TYPE_LIST = "List";

    private String label;
    private String field;
    private String relOp = OP_EQUALS;
    private Object value;
    private String type = TYPE_STRING;
    private String condOp = OP_AND;

    public QueryTerm() {
        super();
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setRelOp(String relOp) {
        this.relOp = relOp;
    }

    public String getRelOp() {
        return relOp;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Collection getValueAsCollection() {
        if (value instanceof Collection) {
            return (Collection) value;
        } else if (value instanceof String) {
            ArrayList list = new ArrayList();
            //1. Using StringTokenizer constructor
            StringTokenizer st1 = new StringTokenizer(value.toString(), ",");
            //iterate through tokens
            while (st1.hasMoreTokens()) {
                list.add(st1.nextToken().trim());
            }
            return list;
        } else {
            return Collections.emptyList();
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setCondOp(String condOp) {
        this.condOp = condOp;
    }

    public String getCondOp() {
        return condOp;
    }

    public static String wildcardValue(Object value) {
        if (value instanceof String) {
            String s = (String) value;

            if (StringUtils.isEmpty(s)) {
                return "%";
            }

            if (!s.contains("%") && !s.contains("*")) {
                return "%" + s + "%";
            } else {
                return s.replaceAll("\\*", "%");
            }
        } else {
            return "%";
        }
    }

    public String wildcardValue() {
        return QueryTerm.wildcardValue(this.value);
    }

    public static String startsWithValue(Object value) {
        if (value instanceof String) {
            String s = (String) value;

            if (StringUtils.isEmpty(s)) {
                return "%";
            }

            if (s.startsWith("*") || s.startsWith("%")) {
                s = s.substring(1, s.length() - 1);
            }

            if (!s.endsWith("%") && !s.endsWith("*")) {
                return s + "%";
            } else {
                return s.replaceAll("\\*", "%");
            }
        } else {
            return "%";
        }
    }

    public String startsWithValue() {
        return QueryTerm.startsWithValue(this.value);
    }

    /**
     * Translate the specified map into a list of query terms.
     *
     * @param filterMap
     * @return
     */
    public static List<QueryTerm> getFilterQuery(Map<String, Object> filterMap) {
        ArrayList<QueryTerm> fl = new ArrayList<QueryTerm>(filterMap.size());

        Map.Entry<String, Object> entry;
        String[] tokens;
        String key;
        String value;
        QueryTerm qt;
        for (Iterator<Map.Entry<String, Object>> j = filterMap.entrySet().iterator(); j.hasNext(); ) {
            entry = j.next();
            value = (String) entry.getValue();

            if (!StringUtils.isEmpty(value)) {
                tokens = entry.getKey().split("\\.");
                if (tokens.length > 1) {
                    key = tokens[1];
                } else {
                    key = tokens[0];
                }

                qt = new QueryTerm();
                qt.setField(key);

                if (value.endsWith("*") || value.endsWith("%")) {
                    qt.setRelOp(QueryTerm.OP_STARTS_WITH);
                    qt.setValue(value.substring(0, value.length() - 1));
                } else {
                    qt.setRelOp(QueryTerm.OP_CONTAINS);
                    qt.setValue(value);
                }

                qt.setCondOp(QueryTerm.OP_AND);
                fl.add(qt);
            }
        }

        return fl;
    }

}

