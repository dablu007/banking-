

import java.io.Serializable;

public class DraftRequest implements Serializable 
{
	
		private String accountno;
	
		public DraftRequest(String accountno)
		{

            super();
            this.accountno = accountno;
		}
		


		public DraftRequest()
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
