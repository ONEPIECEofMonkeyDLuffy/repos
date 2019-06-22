package com.itheima.service;

import com.itheima.domain.TbBrand;

import java.util.List;

public interface BrandService {
     List<TbBrand> findAll();
     TbBrand findById(Long id);
     void save(TbBrand tbBrand);
     List<TbBrand> search(TbBrand tbBrand);
     void delete(Long id);
     void update(TbBrand tbBrand);
}
