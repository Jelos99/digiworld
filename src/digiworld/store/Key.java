package digiworld.store;

public class Key {
	
	private int key_id;
	private int product_id;
	private String key;
	private boolean sold;
	
	public Key(int keyId, int productId, String key, boolean sold) {
		this.key_id = keyId;
		this.product_id = productId;
		this.key = key;
		this.sold = sold;
	}
	
	public int getKeyID()
	{
		return this.key_id;
	}
	
	public int getProductID()
	{
		return this.product_id;
	}
	
	public String getKey()
	{
		return this.key;
	}
	
	public boolean IsSold()
	{
		return this.sold;
	}
	
	public void setSold(boolean sold)
	{
		this.sold = sold;
	}

	public void setKeyID(int key_id) {
		this.key_id = key_id;
		
	}

	public void setProductID(int product_id) {
		this.product_id = product_id;
		
	}

	public void setKey(String key) {
		this.key = key;
		
	}
}
