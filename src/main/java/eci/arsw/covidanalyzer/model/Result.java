package eci.arsw.covidanalyzer.model;

import java.util.UUID;

/**
 * The type Result.
 */
public class Result {



    //<editor-fold desc="properties">
    private UUID id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String birthString;
    private ResultType resultType;
    private String testString;
    private boolean result;
    private double testSpecifity;
    private int numberTest;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="constructor">

    public Result(){

    }
    /**
     * Instantiates a new Result.
     *
     * @param id            the id
     * @param firstName     the first name
     * @param lastName      the last name
     * @param gender        the gender
     * @param email         the email
     * @param birthString   the birth string
     * @param testString    the test string
     * @param result        the result
     * @param testSpecifity the test specifity
     * @param resultType    the result type
     */
    public Result(UUID id, String firstName, String lastName, String gender, String email, String birthString, String testString, boolean result, double testSpecifity, ResultType resultType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.birthString = birthString;
        this.testString = testString;
        this.result = result;
        this.testSpecifity = testSpecifity;
        this.resultType = resultType;
        this.numberTest = 0;
    }

    /**
     * Instantiates a new Result.
     *
     * @param id            the id
     * @param firstName     the first name
     * @param lastName      the last name
     * @param gender        the gender
     * @param email         the email
     * @param birthString   the birth string
     * @param testString    the test string
     * @param result        the result
     * @param testSpecifity the test specifity
     */
    public Result(UUID id, String firstName, String lastName, String gender, String email, String birthString, String testString, boolean result, double testSpecifity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.birthString = birthString;
        this.testString = testString;
        this.result = result;
        this.testSpecifity = testSpecifity;
        this.numberTest = 0;
        this.resultType = ResultType.FALSE_NEGATIVE;
    }

    //</editor-fold>

    /**
     * Gets id.
     *
     * @return the id
     */
//<editor-fold desc="getters">
    public UUID getId() {
        return id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets birth date.
     *
     * @return the birth date
     */
    public String getBirthDate() {
        return birthString;
    }

    /**
     * Gets test date.
     *
     * @return the test date
     */
    public String getTestDate() {
        return testString;
    }

    /**
     * Is result boolean.
     *
     * @return the boolean
     */
    public boolean isResult() {
        return result;
    }

    /**
     * Gets test specifity.
     *
     * @return the test specifity
     */
    public double getTestSpecifity() {
        return testSpecifity;
    }

    /**
     * Gets birth string.
     *
     * @return the birth string
     */
    public String getBirthString() {
        return birthString;
    }

    /**
     * Gets result type.
     *
     * @return the result type
     */
    public ResultType getResultType() {
        return resultType;
    }

    /**
     * Gets test string.
     *
     * @return the test string
     */
    public String getTestString() {
        return testString;
    }

    /**
     * Gets number test.
     *
     * @return the number test
     */
    public int getNumberTest() {
        return numberTest;
    }

    //</editor-fold>

    /**
     * Sets id.
     *
     * @param id the id
     */
//<editor-fold desc="setters">
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets birth date.
     *
     * @param birthString the birth string
     */
    public void setBirthDate(String birthString) {
        this.birthString = birthString;
    }

    /**
     * Sets test date.
     *
     * @param testString the test string
     */
    public void setTestDate(String testString) {
        this.testString = testString;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(boolean result) {
        this.result = result;
    }

    /**
     * Sets test specifity.
     *
     * @param testSpecifity the test specifity
     */
    public void setTestSpecifity(double testSpecifity) {
        this.testSpecifity = testSpecifity;
    }

    /**
     * Sets birth string.
     *
     * @param birthString the birth string
     */
    public void setBirthString(String birthString) {
        this.birthString = birthString;
    }

    /**
     * Sets result type.
     *
     * @param resultType the result type
     */
    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    /**
     * Sets test string.
     *
     * @param testString the test string
     */
    public void setTestString(String testString) {
        this.testString = testString;
    }

    /**
     * Sets number test.
     *
     * @param numberTest the number test
     */
    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    //</editor-fold>

    //<editor-fold desc="Equality Methods">
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return ((Result) o).getId().equals(this.id);
    }
    //</editor-fold>

    @Override
    public String toString() {
        return this.id.toString() + " - " + this.firstName + " - " + this.lastName;
    }
}
