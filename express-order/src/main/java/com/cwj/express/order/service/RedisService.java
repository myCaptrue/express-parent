package com.cwj.express.order.service;

import java.util.List;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * @author cwj
 */
public interface RedisService {
    /**
     * 存储数据
     */
    void set(String key, String value);

    public void setList(String key, List list);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置过期时间的键值对
     */
    boolean setKeyValTTL(String key, String value, long ttl);

    /**
     * zset插入操作
     */
    public Boolean zadd(String key, String menber, double score);

    /**
     * zset改变分数操作
     */
    double zincrby(String key, String menber, double score);

    /**
     *  移除zset中的指定元素
     */
    void zrem(String key, Object... menbers);

    /**
     * 设置超期时间
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * zet更改分数
     * @param key key
     * @param menber 成员值
     * @param delta 分数变动（可为正负数）
     * @return 更改后的分数
     */
    Double increment(String key, String menber, double delta);

    /**
     * 获取指定成员的分数(主要用于判断该成员是否存在)
     * @param key 键值
     * @param menber 成员值
     * @return 分数(成员不存在则为null)
     */
    Double zscore(String key, String menber);

    /**
     * 返回指定key的成员数量
     * @param key key值
     * @return 成员数量
     */
    public Long zcard(String key);


}
