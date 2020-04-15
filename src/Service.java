/*
 * This is the method to store the all of the information about the user
 * This use the arraylist (Vector)
 * Every chickBox's Item store in this three arraylist
 */
import java.util.*;

public class Service {
	private ArrayList<String> babyServices;
	private ArrayList<String> foodServices;
	private ArrayList<String> disableServices;
	
	public Service() {
		this.foodServices = new ArrayList<>();
		this.disableServices = new ArrayList<>();
		this.babyServices = new ArrayList<>();
	}
	
	public boolean isFoodBooked() {
		return foodServices.size() != 0;
	}
	
	public boolean isBabyBooked() {
		return babyServices.size() != 0;
	}
	
	public boolean isDisableBooked() {
		return disableServices.size() != 0;
	}
	
	
	public void addBookedFood(String newFood ) {
		foodServices.add(newFood);
	}
	
	public void addDisableFacility(String newDF) {
		disableServices.add(newDF);
	}
	
	public void addBabyService(String newBS) {
		babyServices.add(newBS);
	}
	
	public ArrayList<String> getBookedFoods() {
		return foodServices;
	}
	
	public ArrayList<String> getBookedBabyService() {
		return babyServices;
	}
	
	public ArrayList<String> getBookedDisabledFacilities() {
		return disableServices;
	}
	
}
