package com.socialwelfareportal.socialwelfareportal.controller;


import com.socialwelfareportal.socialwelfareportal.service.GrantRequestService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final GrantRequestService grantRequestService;


    @GetMapping("/home")
    public String getAdminHomePage(){
        return "/admin/home";
    }

    @GetMapping("/view-all-grant-request")
    public String viewAllGrantrequest(Model model){
        model.addAttribute("allgrant", grantRequestService.getAllGrants());
        return "/admin/allgrantrequest";
    }

    @GetMapping("/view-pending-request")
    public String viewPendingRequest(Model model){
        model.addAttribute("pendingAttribute", grantRequestService.getpendingGrantRequest());
        return "/admin/pendinggrantrequest";
    }

    @GetMapping("/accept-request/{id}")
    public String acceptTheRequest(@PathVariable Integer id){
        grantRequestService.approveTheRequest(id);
        return "redirect:/admin/view-pending-request";
    }

    @GetMapping("/decline-request/{id}")
    public String declineTheRequest(@PathVariable Integer id){
        grantRequestService.approveTheRequest(id);
        return "redirect:admin/view-pending-request";
    }

    @GetMapping("/search")
    public String getSearch(@RequestParam("searchKey") String searchKey, Model model){
        model.addAttribute("result", grantRequestService.getSearchResult(searchKey));
        return "/admin/searchresult";
    }
}
