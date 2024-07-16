package relations;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposits extends BaseEntity{
    private String firstName;
    private String lastName;
    private String notes;
    private int age;
    private String magicWandCreator;
    private int magicWandSize;
    private String depositGroup;
    private LocalDate depositStartDate;
    private double depositAmount;
    private double depositInterest;
    private double depositCharge;
    private LocalDate depositExpirationDate;
    private boolean isDepositExpired;

    public WizardDeposits() {
    }

    public WizardDeposits(String firstName, String lastName, String notes, int age, String magicWandCreator, int magicWandSize, String depositGroup, LocalDate depositStartDate, double depositAmount, double depositInterest, double depositCharge, LocalDate depositExpirationDate, boolean isDepositExpired) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNotes(notes);
        this.setAge(age);
        this.setMagicWandCreator(magicWandCreator);
        this.setMagicWandSize(magicWandSize);
        this.setDepositGroup(depositGroup);
        this.setDepositStartDate(depositStartDate);
        this.setDepositAmount(depositAmount);
        this.setDepositInterest(depositInterest);
        this.setDepositCharge(depositCharge);
        this.setDepositExpirationDate(depositExpirationDate);
        this.setDepositExpired(isDepositExpired);
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() <= 50) {
            this.firstName = firstName;
        }
        else
            throw new IllegalArgumentException("This field must have 50 symbols or less");
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() <= 60) {
            this.lastName = lastName;
        }else
            throw new IllegalArgumentException("LastName must have a length of 60 or less");
    }

    @Column
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        if (notes.length() <= 1000) {
            this.notes = notes;
        }else
            throw new IllegalArgumentException("Notes must have 1000 symbols or less");
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }else
            throw new IllegalArgumentException("Age cannot be negative");
    }

    @Column(name = "magic_wand_creator")
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        if (magicWandCreator.length() <= 100) {
            this.magicWandCreator = magicWandCreator;
        }else
            throw new IllegalArgumentException("magic_wand_creator can't be more then 100 symbols");
    }

    @Column(name = "magic_wand_size")
    public int getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(int magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    @Column(name = "deposit_group")
    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        if (depositGroup.length() <= 20) {
            this.depositGroup = depositGroup;
        }else
            throw new IllegalArgumentException("deposit_group max value is 20");
    }

    @Column(name = "deposit_start_date")
    public LocalDate getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDate depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    @Column(name = "deposit_amount")
    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    @Column(name = "deposit_interest")
    public double getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(double depositInterest) {
        this.depositInterest = depositInterest;
    }

    @Column(name = "deposit_charge")
    public double getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(double depositCharge) {
        this.depositCharge = depositCharge;
    }

    @Column(name = "deposit_expiration_date")
    public LocalDate getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDate depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    @Column(name = "is_deposit_expired")
    public boolean isDepositExpired() {
        return isDepositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        isDepositExpired = depositExpired;
    }
}
