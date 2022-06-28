package prateek.developer.Campaignfilter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prateek.developer.Campaignfilter.DTO.CampaignDto;
import prateek.developer.Campaignfilter.entity.Campaign;
import prateek.developer.Campaignfilter.repo.CampaignRepo;
import prateek.developer.Campaignfilter.service.CampaignService;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;
    @Autowired
    private CampaignRepo campaignRepo;

    @GetMapping("/getCampaigns")
    public ResponseEntity<List<Campaign>> getCampaigns(@RequestBody CampaignDto campaignDto) {
        System.out.println(campaignDto);
        return ResponseEntity.ok().body(campaignService.getCampaigns(campaignDto.getCampaignId(), campaignDto.getCampaignName(),
                campaignDto.getCampaignStatus(), campaignDto.getCreatedDate(), campaignDto.getStartDate(),
                campaignDto.getEndDate()));
    }

    @GetMapping("/get")
    public ResponseEntity<?> fetchCampaignByCampaignStatus(@RequestBody CampaignDto campaignDto){
        return new ResponseEntity<>(this.campaignRepo.fetchCampaign(campaignDto.getCampaignStatus()), HttpStatus.OK);
    }

    @PostMapping("/addCampaign")
    public Campaign addCampaigns(@RequestBody Campaign campaign){
        return campaignService.addCampaign(campaign);
    }

    @GetMapping("/getCampaign/{campId}")
    public Campaign getCampaign(@PathVariable("campId") Integer campId){
        return campaignRepo.findByCampaignId(campId);
    }
}
