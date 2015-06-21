import java.util.Scanner;
import java.lang.*;

public class Main {

	public void exitMessages()
	{
		// "                                                  .~))>>\n" +
		// "                                                 .~)>>\n" +
		// "                                               .~))))>>>\n" +
		// "                                             .~))>>             ___\n" +
		// "                                           .~))>>)))>>      .-~))>>\n" +
		// "                                         .~)))))>>       .-~))>>)>\n" +
		// "                                       .~)))>>))))>>  .-~)>>)>\n" +
		// "                   )                 .~))>>))))>>  .-~)))))>>)>\n" +
		// "                ( )@@*)             //)>))))))  .-~))))>>)>\n" +
		// "              ).@(@@               //))>>))) .-~))>>)))))>>)>\n" +
		// "            (( @.@).              //))))) .-~)>>)))))>>)>\n" +
		// "          ))  )@@*.@@ )          //)>))) //))))))>>))))>>)>\n" +
		// "       ((  ((@@@.@@             |/))))) //)))))>>)))>>)>\n" +
		// "      )) @@*. )@@ )   (\_(\-\b  |))>)) //)))>>)))))))>>)>\n" +
		// "    (( @@@(.@(@ .    _/`-`  ~|b |>))) //)>>)))))))>>)>\n" +
		// "     )* @@@ )@*     (@)  (@) /\b|))) //))))))>>))))>>\n" +
		// "   (( @. )@( @ .   _/  /    /  \b)) //))>>)))))>>>_._\n" +
		// "    )@@ (@@*)@@.  (6///6)- / ^  \b)//))))))>>)))>>   ~~-.\n" +
		// " ( @jgs@@. @@@.*@_ VvvvvV//  ^  \b/)>>))))>>      _.     `bb\n" +
		// "  ((@@ @@@*.(@@ . - | o |' \ (  ^   \b)))>>        .'       b`,\n" +
		// "   ((@@).*@@ )@ )   \^^^/  ((   ^  ~)_        \  /           b `,\n" +
		// "     (@@. (@@ ).     `-'   (((   ^    `\ \ \ \ \|             b  `.\n" +
		// "       (*.@*              / ((((        \| | |  \       .       b `.\n" +
		// "                         / / (((((  \    \ /  _.-~\     Y,      b  ;\n" +
		// "                        / / / (((((( \    \.-~   _.`' _.-~`,    b  ;\n" +
		// "                       /   /   `(((((()    )    (((((~      `,  b  ;\n" +
		// "                     _/  _/      `'''/   /'                  ; b   ;\n" +
		// "                 _.-~_.-~           /  /'                _.'~bb _.'\n" +
		// "               ((((~~              / /'              _.'~bb.--~\n" +
		// "                                  ((((          __.-~bb.-~\n" +
		// "                                              .'  b .~~\n" +
		// "                                              :bb ,' \n" +
		// "                                              ~~~~\n"
		System.out.println("\n\n\nAs Simple as Possible but Not Simpler - Albert Einstein");
		System.out.println("\nProgram was ended . . . .");
	}

	public void menu()
	{
		System.out.print("======= Menu Kalkulator =======\n"
						+  "\t1. Tambahkan Rumus\n"
						+  "\t2. Lihat Rumus\n"
						+  "\t3. Hapus Rumus\n"
						+  "\t4. Hitung Rumus\n"
						+  "\t5. Keluar\n"
						+  "\nMasukkan Pilihan : ");
	}

	public static void main(String[] args)
	{
		Scanner io = new Scanner(System.in);
		Main m = new Main();
		Kalkulator calc = new Kalkulator();

		int pil = 0;
		String rumus;
		int indexRumus = 1;
		boolean goodInput;

		do
		{
			goodInput = false;
			m.menu();
			try {
				pil = io.nextInt();
				System.out.println();
				goodInput = true;
			} catch(Exception e) {
	            System.out.println("Input harus Angka!");
	            io.next();
	        }

	        if (goodInput)
	        {
	        	switch(pil)
				{
					case 1 :
						System.out.print("Masukkan Rumus : ");
						rumus = io.next();
						calc.addRumus(rumus, indexRumus);
						indexRumus++;
						break;
					case 2 :
						calc.printRumus();
						break;
					case 3 :
						calc.printRumus();
						System.out.println();
						if (!calc.getRumus().isEmpty())
						{
							int hapusIndex;
							System.out.print("Masukkan Index Rumus yang akan dihapus : ");
							hapusIndex = io.nextInt();
							calc.removeRumus(hapusIndex);
						}
						break;
					case 4 :
						if (!calc.getRumus().isEmpty())
						{
							int noRumus = 1;
							while (!calc.getRumus().isEmpty())
							{
								double hasil = calc.calculate();
								System.out.println(noRumus + ". Hasil Perhitungan " + calc.getOriginalRumus() + " = " + hasil);
								noRumus++;
							}
						}
						else
						{
							System.out.println("Rumus masih Kosong!\n"
											 + "Silahkan isi Rumus terlebih dahulu!");
						}
						break;
					case 5 :
						m.exitMessages();
						System.exit(0);
						break;
					default:
						System.out.println("Menu Tidak Tersedia, Silahkan Ulangi!\n");
						break;
				}
	        }

			System.out.println();
		} while(true);
	}

}