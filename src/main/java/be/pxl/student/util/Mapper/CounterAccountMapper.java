package be.pxl.student.util.Mapper;

import be.pxl.student.entity.Account;
import be.pxl.student.util.InvalidPaymentException;

public class CounterAccountMapper {
    public static Account map(String validLine) throws InvalidPaymentException {
        String[] splitLines = validLine.split(",");
        if (splitLines.length != 7) {
            throw new InvalidPaymentException("Invalid number of fields in line.");
        }
        Account account = new Account();
        account.setIBAN(splitLines[2]);

        return account;
    }
}
