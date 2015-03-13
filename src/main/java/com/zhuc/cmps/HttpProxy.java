package com.zhuc.cmps;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @title 提供通过http协议访问的方法类
 * @description
 * @usage
 * @copyright Copyright 2011 SHCMCT Corporation. All rights reserved.
 * @company 上海中移通信技术工程有限公司
 * @author hx_zhuc
 * @create 2012-11-14下午4:30:38
 */
public class HttpProxy {

	private final HttpClient httpclient = new DefaultHttpClient();

	private static Logger logger = LoggerFactory.getLogger(HttpProxy.class);

	/**
	 * 
	 * @param url
	 * @param param
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 * @throws IllegalAccessException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public String accessPost(String url, Object param) throws ClientProtocolException, IOException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return access(url, nvpMarker(param));
	}

	/**
	 * 将对象转化为httpclient request 参数的name-value 对象
	 * 
	 * @param obj
	 *            对象
	 * @param className
	 *            类名
	 * @return
	 * @throws NoSuchMethodException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public List<NameValuePair> paramLoader(Object obj) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		List<NameValuePair> list = new ArrayList<NameValuePair>();

		// 访问时参数前缀，gserver开放接口为 的参数为 classname.xxxx 类似

		if (obj != null) {
			String prefix = BeanUtils.getProperty(obj, "prefix");
			if (prefix == null || "".equals(prefix)) {
				prefix = "";
			}

			// 反射获取所有的字段信息
			Field[] fields = getFields(obj);

			String fieldsName = null;
			for (Field f : fields) {
				fieldsName = f.getName();
				if ("prefix".equals(fieldsName)) {
					continue;
				}
				if (!"".equals(prefix)) {
					fieldsName = prefix + "." + fieldsName;
				}

				if (f.getType().isArray()) { // 字段为数组类型的
					String str[] = BeanUtils.getArrayProperty(obj, f.getName());
					for (String s : str) {
						NameValuePair nvp = new BasicNameValuePair(f.getName(), s);
						list.add(nvp);
					}

				} else { // 基本类型
					String value = BeanUtils.getProperty(obj, f.getName());
					if (value == null || ("id".equals(f.getName()) && "0".equals(value))) { // 若值为null 不作为参数传递
						continue;
					}
					NameValuePair nvp = new BasicNameValuePair(fieldsName, value);
					list.add(nvp);
				}
			}

		}

		return list;
	}

	/**
	 * Object对象封装成参数
	 * 
	 * @param obj
	 * @return
	 * @throws IllegalAccessException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public List<NameValuePair> nvpMarker(Object obj) throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		List<NameValuePair> list = null;
		if (obj != null) {
			Field[] fields = obj.getClass().getDeclaredFields();
			list = new ArrayList<NameValuePair>();
			for (Field f : fields) {
				String value = BeanUtils.getProperty(obj, f.getName());
				if (value == null) { // 若值为null 不作为参数传递
					continue;
				}
				NameValuePair nvp = new BasicNameValuePair(f.getName(), value);
				list.add(nvp);
			}

		}
		return list;
	}

	/**
	 * Map对象封装成参数
	 * 
	 * @param paramMap
	 * @return
	 * @throws IllegalAccessException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public List<NameValuePair> nvpMarkerMap(Map<String, String> paramMap) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		List<NameValuePair> list = null;

		if (null != paramMap) {
			list = new ArrayList<NameValuePair>();
			for (Map.Entry<String, String> entry : paramMap.entrySet()) {
				NameValuePair nvp = new BasicNameValuePair(entry.getKey(), entry.getValue());
				list.add(nvp);
			}
		}

		return list;
	}

	/**
	 * 默认情况http请求/响应编码为UTF-8,且显示日志
	 * @param url
	 * @param paramMap
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 * @throws IllegalAccessException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public String accessPost(String url, Map<String, String> paramMap) throws ClientProtocolException, IOException,
			IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return accessPost(url, paramMap, "UTF-8", "UTF-8", true);
	}

	/**
	 * 默认显示日志
	 * @param url
	 * @param paramMap
	 * @param requestCharset 指定请求编码
	 * @param responseCharset 指定响应编码
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 * @throws IllegalAccessException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public String accessPost(String url, Map<String, String> paramMap, String requestCharset, String responseCharset)
			throws ClientProtocolException, IOException, IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		return accessPost(url, paramMap, requestCharset, responseCharset, true);
	}

	/**
	 * 默认请求/响应编码为UTF-8
	 * @param url
	 * @param paramMap
	 * @param showLog 是否显示日志
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 * @throws IllegalAccessException
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public String accessPost(String url, Map<String, String> paramMap, boolean showLog) throws ClientProtocolException,
			IOException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return accessPost(url, paramMap, "UTF-8", "UTF-8", showLog);
	}

	/**
	 * @param url
	 * @param paramMap
	 * @param requestCharset 可以自行设置请求编码
	 * @param responseCharset 可以自行设置响应编码
	 * @param showLog 是否显示请求及响应的日志
	 * 
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 * @throws NoSuchMethodException 
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws IllegalAccessException 
	 */
	public String accessPost(String url, Map<String, String> paramMap, String requestCharset, String responseCharset,
			boolean showLog) throws ClientProtocolException, IOException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		String result = null;

		HttpPost post = new HttpPost(url);

		List<NameValuePair> nvps = nvpMarkerMap(paramMap);
		if (nvps != null) {
			post.setEntity(new UrlEncodedFormEntity(nvps, requestCharset));
		}

		HttpResponse response = httpclient.execute(post);
		HttpEntity entity = response.getEntity();

		if (entity != null) {
			result = EntityUtils.toString(entity, responseCharset);
		}

		if (showLog) {
			logger.debug("http status >>>>> " + response.getStatusLine().getStatusCode());
			logger.debug("=======http content =====");
			logger.debug("result:" + result);
			logger.debug("=======http content =====");

			if (null != nvps) {
				for (NameValuePair nvp : nvps) {
					logger.debug(nvp.getName() + "====" + nvp.getValue());
				}
			}
			logger.debug("\n");
		}

		return result;

	}

	/**
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws java.io.IOException
	 * @throws NoSuchMethodException 
	 * @throws java.lang.reflect.InvocationTargetException
	 * @throws IllegalAccessException 
	 */
	public String accessGet(String url) throws ClientProtocolException, IOException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		String result = null;

		HttpGet get = new HttpGet(url);

		HttpResponse response = httpclient.execute(get);
		HttpEntity entity = response.getEntity();
		logger.debug("http status >>>>> " + response.getStatusLine().getStatusCode());

		if (entity != null) {
			result = EntityUtils.toString(entity, "UTF-8");
			logger.debug("=======http content =====");
			logger.debug(result);
			logger.debug("=======http content =====");
		}

		if (logger.isDebugEnabled()) {
			logger.debug("url====" + url);
		}

		return result;

	}

	public String access(String url, List<NameValuePair> nvps) throws ClientProtocolException, IOException {
		String result = null;

		HttpPost post = new HttpPost(url);

		if (nvps != null) {
			post.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
		}

		HttpResponse response = httpclient.execute(post);
		HttpEntity entity = response.getEntity();
		logger.debug("http status >>>>> " + response.getStatusLine().getStatusCode());

		if (entity != null) {
			result = EntityUtils.toString(entity, "UTF-8");
			logger.debug("=======http content =====");
			logger.debug(result);
			logger.debug("=======http content =====");
		}

		//TODO print all paramers ,need to remove
		if (logger.isDebugEnabled() && nvps != null && nvps.size() > 0) {
			for (NameValuePair nvp : nvps) {
				logger.debug(nvp.getName() + "====" + nvp.getValue());
			}
		}

		return result;

	}

	/**
	 * 关闭连接
	 */
	public void closeConnection() {
		if (httpclient != null)
			this.httpclient.getConnectionManager().shutdown();
	}

	/**
	 * 获取指定类的所有字段名
	 * @param obj
	 * @return
	 */
	public Field[] getFields(Object obj) {
		Map<String, Field> map = new LinkedHashMap<String, Field>();
		Class cc = obj.getClass();

		while (null != cc && cc != Object.class) {
			Field[] fs = cc.getDeclaredFields();
			for (Field f : fs) {
				map.put(f.getName(), f);
			}
			cc = cc.getSuperclass();
		}

		return map.values().toArray(new Field[map.size()]);
	}

}
