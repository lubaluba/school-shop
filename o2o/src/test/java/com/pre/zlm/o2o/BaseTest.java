package com.pre.zlm.o2o;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.RedisConfig;
import config.RootConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class,RedisConfig.class})
public class BaseTest {
}
