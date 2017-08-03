package com.fi.map;
/**
 * �Զ���ʵ��Map�Ĺ���
 * @author Administrator
 *Map:��ż�ֵ�ԣ����ݼ������Ҷ�Ӧ��ֵ����,�������ظ�
 */
public class CustomMap {
	CustomEntry[] arr=new CustomEntry[999];
	int size;
	
	public void put(Object key,Object value){
		CustomEntry e = new CustomEntry(key, value);
		//�Դ洢���ظ��Ĵ���
		for(int i=0;i<size;i++){
			if(arr[i].key.equals(key)){
				arr[i].value=value;
				return;
			}
		}
		arr[size++]=e;
	}
	
	//���ݼ���ѯֵ��ʱ��ÿ�ζ�Ҫ����һ�Σ�Ч�ʱȽϵ�
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
		map.put("����", "25");
		map.put("����", "26");
		map.put("����", "18");
		
		
		System.out.println(map.get("����"));
		System.out.println(map.containsKey("����"));
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