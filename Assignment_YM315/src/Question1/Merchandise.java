package Question1;

public class Merchandise implements Comparable<Merchandise>{
	private String itemCode;
	private int quantity;
	private double unitPrice;
	
	public Merchandise(String itemCode, int quantity, double unitPrice) {
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getItemCode() {
		return itemCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Merchandise [itemCode=").append(itemCode).append(", quantity=").append(quantity)
				.append(", unitPrice=").append(unitPrice).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Merchandise merch) {
		// TODO Auto-generated method stub
		return this.itemCode.compareTo(merch.itemCode);
	}
	
}
