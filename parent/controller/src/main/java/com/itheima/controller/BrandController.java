package com.itheima.controller;

import com.itheima.domain.TbBrand;
import com.itheima.domain.Result;
import com.itheima.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tanshuai on 2019/6/16.
 */
@RestController
//@Controller
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    
    @RequestMapping("/findAll")
    public Result findAll(){
        List<TbBrand> brandList = brandService.findAll();
        return  new Result(true,"成功",brandList);//{"success":true,"message":"成功","data":[{}]}
    }
    @RequestMapping("/saveBrand")
    public Result save(TbBrand tbBrand){
        brandService.save(tbBrand);
        return new Result(true, "成功");
    }

    @RequestMapping("/search")
    public Result search(TbBrand tbBrand){
        List<TbBrand> list = brandService.search(tbBrand);
        return new Result(true, "成功", list);
    }
    @RequestMapping("/delete")
    public Result search(Long id){
        brandService.delete(id);
        return new Result(true, "成功");
    }

    @RequestMapping("/findById")
    public Result findById(Long id){
        return new Result(true, "成功", brandService.findById(id));
    }

 @RequestMapping("/update")
    public Result findById(TbBrand tbBrand){
        brandService.update(tbBrand);
        return new Result(true, "成功");
    }
@RequestMapping("/login")
    public String  login(){
    System.out.println("login");
        return "login";
}

}
