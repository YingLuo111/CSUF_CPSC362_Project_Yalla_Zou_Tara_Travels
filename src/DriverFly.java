/*
 * Class_362_Final_Project
 ****               Yalla Zou Tara                          ****
 *****************************************************************
 *This Project is the flight ticket reservation system.
 *The user can using this System booking the flight ticket 
 *choicing the Oneway or RoundTrip.
 ****         The function this project will have             ****
 ******************************************************************
 *The user can reservate the seat by this system use the mouse
 *click what seat they want to choice.
 *The user can reservate the disabled help by this system.
 *The user can reservate the baby help by this system.
 *The user can reservate the special food by this system.
 *The user can search the city's weather by this system.
 *The user can chang/refound the flight ticket by this system
 ****         The fianlly result about the project             ****
 ******************************************************************
 *Finally the sysytem will the all of the information about the 
 *user choice, let make sure that is correct or not.
 *if the information is correct user can choice the submit it 
 *and get the filgt tickit.
 *if some infomation is not correct the user can back home change it.
 *******************************************************************
 */
/*
 * This is the main function to operation the program
 */
public class DriverFly {

	public static void main(String[] args) {
		DBManager dbMgr = DBManager.getDBManager();
		
		Fly f =  new Fly(dbMgr);
		f.setVisible(true);

	}

}
