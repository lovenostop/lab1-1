package lab1;

import java.util.Scanner; 
import java.io.*;

public class lab1 {
	
	public static String getTheFileInput(){
		
		//�����洢���ս�����Ҳ����ļ�����""���ҵ��ļ�֮�󷵻ش���õ��ַ�������.
		//str�����շ��ص�����
		String str = "";
		
		//strTemp������ʱ��Ŷ�ȡ������
		String strTemp = "";
		
		//��ȡ�ļ���
		System.out.println("�����ļ���:");
		Scanner sc= new Scanner(System.in);
		String fileName = sc.nextLine();
		sc.close();
		
		//���ļ�
		File myFile=new File(fileName);
		
		//����ļ�������
		if(!myFile.exists()){
			//�ļ������ڣ�����""��
			return str;
		}
		
		//����ļ�����
		try {
            BufferedReader in = new BufferedReader(new FileReader(myFile));
            String s;
            
            //���ν��������ַ�����strTemp��β��,�����ǰ��ж�ȡ���޷�����ж��ַ��Ƿ�Ϸ�������֪����ô�����ȡ��׼��������ɨ��һ��������
            while ((s = in.readLine()) != null) {
            	strTemp = strTemp + s;
            }
            in.close();
        } 
        catch (IOException e) {
            e.getStackTrace();
        }
		
		//�ַ��������������ȥ�����Ϸ��ַ�������Ŀո񣬺ʹ�д��Сд�Ĳ�����
		for(int i = 0; i < strTemp.length(); i++){
			
			//��д��ĸ��Сд
			strTemp = strTemp.toLowerCase();	
			
			//�Ϸ��ַ���ո���ӽ�str�����ܻ��ж���ո�ֻҪ�ָ�ʱ��split("\\s+")�Ϳ��Ժ��Զ���ո������
			if((strTemp.charAt(i) >= 'a' && strTemp.charAt(i) <= 'z') || strTemp.charAt(i) == ' '){
				
				//��ӵ�str��β��
				str = str + strTemp.charAt(i);
			}
			
			//����ȫ�����ԡ�
		}
		
		//���˷��ص��ַ�����һ��ֻ��Сд��ĸ�Ϳո���ɵ��ַ������ո�����ж���������������ȫ�������ӡ�
		return str;
	}
	
	public static void main(String[] args){
		
		//ѯ���ļ�������ȡ�ļ����ݣ��Զ������ֻ��Сд��ĸ�Ϳո�ĳ��ַ����Թ����������ȡ�ļ�ʧ�ܻ�õ��ַ�������""��
		String fileContent = getTheFileInput();
		
		//�ѻ�õĴ��ַ������ո�ָ�
		
		String fileContentArray[] = fileContent.split("\\s+");
		
		for(int i = 0; i < fileContentArray.length;i++){
			
			System.out.println(fileContentArray[i]);
			
		}
		
	}
	
	
}
