package com.lyy.dao;

import java.util.List;

import com.lyy.action.Product;

public interface IShowPage {
   public abstract List<Product> show(int S_id,int pageNum);
}
