package com.example.tutorialjunit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.Mockito.when;

/**
 * @author chenpenghui
 * @date 2020/7/11
 */
//该注解用于构建Spring Boot上下文环境
@SpringBootTest
class MyFirstJUnitJupiterTest {

    //@Autowired

    //用于添加when条件
    //@MockBean

    //介于@Autowired与@MockBean之间，有条件执行条件，无条件则正常执行方法
    @SpyBean
    private Svc svc;

    /**
     * 所有方法之前执行一次
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll-----------");
    }

    /**
     * 所有方法之后执行一次
     */
    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll-------------");
    }

    /**
     * 每个@Test方法之前执行一次
     */
    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach-------------");
    }

    /**
     * 每个@Test方法之后执行一次
     */
    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach-------------");
    }

    /**
     * 测试方法
     */
    @Test
    @Tag("dev")
    @DisplayName("dev#addTest")
    //@Disabled
    void addTest() {
        when(svc.add(1, 1)).thenReturn(2);
        System.out.println("addTest()");
        int res = svc.add(1, 1);
        Assertions.assertEquals(2, res);
    }

    /**
     * 测试方法
     */
    @Test
    @Tag("prod")
    @DisplayName("prod#minusTest")
    void minusTest() {
        System.out.println("minusTest()");
        int res = svc.minus(2, 1);
        Assertions.assertEquals(1, res);
    }
}
