package dmit2015.hr.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "REGIONS", schema = "HR", catalog = "")
public class RegionsEntity {
    private Long id;
    private Long regionId;
    private String regionName;
    private Collection<CountriesEntity> countriesByRegionId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "REGION_ID")
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "REGION_NAME")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionsEntity that = (RegionsEntity) o;
        return Objects.equals(regionId, that.regionId) && Objects.equals(regionName, that.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, regionName);
    }

    @OneToMany(mappedBy = "regionsByRegionId")
    public Collection<CountriesEntity> getCountriesByRegionId() {
        return countriesByRegionId;
    }

    public void setCountriesByRegionId(Collection<CountriesEntity> countriesByRegionId) {
        this.countriesByRegionId = countriesByRegionId;
    }
}
