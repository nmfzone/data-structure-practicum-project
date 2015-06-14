
import java.util.Scanner;

class Kalkulator {

	private Queue rumus;
	private Queue splitRumus;
	private String postFix = "";
	private Stack rumusPostFix;
	private Stack hitung;
	private Stack tempOperand;
	private Stack tempOperator;
	private String[] operator = {"^", "%", "*", "/", "+", "-"};
	private int[] priority = {5, 4, 3, 2, 1, 0};
	private String[] variables = {"a", "b", "x", "y"};

	public Kalkulator()
	{
		rumus = new Queue();
		splitRumus = new Queue();
		rumusPostFix = new Stack();
		hitung = new Stack();
		tempOperand = new Stack();
		tempOperator = new Stack();
	}

	public double calculate()
	{
		double results=0, val1, val2, calc = 0;
		boolean isOperator;

		this.makePostFix();

		String[] parts = postFix.split(",");

		for (int i = 0; i < parts.length;i++)
		{
			isOperator = false;
			String test = parts[i];

            for (int j = 0;j < 6;j++)
			{
				if (test.equals(operator[j]))
				{
					isOperator = true;
					break;
				}
			}

			if (!isOperator)
			{
				hitung.push(new Element(new Info(test)));
			}
			else
			{
				val1 = Double.parseDouble(hitung.pop().getInfo().getIsi());
				val2 = Double.parseDouble(hitung.pop().getInfo().getIsi());
				switch (test)
				{
					case "^":
						calc = Math.pow(val2, val1);
						// System.out.println("^ => " + val2 + "^" + val1 + " = " + calc); //testCase
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "%":
						calc = val2 % val1;
						// System.out.println("% => " + val2 + " % " + val1); //testCase
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "*":
						calc = val2 * val1;
						// System.out.println("* => " + val2 + " * " + val1); //testCase
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "/":
						calc = val2 / val1;
						// System.out.println("/ => " + val2 + " / " + val1); //testCase
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "+":
						calc = val2 + val1;
						// System.out.println("+ => " + val2 + " + " + val1); //testCase
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "-":
						calc = val2 - val1;
						// System.out.println("- => " + val2 + " - " + val1); //testCase
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
				}
			}

	    }

	    results = Double.parseDouble(hitung.pop().getInfo().getIsi());

	    return results;
	}

	public void makePostFix()
	{
		boolean isOperator;
		int opNow, opPeek;

		this.makeRumusSparated();

		// splitRumus.print(); //testCase
	
		while (!splitRumus.isEmpty())
		{
			isOperator = false;
			String pop = splitRumus.deQueue().getInfo().getIsi();

			// Make from Infix to Postfix
			for (int i = 0; i < 6; i++)
			{
				if (pop.equals(operator[i]))
				{
					if (tempOperator.isEmpty())
					{
						tempOperator.push(new Element(new Info(pop)));
					}
					else
					{
						opNow = priority[i];
						opPeek = 0;

						for (int j = 0;j < 6;j++)
						{
							if (tempOperator.peek().getInfo().getIsi().equals(operator[j]))
							{
								opPeek = priority[j];
								break;
							}
						}

						//testCase
						// System.out.println("Pop: " + pop + ", Prior Soal : " + opNow + ", Prior Peek : " + opPeek);

						if (opNow > opPeek)
						{
							tempOperator.push(new Element(new Info(pop)));
						}
						else
						{
							while (opNow <= opPeek)
							{
								if (!tempOperator.isEmpty())
								{
									tempOperand.push(tempOperator.pop());

									if (!tempOperator.isEmpty())
									{
										for (int j = 0;j < 6;j++)
										{
											if (tempOperator.peek().getInfo().getIsi().equals(operator[j]))
											{
												opPeek = priority[j];
												break;
											}
										}
									}
								}
								else
								{
									break;
								}
							}
							tempOperator.push(new Element(new Info(pop)));
						}
					}
					isOperator = true;
				}
			}
			
			if(!isOperator)
			{
				tempOperand.push(new Element(new Info(pop)));
			}
		}

		// Concatenate the Operand and Operator to rumusPostFix
		rumusPostFix = tempOperand;
		// System.out.println("Operator : "); //testCase
		// tempOperator.print(); //testCase
		while (!tempOperator.isEmpty())
		{
			rumusPostFix.push(tempOperator.pop());
		}

		String reversePostFix = "";

		while (!rumusPostFix.isEmpty())
		{
			reversePostFix += rumusPostFix.pop().getInfo().getIsi();
		}

		// System.out.println(reversePostFix); //testCase

		int length = reversePostFix.length();

		// Reverse the reversePostFix String
		// ex. "cba" to "abc" and add separate with comma (,)
		for (int i = length - 1; i >= 0; i--)
		{
			postFix += reversePostFix.charAt(i) + ",";
		}

		// System.out.println("PostFix : " + postFix); //testCase

	}

	public void addRumus(String rumus)
	{
		this.rumus.enQueue(new Element(new Info(rumus)));
	}

	public Queue getRumus()
	{
		return rumus;
	}

	public void makeRumusSparated()
	{
		Scanner io = new Scanner(System.in);
		Element helper = rumus.deQueue();
		String isi, varIn;
		int varIndex = 10000;
		for (int i = 0;i < helper.getInfo().getIsi().length();i++)
		{
			isi = String.valueOf(helper.getInfo().getIsi().charAt(i));

			// Replace with number from input if found Variables
			for (int j = 0;j < variables.length;j++)
			{
				if (isi.toLowerCase().equals(variables[j]))
				{
					System.out.print("Masukkan Value " + variables[j] + " : ");
					varIn = io.next();
					isi = varIn;

					// Check if before variable is not operator
					// then add * before the variable
					for (int k = 0;k < operator.length;k++)
					{
						if (!splitRumus.getHead().getInfo().getIsi().equals(operator[k]))
						{
							splitRumus.enQueue(new Element(new Info("*")));
							break;
						}
					}

					varIndex = i;
					break;
				}
			}

			splitRumus.enQueue(new Element(new Info(isi)));

			if (i == varIndex+1)
			{
				// Check if after variable is not operator
				// then add * after the variable
				for (int k = 0;k < operator.length;k++)
				{
					if (!splitRumus.getHead().getInfo().getIsi().equals(operator[k]))
					{
						splitRumus.enQueue(new Element(new Info("*")));
						break;
					}
				}
				varIndex = 10000;
			}
		}
	}

	public void printRumus()
	{
		if (!rumus.isEmpty())
		{
			System.out.println("Daftar Rumus : ");
			rumus.print();
		}
		else
		{
			System.out.println("Rumus masih Kosong!");
		}
	}

}