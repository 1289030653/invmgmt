package org.sxd.invmgmt.service.authc;

import org.sxd.invmgmt.dto.authc.ResourceDto;
import org.sxd.invmgmt.entity.authc.ResourceEntity;
import org.sxd.invmgmt.service.base.BaseService;

import java.util.List;
import java.util.Set;

/**
 * Created by eddie on 2017/12/28.
 */
public interface ResourceService extends BaseService<ResourceDto> {
    /**
     * 得到资源对应的权限字符串
     * @param resourceIds
     * @return
     */
    Set<String> findPermissions(Set<Long> resourceIds);

    /**
     * 根据用户权限得到菜单
     * @param permissions
     * @return
     */
    List<ResourceEntity> findMenus(Set<String> permissions);
}
