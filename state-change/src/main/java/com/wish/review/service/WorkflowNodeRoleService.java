package com.wish.review.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wish.review.dao.WorkflowNodeDao;
import com.wish.review.dao.WorkflowNodeRoleDao;
import com.wish.review.dto.WorkflowNodeRoleText;
import com.wish.review.entity.WorkflowNode;
import com.wish.review.entity.WorkflowNodeRole;
import com.wish.sys.dao.RoleDao;
import com.wish.sys.entity.Role;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WorkflowNodeRoleService {
    @Autowired
    private WorkflowNodeRoleDao workflowNodeRoleDao;
    @Autowired
    private WorkflowNodeDao workflowNodeDao;
    @Autowired
    private RoleDao roleDao;

    public List<WorkflowNodeRole> list() {
        return workflowNodeRoleDao.queryAll(null);
    }

    public List<WorkflowNodeRoleText> listText() {
        List<WorkflowNodeRoleText> nodeRoleTextList = Lists.newArrayList();
        List<WorkflowNodeRole> workflowNodeRoles = workflowNodeRoleDao.queryAll(null);
        if(CollectionUtils.isNotEmpty(workflowNodeRoles)) {
            Map<Integer, Role> roleMap = converterRoleMap();
            Map<Integer, WorkflowNode> nodeMap = converterNodeMap();

            for(WorkflowNodeRole nodeRole : workflowNodeRoles) {
                WorkflowNodeRoleText nodeRoleText = new WorkflowNodeRoleText();
                BeanUtils.copyProperties(nodeRole,nodeRoleText);
                nodeRoleText.setNodeText(nodeMap.get(nodeRole.getNodeId()).getNodeName());
                nodeRoleText.setRoleText(roleMap.get(nodeRole.getRoleId()).getName());
                nodeRoleTextList.add(nodeRoleText);
            }
        }
        return nodeRoleTextList;
    }

    private Map<Integer,Role> converterRoleMap() {
        Map<Integer,Role> maps = Maps.newHashMap();
        List<Role> roleList = roleDao.queryAll(null);
        if(CollectionUtils.isNotEmpty(roleList)) {
            for (Role role : roleList) {
                maps.put(role.getRoleId(),role);
            }
        }
        return maps;
    }

    private Map<Integer,WorkflowNode> converterNodeMap() {
        Map<Integer,WorkflowNode> maps = Maps.newHashMap();
        List<WorkflowNode> workflowNodes = workflowNodeDao.queryAll();
        if(CollectionUtils.isNotEmpty(workflowNodes)) {
            for (WorkflowNode node : workflowNodes) {
                maps.put(node.getNodeId(),node);
            }
        }
        return maps;
    }

}
