package Question1;

import java.util.Comparator;

public class priceComparator implements Comparator<Merchandise>{

	@Override
	public int compare(Merchandise merch1, Merchandise merch2) {
		return Double.compare(merch1.getUnitPrice(), merch2.getUnitPrice());
	}
	
}
