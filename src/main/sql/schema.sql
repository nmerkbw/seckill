-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
use seckill;
-- 创建秒杀库存表
CREATE TABLE seckill.`seckill`(
  `seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  `name` VARCHAR(120) NOT NULL COMMENT '商品名称',
  `number` INT NOT NULL COMMENT '库存数量',
  `start_time` TIMESTAMP NOT NULL COMMENT '秒杀开启时间',
  `end_time` TIMESTAMP NOT NULL COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
) ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET =utf8 COMMENT = '秒杀库存表';

-- 初始化数据
INSERT INTO `seckill` (name,number,start_time,end_time)
    VALUES
      ('4000元秒杀iPhoneX',100,'2018-6-22 00:00:00','2018-6-23 00:00:00' ),
      ('2000元秒杀iPhone8',200,'2018-6-22 00:00:00','2018-6-23 00:00:00' ),
      ('1000元秒杀华为P20',300,'2018-6-22 00:00:00','2018-6-23 00:00:00' ),
      ('500元秒杀小米8',400,'2018-6-22 00:00:00','2018-6-23 00:00:00' );

-- 秒杀成功明细表
-- 用户登录认证相关信息
CREATE TABLE `success_killed`(
  `seckill_id` BIGINT NOT NULL COMMENT '秒杀商品id',
  `user_phone` BIGINT NOT NULL COMMENT '用户手机号',
  `state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态标示：-1：无效 0：成功 1：已付款',
  `create_time` TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
  KEY idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = '秒杀成功明细表';

-- 连接数据库控制台
-- mysql -u root -p;

-- 为什么手写DDL（DML：CRUD操作   DDL：在DML的基础上增加了表结构的修改）
-- 记录每次上线的DDL修改



