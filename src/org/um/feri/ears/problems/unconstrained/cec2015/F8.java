package org.um.feri.ears.problems.unconstrained.cec2015;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.um.feri.ears.problems.unconstrained.cec.Functions;

public class F8 extends CEC2015 {
	
	public F8(int d) {
		super(d,8);

		name = "F08 Griewank-Rosenbrock Function";
	}

	@Override
	public double eval(Double[] ds) {
		return eval(ArrayUtils.toPrimitive(ds));
	}
	
	public double eval(double x[]) {
		double F;
		F = Functions.grie_rosen_func(x, numberOfDimensions, OShift, M, 1, 1);
		F+= 100 * func_num;
		return F;
	}

}
