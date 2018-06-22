package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新库存的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀的商品信息
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param off
     * @param limit
     * @return
     * @note queryAll方法为什么不直接查询所有记录，用offset和limit限制区间的好处是什么？
     * 为了分页显示用，如果全部查询所有记录的话，DB里的记录数特别多的话，影响性能。
     */
    List<Seckill> queryAll(@Param("offset") int off, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     * @return
     */
    void killByProcedure(Map<String,Object> paramMap);
}
