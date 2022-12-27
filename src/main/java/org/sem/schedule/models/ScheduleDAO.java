package org.sem.schedule.models;

import org.sem.classes.models.Class;
import org.sem.classes.models.ClassDAO;
import org.sem.database.DAO;
import org.sem.subjects.models.Subject;
import org.sem.subjects.models.SubjectDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScheduleDAO extends DAO<Schedule> {
    public ClassDAO classDAO;
    public SubjectDAO subjectDAO;

    public ScheduleDAO() {
        super("schedule");
        classDAO = new ClassDAO();
        subjectDAO = new SubjectDAO();
    }

    @Override
    public Optional<Schedule> get(Long id) {
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
            Schedule cs = null;
            if (rs.next()) {
                cs = processScheduleData(rs);
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
    public List<Schedule> getAll() {
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
            List<Schedule> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processScheduleData(rs));
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
    public Schedule save(Schedule schedule) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            // 2.1 check is new or not => aClass.getId() != null or not
            // if new => use insert into query else update query
            String sql;
            PreparedStatement ps;

            if (schedule.getId() != null) {
                sql = String.format("UPDATE `%s` SET `class_id` = ?, `day` = ?, `start_time` = ?, `end_time` = ?, `subject_id` = ? WHERE `id` = ?", getTableName());
                ps = con.prepareStatement(sql);

                ps.setLong(6, schedule.getId());
            } else {
                sql = String.format("INSERT INTO `%s` (`class_id`,`day`,`start_time`,`end_time`,`subject_id`) VALUES (?,?,?,?,?)", getTableName());
                ps = con.prepareStatement(sql);
            }

            ps.setLong(1, schedule.getClassS().getId());
            ps.setDate(2, schedule.getDate());
            ps.setString(3, schedule.getStartTime());
            ps.setString(4, schedule.getEndTime());
            ps.setLong(5, schedule.getSubject().getId());

            // 3.execute query
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            // 4.process query return data
            if (rs.next()) {
                schedule.setId(rs.getLong(1));
                rs.close();
            }

            // 5.close transaction
            ps.close();

            // 6.return result
            return schedule;
        } catch (Exception e) {
            // 7.handle errors
            throw new RuntimeException(e);

        } finally {
            // 8.close database connection
            this.connector.closeConnection();
        }
    }

    @Override
    public Boolean delete(Schedule schedule) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("DELETE FROM `%s` WHERE `id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, schedule.getId());


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

    private Schedule processScheduleData(ResultSet rs) {
        try {
            Schedule schedule = new Schedule(
                    rs.getLong("id"),
                    rs.getDate("day"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getTimestamp("created_at"),
                    rs.getTimestamp("updated_at")
            );

            Class cl = classDAO.get(rs.getLong("class_id"))
                    .orElseThrow(() -> new RuntimeException("Class not found!"));

            Subject subject = subjectDAO.get(rs.getLong("subject_id"))
                    .orElseThrow(() -> new RuntimeException("Subject not found!"));

            schedule.setClassS(cl);
            schedule.setSubject(subject);

            return schedule;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Schedule> getAllUpcoming() {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE DATE(NOW()) <= `day`", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Schedule> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processScheduleData(rs));
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

    public List<Schedule> searchBySubjectName(String name) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` AS `m` LEFT JOIN `subject` AS `s` ON `m`.`subject_id` = `s`.`id` WHERE (`s`.`subject_name` is null or `s`.`subject_name` like concat('%', ?, '%') AND DATE(NOW()) <= `m`.`day`)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Schedule> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processScheduleData(rs));
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

    public List<Schedule> getAllByClass(Class classData) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = String.format("SELECT * FROM `%s` WHERE `class_id` = ?", getTableName());
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, classData.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Schedule> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processScheduleData(rs));
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

    public List<Schedule> searchBySubjectNameWithClass(String name, Class classData) {
        try {
            // 1.get connection
            Connection con = this.connector
                    .startConnection().getConnection();

            // 2.prepare query
            String sql = "SELECT * FROM `" + getTableName() + "` AS `m` LEFT JOIN `subject` AS `s` ON `m`.`subject_id` = `s`.`id` WHERE (`s`.`subject_name` is null or `s`.`subject_name` like concat('%', ?, '%') AND `m`.`class_id` = ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setLong(2, classData.getId());

            // 3.execute query
            ResultSet rs = ps.executeQuery();

            // 4.process query return data
            List<Schedule> result = new ArrayList<>();
            while (rs.next()) {
                result.add(processScheduleData(rs));
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
}
