package com.gaochen.reflect;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/11/27
 */
@Data
public class User {
    private String name;
    private String url;
    private Integer age;
    private Company company;
    private List<Company> companyList;
    private Set<Company> companySet;
}
