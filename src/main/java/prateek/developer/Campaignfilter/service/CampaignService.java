package prateek.developer.Campaignfilter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prateek.developer.Campaignfilter.entity.Campaign;
import prateek.developer.Campaignfilter.entity.CampaignStatus;
import prateek.developer.Campaignfilter.repo.CampaignRepo;

import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepo campaignRepo;

    public List<Campaign> getCampaigns(Integer campaignId, String campaignName, List<CampaignStatus> campaignStatus, String createdDate, String startDate, String endDate) {
//        Map<Integer,String> mapper = new HashMap<>();
//        mapper.put(1,"ACTIVE");
//        mapper.put(2,"PENDING");
//        mapper.put(3,"OPEN");
//        mapper.put(4,"CLOSED");
//
//        List<String> campaigns = new ArrayList<>();
//
//        for (Integer var : campaignStatus){
//            campaigns.add(mapper.get(var));
//        }
        return campaignRepo.getFilteredCampaigns(campaignId, campaignName, campaignStatus, createdDate, startDate, endDate);
    }

    public Campaign addCampaign(Campaign campaign) {
        return campaignRepo.save(campaign);
    }
}
