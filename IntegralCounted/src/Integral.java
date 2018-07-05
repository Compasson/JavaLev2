import java.util.function.DoubleFunction;

/*
 * Чтобы распаралелить нужно задать константу - на сколько частей разделить подчет
 * 
 * 	Потом 2 варианта:
 * 			1) Thread()
 * 				результат возвращать с помощью DoubleAdder
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
			summa+=f.apply(x)*w; // площадь
		}
		
		return summa;
	}
	
	public static double singleThread(DoubleFunction<Double> f,
			double a, double b)
	{
		return singleThread(f,a,b,STEPS);
	}
}
