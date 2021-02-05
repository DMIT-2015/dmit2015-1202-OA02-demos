package dmit2015.hr.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "JOBS", schema = "HR")
public class JobsEntity {
    private String jobId;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;
    private Collection<EmployeesEntity> employeesByJobId;
    private Collection<JobHistoryEntity> jobHistoriesByJobId;

    @Id
    @Column(name = "JOB_ID")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "JOB_TITLE")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Basic
    @Column(name = "MIN_SALARY")
    public Long getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Long minSalary) {
        this.minSalary = minSalary;
    }

    @Basic
    @Column(name = "MAX_SALARY")
    public Long getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Long maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobsEntity that = (JobsEntity) o;
        return Objects.equals(jobId, that.jobId) && Objects.equals(jobTitle, that.jobTitle) && Objects.equals(minSalary, that.minSalary) && Objects.equals(maxSalary, that.maxSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, minSalary, maxSalary);
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<EmployeesEntity> getEmployeesByJobId() {
        return employeesByJobId;
    }

    public void setEmployeesByJobId(Collection<EmployeesEntity> employeesByJobId) {
        this.employeesByJobId = employeesByJobId;
    }

    @OneToMany(mappedBy = "jobsByJobId")
    public Collection<JobHistoryEntity> getJobHistoriesByJobId() {
        return jobHistoriesByJobId;
    }

    public void setJobHistoriesByJobId(Collection<JobHistoryEntity> jobHistoriesByJobId) {
        this.jobHistoriesByJobId = jobHistoriesByJobId;
    }
}
