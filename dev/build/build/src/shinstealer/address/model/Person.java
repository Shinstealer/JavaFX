package shinstealer.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty street;
	private final IntegerProperty postalcode;
	private final StringProperty city;
	//private final ObjectProperty<LocalDate> birthday;

	/**
	* 디폴트 생성자
	*/
	public Person() {
		this(null, null);
	}

	/**
	 * 데이터를 초기화하는 생성자
	 *
	 * @param firstName
	 * @param lastName
	 */
	public Person(String firstName, String lastName) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);

		this.street = new SimpleStringProperty("moriguchi");
		this.postalcode = new SimpleIntegerProperty(1234);
		this.city = new SimpleStringProperty("osaka");
		//this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 5, 20));

	}

	public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }

    public int getPostalCode() {
        return postalcode.get();
    }

    public void setPostalCode(int postalCode) {
        this.postalcode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty() {
        return postalcode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
    }

//    public LocalDate getBirthday() {
//        return birthday.get();
//    }
//
//    public void setBirthday(LocalDate birthday) {
//        this.birthday.set(birthday);
//    }
//
//    public ObjectProperty<LocalDate> birthdayProperty() {
//        return birthday;
//    }

}
