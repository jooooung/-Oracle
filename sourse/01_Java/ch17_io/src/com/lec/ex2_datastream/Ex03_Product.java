package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// x �Է��Ҷ����� ��� ��� : file ��� -> x �Է½� ��ϵ� ��� ��� ���
public class Ex03_Product {
	public static void main(String[] args) {
		// x �Է��Ҷ����� ��� ��� : file ���
		OutputStream fos = null;
		DataOutputStream dos = null;
		Scanner scanner = new Scanner(System.in);
		try {
			fos = new FileOutputStream("src/com/lec/ex2_datastream/product.dat", true);
			dos = new DataOutputStream(fos);
			while (true) {
				System.out.println("�԰�� ��� �ֳ���?(y/x)");
				if (scanner.next().trim().equals("x"))
					break;
				System.out.print("�԰�� ��ǰ�� : ");
				dos.writeUTF(scanner.next());
				System.out.print("����(���ڸ�) : ");
				dos.writeInt(scanner.nextInt());
				System.out.print("��� ����(���ڸ�) : ");
				dos.writeInt(scanner.nextInt());
			}
			System.out.println("��� ��� �Ϸ�");
			// x �Է½� ��ϵ� ��� ��� ���
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("������ �߸� �Է���" + e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		ArrayList<Product> products = new ArrayList<>();
		InputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("src/com/lec/ex2_datastream/product.dat");
			dis = new DataInputStream(fis);
			while (true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int stock = dis.readInt();
				products.add(new Product(name, price, stock));
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dis != null)
					dis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally
		if (products.isEmpty()) {
			System.out.println("��ϵ� ��� �����ϴ�");
		} else {
			System.out.println("��ǰ��\t����\t������");
			for (Product product : products) {
				System.out.println(product);
			}
			System.out.println("�̻�" + products.size() + "���� ��� ��ǰ �Էµ�");
		} // if-else
		scanner.close();
	}// main
}
