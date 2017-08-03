package com.fi.map;
/**
 * 自定义实现Map的功能
 * @author Administrator
 *Map:存放键值对，根据键对象找对应的值对象,键不能重复
 */
public class CustomMap {
	CustomEntry[] arr=new CustomEntry[999];
	int size;
	
	public void put(Object key,Object value){
		CustomEntry e = new CustomEntry(key, value);
		//对存储键重复的处理
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				arr[i].value=value;
				return;
			}
		}
		arr[size++]=e;
	}
	
	//根据键查询值的时候，每次都要遍历一次，效率比较低
	public Object get(Object key){
		for (int i = 0; i < size; i++) {
			if(arr[i].key.equals(key)){
				return arr[i].value;
			}
		}
		return null;
	}
	
	public boolean containsKey(Object key){
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		CustomMap map=new CustomMap();
		map.put("张三", "25");
		map.put("李四", "26");
		map.put("张三", "18");
		
		
		System.out.println(map.get("张三"));
		System.out.println(map.containsKey("张三"));
	}

}
class CustomEntry{
	Object key;
	Object value;
	public CustomEntry(Object key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
}