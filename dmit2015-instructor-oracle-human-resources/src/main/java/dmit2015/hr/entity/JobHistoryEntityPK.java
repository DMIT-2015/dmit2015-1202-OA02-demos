package dmit2015.hr.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

public class JobHistoryEntityPK implements Serializable {
    private Long employeeId;
    private Time startDate;

    @Column(name = "EMPLOYEE_ID")
    @Id
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name = "START_DATE")
    @Id
    public Time getStartDate() {
        return startDate;
    }

    public void setStartDate(Time startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHistoryEntityPK that = (JobHistoryEntityPK) o;
        return Objects.equals(employeeId, that.employeeId) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, startDate);
    }
}
