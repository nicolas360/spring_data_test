package com.zhuc.relation.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zhuc.relation.entity.AirLine;
import com.zhuc.relation.entity.AirLinePK;

public interface AirLineDao extends PagingAndSortingRepository<AirLine, AirLinePK>, JpaSpecificationExecutor<AirLine> {

}
