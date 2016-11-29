
public class mat {
	// "acc" is the accuracy of the method
	final static double pI = 3.141592635897932384626433832795028841971;
	public static double logs(double base, double number, int acc){ //returns the base "base" logarithm of "number"
		double ans = 0;
		double n = 1;
		for (int i = 1; i <= acc; i++){
			while ((power(base,ans) <= number)) {
				ans += n;
			} 
			ans -= n;
			n = (n / 10);
			if (power(base,ans) == number){
				break;
			}
		}
		return ans;
	}
	public static double factorial(int a){ //returns "a" factorial
		double fac = 1;
		for (int n = a; n > 1; n--){
			fac *= n;
		}
		return fac;
	}
	public static double sin(boolean rad, double x, int acc){ //returns sine of "x", in either radians or degrees
		double sinx = 0;
		if (rad){
			for (int n = 1; n <= acc; n++){
				sinx += power(-1, n-1) * (power(x, 2 * n -1) / factorial(2 * n - 1));
			}
		}
		else {
			x *= pI / 180;
			for (int n = 1; n <= acc; n++){
				sinx += power(-1, n-1) * (power(x, 2 * n -1) / factorial(2 * n - 1));
			}
		}
		return sinx;
	}
	public static double cos(boolean rad, double x, int acc){ //returns cosine of "x", in either radians or degrees
		double cosx = 0;
		if (rad){
			for (int n = 0; n <= acc; n++){
				cosx += power(-1, n) * (power(x, 2 * n) / factorial(2 * n));
			}
		}
		else {
			x *= pI / 180;
			for (int n = 0; n <= acc; n++){
				cosx += power(-1, n) * (power(x, 2 * n) / factorial(2 * n));
			}
		}
		return cosx;
	}
	public static double tan(boolean rad, double x, int acc){ //returns the tangent of "x", in either radians or degrees
		if (rad){
			return (sin(true,x,acc) / cos(true,x,acc));
		}
		else {
			x *= pI / 180;
			return (sin(true,x,acc) / cos(true,x,acc));
		}
	}
	public static double ln(double a, int acc){ //returns natural logarithm of "a"
		double ans1 = 0;
		double ans2 = 0;
		int n = 1;
		while (a/n >= 2){
			n *= 10;
		}
		a = a/n - 1;
		for (int i = 1; i <= acc; i++){
			ans1 += (easyPow(-1, i - 1) * (easyPow(a,i) / i));
		}
		if (n > 1){
			for (int i = 1; i <= acc; i++){
				ans2 += (easyPow(-1, i - 1) * (easyPow(((double)1 / n) - 1,i) / i));
			}
		}
		
		return ans1 - ans2 ;
	}
	public static double easyPow(double a, int b){ //returns "a" to the power "b", "b" is an integer
		double testa = a;
		if (b == 0){
			return 1;
		}
		else if (b > 0){
			for(int n = 1; n < b; n++){
				a *= testa;
			}
		}
		else if (b < 0){
			for(int n = 1; n < b; n++){
				a *= a;
			}
			a = 1 / a;
		}
		return a;
	}
	public static double epow(double x, int acc){ //returns e to the power "x"
		double ans = 0;
		for (int n = 0; n < acc; n++){
			ans += (easyPow(x,n) / factorial(n));
		}
		return ans;
	}
	public static double power(double a, double x){ //returns "a" to the power "x"
		if (x % 1 == 0){
			return easyPow(a,(int)x);
		}
		double exp;
		if (a > 20){
			exp = x * ln(a,(int)a * 50);
		}
		else {
			exp = x * ln(a,1000);
		}
		return epow(exp,155);
	}
}
