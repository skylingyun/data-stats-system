package com.ybz.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.query.SortQueryBuilder;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 通用缓存工具类
 */
@SuppressWarnings("unchecked")
public class RedisTemplateUtil {

	private static RedisTemplate redisTemplate;

	static {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring-redis.xml");
		redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
	}

	/**
	 * 删除缓存<br>
	 * 根据key精确匹配删除
	 * 
	 * @param key
	 */
	public static void del(String... key) {
		if (key != null && key.length > 0) {
			if (key.length == 1) {
				redisTemplate.delete(key[0]);
			} else {
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}

	/**
	 * 批量删除<br>
	 * （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删）
	 * 
	 * @param pattern
	 */
	public static void batchDel(String... pattern) {
		for (String kp : pattern) {
			redisTemplate.delete(redisTemplate.keys(kp + "*"));
		}
	}

	/**
	 * 取得缓存（int型）
	 * 
	 * @param key
	 * @return
	 */
	public static Integer getInt(String key) {
		String value = (String) redisTemplate.opsForValue().get(key);
		if (StringUtil.isNotEmpty(value)) {
			return Integer.valueOf(value);
		}
		return null;
	}

	/**
	 * 取得缓存（字符串类型）
	 * 
	 * @param key
	 * @return
	 */
	public static String getStr(String key) {
		return (String) redisTemplate.opsForValue().get(key);
	}

	/**
	 * 取得缓存（字符串类型）
	 * 
	 * @param key
	 * @return
	 */
	public static String getStr(String key, boolean retain) {
		String value = (String) redisTemplate.opsForValue().get(key);
		if (!retain) {
			redisTemplate.delete(key);
		}
		return value;
	}

	/**
	 * 获取缓存<br>
	 * 注：基本数据类型(Character除外)，请直接使用get(String key, Class<T> clazz)取值
	 * 
	 * @param key
	 * @return
	 */
	public static Object getObj(String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 获取缓存<br>
	 * 注：java 8种基本类型的数据请直接使用get(String key, Class<T> clazz)取值
	 * 
	 * @param key
	 * @param retain
	 *            是否保留
	 * @return
	 */
	public static Object getObj(String key, boolean retain) {
		Object obj = redisTemplate.opsForValue().get(key);
		if (!retain) {
			redisTemplate.delete(key);
		}
		return obj;
	}

	/**
	 * 获取缓存<br>
	 * 注：该方法暂不支持Character数据类型
	 * 
	 * @param key
	 *            key
	 * @param clazz
	 *            类型
	 * @return
	 */
	public static <T> T get(String key, Class<T> clazz) {
		return (T) redisTemplate.opsForValue().get(key);
	}

	

	/**
	 * 将value对象写入缓存
	 * 
	 * @param key
	 * @param value
	 * @param time
	 *            失效时间(秒)
	 */
	public static void set(String key, Object value, Long time) {
		if (value.getClass().equals(String.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else if (value.getClass().equals(Integer.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else if (value.getClass().equals(Double.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else if (value.getClass().equals(Float.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else if (value.getClass().equals(Short.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else if (value.getClass().equals(Long.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else if (value.getClass().equals(Boolean.class)) {
			redisTemplate.opsForValue().set(key, value.toString());
		} else {
			redisTemplate.opsForValue().set(key, value);
		}
		expire(key, time);
	}

	
	/**
	 * 递减操作
	 * 
	 * @param key
	 * @param by
	 * @return
	 */
	public static double decr(String key, double by) {
		return redisTemplate.opsForValue().increment(key, -by);
	}

	/**
	 * 递增操作
	 * 
	 * @param key
	 * @param by
	 * @return
	 */
	public static double incr(String key, double by) {
		return redisTemplate.opsForValue().increment(key, by);
	}

	/**
	 * 获取double类型值
	 * 
	 * @param key
	 * @return
	 */
	public static double getDouble(String key) {
		String value = (String) redisTemplate.opsForValue().get(key);
		if (StringUtil.isNotEmpty(value)) {
			return Double.valueOf(value);
		}
		return 0d;
	}

	/**
	 * 设置double类型值
	 * 
	 * @param key
	 * @param value
	 * @param time
	 *            失效时间(秒)
	 */
	public static void setDouble(String key, double value, Long time) {
		redisTemplate.opsForValue().set(key, String.valueOf(value));
		if (time > 0) {
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
		}
	}

	/**
	 * 设置double类型值
	 * 
	 * @param key
	 * @param value
	 * @param time
	 *            失效时间(秒)
	 */
	public static void setInt(String key, int value, Long time) {
		redisTemplate.opsForValue().set(key, String.valueOf(value));
		if (time > 0) {
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
		}
	}
	
	
	/////////////////// 缓存成JSON start ///////////////////////
	
	/**
	 * 将数据缓存成json
	 * 
	 * @param key
	 * @param data
	 * @param time
	 */
	public static <T,K> void setToJson(K key, T data, Long time) {
		redisTemplate.opsForValue().set(key, JsonMapper.toJsonString(data));
		expire(key, time);
	}

	/**
	 * 更新json中的某个属性字段值
	 * 
	 * @param key
	 * @param field
	 * @param data
	 */
	public static <T,K> void setToJsonField(K key, String field, T data) {
		JSONObject obj = JSON.parseObject((String) redisTemplate.opsForValue().get(key));
		obj.put(field, data);
		redisTemplate.opsForValue().set(key, obj.toJSONString());
	}
	
	/**
	 * 从缓存成json格式的数据中获取jsonstring，转换为指定的数据结构
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> T getFromJson(String key, Class<T> clazz) {
		return JsonMapper.fromJsonString((String) redisTemplate.opsForValue().get(key), clazz);
	}
	
	/**
	 * 从缓存成json格式的数据中获取jsonstring，转换为指定数据结构的List
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> getListFromJson(String key, Class<T> clazz) {
		return JSON.parseArray((String) redisTemplate.opsForValue().get(key), clazz);
	}
	
	
	/////////////////// 缓存成JSON end ///////////////////////
	
	

	/////////////////// 缓存到map start ///////////////////////

	/**
	 * 缓存到map
	 * 
	 * @param key
	 * @param map
	 * @param time
	 *            有效时长 单位秒 , time>0才有效
	 */
	public static <T, K, V> void setToMap(T key, Map<K, V> data, Long time) {
		redisTemplate.opsForHash().putAll(key, data);
		expire(key, time);
	}

	/**
	 * 缓存数据到map中的指定key
	 * 
	 * @param key
	 * @param hashKey
	 * @param value
	 */
	public static <T, K, V> void setToMap(T key, K hashKey, V data) {
		redisTemplate.opsForHash().put(key, hashKey, data);
	}

	/**
	 * 缓存到map
	 * 
	 * @param key
	 * @param obj
	 * @param time
	 *            有效时长 单位秒 , time>0才有效
	 */
	public static <K, T> void setToMap(K key, T data, Long time) {
		Map<String, String> map = (Map<String, String>) JsonMapper.parseObject(data, Map.class);
		redisTemplate.opsForHash().putAll(key, map);
		expire(key, time);
	}

	/**
	 * 从map中获取
	 * 
	 * @param key
	 * @return
	 */
	public static <T, K, V> Map<K, V> getFromMap(T key) {
		BoundHashOperations<T, K, V> boundHashOperations = redisTemplate.boundHashOps(key);
		return boundHashOperations.entries();
	}

	/**
	 * 从map中获取
	 * 
	 * @param key
	 * @param clazz
	 * @return
	 */
	public static <T, K> T getFromMap(K key, Class<T> clazz) {
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(key);
		Map<String, String> map = boundHashOperations.entries();
		return JsonMapper.parseObject(map, clazz);
	}

	/**
	 * 从map中获取指定hashKey的数据
	 * 
	 * @param key
	 * @param hashKey
	 * @param clazz
	 * @return
	 */
	public static <T, K, V> V getFromMap(T key, K hashKey, Class<V> clazz) {
		return (V) redisTemplate.boundHashOps(key).get(hashKey);
	}

	/**
	 * 从map中删除指定的hashKeys
	 * 
	 * @param key
	 * @param hashKeys
	 */
	public static <T, K> void delFromMap(T key, K... hashKeys) {
		BoundHashOperations<T, K, ?> boundHashOperations = redisTemplate.boundHashOps(key);
		boundHashOperations.delete(hashKeys);
	}

	/////////////////// 缓存到map end ///////////////////////

	/////////////////// 缓存到list start ///////////////////////

	/**
	 * 缓存数据到链表中
	 * 
	 * @param key
	 * @param data
	 * @return
	 */
	public static <T, K> Long setToList(K key, T data, Long time) {
		ListOperations<K, T> list = redisTemplate.opsForList();
		// redisTemplate.delete(key);
		Long result = list.rightPushAll(key, data);
		expire(key, time);
		return result;
	}

	/**
	 * 从缓存链表中获取最新的一个数据
	 * 
	 * @param key
	 * @return
	 */
	public static <T, K> T getFromList(K key) {

		ListOperations<K, T> list = redisTemplate.opsForList();
		return (T) list.rightPop(key);
	}

	/**
	 * 从缓存链表中获取数据
	 * 
	 * @param key
	 * @param start
	 *            链表起始位置 起始位置是0
	 * @param end
	 *            链接结束位置 全部用-1
	 * @return
	 */
	public static <T extends Object> List<T> getSubFromList(String key, Long start, Long end) {

		ListOperations<String, Object> list = redisTemplate.opsForList();
		// 按指定范围取链表的子链表
		return (List<T>) list.range(key, start, end);

	}

	/////////////////// 缓存到list end ///////////////////////

	/////////////////// 缓存到set start ///////////////////////

	/**
	 * 缓存到set
	 * 
	 * @param key
	 * @param time
	 * @param data
	 */
	public static <T, K> void setToSet(K key, Long time, T... data) {
		redisTemplate.boundSetOps(key).add(data);
		expire(key,time);
	}

	/**
	 * 删除set中指定的数据
	 * 
	 * @param key
	 * @param data
	 */
	public static <T, K> void delFromSet(K key, T... data) {
		redisTemplate.boundSetOps(key).remove(data);
	}

	/**
	 * set key重命名
	 * 
	 * @param oldkey
	 * @param newkey
	 */
	public static <K1, K2> void renameSet(K1 oldkey, K2 newkey) {
		redisTemplate.boundSetOps(oldkey).rename(newkey);
	}

	/////////////////// 缓存到set end ///////////////////////

	/**
	 * 指定缓存的失效时间
	 * 
	 * @param key
	 * @param time
	 *            有效时长 单位秒 , time>0才有效
	 */
	public static <T> void expire(T key, Long time) {
		if (time > 0) {
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
		}
	}

	

	/**
	 * 模糊查询keys
	 * 
	 * @param pattern
	 * @return
	 */
	public static Set<String> keys(String pattern) {
		return redisTemplate.keys(pattern);
	}

}