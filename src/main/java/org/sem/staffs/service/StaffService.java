package org.sem.staffs.service;

import org.sem.helper.DateTimeHelper;
import org.sem.staffs.models.Staff;
import org.sem.staffs.models.StaffDAO;

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
            String address
    ) {
        try {
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
}
