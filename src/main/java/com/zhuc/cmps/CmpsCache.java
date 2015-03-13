package com.zhuc.cmps;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Created by zhucheng on 2014/9/9.
 */
public class CmpsCache {

	private static final Logger logger = LoggerFactory.getLogger(CmpsCache.class);

	private static final ReadWriteLock cmpsTableLock = new ReentrantReadWriteLock();

	/**
	 * R为devId(sim卡号, 前面不带0), C为gserverId, V为配对关系
	 */
	private static final Table<String, String, VehicleInfoView> cmpsTable = HashBasedTable.create();

	/**
	 * 终端号前缀(手机号), 采集平台数据库中存储的sim卡号前缀带0
	 */
	public static final String devid_prefix = "0";

	public static void addToCmpsTable(String devId, String gserverId, VehicleInfoView view) {
		try {
			cmpsTableLock.writeLock().lock();
			cmpsTable.put(getDevIdBySubString(devId), gserverId, view);

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			cmpsTableLock.writeLock().unlock();
		}
	}

	private static String getDevIdBySubString(String devId) {
		if (devId.startsWith(devid_prefix)) {
			// 需要判断devId是否前缀带0, 带0则去除
			devId = devId.substring(1);
		}

		return devId;
	}

	public static VehicleInfoView getByDevId(String devId) {
		VehicleInfoView view = null;
		try {
			cmpsTableLock.readLock().lock();
			Map<String, VehicleInfoView> map = cmpsTable.row(getDevIdBySubString(devId));
			if (!map.isEmpty()) {
				view = map.values().iterator().next();
			}

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			cmpsTableLock.readLock().unlock();
		}

		return view;
	}

	public static VehicleInfoView getByGserverId(String gserverId) {
		VehicleInfoView view = null;
		try {
			cmpsTableLock.readLock().lock();
			Map<String, VehicleInfoView> map = cmpsTable.column(gserverId);
			if (!map.isEmpty()) {
				view = map.values().iterator().next();
			}

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			cmpsTableLock.readLock().unlock();
		}

		return view;
	}

	/**
	 * @param gserverId
	 * @return 不带0的sim卡号
	 */
	public static String getSimcardNoByGserverId(String gserverId) {
		VehicleInfoView view = getByGserverId(gserverId);
		return null == view ? null : view.getCardNum();
	}

	public static void clearAll() {
		try {
			cmpsTableLock.writeLock().lock();
			cmpsTable.clear();

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			cmpsTableLock.writeLock().unlock();
		}
	}

	public static Set<String> getGserverIds() {
		try {
			cmpsTableLock.readLock().lock();
			return cmpsTable.columnKeySet();

		} catch (Exception e) {
			logger.error("", e);
		} finally {
			cmpsTableLock.readLock().unlock();
		}

		return null;
	}

}
