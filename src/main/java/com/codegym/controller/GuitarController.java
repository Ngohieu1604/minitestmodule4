package com.codegym.controller;


import com.codegym.model.Guitar;
import com.codegym.model.GuitarForm;
import com.codegym.service.IGuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class GuitarController {
    @Value("E:\\img")
    private String fileUpload;

    @Autowired
    IGuitarService guitarService;

    @GetMapping("/home")
    public ModelAndView home() {
        List<Guitar> guitarList = guitarService.findAll();
        ModelAndView modelAndView = new ModelAndView("/guitar/index");
        modelAndView.addObject("guitarList", guitarList);
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/guitar/create");
        modelAndView.addObject("guitar", new Guitar());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createProduct(@ModelAttribute GuitarForm guitarForm) {
        MultipartFile multipartFile = GuitarForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(guitarForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Guitar guitar = new Guitar(guitarForm.getId(), guitarForm.getName(), guitarForm.getPrice(), fileName);
        ModelAndView modelAndView = new ModelAndView("/guitar/create");
        modelAndView.addObject("guitar", new Guitar());
        guitarService.insert(guitar);
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/guitar/update");
        Guitar guitar = guitarService.findById(id);
        modelAndView.addObject("guitar", guitar);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateProduct(@ModelAttribute GuitarForm guitarForm) {
        MultipartFile multipartFile = guitarForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(guitarForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Guitar guitar = new Guitar(guitarForm.getId(), guitarForm.getName(), guitarForm.getPrice(), fileName);
        ModelAndView modelAndView = new ModelAndView("/guitar/update");
        modelAndView.addObject("guitar", new Guitar());
        guitarService.update(guitar);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        guitarService.remove(id);
        List<Guitar> guitarList = guitarService.findAll();
        ModelAndView modelAndView = new ModelAndView("/guitar/index");
        modelAndView.addObject("guitarList", guitarList);
        return modelAndView;
    }
}