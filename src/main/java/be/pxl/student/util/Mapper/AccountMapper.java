package be.pxl.student.util.Mapper;

import be.pxl.student.entity.Account;
import be.pxl.student.entity.Payment;
import be.pxl.student.util.InvalidPaymentException;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {
    public static List<Account> accountList = new ArrayList<Account>();
    public static List<Payment>  paymentList = new ArrayList<Payment>();

    public Account mapToAccount(String line) throws InvalidPaymentException {
        String[] paymentInfo = line.split(",");
        if(paymentInfo.length!=7){
            throw new InvalidPaymentException("Invalid number of fields in line");
        }
        var account = new Account();
        account.setIBAN(paymentInfo[1]);
        account.setName(paymentInfo[0]);
        return account;
    }
}
