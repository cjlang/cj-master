package com.cj.core.manual.bllservice;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cj.core.auto.dto.CjMenuDTO;
import com.cj.core.auto.entity.CjMenuEntity;
import com.cj.core.auto.mapper.CjMenuMapper_;
import com.cj.core.auto.service.ICjMenuService_;
import com.cj.core.manual.mapper.CjUserMapper;
import com.cj.core.manual.vo.MenuNode;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* <p>
    *  业务DAO
    * </p>
*
* @author lang.chaojin
* @since 2022-09-04
*/
@Service
public class CjMenuBllService {

    @Autowired
    CjMenuMapper_ cjMenuMapper_;
    @Autowired
    protected Mapper dozerMapper;

    @Autowired
    CjUserMapper cjMenuMapper;

    @Autowired
    ICjMenuService_ iCjMenuService_;



    /**
    * 获取菜单信息表列表
    * @return
    */
    public List<MenuNode> getMenuTree(CjMenuDTO dto){
        LambdaQueryWrapper<CjMenuEntity> lambda=new LambdaQueryWrapper<CjMenuEntity>();
        if(dto.getType()!=null){
            lambda.le(CjMenuEntity::getType,dto.getType());
        }
        if(dto.getSysWindow()!=null){
            lambda.eq(CjMenuEntity::getSysWindow,dto.getSysWindow());
        }
        List<CjMenuEntity> list = iCjMenuService_.list(lambda);

        List<MenuNode> menuList=TranslateObj(list);
        int maxLevel=getMaxLevel(menuList);
        for (int i = maxLevel; i > 0; i--) {
            int listSize=menuList.size();
            for (int j = 0; j <listSize ; j++) {
                if(menuList.get(j).getLevel()==i){
                    setChildrenNode(menuList,menuList.get(j));
                }
            }
        }
        List<MenuNode> menuTree=new ArrayList<MenuNode>();
        for (int i = 0; i <menuList.size() ; i++) {
            if(menuList.get(i).getLevel()==0){
                menuTree.add(menuList.get(i));
            }
        }
        return  menuTree;
    }

    /**
     * 最大深度
     * @param list
     * @return
     */
    public int getMaxLevel(List<MenuNode> list){
        int maxLevel=0;
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i).getLevel()>maxLevel)
            {
                maxLevel=list.get(i).getLevel();
            }
        }
        return maxLevel;
    }

    /**
     * 设置子节点
     * @param list
     * @param node
     */
    public void setChildrenNode(List<MenuNode> list,MenuNode node){
        for (int i = 0; i <list.size(); i++) {
            if(list.get(i).getId().equals(node.getPid()+""))
            {
                if(list.get(i).getChildren()==null)
                {
                    list.get(i).setChildren(new ArrayList<MenuNode>());
                }
                List<MenuNode> children=list.get(i).getChildren();
                children.add(node);
                list.get(i).setChildren(children);
            }
        }
    }

    /**
     * 转换对象
     * @param list
     * @return
     */
    public List<MenuNode> TranslateObj(List<CjMenuEntity> list){
        List<MenuNode> menuList=new ArrayList<MenuNode>();
        for (int i = 0; i <list.size() ; i++) {
            menuList.add(dozerMapper.map(list.get(i),MenuNode.class));
        }
        return menuList;
    }

}

