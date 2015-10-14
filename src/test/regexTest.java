package test;

public class regexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String point_describe = ",£¬£¬aaaaaa";
		
		if(point_describe.matches("^[,|£¬|£¬].*"))
		{
			System.out.println("there is comma(s)");
		}
		else
		{
			System.out.println("there is no comma");
		}
		while(point_describe.matches("^[,|£¬|£¬].*"))
		{
			point_describe = point_describe.substring(1);
		}
		
		System.out.println(point_describe);
	}

}
