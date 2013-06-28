

import java.io.Serializable;

public class TransactionInfo implements Serializable {
	
	//private String date;
	private String accountno;
	private String debit;
	private String credit;
	//private String total;
	
	public TransactionInfo(String accountno, String debit,
			String credit) {
		super();
		//this.date = date;
		this.accountno = accountno;
		this.debit = debit;
		this.credit = credit;
		//this.total = total;
	}
	
	public TransactionInfo()
	{
		
	}

	/*public void setDate(String date) {
		this.date = date;
	}

	
	public String getDate() {
		return (date);
	}*/

	public void setaccountno(String accountno) {
		this.accountno = accountno;
	}
	

	public String getaccountno() {
		return accountno;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	
	public String getDebit() {
		return debit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	

	public String getCredit() {
		return credit;
	}

	/*public void setTotal(String total) {
		this.total = total;
	}

	
	public String getTotal() {
		return total;
	}*/

	
	
	

}

