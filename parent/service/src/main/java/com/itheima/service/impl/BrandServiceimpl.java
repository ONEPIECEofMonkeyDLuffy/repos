package com.itheima.service.impl;

import com.itheima.dao.TbBrandMapper;
import com.itheima.domain.TbBrand;
import com.itheima.domain.TbBrandExample;
import com.itheima.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceimpl implements BrandService {
    @Autowired
    public TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }


    @Override
    public void save(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    @Override
    public List<TbBrand> search(TbBrand tbBrand) {
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null) {
            if (tbBrand.getName() != null && !"".equals(tbBrand.getName())) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            } else if (tbBrand.getFirstChar() != null && !"".equals(tbBrand.getFirstChar())) {
                criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
            }
        }
        return tbBrandMapper.selectByExample(example);

    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void update(TbBrand tbBrand) {
        TbBrandExample te=new TbBrandExample();
        TbBrandExample.Criteria criteria=te.createCriteria();
        System.out.println(tbBrand);
        if (tbBrand.getId()!=null&&!"".equals(tbBrand.getId())){

        criteria.andIdEqualTo(tbBrand.getId());
        tbBrandMapper.updateByExample(tbBrand, te);
        }


    }

    @Override
    public TbBrand findById(Long id) {

        return tbBrandMapper.selectByPrimaryKey(id);
    }

}
