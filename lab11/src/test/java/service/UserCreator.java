package service;

import model.User;

public class UserCreator {

    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_SURNAME = "testdata.user.surname";
    public static final String TESTDATA_USER_NAME_OF_BUYER = "testdata.user.name_of_buyer";
    public static final String TESTDATA_USER_WRONG_EMAIL = "testdata.user.wrong_email";
    public static final String TESTDATA_USER_EMPTY_EMAIL = "testdata.user.empty_email";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD),
                TestDataReader.getTestData(TESTDATA_USER_NAME),
                TestDataReader.getTestData(TESTDATA_USER_SURNAME));
    }

    public static User withCredentialsFromPropertyToCertificate(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL),
            "",
            TestDataReader.getTestData(TESTDATA_USER_NAME_OF_BUYER),
            TestDataReader.getTestData(TESTDATA_USER_NAME));
    }

    public static User withCredentialsFromPropertyWrongEmail() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_WRONG_EMAIL), "", "", "");
    }

    public static User withCredentialsFromPropertyEmptyEmail() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMPTY_EMAIL), "", "", "");
    }
}
