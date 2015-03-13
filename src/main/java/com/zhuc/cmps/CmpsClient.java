package com.zhuc.cmps;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZHUC on 2015/3/13.
 */
public class CmpsClient {
    private static final Logger logger = LoggerFactory.getLogger(CmpsClient.class);

    private static String url = "http://192.168.51.35:8080/cmps/interfaces/vehicleInfo/getVehicleInfoJson";

    private CmpsClient() {
    }

    public static void getVehicleInfo(VehicleInfoQuery query) {
        HttpProxy proxy = new HttpProxy();
        try {
            String result = proxy
                    .accessPost(url, query);
            VehicleInfoViewResult vr = JSONObject.parseObject(result, VehicleInfoViewResult.class);
            if (null == vr || null == vr.getVehicleInfoList()) {
                return;
            }

            // 先清空缓存
            CmpsCache.clearAll();
            // 缓存车辆配对关系
            logger.debug("本次获取到{}个配对关系", new Object[] { vr.getVehicleInfoList().size() });

            for (VehicleInfoView view : vr.getVehicleInfoList()) {
                String gserverId = view.getGserverId(); //gserverId
                String cardNum = view.getCardNum(); // sim卡号,前面不带0

                CmpsCache.addToCmpsTable(cardNum, gserverId, view);

//				Global g = LocationCache.getFromGlobalMap(gserverId);
//				if (null != g) {
//					if (!cardNum.equals(g.getDevId())) {
//						// 如果发现sim卡有变更则更新全局信息
//						g.setDevId(cardNum);
//						globalDao.saveOrUpdate(g);
//					}
//
//				} else {
//					logger.debug("新增车辆gserverId:{}, devId:{}", new Object[] { gserverId, cardNum });
//
//					// 如果是新增车辆, 先删除新sim卡之前的配对关系
//					List<Global> list = globalDao.findByDevId(cardNum);
//					for (Global src : list) {
//						LocationCache.removeFromGlobalMap(src.getGserverId());
//						globalDao.remove(src);
//					}
//                    // 分别删除不带前缀和带前缀0的
//                    list = globalDao.findByDevId(CmpsCache.devid_prefix+cardNum);
//                    for (Global src : list) {
//                        LocationCache.removeFromGlobalMap(src.getGserverId());
//                        globalDao.remove(src);
//                    }
//
//					// gserverId对应的全局对象为空
//					g = new Global();
//					g.setGserverId(gserverId);
//					g.setDevId(cardNum);
//
//					globalDao.saveOrUpdate(g);
//					LocationCache.addToGlobalMap(gserverId, g);
//				}
            }
        } catch (Exception e) {
            logger.error("车辆配对关系同步信息获取失败", e);
        } finally {
            proxy.closeConnection();
        }

    }

}
