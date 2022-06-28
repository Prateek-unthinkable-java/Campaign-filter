package prateek.developer.Campaignfilter.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import prateek.developer.Campaignfilter.entity.CampaignStatus;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampaignDto {

    private Integer campaignId;
    private String campaignName;
    private String createdDate;
    private String startDate;
    private String endDate;
    private List<CampaignStatus> campaignStatus;
}
