package ru.my1.corbie;

import java.util.*;

public class Main
    {

	private static Scanner sc;

	public static void main(String[] args)
	    {
		int costCounter = 0;
		
		sc = new Scanner(System.in);
		//предполагаем, что пользователь знает формат ввода данных
		System.out.println("Введите данные: "); 
		String a = sc.nextLine().trim() + " ";
		List<Short> b = new ArrayList<Short>();
		
			//обработка первой строки ввода
			StringBuilder sb = new StringBuilder();
        		for (byte i=0; i < a.length(); i++)
        		    {
                		if (Character.isDigit(a.charAt(i)))
                		    sb.append(a.charAt(i));
                		else 	{
                        		    b.add(Short.parseShort(sb.toString()));
                        		    sb.delete(0, sb.length());
                			}
                		
        		    }
        		
        		Short[] inner = b.toArray(new Short[4]);
        		short m = inner[0];
        		short n = inner[1];
        		short costSingle = inner[2];
        		short costDouble = inner[3];
        		
        		//имитаци¤ двумерного массива
        		byte[][] parq = new byte[m][n];

        		//обработка последующих строк ввода			
        		for(short k=0; k < m; k++)
				{
				    String layer = sc.nextLine();
				    byte[] x = new byte[n];
					for (short j=0; j<n;j++)
						if (layer.charAt(j) == '.')
						    x[j] = 0;
						else x[j] = 1;
				     parq[k] = x;
				}
			    
			/*
			алгоритм проверки на возможность починки паркета плиткой размером 1х2
        		проверка осуществляется в пределах прямоугольника 3х2 в следующих местах:
        		
        		_______
        		|x|x|x|
        		|x| | |
        		-------
        		
        		*/
        		for(short i=0; i < parq.length; i++)
				{
				    for(short j=0; j < parq[i].length; j++)
					//Проверка возможности использования метода с прямоугольником 3х2
					if (!(i==parq.length))
					    {
					    if (j<parq[i].length-1)
						{
    						//Начало цикла основной проверки
    						if (parq[i][j]==1)
    						    if (parq[i][j+1]==1)
    							if (parq[i+1][j]==1)
    							    if (parq[i][j+2]==1)
    								{
    								    parq[i][j]=0;
    								    parq[i][j+1]=0;
    								    parq[i+1][j]=0;
    								    parq[i][j+2]=0;
    								    costCounter += 2*costDouble;
    								}
    							    else {
    								parq[i][j]=0;
    								parq[i][j+1]=0;
    								costCounter += costDouble;
    							    }
    							else {
    							    parq[i][j]=0;
    							    parq[i][j+1]=0;
    							    costCounter += costDouble;
    							}
    						    else if (parq[i+1][j]==1)
    							{
    							    parq[i][j]=0;
    							    parq[i+1][j]=0;
    							    costCounter += costDouble;
    							}
    						//конец цикла проверки
						}
					    else if (j<parq[i].length)
        						{
        						    //основной цикл проверки для квадрата 2х2
        						    if (parq[i][j]==1)
        	    						    if (parq[i][j+1]==1)
        	    							if (parq[i+1][j]==1)
        	    							   {
        	    								parq[i][j]=0;
        	    								parq[i][j+1]=0;
        	    								costCounter += costDouble;
        	    							    }
        	    							else {
        	    							    parq[i][j]=0;
        	    							    parq[i][j+1]=0;
        	    							    costCounter += costDouble;
        	    							}
        	    						    else if (parq[i+1][j]==1)
        	    							{
        	    							    parq[i][j]=0;
        	    							    parq[i+1][j]=0;
        	    							    costCounter += costDouble;
        	    							}
        						    //конец цикла проверки для квадрата 2х2
        						}
					    	else {
        					    	if (parq[i][j]==1 && parq[i+1][j]==1)
            							{
            							    parq[i][j]=0;
            							    parq[i+1][j]=0;
            							    costCounter += costDouble;
            							}
					    	}
						
							
					    
					    }
					else {
					    	if (parq[i][j]==1 && parq[i][j+1]==1)
    							{
    							    parq[i][j]=0;
    							    parq[i+1][j]=0;
    							    costCounter += costDouble;
    							}
				    	}
    						    
				} 
        		
			//алгоритм проверки на возможность починки паркета плиткой размером 1х1
        				
			
			
			
			for(int i=0; i < parq.length; i++)
				{
					for(int j=0; j < parq[i].length; j++)
						System.out.printf("%2d", parq[i][j]);
					
					System.out.println();
					
				}   
			
	    }

    }
