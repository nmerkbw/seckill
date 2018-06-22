package org.seckill.exception;

/**
 *  秒杀关闭异常，当秒杀结束时用户还要进行秒杀就会出现这个异常
 *  Spring事务管理只对出现运行期异常进行回滚
 * */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {

        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {

        super(message, cause);
    }
}
