package com.fi.map;

import java.util.LinkedList;
/**
 * 自定义Map
 * 提高查询的效率
 * @author Administrator
 *
 */
public class CustomMap02 {
	LinkedList[] arr=new LinkedList[999];
	int size;
	
	public void put (Object key,Object value){
		CustomEntry e=new CustomEntry(key,value);
		
		int index=key.hashCode()%999;
		if(arr[index]==null){
			LinkedList list=new LinkedList();
			arr[index]=list;
			list.add(e);
		}else {
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++){
				CustomEntry ee=(CustomEntry) list.get(i);
				if(ee.key.equals(key)){
					ee.value=value;//键值重复就直接覆盖
				}
			}
			arr[index].add(e);
		}
	}
	
	public Object get(Object key){
		int index=key.hashCode()%999;
		//数组里面存储的是链表，链表里面存储的是Entry对象，Entry对象里面有两个属性key,value
		if(arr[index]!=null){
			LinkedList list=arr[index];
			for(int i=0;i<list.size();i++){
				CustomEntry e=(CustomEntry) list.get(i);
				if(e.key.equals(key)){
					return e.value;
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		CustomMap02 map=new CustomMap02();
		map.put("孙悟空", "弼马温");
		map.put("猪八戒", "天蓬元帅");
		map.put("孙悟空", "齐天大圣");
		
		System.out.println(map.get("孙悟空"));
	}

}
