/**
 * 
 */
package com.zhuc.mongo.dao;

import com.zhuc.mongo.entity.LastLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("lastlocationDao")
public class LastLocationDao extends MongoDao<LastLocation> {

	private static final Logger logger = LoggerFactory.getLogger(LastLocationDao.class);

    /**
     * 获取最新一条位置信息
     * @param gserverId
     * @return
     */
	public LastLocation findLastLocation(String gserverId) {
        LastLocation location = getMt().findOne(new Query().addCriteria(Criteria.where("gserverId").is(gserverId))
                .with(new Sort(Direction.DESC, "reportTime")), LastLocation.class);
		return location;
	}

    /**
     * 批量删除
     * @param list
     */
    public void delete(List<String> list){
        getMt().remove(new Query().addCriteria(Criteria.where("gserverId").in(list)), LastLocation.class);
    }

}
