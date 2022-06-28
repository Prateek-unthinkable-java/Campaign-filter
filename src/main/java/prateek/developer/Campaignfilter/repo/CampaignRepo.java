package prateek.developer.Campaignfilter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import prateek.developer.Campaignfilter.entity.Campaign;
import prateek.developer.Campaignfilter.entity.CampaignStatus;

import java.util.List;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, String> {

//    @Query("SELECT c FROM campaign as c WHERE CONCAT(c.campaign_id, c.campaign_name, c.campaign_status, c.created_date, c.start_date, c.end_date) LIKE %?1%")
//    public List<Campaign> findCampaigns(Campaign campaign);

    @Query("SELECT  c FROM Campaign c WHERE c.campaignId = ?1")
    public Campaign findByCampaignId(Integer campaignId);

    @Query(value = "SELECT c FROM Campaign c WHERE c.campaignId=:campaignId or (:campaignName=' ' or :campaignName is null or c.campaignName=:campaignName ) or " +
            "(:campaignStatus=' ' or :campaignStatus is null or c.campaignStatus IN :campaignStatus) or (:createdDate=' ' or :createdDate is null or c.createdDate=:createdDate) or " +
    "(:startDate=' ' or :startDate is null or c.startDate=:startDate) or (:endDate=' ' or :endDate is null or c.endDate=:endDate)")
    public List<Campaign> getFilteredCampaigns(@Param("campaignId") Integer campaignId,
                                               @Param("campaignName") String campaignName,
                                               @Param("campaignStatus") List<CampaignStatus> campaignStatus,
                                               @Param("createdDate") String createdDate,
                                               @Param("startDate") String startDate,
                                               @Param("endDate") String endDate);

    @Query(value = "select c from Campaign c where c.campaignStatus in :campaignStatus")
    public List<Campaign> fetchCampaign(@Param("campaignStatus") List<CampaignStatus> campaignStatus);


}
