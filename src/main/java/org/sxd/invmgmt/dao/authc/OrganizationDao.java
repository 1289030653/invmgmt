package org.sxd.invmgmt.dao.authc;

import org.sxd.invmgmt.dao.base.BaseDao;
import org.sxd.invmgmt.entity.authc.OrganizationEntity;
import org.sxd.invmgmt.entity.authc.OrganizationEntity;

import java.util.List;

/**
 * Created by eddie on 2017/12/25.
 */
public interface OrganizationDao extends BaseDao<OrganizationEntity> {

    List<OrganizationEntity> selectAllWithExclude(OrganizationEntity excludeOraganization);

}
