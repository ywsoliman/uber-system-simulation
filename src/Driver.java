import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends Member implements Observer {
	
	String nationalID;
	String drivingLicense;
	boolean verified;
	boolean available;
	Ride ride;
	double averageRating;
	ArrayList<String> favoriteAreas = new ArrayList<String>();
	ArrayList<Ride> nearbyRequests = new ArrayList<Ride>();
	HashMap<String, Double> userRatings = new HashMap<String, Double>();
	

	public Driver(String username, String password, String email, String mobileNumber, String nationalID, String drivingLicense) {
		super(username, password, email, mobileNumber);
		this.nationalID = nationalID;
		this.drivingLicense = drivingLicense;
		this.verified = false;
		this.available = true;
		this.averageRating = 0.0;
	}
	

	public HashMap<String, Double> getUserRatings() {
		return userRatings;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}


	public ArrayList<Ride> getNearbyRequests() {
		return nearbyRequests;
	}


	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getNationalID() {
		return nationalID;
	}
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public void addFavArea(String area) {
		favoriteAreas.add(area);
	}
	public ArrayList<String> getFavoriteAreas() {
		return favoriteAreas;
	}
	
	public void makeOffer(User user, double price) {
		Offer offer = new Offer(price, this);
		user.getOffers().add(offer);	
	}
	
	public void listUserRatings() {
		for(HashMap.Entry<String, Double> entry : userRatings.entrySet()) {
			System.out.println("User: " + entry.getKey() + " Rating:  " + entry.getValue());
		}
	}

	@Override
	public String toString() {
		return "Driver [nationalID=" + nationalID + ", drivingLicense=" + drivingLicense + ", verified=" + verified
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", suspended=" + suspended + "]";
	}	

//	public User getUser() {
//		return user;
//	}

	@Override
	public void update(Ride ride) {
		this.ride = ride;
		nearbyRequests.add(ride);
	}
	
	
}
