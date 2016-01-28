package com.lyy.dao;

public interface IGetCount {
     public abstract int getCount(int S_id);
     public abstract int getSelectCount(int S_id,String likename);
     public abstract int getListCount(int S_id,String item);
}
