import java.util.function.DoubleFunction;

/*
 * ����� ������������� ����� ������ ��������� - �� ������� ������ ��������� ������
 * 
 * 	����� 2 ��������:
 * 			1) Thread()
 * 				��������� ���������� � ������� DoubleAdder
 * 			2) ForkJoin
 */

public class Integral {
	
	public static final int STEPS = 10000000;
	
	public static double singleThread(DoubleFunction<Double> f,
			double a, double b, int steps)
	{
		double summa = 0d;
		double w = (b-a)/steps;
		
		for (int i=0;i<steps;i++)
		{
			double x = a+i*w + w/2;
			summa+=f.apply(x)*w; // �������
		}
		
		return summa;
	}
	
	public static double singleThread(DoubleFunction<Double> f,
			double a, double b)
	{
		return singleThread(f,a,b,STEPS);
	}
}
