package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在“使用者”角度去设计接口
 * 三个方面：
 * 方法定义粒度
 * 参数
 * 返回类型（return 类型/异常）
 * */
public interface SeckillService {

    /**
     * 查询全部的秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param md5
     * @param userPhone
     * @param seckillId
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws RepeatKillException, SeckillCloseException, SeckillException;

    /**
     * 执行秒杀操作 by 存储过程
     *
     * @param md5
     * @param userPhone
     * @param seckillId
     * @return
     * 商品是否秒杀成功，是否能够秒杀在存储过程中已经做了相应的判断，所以这里不需要再使用异常
     * 来提示是进行提交还是回滚
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
