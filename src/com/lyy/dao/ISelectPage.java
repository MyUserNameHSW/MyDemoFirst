package com.lyy.dao;

import java.util.List;

import com.lyy.action.Product;

public interface ISelectPage {
    public List<Product> show(int S_id,String likename,int pageNum);
} 
