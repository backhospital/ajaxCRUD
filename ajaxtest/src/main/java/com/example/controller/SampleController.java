package com.example.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.service.SampleService;
import com.example.vo.SampleVO;

@Controller
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @RequestMapping(value = "/sample/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<SampleVO> samples = sampleService.selectSampleList();
        model.addAttribute("selectSampleList", samples);
        return "sample/list";
    }

    @RequestMapping(value = "/sample/detail", method = RequestMethod.GET)
    public void detail(@RequestParam("idx") int idx, Model model) {
        SampleVO sample = sampleService.selectSample(idx);
        model.addAttribute("selectSample", sample);
    }
    
	@RequestMapping(value = "/sample/insert", method = RequestMethod.GET)
	public void insert() throws Exception {
		 
	}    

    @RequestMapping(value = "/sample/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insert(SampleVO sample) {
        sampleService.insertSample(sample);
        return "success";
    }

    @RequestMapping(value = "/sample/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(SampleVO sample) {
        sampleService.updateSample(sample);
        return "success";
    }

    @RequestMapping(value = "/sample/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam int idx) {
        sampleService.deleteSample(idx);
        return "success";
    }
}