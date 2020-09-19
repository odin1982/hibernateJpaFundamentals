# BASIC VALUE TYPES
    - basic value types
    - collection value type
    - composite value type

@Entity
public class User{
    @Id
    private Long userId;                            ----> Basic Value Type
    private String firstName;                       ----> Basic Value Type
    private String lastName;                        ----> Basic Value Type
    private User referredBy;                        ----> Entity Type
    private List<String> aliases;                   ----> Collection Value Type
    private Address address;                        ----> Composite Value Type
}



public class Address{
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
}



# COMPOSITE VALUE TYPES


TABLE USER
__________________

USER_ID                 BIGINT
FIRST_NAME              VARCHAR(45)
LAST_NAME               VARCHAR(45)
REFERRED_BY_USER_ID     BIGINT
ADDRESS_LINE_1          VARCHAR(45)
ADDRESS_LINE_2          VARCHAR(45)
CITY                    VARCHAR(45)
STATE                   VARCHAR(45)
ZIP                     VARCHAR(45)

Como se puede observar en la clase existen campos de tabla en dos clases diferentes
a esto le llamamos Composite Value types

@Entity
public class User{
    @Id
    private Long userId;                            ----> Basic Value Type
    private String firstName;                       ----> Basic Value Type
    private String lastName;                        ----> Basic Value Type
    private User referredBy;                        ----> Entity Type
    private List<String> aliases;                   ----> Collection Value Type
    private Address address;                        ----> Composite Value Type
}



public class Address{
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
}




# COLLECTION VALUE TYPE


TABLE BANK_CONTACT
------------------------
BANK_ID         BIGINT
NAME            VARCHAR(100)



    public clas Bank{
        private Long bankId;
        private String name;
        private List<String> contacts = new LinkedList<String>();
        private Address address = new Address();
        private boolean international;
    }
