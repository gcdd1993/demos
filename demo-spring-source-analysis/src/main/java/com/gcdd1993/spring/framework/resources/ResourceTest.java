package com.gcdd1993.spring.framework.resources;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.math.BigInteger;
import java.net.MalformedURLException;

/**
 * @author gaochen
 * @date 2019/3/26
 */
public class ResourceTest {

    /**
     * test on {@link org.springframework.core.io.UrlResource}
     */
    @Test
    public void test_UrlResource() throws MalformedURLException {
        UrlResource resource = new UrlResource("https://www.baeldung.com/wp-content/uploads/2018/01/BookCover-Persistence_with_Spring.png");
        String filename = resource.getFilename();
        Assert.assertEquals("BookCover-Persistence_with_Spring.png", filename);
    }


    /**
     * test on {@link org.springframework.core.io.ClassPathResource}
     */
    @Test
    public void test_ClassPathResource() throws IOException {
        ClassPathResource resource = new ClassPathResource("config.xml");
        Assert.assertTrue(resource.getFile().exists());
    }

    /**
     * test on {@link org.springframework.core.io.FileSystemResource}
     */
    @Test
    public void test_FileSystemResource() {
        FileSystemResource resource = new FileSystemResource("config.xml");
        Assert.assertFalse(resource.getFile().exists());
    }

    /**
     * test on {@link org.springframework.core.io.ResourceLoader}
     */
    @Test
    public void test_ResourceLoader() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        Resource resource = applicationContext.getResource("classpath:config.xml");
        System.out.println(resource.getClass().getName());
        resource = applicationContext.getResource("file:///config.xml");
        System.out.println(resource.getClass().getName());
        resource = applicationContext.getResource("https://theme-next.iissnan.com/third-party-services.html");
        System.out.println(resource.getClass().getName());

    }

    @Test
    public void test_longMaxValue() {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.toString(Long.MAX_VALUE).length());
        System.out.println(new BigInteger("11111111111111111111"));
    }


}
