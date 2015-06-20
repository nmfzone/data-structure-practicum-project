# About this Project
This is my "Struktur Data" Practicum Project for "Responsi" using JAVA in Islamic University of Indonesia.


# About The Program
```
The program is for calculate the formula that have been inputed by user.
The program can calculate the formula that have variables or not. The program
calculate the formula by using LinkedList, Queue, and Stack, the basic algorithm
to calculate the formula.
```

# Features
```
	1. 	Calculate the formula that have a variables or not

	2. 	Can calculate the formula that have variables a, b, x and y. You can easily
		add or remove the variables that can be used by edit this line in
		Kalkulator.java :

			private String[] variables = {"a", "b", "x", "y"};

	3. 	Can calculate the formula that have operator ^(pow), %(modulo), *(multiply),
		/(div), +(plus) and -(minus). You can easily add or remove the operators that
		can be used by edit this line in Kalkulator.java :

			private String[] operator = {"^", "%", "*", "/", "+", "-"};

		but you must also add the priority in this line :

			private int[] priority = {5, 4, 3, 2, 1, 0};

		and then you must also add the operation in this section :
		(please beware about this)

			switch (test)
				{
					case "^":
						calc = Math.pow(val2, val1);
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "%":
						calc = val2 % val1;
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "*":
						calc = val2 * val1;
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "/":
						calc = val2 / val1;
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "+":
						calc = val2 + val1;
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
					case "-":
						calc = val2 - val1;
						hitung.push(new Element(new Info(String.valueOf(calc))));
						break;
				}

```

# About Release
```
	v1.0

	Bugs:
		* I think no one. Please pull request if you found a bugs.
```

```
	v0.1 - BETA
	
	Bugs:
		* Can only calculate for single number (1-9), in that sense number can only
		  with one digit. (will be fixed for next releases)
```