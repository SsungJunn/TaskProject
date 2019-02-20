import java.io.*;
import java.util.*;

public class Task003 {

	public static void main(String[] args) {
		int count = 1;
		int point = 0;
		int count2 = 1;
		int point2 = 0;
		
		String str = "소프트웨어 개발자 보안능력과 MIND 향상을 위한 솔루션과 서비스를 제공합니다.";
		
		String strarr[] = new String[20];
		
		System.out.print("순번\t" + ":" + "\t");
		System.out.print("위치\t" + ":" + "\t");
		System.out.println("내용");
		System.out.println("-----------------------------------------");
		
		String s = str.substring(0, 21);
		StringTokenizer stok = new StringTokenizer(s, " ", true);
		
		while (stok.hasMoreTokens()) {
			
			String token = stok.nextToken();
			strarr[point] = token;
			
			System.out.print(" " + count++ + "\t" + ":" + "\t");
			System.out.print(" " + point + "\t" + ":" + "\t");
			
			if (token.contentEquals(" "))
				System.out.println(" ");
			else
				System.out.println(token);
			System.out.println("-----------------------------------------");
			point++;
		}

		/////////////////////////////
		// 3.1 blank 단위로 나누기 //
		/////////////////////////////
		System.out.println(" ");
		System.out.println("\t   3.1 blank단위로");
		System.out.println("-----------------------------------------");

		StringTokenizer sblank = new StringTokenizer(str);
		
		while (sblank.hasMoreTokens()) {
			
			String token2 = sblank.nextToken();
			
			System.out.print(" " + count2++ + "\t" + ":" + "\t");
			System.out.print(" " + point2 + "\t" + ":" + "\t");
			
			if (token2.contentEquals(" "))
				System.out.println(" ");
			else
				System.out.println(token2);
			System.out.println("-----------------------------------------");
			point2++;
		}
		
		/////////////////////////////
		// 		3.2 문자 쪼개기	   //
		/////////////////////////////
		System.out.println(" ");
		System.out.println("\t   3.2 문자 쪼개기");
		System.out.println("-----------------------------------------");
		System.out.println(str.substring(42));
		System.out.println(str.substring(40));
		System.out.print(" ");
		System.out.println(str.substring(41));
		System.out.print(" ");
		System.out.println(str.substring(38));
		System.out.println("-----------------------------------------");
		
		/////////////////////////////
		//	  3.3 파일에 읽어오기	   //
		/////////////////////////////
		System.out.println(" ");
		System.out.println("\t   3.3 파일에 읽어오기");
		System.out.println("-----------------------------------------");
		
		FileReader reader = null;
		try {
			reader = new FileReader("/home/ubuntu/text.txt");	// 리눅스 안의 경로를 맞춰줘야됨. 기본이 Home!!
			while(true) {
				int data = reader.read();
				if ( data == -1 )
					break;
				char ch = (char) data;
				System.out.print(ch);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e3) { }
		}
		
		///////////////////////////////
		//	3.4 output을 파일로 저장 //
		///////////////////////////////
		System.out.println(" ");
		System.out.println("\t   3.4 output을 파일로 저장");
		System.out.println("-----------------------------------------");
		
		FileWriter writer = null;
		
		File file = new File("/home/ubuntu/output.txt");
		
		try {
			writer = new FileWriter(file);
			writer.write(str);
			
		} catch (IOException e1) {
			System.out.println("파일에 쓸 수 없습니다.");
		} finally {
			try {
				writer.close();
			} catch (Exception e) { }
		}
	}	
}
