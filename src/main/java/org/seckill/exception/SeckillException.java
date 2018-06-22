package org.seckill.exception;

/**
 * 秒杀相关的所有业务异常
 * Spring事务管理只对出现运行期异常进行回滚
 * */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {

        super(message);
    }

    public SeckillException(String message, Throwable cause) {

        super(message, cause);
    }
}
