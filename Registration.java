

import java.io.Serializable;

public class Registration implements Serializable {
	private String name;
	private String dob;
	private String gender;
	private String phoneno;
	private String address;
	private String emailid;
	private String occupation;
	private String idproof;
	private String identityproofno;
	private String accounttype;
	private String depositamount;
	private String facilitiesrequired;
	private String accountno;	

	public Registration(String name, String phoneno, String address,  String identityproofno,  String occupation, String dob,) 

	{
                super();
		this.name = name;
		this.dob = dob;
	//	this.gender = gender;
		this.phoneno = phoneno;
		this.address = address;
	//	this.emailid = emailid;
		this.occupation = occupation;
		this.identityproofno = identityproofno;
	/*	this.idproof = idproof;
		this.accounttype = accounttype;
		this.depositamount = depositamount;
		this. facilitiesrequired =  facilitiesrequired;
		this.accountno = accountno;
	*/
	}

	public Registration()
	{
		
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return (name);
	}

	public void setdob(String dob) {
		this.dob = dob;
	}

	public String getdob() {
		return (dob);
	}

	
/*	public void setgender(String gender) {
		this.gender = gender;
	}

	public String getgender() {
		return (gender);
	}
*/
	public void setphoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getphoneno() {
		return (phoneno);
	}

	
	public void setaddress(String address) {
		this.address = address;
	}
	public String getaddress() {
		return (address);
	}

/*	public void setemailid(String emailid) {
		this.emailid = emailid;
	}

	public String getemailid() {
		return (emailid);
	}
*/
	public void setoccupation(String  occupation) {
		this. occupation =  occupation;
	}

	
	public String getoccupation() {
		return  (occupation);
	}

/*	public void setidproof(String idproof) {
		this.idproof = idproof;
	}

	public String getidproof() {
		return (idproof);
	}
*/
	public void setidentityproofno(String identityproofno) {
		this.identityproofno = identityproofno;
	}

	public String getidentityproofno() {
		return (identityproofno);
	}

/*	public void setaccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getaccounttype() {
		return (accounttype);
	}

	public void setdepositamount(String depositamount) {
		this.depositamount = depositamount;
	}

	public String getdepositamount() {
		return (depositamount);
	}

	public void setfr(String  facilitiesrequired) {
		this. facilitiesrequired =  facilitiesrequired;
	}

	public String getfr() {
		return (facilitiesrequired);
	}

	public void setaccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getaccountno() {
		return (accountno);
	}

*/	

	}
