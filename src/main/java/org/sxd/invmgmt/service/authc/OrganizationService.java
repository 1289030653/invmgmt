package org.sxd.invmgmt.service.authc;

import org.sxd.invmgmt.dto.authc.OrganizationDto;
import org.sxd.invmgmt.entity.authc.OrganizationEntity;
import org.sxd.invmgmt.service.base.BaseService;

import java.util.List;

/**
 * Created by eddie on 2017/12/28.
 */
public interface OrganizationService extends BaseService<OrganizationDto> {
    List<OrganizationEntity> findAllWithExclude(OrganizationEntity excludeOraganization);

    void move(OrganizationEntity source, OrganizationEntity target);
}
