package prateek.developer.Campaignfilter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "CAM")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer campaignId;
    private String campaignName;
    private String createdDate;
    private String startDate;
    private String endDate;
    @Enumerated(EnumType.ORDINAL)
    private CampaignStatus campaignStatus;

    public CampaignStatus getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(CampaignStatus campaignStatus) {
        this.campaignStatus = campaignStatus;
    }
}








//@Query("SELECT c FROM CampaignCampaignStatus ccs LEFT JOIN ccs.campaignStatus camS WHERE :campaignStatus IN cams")