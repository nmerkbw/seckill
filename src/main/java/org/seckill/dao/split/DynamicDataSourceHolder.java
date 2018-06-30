package org.seckill.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceHolder {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    private static ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    /**
     * 获取数据源
     * @return
     */
    public static String getDbType() {
        String db = contextHolder.get();
        if(db==null) {
            db = DB_MASTER;
        }
        return db;
    }

    /**
     * 设置数据源
     * @param dbType
     */
    public static void setDbType(String dbType) {

        logger.debug("所使用的数据源"+dbType);
        contextHolder.set(dbType);
    }

    /**
     * 清理数据源
     */
    public static void clearDbType() {

        contextHolder.remove();
    }
}
