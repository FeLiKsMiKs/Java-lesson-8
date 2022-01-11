package ua.lviv.lgs.seasons;

import java.util.Scanner;

public class Application {

	enum Seasons{
		WINTER, SPRING, SUMMER, AUTUMN;
	}
	enum Month{
		DECEMBER(31, Seasons.WINTER),
		JANUARY(31,Seasons.WINTER),
		FEBRUARY(28,Seasons.WINTER),
		MARCH(31,Seasons.SPRING),
		APRIL(30,Seasons.SPRING),
		MAY(31,Seasons.SPRING),
		JUNE(30,Seasons.SUMMER),
		JULY(31,Seasons.SUMMER),
		AUGUST(31,Seasons.SUMMER),
		SEPTEMBER(30,Seasons.AUTUMN),
		OCTOBER(31,Seasons.AUTUMN),
		NOVEMBER(30,Seasons.AUTUMN);
		 int days;
		Seasons season;
		public Seasons getSeason() {
			return season;
		}
		public  int getDays() {
			return days;
		}
		Month(int days, Seasons season) {
			this.days = days;
			this.season = season;
		}
		
		 
		 
	}
	static void menu() {
		System.out.println("Натисніть 0 щоб перевірити чи є такий місяць ");
		System.out.println("Натисніть 1 щоб вивести всі місяці з такою ж порою року");
		System.out.println("Натисніть 2 щоб вивести всі місяці які мають таку саму кількість днів");
		System.out.println("Натисніть 3 щоб вивести всі місяці які мають меншу кількість днів");
		System.out.println("Натисніть 4 щоб вивести всі місяці які мають більшу кількість днів");
		System.out.println("Натисніть 5 щоб вивести наступну пору року");
		System.out.println("Натисніть 6 щоб вивести попередню пору року");
		System.out.println("Натисніть 7 щоб вивести всі місяці які мають парну кількість днів");
		System.out.println("Натисніть 8 щоб вивести всі місяці які мають непарну кількість днів");
		System.out.println("Натисніть 9 щоб вивести чи місяць має парну кількість днів");
	}
	
	public static void main(String[] args) {
		Seasons[] mas2 = Seasons.values();
		Month [] mas = Month.values();
		Scanner sc = new Scanner(System.in);
		while(true) {
			menu();
			switch (sc.next()) {
			case "0":{ 
				System.out.println("Enter continent: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();
				boolean flag = isMonthPresent(mas, month);
				if(!flag) {
					System.out.println("Doesn`t exist");
				}
			
			
				break;
			
			}
			case "1":{
				System.out.println("Enter season: ");
				sc = new Scanner(System.in);
				String sn = sc.next().toUpperCase();
				boolean flag = false;
				for(Month c : mas) {
					if(c.getSeason().name().equals(sn)) {
						
						flag = true;
					}
				}
				if(flag) {
					Seasons dir = Seasons.valueOf(sn);
					for(Month cont: mas) {
						if(cont.getSeason().toString().equalsIgnoreCase(sn)) {
							System.out.println(cont);
						}
					}
				}
				if(!flag) {
					System.out.println("Doesn`t exist");
				}
			
			
				break;
			}
			case "2": {
				sc = new Scanner(System.in);
				System.out.println("Enter days");
				int days = sc.nextInt();

				boolean flag = false;

				for (Month months : mas) {
					if (months.getDays() == days) {
						flag = true;
					}
				}

				if (flag == true) {
					

					for (Month months2 : mas) {
						if (months2.getDays() == days) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Error");

				break;
			}
			case "3": {
				sc = new Scanner(System.in);
				System.out.println("Enter days");
				int days = sc.nextInt();

				boolean flag = false;

				for (Month months : mas) {
					if (months.getDays() == days && days >= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					

					for (Month months2 : mas) {
						if (months2.getDays() < days) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Error");

				break;
			}
			case "4": {
				sc = new Scanner(System.in);
				System.out.println("Enter days");
				int days = sc.nextInt();

				boolean flag = false;

				for (Month months : mas) {
					if (months.getDays() == days && days <= 30) {
						flag = true;
					}
				}

				if (flag == true) {
					

					for (Month months2 : mas) {
						if (months2.getDays() > days) {
							System.out.println(months2);
						}
					}
				}

				if (flag == false)
					System.out.println("Error");

				break;
			}
			case "5":{ 
				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();
				boolean flag = isMonthPresent(mas, month);
				if(flag) {
					Month month2 = Month.valueOf(month);
					int ordinal = month2.ordinal();
					if(ordinal == (mas.length -1)) {
						ordinal = 0;
						System.out.println(mas[ordinal]);
					}else {
						System.out.println(mas[ordinal+1]);
					}
				}
				if(!flag) {
					System.out.println("Doesn`t exist");
				}
			
			
				break;
			
			}
			case "6":{ 
				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String continent = sc.next().toUpperCase();
				boolean flag = isMonthPresent(mas, continent);
				if(flag) {
					Month cont2 = Month.valueOf(continent);
					int ordinal = cont2.ordinal();
					if(ordinal == (mas.length +1)) {
						ordinal = 0;
						System.out.println(mas[ordinal]);
					}else {
						System.out.println(mas[ordinal-1]);
					}
				}
				if(!flag) {
					System.out.println("Doesn`t exist");
				}
			
			
				break;
			
			}
			case "7":{ 
				for ( Month month : mas) {
					if (month.getDays() % 2 == 0) {
						System.out.println(month);
					}
				}
			
			
				break;
			
			}
			case "8":{ 
				for ( Month month : mas) {
					if (month.getDays() % 2 != 0) {
						System.out.println(month);
					}
				}
			
			
				break;
			
			}
			case "9":{ 
				System.out.println("Enter month: ");
				sc = new Scanner(System.in);
				String day = sc.next().toUpperCase();
				boolean flag = isMonthPresent(mas, day);
				if(flag) {
					Month month = Month.valueOf(day);
					if (month.getDays() % 2 == 0) {
						System.out.println("Month has even number of days");
					}else { System.out.println("Month has odd number of days");}
				}else {
					System.out.println("Error");
				}
				
			
				break;
			
			}
			}
		}
		
	}

	 private static boolean isMonthPresent(Month[] mas, String month) {
		boolean flag = false;
		for(Month c : mas) {
			if(c.name().equals(month)) {
				System.out.println("Month exist");
				flag = true;
			}
		}
		return flag;
	}
	 static String firstUpperCase(String string) {
			if (string == null || string.isEmpty()) {
				return string;
			} else {
				return string.substring(0, 1).toUpperCase() + string.substring(1);
			}
		}
}
