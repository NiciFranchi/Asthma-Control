package edu.gatech.epidemics.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String username;
    private String password;
    private Boolean active;
    @NotNull
    private String personType;
    @NotNull
    private String firstName;
    private String middleName;
    @NotNull
    private String lastName;
    private String contactPhone;
    private String contactEmail;
    private String contactFax;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    @NotNull
    private Date birthday;
    @Transient
    private Integer age;
    @OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL)
    private Set<Visit> visits;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", username=" + username + ", password=" + password + ", active=" + active + ", personType=" + personType + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail + ", contactFax=" + contactFax + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", zip=" + zip + ", birthday=" + birthday + ", age=" + age + ", visits=" + visits + '}';
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactFax() {
        return contactFax;
    }

    public void setContactFax(String contactFax) {
        this.contactFax = contactFax;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.city = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
        setAge();
    }
    
    public Integer getAge() {
        int age = yearFromDate(new Date()) - yearFromDate(birthday);
        if (birthdayHasNotPassedThisYear()) {
            age -= 1;
        }
        return age;
    }
    
    private void setAge() {
        this.age = getAge();
    }

    public Set<Visit> getVisits() {
        return visits;
    }

    public void setVisits(Set<Visit> visits) {
        this.visits = visits;
    }
    
    private int yearFromDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }
    
    private boolean birthdayHasNotPassedThisYear() {
        Calendar today = new GregorianCalendar();
        today.setTime(new Date());
        Calendar bday = new GregorianCalendar();
        bday.setTime(birthday);
        return bday.get(Calendar.MONTH) >= today.get(Calendar.MONTH) &&
            bday.get(Calendar.DAY_OF_MONTH) >= today.get(Calendar.DAY_OF_MONTH);
    }
    
    @PostLoad
    private void onLoad() {
        setAge();
    }
}
