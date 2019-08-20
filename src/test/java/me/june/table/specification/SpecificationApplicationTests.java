package me.june.table.specification;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpecificationApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void jdbcTemplateTest () {
        System.out.println(jdbcTemplate);
        assertThat(jdbcTemplate).isNotNull();
    }
}
