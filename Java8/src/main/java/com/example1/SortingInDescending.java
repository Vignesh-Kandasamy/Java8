package com.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingInDescending 
{
	public static void main(String args[])
	{
		List<Integer> list = new ArrayList<>();
		list.add(54);
		list.add(22);
		list.add(34);
		list.add(7);
		list.add(19);
		
		Collections.sort(list,(l1,l2)->(l1>l2)?-1:(l1<l2)?1:0);
		System.out.println(list);
	}
}
