package ru.my1.corbie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
    {
	private static Scanner sc;

	public static void main(String[] args)
	    {
		sc = new Scanner(System.in);
		//предполагаем, что пользователь знает формат ввода данных
		System.out.println("Введите данные: "); 
		String a = sc.nextLine().trim() + " ";
		List<Integer> b = new ArrayList<Integer>();
				
		//обработка первой строки ввода
		StringBuilder sb = new StringBuilder();
		for (byte i=0; i < a.length(); i++)
		    {
			if (Character.isDigit(a.charAt(i)))
			    sb.append(a.charAt(i));
			else {
			    b.add(Integer.parseInt(sb.toString()));
			    sb.delete(0, sb.length());
			    }
			}
		sb.delete(0, sb.length());
		Integer[] inner = b.toArray(new Integer[5]);
		b.clear();
		int k = inner[0], U = inner[1], 
			M = inner[2], D = inner[3], T = inner[4];
		
		//проверка правильно введённых данных
		if (!(((1 < k) & (k < 101)) & ((0 < U) & (U < 10001)) &
			((0 < M) & (M < 10001)) & ((0 < D) & (D < 100001)) & 
			((0 < T) & (T < 1000001))))
		    {
			System.out.println("Введены некорректные данные");
			return;
		    }
		
		//имитация двумерного массива для рейтинга фильмов
		int[][] ratingArray = new int[M][U];

		//обработка последующих строк ввода			
		for(short i=0; i< D; i++)
			{
			    String l = sc.nextLine().trim();
			    for (byte j=0; j<l.length();j++)
				{
				    if (Character.isDigit(a.charAt(j)))
					    sb.append(a.charAt(j));
				    else {
					b.add(Integer.parseInt(sb.toString()));
					sb.delete(0, sb.length());
					}
				    Integer[] t = b.toArray(new Integer[3]);
				    sb.delete(0, sb.length());
				    b.clear();
				    ratingArray[t[0]][t[1]] = t[2];
				}
			    }
		for (int[] is : ratingArray)
		    {
			System.out.println(is);
		    }
		/*
		for(short i=0; i< T; i++)
			{
			    String l = sc.nextLine().trim();
			    for (byte j=0; j<l.length();j++)
				{
				    if (Character.isDigit(a.charAt(j)))
					    sb.append(a.charAt(j));
				    else {
					b.add(Integer.parseInt(sb.toString()));
					sb.delete(0, sb.length());
					}
				    Integer[] t = b.toArray(new Integer[2]);
				    sb.delete(0, sb.length());
				    b.clear();
				}
			    }
		*/
	    }
	
	

    }
