/*
 * ��������� ��������� �������� ���������
 * 		��� ������� ����� �������� ��������� ���������������� �� ������� �� ����� ��� ������� ��� ����� �������� �� ������� ������� ��������
 * 
 * 	
 */
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long t1 = System.currentTimeMillis();
		double r1 = Integral.singleThread(Math::sin, 0, Math.PI/2);
		long t2 = System.currentTimeMillis();
		System.out.printf("Integral single thread: %f Time: %s",r1,t2-t1);
	}

}
