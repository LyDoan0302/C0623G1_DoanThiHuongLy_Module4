package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongDto;
import com.codegym.service.ISongService;
import com.ibm.j9ddr.vm29.pointer.generated._jfieldIDPointer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping
public class SongController {
    @Autowired
    private ISongService songService;

    @RequestMapping(method = RequestMethod.GET)
    public String showSongList(@PageableDefault(value = 5, sort = "songName",
            direction = Sort.Direction.ASC)Pageable pageable, Model model) {
        model.addAttribute("songList", songService.findAll(pageable));
        return "index";
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        return new ModelAndView("create", "songDto", new SongDto());
    }

    @PostMapping("/create")
    public String addNewSong(@Validated @ModelAttribute SongDto songDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            return "create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);

            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Add "
                    + song.getSongName() + " song" + " OK!");
            return "redirect:/";
        }
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showEditPage(@PathVariable Long id) {
        Song song = songService.findSongById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song, songDto);
        return new ModelAndView("edit", "songDto", songDto);
    }
    @PostMapping("/{id}/edit")
    public String editSong(@Validated @ModelAttribute SongDto songDto,
                                 BindingResult bindingResult,
                                 @PageableDefault(value = 5, sort = "songName",
                                         direction = Sort.Direction.ASC)Pageable pageable,
                                 @PathVariable Long id, Model model) {
        if(bindingResult.hasErrors()){
            return "edit";
        } else {
            Song song = songService.findSongById(id);
            BeanUtils.copyProperties(songDto, song);
            songService.save(song);
            model.addAttribute("songList", songService.findAll(pageable));
            return "redirect:/";
        }
    }
    @GetMapping("/{id}/delete")
    public String deleteSong(@PathVariable Long id) {
        songService.delete(id);
        return "redirect:/";
    }

}
