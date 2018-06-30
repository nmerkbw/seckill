package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

    private JedisPool jedisPool;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public RedisDao(String ip, int port) {

        jedisPool = new JedisPool(ip, port);
    }

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    /**
     * 从redis的缓存中取数据
     * */
    public Seckill getSeckill(long seckillId) {

        // redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                // redis/jedis并没有实现内部序列化操作
                // get->byte[](二进制数组)->反序列化->Object(Seckill)
                // 序列化涉及到高并发的问题
                // Serializable实现的是java自己的序列化机制，但是这样高并发不够高效
                // 只需要传入一个class，内部有一个类似scheme的东西去描述这个class的结构
                // class必须是一个pojo（普通java对象）
                // protostuff序列化比jdk原生的序列化空间可以压缩到1/10-1/5，压缩速度增加两个数量级
                byte[] bytes = jedis.get(key.getBytes());
                // 缓存获取到
                if (bytes != null) {
                    // 空对象
                    Seckill seckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    // seckill被反序列化
                    return seckill;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 将数据库的值放入redis当中
     * */
    public String putSeckill(Seckill seckill) {

        // set Object(Seckill)->序列化->byte[]
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                // 超时缓存
                int timeOut = 60 * 60; // 1小时
                // 放入redis
                String result = jedis.setex(key.getBytes(), timeOut, bytes);
                // 错误时返回错误信息，正确时返回ok
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }
}
