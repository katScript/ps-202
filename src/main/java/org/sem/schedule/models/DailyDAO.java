package org.sem.schedule.models;

import org.sem.classes.models.Class;
import org.sem.database.DAO;
import org.sem.staffs.models.Staff;
import org.sem.staffs.models.StaffDAO;
import org.sem.students.models.Student;
import org.sem.students.models.StudentDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DailyDAO extends DAO<Daily> {
    public StaffDAO staffDAO;
    public StudentDAO studentDAO;
    public ScheduleDAO scheduleDAO;

    public DailyDAO() {
        super("daily");
        staffDAO = new StaffDAO();
        studentDAO = new StudentDAO();
        scheduleDAO = new ScheduleDAO();
    }

    @Override
    public Optional<Daily> get(Long id) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            Daily cs = null;
            if (rs.next()) {
                cs = processDailyObjectData(rs);
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(cs);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public List<Daily> getAll() {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s`", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Daily> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processDailyObjectData(rs));
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return result;
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public Daily save(Daily daily) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            // 2.1 check is new or not => aClass.getId() != null or not
            // if new => use insert into query else update query
            String sql;
            PreparedStatement ps;

            if (daily.getId() != null) {
                sql = String.format("UPDATE `%s` SET `staff_id` = ?, `student_id` = ?, `schedule_id` = ?, `present` = ? WHERE `id` = ?", getTableName());
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setLong(5, daily.getId());
            } else {
                sql = String.format("INSERT INTO `%s` (`staff_id`,`student_id`,`schedule_id`,`present`) VALUES (?,?,?,?)", getTableName());
                ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            }

            if (daily.getStaff() == null || daily.getStaff().getId() == null) {
                ps.setNull(1, Types.BIGINT);
            } else {
                ps.setLong(1, daily.getStaff().getId());
            }

            ps.setLong(2, daily.getStudent().getId());
            ps.setLong(3, daily.getSchedule().getId());
            ps.setBoolean(4, daily.getPresent());

            // 3.execute query
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            // 4.process query return data
            if (rs.next()) {
                daily.setId(rs.getLong(1));

                rs.close();
            }

            // 5.close transaction
            ps.close();

            // 6.return result
            return daily;
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);

        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public Boolean delete(Daily daily) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("DELETE FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, daily.getId());


            // 3.execute query
            Boolean result = ps.execute();

            // 4.process query return data true or false => delete success or not
            ps.close();

            // 5.close transaction
            return result;

            // 6.return result
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    private Daily processDailyObjectData(ResultSet rs) {
        try {
            Daily daily = new Daily(
                    rs.getLong("id"),
                    rs.getBoolean("present"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );

            Staff staff = staffDAO.get(rs.getLong("staff_id"))
                    .orElse(null);
            Student student = studentDAO.get(rs.getLong("student_id"))
                    .orElseThrow(() -> new RuntimeException("Student not found!"));
            Schedule schedule = scheduleDAO.get(rs.getLong("schedule_id"))
                    .orElseThrow(() -> new RuntimeException("Schedule not found!"));

            daily.setStaff(staff);
            daily.setSchedule(schedule);
            daily.setStudent(student);

            return daily;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<Daily> getByStudentAndSchedule(Student student, Schedule schedule) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `student_id` = ? AND `schedule_id` = ? LIMIT 1", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, student.getId());
            ps.setLong(2, schedule.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            Daily result = null;
            while (rs.next()) {
                result = processDailyObjectData(rs);
            }

            // 5.close transaction
            ps.close();
            rs.close();

            // 6.return result
            return Optional.ofNullable(result);
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);
        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }
}
