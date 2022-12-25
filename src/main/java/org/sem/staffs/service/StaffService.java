package org.sem.staffs.service;

import org.sem.authenticate.models.User;
import org.sem.helper.DateTimeHelper;
import org.sem.staffs.models.Staff;
import org.sem.staffs.models.StaffDAO;

import java.util.regex.Pattern;

public class StaffService {
    public StaffDAO staffDAO;

    public StaffService() {
        staffDAO = new StaffDAO();
    }

    public void saveStaff(
            Long id,
            String staffNo,
            String fullName,
            String email,
            String phone,
            Boolean gender,
            String dob,
            String address,
            User user
    ) {
        try {
            validate(staffNo, fullName, email, phone, dob, address);
            Staff staff = new Staff(
                    id,
                    staffNo,
                    fullName,
                    email,
                    phone,
                    gender,
                    DateTimeHelper.stringToDate(dob),
                    address
            );

            staff.setUser(user);

            staffDAO.save(staff);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStaff(Long id) {
        try {
            Staff staff = staffDAO.get(id).orElseThrow(() -> new RuntimeException("Staff id not found!"));

            staffDAO.delete(staff);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void validate(
            String staffNo,
            String fullName,
            String email,
            String phone,
            String dob,
            String address
    ) {

        if (staffNo == null || staffNo.equals(""))
            throw new RuntimeException("Staff no must not be null!");
        if (fullName == null || fullName.equals(""))
            throw new RuntimeException("FullName must not be null!");
        if (email == null || email.equals(""))
            throw new RuntimeException("Email must not be null!");
        if (phone == null || phone.equals(""))
            throw new RuntimeException("Phone must not be null!");
        if (dob == null || dob.equals(""))
            throw new RuntimeException("Dob must not be null!");
        if (address == null || address.equals(""))
            throw new RuntimeException("Address must not be null!");

        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches())
            throw new RuntimeException("Email not valid!");

        if (!Pattern.compile("^\\d{10}$").matcher(phone).matches())
            throw new RuntimeException("Phone number not valid!");
    }
}
