package org.seckill.exception;

/**
 * 重复秒杀异常，是一个运行期异常，不需要我们手动try catch
 * Mysql只支持运行期异常的回滚操作
 * Spring事务管理只对出现运行期异常进行回滚
 * */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {

        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {

        super(message, cause);
    }
}

