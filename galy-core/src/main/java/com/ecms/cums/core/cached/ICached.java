package com.ecms.cums.core.cached;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.connection.RedisZSetCommands.Tuple;
/**
 *
 * @Title：
 * @Description：Cache 接口   (目前实现仅有redis一个实现)
 * @Package com.zucp.core.cached
 * @ClassName ICached
 * @author zJin
 * @date 2018年03月02日
 * @version V1.0
 */
public interface ICached {

	/**
	 * 删除 缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	String deleteCached(byte[] key)throws Exception;

	/**
	 * 更新 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Object updateCached(byte[] key,byte[] value,Long expire)throws Exception;

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Object getCached(byte[] key)throws Exception;

	/**
	 * 根据 正则表达式key 获取 列表
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	Set getKeys(byte[] keys)throws Exception;

	/**
	 * 根据 正则表达式key 获取 列表
	 * @param keys
	 * @return
	 * @throws Exception
	 */
	Set getHashKeys(byte[] key)throws Exception;

	/**
	 * 更新 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Boolean updateHashCached(byte[] key,byte[] mapkey,byte[] value,Long expire)throws Exception;

	/**
	 * 获取缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Object getHashCached(byte[] key,byte[] mapkey)throws Exception;

	/**
	 * 删除 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Long deleteHashCached(byte[] key,byte[] mapkey)throws Exception;

	/**
	 * 获取 map的长度
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Long getHashSize(byte[] key)throws Exception;
	/**
	 * 获取 map中的所有值
	 * @param key
	 * @return
	 * @throws Exception
	 */
	List getHashValues(byte[] key)throws Exception;

	/**
	 * 获取 map的长度
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Long getDBSize()throws Exception;

	/**
	 * 清空Redis DB
	 * @param key
	 * @return
	 * @throws Exception
	 */
	void clearDB()throws Exception;

	/**
	* @Title: addSortedSetCached
	* @Description: 增加sortedSetRedis
	* @param mapkey
	* @param score
	* @param value
	* @param expire
	* @throws Exception    设定文件
	* @return Boolean    返回类型
	 */
	Boolean addSortedSetCached(byte[] mapkey, double score, byte[] value) throws Exception;

	//更新SortedSet的scroce值
	Double updateSortedSetCached(byte[] mapkey, double score, byte[] value) throws Exception;

	//增加sortedSetRedis,参数为set,与addSortedSetCached结果一致,参数不同
	Long addSortedSetCachedBySet(byte[] key, Set<Tuple> set) throws Exception;

	//得到addSortedSetCached指定rank之间的数据
	Set<byte[]> getSortedSetCached(byte[] key, long begin, long end) throws Exception;

	//删除addSortedSetCached指定rank之间的数据
	long deleteSortedSetCached(byte[] key, long begin, long end) throws Exception;

	//得到addSortedSetCached的数据数量
	long getSortedSetCachedNum(byte[] key) throws Exception;

	/**
	 * @Title: deleteSortedSetCachedByMember
	 * @Description: 根据key，value删除单条记录
	 */
	long deleteSortedSetCachedByMember(byte[] key, byte[] value) throws Exception;

	/**
	 * 存放 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Object putHashCached(byte[] key,Map<byte[], byte[]> mapkey,Long expire)throws Exception;

	/**
	 * 获取 缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	List<String> getHashCachedObject(byte[] key,byte[] mapkey)throws Exception;

	/**
	 * 获取所有的key值
	* @Title: getKeysNoValue
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param serialize
	* @return    设定文件
	* @return Set    返回类型
	 */
	Set getKeysNoValue(byte[] serialize) throws Exception;

	/**
	 *
	 * @Title: getAllHashCached
	 * @Description: 通过key得到所有的hashcachede的map(mapkey value)
	 * @param bytes
	 * @return Map<byte[],byte[]>返回类型
	 * @throws
	 */
	Map<byte[],byte[]> getAllHashCached(byte[] bytes);

	/**
	 *
	 * @Title: puthMapSet
	 * @Description:把键值对放入key对应的HMap中
	 * @param key
	 * @param mKey
	 * @param mValue
	 * @return
	 */
	boolean puthMapSet(String key,String mKey,String mValue);


	/**
	 *
	 * @Title: gethMapSet
	 * @Description:通过key得到HMap
	 * @param key
	 * @return
	 */
	Map<String,Object> gethMapSet(byte[] key);

	/**
	 *
	 * @Title: existInhMapSet
	 * @Description:验证键值对是否在key对应的HMap中
	 * @param key
	 * @param args0
	 * @param args1
	 * @return
	 */
	boolean existInhMapSet(String key,String mKey,String mValue);

	List<String> getHashCachedObject(String key, String mapkey) throws Exception;
}
