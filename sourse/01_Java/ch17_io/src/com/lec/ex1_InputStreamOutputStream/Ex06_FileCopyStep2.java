package com.lec.ex1_InputStreamOutputStream;

// �ӵ� ���̱�
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//C:\Users\EZEN 203\Desktop\bts.mp4  -> C:\Users\EZEN 203\Desktop\bts_copy.mp4 
public class Ex06_FileCopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		long start = System.currentTimeMillis();
		try {
			is = new FileInputStream("C:\\Users\\EZEN 203\\Desktop\\bts.mp4"); // 1. ��Ʈ�� ��ü ����
			os = new FileOutputStream("C:\\Users\\EZEN 203\\Desktop\\bts_copy.mp4");
			int cnt = 0; // �� �� �����ϴ��� üũ
			while (true) {
				cnt++;
				byte[] bs = new byte[1024];  //1ų�ι���Ʈ
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
