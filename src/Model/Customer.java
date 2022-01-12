package Model;

public class Customer {
    private String cstId;
    private String cstName;
    private int contactNumber;
    private String address;


    public Customer(String cstId, String cstName, int contactNumber, String address) {
        this.setCstId(cstId);
        this.setCstName(cstName);
        this.setContactNumber(contactNumber);
        this.setAddress(address);
    }

    public Customer() {
    }


    public String getCstId() {
        return cstId;
    }

    public void setCstId(String cstId) {
        this.cstId = cstId;
    }

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cstId='" + cstId + '\'' +
                ", cstName='" + cstName + '\'' +
                ", contactNumber=" + contactNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
