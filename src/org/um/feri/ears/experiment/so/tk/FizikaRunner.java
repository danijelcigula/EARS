package org.um.feri.ears.experiment.so.tk;


import org.um.feri.ears.problems.EnumStopCriteria;
import org.um.feri.ears.problems.Problem;
import org.um.feri.ears.problems.StopCriteriaException;
import org.um.feri.ears.problems.Task;
import org.um.feri.ears.problems.unconstrained.ProblemRosenbrock;
import org.um.feri.ears.problems.unconstrained.ProblemSphere;
import org.um.feri.ears.problems.unconstrained.cec2010.F1;
import org.um.feri.ears.problems.unconstrained.cec2010.F10;
import org.um.feri.ears.problems.unconstrained.cec2010.F11;

import org.um.feri.ears.util.Util;

//MAIN za testiranje algoritmov fizikalnih fenomenov (posami�no delovanje)
public class FizikaRunner {

	//run metoda main
	public static void main(String[] args) 
	{	
		Util.rnd.setSeed(100);


		//ECBO a = new ECBO();

		//	EML a = new EML(); 
		//GSA a = new GSA(); 
		//LSA a = new LSA();

		//�e v testiranju, kodiranju, popravljanju
		//CSS a = new CSS();

		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new ProblemSphere(30));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Rastrigin(30));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Bohachevsky1(2));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Hartman3(3));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Hartman6(6));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new GoldStein_Price(2));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new Shekel10(4));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new Shekel5(4));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new Shekel7(4));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.000001, new Branin(2));
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Step(30));  
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Griewank(2));  
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new Rosenbrock(30));  
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new Ackley(10));  
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.001, new SixHumpCamelBack(2));

		//SHIFTED ELLIPTIC = 0 OPTIMUM
		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new F1(30));

		//Task t = new Task(EnumStopCriteria.GLOBAL_OPTIMUM_OR_EVALUATIONS, 200000, 0.0001, new FX(1,30));


		double avg_eval = 0;
		double best = 99999;
		double avg_best = 0;
		double worst = -9999;
		
		for(int i = 0;i < 30;i++)
		{
			EML2 a = new EML2(); 

			Task t = new Task(EnumStopCriteria.EVALUATIONS, 200000, 500, 300, 0.0001, new ProblemSphere(30));  

			try 		    
			{		
				double besttmp = a.execute(t).getEval();
				System.out.println(besttmp);

				avg_best = avg_best + besttmp;

				if(besttmp < best)
					best = besttmp;
				
				if(worst < besttmp)
					worst = besttmp;

			} 	    
			catch (StopCriteriaException e) 
			{
				e.printStackTrace();
			}

			avg_eval = avg_eval + t.getNumberOfEvaluations();

		}

		avg_eval = avg_eval / 30.0;
		avg_best = avg_best / 30.0;

		System.out.println("AVG EVAl:" + avg_eval + "  bestfx:" + best);
		System.out.println("worstfx: "  + worst);
		System.out.println("AVG best:" + avg_best);

	}
}