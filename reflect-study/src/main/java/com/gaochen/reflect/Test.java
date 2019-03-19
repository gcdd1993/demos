package com.gaochen.reflect;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: gaochen
 * Date: 2018/11/27
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setName("111");
        user.setUrl("222");
        user.setAge(22);
        Company company = new Company();
        company.setName("111");
        company.setAddress("222");
        user.setCompany(company);
        List<Company> companies = new ArrayList<>();
        companies.add(company);
        companies.add(company);
        companies.add(company);
        user.setCompanyList(companies);
        Set<Company> companies1 = new HashSet<>();
        companies1.add(company);
        companies1.add(company);
        companies1.add(company);
        companies1.add(company);
        user.setCompanySet(companies1);
        UserDTO copy = copy(user);

        System.out.println(copy);
    }

    public static <T, R> T copy(R r) {

        try {
            T t = (T) Class.forName(r.getClass().getName() + "DTO").newInstance();
            BeanUtils.copyProperties(r, t);
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type.getName().contains("DTO")) {
                    Field rField = r.getClass().getDeclaredField(field.getName());
                    rField.setAccessible(true);
                    field.set(t, copy(Class.forName(type.getName().replace("DTO", "")).cast(rField.get(r))));
                }
                if (Collection.class.isAssignableFrom(type)) {
                    ParameterizedType listType = (ParameterizedType) field.getGenericType();
                    Class<?> parameterizedType = (Class<?>) listType.getActualTypeArguments()[0];
                    if (parameterizedType.getName().contains("DTO")) {
                        Field rField = r.getClass().getDeclaredField(field.getName());
                        rField.setAccessible(true);
                        Collection collection = (Collection) rField.get(r);
                        Collector collector = null;
                        if (List.class.isAssignableFrom(type)) {
                            collector = Collectors.toList();
                        }
                        if (Set.class.isAssignableFrom(type)) {
                            collector = Collectors.toSet();
                        }
                        field.set(t, collection.stream().map(item ->
                        {
                            try {
                                return Test.copy(Class.forName(parameterizedType.getName().replace("DTO","")).cast(item));
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                                return null;
                            }
                        }).collect(collector));
                    }
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
