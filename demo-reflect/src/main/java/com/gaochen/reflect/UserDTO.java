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
public class UserDTO {
    private String name;
    private String url;
    private Integer age;
    private CompanyDTO company;
    private List<CompanyDTO> companyList;
    private Set<CompanyDTO> companySet;
}
