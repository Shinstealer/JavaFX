package shinstealer.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private final StringProperty firstName;
	private final StringProperty lastName;
	private final StringProperty street;
	private final IntegerProperty postalcode;
	private final StringProperty city;
	private final ObjectProperty<LocalDate> birthday;

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
		this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 5, 20));

	}

	public final StringProperty firstNameProperty() {
		return this.firstName;
	}

	public final String getFirstName() {
		return this.firstNameProperty().get();
	}

	public final void setFirstName(final String firstName) {
		this.firstNameProperty().set(firstName);
	}

	public final StringProperty lastNameProperty() {
		return this.lastName;
	}

	public final String getLastName() {
		return this.lastNameProperty().get();
	}

	public final void setLastName(final String lastName) {
		this.lastNameProperty().set(lastName);
	}

	public final StringProperty streetProperty() {
		return this.street;
	}

	public final String getStreet() {
		return this.streetProperty().get();
	}

	public final void setStreet(final String street) {
		this.streetProperty().set(street);
	}

	public final IntegerProperty postalcodeProperty() {
		return this.postalcode;
	}

	public final int getPostalcode() {
		return this.postalcodeProperty().get();
	}

	public final void setPostalcode(final int postalcode) {
		this.postalcodeProperty().set(postalcode);
	}

	public final StringProperty cityProperty() {
		return this.city;
	}

	public final String getCity() {
		return this.cityProperty().get();
	}

	public final void setCity(final String city) {
		this.cityProperty().set(city);
	}

	public final ObjectProperty<LocalDate> birthdayProperty() {
		return this.birthday;
	}

	public final LocalDate getBirthday() {
		return this.birthdayProperty().get();
	}

	public final void setBirthday(final LocalDate birthday) {
		this.birthdayProperty().set(birthday);
	}

}
