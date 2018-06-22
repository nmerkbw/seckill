package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {

        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("list={}", seckills);
    }

    @Test
    public void queryById() throws Exception {

        long seckillId = 1000;
        Seckill seckill = seckillService.queryById(seckillId);
        logger.info("seckill={}",seckill);
    }

    // 测试代码完整逻辑，注意可重复执行
    @Test
    public void seckillLogic() throws Exception {

        long seckillId = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);

            long userPhone = 13037310136L;
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = null;
            try {
                seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                logger.info("seckillExcution={}", seckillExecution);
            } catch (RepeatKillException e1) {
                logger.error(e1.getMessage());
            } catch (SeckillCloseException e2) {
                logger.error(e2.getMessage());
            }
        } else {
            // 秒杀未开启
            logger.warn("exposer={}",exposer);
        }
    }

    @Test
    public void executeSeckillProcedureTset() {

        long secKillId = 1000;
        long phone = 13878786767L;
        Exposer exposer = seckillService.exportSeckillUrl(secKillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution execution = seckillService.executeSeckillProcedure(secKillId, phone, md5);
            logger.info(execution.getStateInfo());
        }
    }
}