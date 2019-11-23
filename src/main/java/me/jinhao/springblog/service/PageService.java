package me.jinhao.springblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.jinhao.springblog.exception.PageNotFoundException;
import me.jinhao.springblog.model.Page;
import me.jinhao.springblog.model.PageRepository;

@Service
public class PageService {

    @Autowired
    private PageRepository pageRepository;


    public Page findPageBySlug(String slug){
        return pageRepository.findBySlug(slug);
    }


	public Page findPageById(Integer id) {
        Optional<Page> optionalPage = pageRepository.findById(id);
        if(!optionalPage.isPresent()){
            throw new PageNotFoundException("the page does not exist");
        }
        return optionalPage.get();
	}


	public List<Page> findAllPages() {
		return pageRepository.findAll();
	}


	public void addPage(Page page) {
        String title = page.getTitle();
        String slug = title.trim().toLowerCase().replace(" ", "-");
        page.setSlug(slug);
        page.setIsActive(true);
        pageRepository.save(page);
	}


	public void editPage(Page page) {
        String title = page.getTitle();
        String slug = title.trim().toLowerCase().replace(" ", "-");
        page.setSlug(slug);
        pageRepository.save(page);
	}


	public void deletePageById(Integer id) {
        if(!pageRepository.existsById(id)){
            throw new PageNotFoundException("the page does not exist");
        }
        pageRepository.deleteById(id);
	}


	public Page switchPageActive(Integer id) {
        Optional<Page> optionalPage = pageRepository.findById(id);
        if(!optionalPage.isPresent()){
            throw new PageNotFoundException("the page does not exist");
        }
        Page page = optionalPage.get();
        page.setIsActive(!page.getIsActive());
        pageRepository.save(page);
        return page;
	}

}