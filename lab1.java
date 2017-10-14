package lab1;

import java.util.Scanner; 
import java.io.*;

public class lab1 {
	
	public static String getTheFileInput(){
		
		//用来存储最终结果，找不到文件返回""，找到文件之后返回处理好的字符串内容.
		//str是最终返回的内容
		String str = "";
		
		//strTemp用来临时存放读取的内容
		String strTemp = "";
		
		//获取文件名
		System.out.println("输入文件名:");
		Scanner sc= new Scanner(System.in);
		String fileName = sc.nextLine();
		sc.close();
		
		//打开文件
		File myFile=new File(fileName);
		
		//如果文件不存在
		if(!myFile.exists()){
			//文件不存在，返回""。
			return str;
		}
		
		//如果文件存在
		try {
            BufferedReader in = new BufferedReader(new FileReader(myFile));
            String s;
            
            //依次将读到的字符加在strTemp的尾部,这里是按行读取，无法逐个判断字符是否合法，还不知道怎么逐个读取，准备后面再扫描一次来处理
            while ((s = in.readLine()) != null) {
            	strTemp = strTemp + s;
            }
            in.close();
        } 
        catch (IOException e) {
            e.getStackTrace();
        }
		
		//字符串的整理操作，去除不合法字符，多余的空格，和大写变小写的操作。
		for(int i = 0; i < strTemp.length(); i++){
			
			//大写字母变小写
			strTemp = strTemp.toLowerCase();	
			
			//合法字符与空格都添加进str，可能会有多个空格，只要分割时用split("\\s+")就可以忽略多个空格的问题
			if((strTemp.charAt(i) >= 'a' && strTemp.charAt(i) <= 'z') || strTemp.charAt(i) == ' '){
				
				//添加到str的尾部
				str = str + strTemp.charAt(i);
			}
			
			//其他全部忽略。
		}
		
		//到此返回的字符串是一个只有小写字母和空格组成的字符串，空格可以有多个，其他特殊符号全部被忽视。
		return str;
	}
	
	public static void main(String[] args){
		
		//询问文件名，获取文件内容，自动整理成只有小写字母和空格的长字符串以供处理，如果读取文件失败获得的字符串将是""。
		String fileContent = getTheFileInput();
		
		//把获得的大字符串按空格分割
		
		String fileContentArray[] = fileContent.split("\\s+");
		
		for(int i = 0; i < fileContentArray.length;i++){
			
			System.out.println(fileContentArray[i]);
			
		}
		
	}
	
	
}
