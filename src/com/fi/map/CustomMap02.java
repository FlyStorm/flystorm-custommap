package com.fi.map;

import java.util.LinkedList;
/**
 * �Զ���Map
 * ��߲�ѯ��Ч��
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
					ee.value=value;//��ֵ�ظ���ֱ�Ӹ���
				}
			}
			arr[index].add(e);
		}
	}
	
	public Object get(Object key){
		int index=key.hashCode()%999;
		//��������洢����������������洢����Entry����Entry������������������key,value
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
		map.put("�����", "������");
		map.put("��˽�", "����Ԫ˧");
		map.put("�����", "�����ʥ");
		
		System.out.println(map.get("�����"));
	}

}
