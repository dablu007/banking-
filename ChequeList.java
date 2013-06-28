

import java.io.Serializable;

public class ChequeList implements Serializable 
{
	
		private String accountno;
	
		public ChequeList(String accountno)
		{

            super();
            this.accountno = accountno;
		}
		


		public ChequeList()
		{
	
		}

		public void setaccountno(String accountno)
		{
			this.accountno = accountno;
		}
		
		public String getaccountno() {
			return (accountno);
		}
}