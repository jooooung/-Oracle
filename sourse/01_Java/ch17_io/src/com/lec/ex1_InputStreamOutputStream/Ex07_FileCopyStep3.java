package com.lec.ex1_InputStreamOutputStream;
import java.io.File;
// �ӵ� ���̱�
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//JSP�� Spring���� ����÷�ΰԽ��� ������ copy�� ����
//C:\Users\EZEN 203\Desktop\bts.mp4  -> C:\Users\EZEN 203\Desktop\bts_copy.mp4 
public class Ex07_FileCopyStep3 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		long start = System.currentTimeMillis();
		try {
			File file = new File("C:\\Users\\EZEN 203\\Desktop\\bts.mp4");
			is = new FileInputStream(file); // 1. ��Ʈ�� ��ü ����
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Desktop\\bts_copy.mp4");
			byte[] bs = new byte[(int) file.length()];  //1ų�ι���Ʈ
			int cnt = 0; // �� �� �����ϴ��� üũ
			while (true) { //2�� ����
				cnt++;
				int Count = is.read(bs); // 2. read(bs�� �д´�) & write
				if (Count == -1)
					break;
				os.write(bs, 0, Count); // bs�迭�� 0�� index���� Count�� ����Ʈ ��ŭ write
			}
			System.out.println(cnt + "�� while�� �����Ͽ� ���� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) // 3. ���� �ݱ�(��Ʈ�� ����\)
					os.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} //
		long end = System.currentTimeMillis(); // 1970. 1.1 ~ ������ ���������� �и�����
		System.out.println(end - start);
	}
}
