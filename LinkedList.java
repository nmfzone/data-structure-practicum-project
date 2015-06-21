
public class LinkedList {

	private Element first;

	public LinkedList()
	{
		first = null;
	}

	public Element getFirst()
	{
		return first;
	}

	public void setFirst(Element data)
	{
		first = data;
	}

	public void insertFirst(Element data)
	{
		data.setNext(first);
		first = data;
	}

	public void insertLast(Element data)
	{
		if (isEmpty())
		{
			first = data;
		}
		else
		{
			Element helper = first;
			while (helper.getNext() != null)
			{
				helper = helper.getNext();
			}
			helper.setNext(data);
		}
	}

	public Element deleteFirst()
	{
		Element helper = first;
		first = first.getNext();

		return helper;
	}

	public Element deleteAt(int index)
	{
		Element elSem = first;
		boolean ketemu = false;

        if (elSem.getNext() != null)
        {
            Element eseyd = null;

            while (elSem.getNext() != null)
            {
                eseyd = elSem;
                elSem = elSem.getNext();
                if (elSem.getInfo().getIndex() == index)
                {
                    eseyd.setNext(elSem.getNext());
                    ketemu = true;
                }
            }
        }
        else
        {
        	if (elSem.getInfo().getIndex() == index)
        	{
    			first = null;
    			ketemu = true;
    		}
        }

        if (!ketemu)
        {
        	System.out.println("\nRumus dengan Index '" + index + "' tidak ada dalam List.\n"
        					 + "Gagal Mengapus!");
        }
        else
        {
        	System.out.println("\nRumus Berhasil Dihapus :)");
        }

        return first;
    }

	public boolean isEmpty()
	{
		return first == null;
	}

	public void print()
	{
		Element helper = this.getFirst();
		System.out.print("Isi List : ");
		while (helper != null)
		{
			System.out.print(helper.getInfo().getIsi() + " ");
			helper = helper.getNext();
		}
		System.out.println();
	}

}