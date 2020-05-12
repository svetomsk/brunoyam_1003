package db;

public class ClientEntity {
//    @FieldName("client_id")
    private int clientId;
    private String firstName;
    private String lastName;

    public String getInsertStatementSql() {
        String result = String.format("INSERT INTO Client (first_name, last_name) VALUES ('%s', '%s');",
                firstName, lastName);
        return result;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ClientEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
