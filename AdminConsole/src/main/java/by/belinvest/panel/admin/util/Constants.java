package by.belinvest.panel.admin.util;

import java.util.ArrayList;

public class Constants {

    static ArrayList<String> list = new ArrayList<>();

    static {
        list.add("aftermath");
        list.add("prospects");
        list.add("risks");
        list.add("business_line");
        list.add("product_class");
        list.add("dep_product_line");
        list.add("depfl_product_line");
        list.add("depfl_currency");
        list.add("dep_currency");
        list.add("depfl_terms");
        list.add("dep_terms");
    }

    public static ArrayList<String> getList() {
        return list;
    }

    public static final String ADD = "ADD";
    public static final String CHANGE_SINGLE_USER = "CHANGE_SINGLE_USER";

}
