package me.jinhao.springblog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.jinhao.springblog.exception.PageNotFoundException;
import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.service.PageService;

@Controller
@RequestMapping("/admin/page")
public class AdminPageController {

    @Autowired
    private PageService pageService;

    @GetMapping("")
    public String pages(Model model) {
        List<Page> pages = pageService.findAllPages();
        model.addAttribute("pages", pages);
        return "/admin/page/index";
    }

    @GetMapping("/add")
    public String add(Page page, Model model) {
        return "/admin/page/add";
    }

    @PostMapping("/add")
    public String add(@Valid Page page, BindingResult bindingResult, RedirectAttributes redirectAttributes,
            Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            return "/admin/page/add";
        }

        pageService.addPage(page);

        redirectAttributes.addFlashAttribute("message", "Page added");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/admin/page";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Page page = pageService.findPageById(id);
            model.addAttribute("page", page);
        } catch (PageNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/page";
        }
        return "/admin/page/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid Page page, BindingResult bindingResult, RedirectAttributes redirectAttributes,
            Model model) throws Exception {

        if (bindingResult.hasErrors()) {
            return "/admin/page/edit";
        }

        try {
            pageService.editPage(page);
        } catch (PageNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/admin/page";
        }

        redirectAttributes.addFlashAttribute("message", "Page edited");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/admin/page";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        try {
            pageService.deletePageById(id);
            redirectAttributes.addFlashAttribute("message", "Blog deleted");
            redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        } catch (PageNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return "redirect:/admin/page";
    }

    @ResponseBody
    @GetMapping("/switch/{id}")
    public Page switchActive(@PathVariable Integer id, RedirectAttributes redirectAttributes) {

        Page page = null;
        try {
            page = pageService.switchPageActive(id);
        } catch (PageNotFoundException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        }

        return page;

    }

}