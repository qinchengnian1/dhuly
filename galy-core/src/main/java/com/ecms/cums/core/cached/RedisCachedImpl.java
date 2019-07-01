package com.ecms.cums.core.cached;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisZSetCommands.Tuple;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;


/**
 *
 * @Title：
 * @Description：RedisCachedImpl
 * @Package com.zucp.core.cached
 * @ClassName RedisCachedImpl
 * @author zJin
 * @date 2018年03月02日
 * @version V1.0
 */
public class RedisCachedImpl implements ICached {

	private static Logger logger = LoggerFactory.getLogger(RedisCachedImpl.class);

	public RedisCachedImpl() {

	}

	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public String deleteCached(final byte[] sessionId) throws Exception {
		redisTemplate.execute(new RedisCallback<Object>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.del(sessionId);
				return null;
			}
		});
		return null;
	}

	@Override
	public String updateCached(final byte[] key, final byte[] session,final Long expireSec)
			throws Exception {
		return (String) redisTemplate.execute(new RedisCallback<Object>() {
			public String doInRedis(final RedisConnection connection)
					throws DataAccessException {
				connection.set(key, session);
				if(expireSec!=null){
					connection.expire(key, expireSec);
				}
				try {
					return new String(key,"utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	@Override
	public Object getCached(final byte[] sessionId) throws Exception {
		return redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] bs = connection.get(sessionId);
				return SerializeUtil.unserialize(bs);
			}
		});

	}

	@Override
	public Set getKeys(final byte[] keys) throws Exception {
		return redisTemplate.execute(new RedisCallback<Set>() {
			public Set doInRedis(RedisConnection connection)
					throws DataAccessException {
				Set<byte[]> setByte = connection.keys(keys);
				if (setByte == null || setByte.size() < 1) {
					return null;
				}
				Set set = new HashSet();
				for (byte[] key : setByte) {
					byte[] bs = connection.get(key);
					set.add(SerializeUtil.unserialize(bs));
				}

				return set;

			}
		});
	}

	@Override
	public Set getHashKeys(final byte[] key) throws Exception {
		return (Set) redisTemplate.execute(new RedisCallback<Set>() {
			public Set doInRedis(RedisConnection connection)
					throws DataAccessException {
				Set<byte[]> hKeys = connection.hKeys(key);
				if(hKeys==null||hKeys.size()>1){
					return null;
				}
				Set set=new HashSet();
				for(byte[] bs:hKeys){
					set.add(SerializeUtil.unserialize(bs));
				}
			return set;
			}
		});

	}

	@Override
	public Boolean  updateHashCached(final byte[] key,final byte[] mapkey, final byte[] value, Long expire)
			throws Exception {

		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				Boolean hSet = connection.hSet(key, mapkey, value);
				return hSet;
			}
		});
	}

	@Override
	public Object getHashCached(final byte[] key, final byte[] mapkey) throws Exception {
		return redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				byte[] hGet = connection.hGet(key, mapkey);
				return SerializeUtil.unserialize(hGet);
			}
		});
	}

	@Override
	public Boolean  addSortedSetCached(final byte[] key,final double score, final byte[] value)
			throws Exception {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				Boolean hSet = connection.zAdd(key, score, value);
				Set<Tuple> set = new HashSet<Tuple>();
				connection.zAdd(key, set);
				return hSet;
			}
		});
	}

	@Override
	public Long  addSortedSetCachedBySet(final byte[] key,final Set<Tuple> set)
			throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long result = connection.zAdd(key, set);
				return result;
			}
		});
	}

	@Override
	public Set<byte[]>  getSortedSetCached(final byte[] key,final long begin,final long end)
			throws Exception {
		return redisTemplate.execute(new RedisCallback<Set<byte[]>>() {
			public Set<byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {

				Set<byte[]> set = connection.zRange(key,begin,end);

				return set;
			}
		});
	}

	@Override
	public long  getSortedSetCachedNum(final byte[] key)throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {

				Long set = connection.zCard(key);

				return set;
			}
		});
	}

	@Override
	public long  deleteSortedSetCachedByMember(final byte[] key,final byte[] value)throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {

				Long zRem = connection.zRem(key, value);

				return zRem;
			}
		});
	}

	@Override
	public Double updateSortedSetCached(final byte[] key, final double score,
			final byte[] value) throws Exception {
		return redisTemplate.execute(new RedisCallback<Double>() {
			public Double doInRedis(RedisConnection connection)
					throws DataAccessException {
				Double zImcr = connection.zIncrBy(key, score, value);
				return zImcr;
			}
		});
	}

	@Override
	public long deleteSortedSetCached(final byte[] key, final long begin,
			final long end) throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
			    long zRem = connection.zRemRange(key, begin, end);
				return zRem;
			}
		});
	}

	@Override
	public Long deleteHashCached(final byte[] key, final byte[] mapkey) throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long hDel = connection.hDel(key, mapkey);
				return hDel;

			}
		});
	}

	@Override
	public Long getHashSize(final byte[] key) throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long len = connection.hLen(key);

				return len;

			}
		});
	}

	@Override
	public List getHashValues(final byte[] key) throws Exception {
		return redisTemplate.execute(new RedisCallback<List>() {
			public List doInRedis(RedisConnection connection)
					throws DataAccessException {
				 List<byte[]> hVals = connection.hVals(key);

				 if(hVals==null||hVals.size()<1){
					 return null;
				 }
				 List list=new ArrayList();

				 for(byte[] bs:hVals){
					 list.add(SerializeUtil.unserialize(bs));
				 }
				return list;

			}
		});
	}

	@Override
	public String putHashCached(final byte[] key, final Map<byte[],byte[]> mapkey,
			Long expire) throws Exception {
		return (String) redisTemplate.execute(new RedisCallback<Object>() {
			public String doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.hMSet(key, mapkey);
				return new String(key);
			}
		});
	}

	@Override
	public List<String> getHashCachedObject(final byte[] key, final byte[] mapkey) throws Exception {
		return redisTemplate.execute(new RedisCallback<List<String>>() {
			public List<String> doInRedis(RedisConnection connection)
					throws DataAccessException {
				List<byte[]> hMGetList = connection.hMGet(key, mapkey);
				Iterator<byte[]> it = hMGetList.iterator();
				List<String> hMGet = new ArrayList<String>();
				while(it.hasNext()){
					hMGet.add(redisTemplate.getStringSerializer().deserialize(it.next()));
				}
				return hMGet;
			}
		});
	}

	@Override
	public List<String> getHashCachedObject(final String key, final String mapkey) throws Exception {
		return redisTemplate.execute(new RedisCallback<List<String>>() {
			public List<String> doInRedis(RedisConnection connection)
					throws DataAccessException {
				List<byte[]> hMGetList = connection.hMGet(redisTemplate.getStringSerializer().serialize(key), redisTemplate.getStringSerializer().serialize(mapkey));
				Iterator<byte[]> it = hMGetList.iterator();
				List<String> hMGet = new ArrayList<String>();
				while(it.hasNext()){
					hMGet.add(redisTemplate.getStringSerializer().deserialize(it.next()));
				}
				return hMGet;
			}
		});
	}

	@Override
	public Map<byte[], byte[]> getAllHashCached(final byte[] key){
		return redisTemplate.execute(new RedisCallback<Map<byte[], byte[]>>() {
			public Map<byte[], byte[]> doInRedis(RedisConnection connection)
					throws DataAccessException {
				Map<byte[], byte[]> hGetAll = connection.hGetAll(key);
				return hGetAll;
			}
		});
	}

	/**
	 * 模糊查询获取所有key
	 */
	@Override
	public Set<String> getKeysNoValue(final byte[] keys) throws Exception {
		return redisTemplate.execute(new RedisCallback<Set>() {
			public Set doInRedis(RedisConnection connection)
					throws DataAccessException {
				Set<byte[]> setByte = connection.keys(keys);
				Set<String> set = new HashSet();
				for (byte[] key : setByte) {
					set.add(redisTemplate.getStringSerializer().deserialize(key));
				}
				return set;
			}
		});
	}

	@Override
	public Long getDBSize() throws Exception {
		return redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				Long len = connection.dbSize();

				return len;

			}
		});
	}

	@Override
	public void clearDB() throws Exception {
		 redisTemplate.execute(new RedisCallback<Long>() {
			public Long doInRedis(RedisConnection connection)
					throws DataAccessException {
				  connection.flushDb();
				return null;

			}
		});
	}





	@Override
	public boolean puthMapSet(final String key, final String mKey, final String mValue) {
		try {
			redisTemplate.execute(new RedisCallback<Object>() {
				@Override
				public Object doInRedis(RedisConnection con)
						throws DataAccessException {
						Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
						byte[] bkey = redisTemplate.getStringSerializer().serialize(key);
						byte[] bmKey = redisTemplate.getStringSerializer().serialize(mKey);
						byte[] bmValue = redisTemplate.getStringSerializer().serialize(mValue);
						map.put(bmKey, bmValue);
						con.hMSet(bkey, map);
						return null;
					}
				});
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Map<String, Object> gethMapSet(byte[] key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existInhMapSet(final String key,final  String mKey, final String mValue) {
		return redisTemplate.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection con)
					throws DataAccessException {
				byte[] bkey = redisTemplate.getStringSerializer().serialize(key);
				if (con.exists(bkey)) {
					byte[] bmKey = redisTemplate.getStringSerializer().serialize(mKey);
						List<byte[]> value = con.hMGet(bkey, bmKey);
						String valueString = redisTemplate.getStringSerializer().deserialize(value.get(0));
						if (valueString != null && valueString.equals(mValue)) {
							return true;
						}
					}
					return false;
				}
			});
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}


}
