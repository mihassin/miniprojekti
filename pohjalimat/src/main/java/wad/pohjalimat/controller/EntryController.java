package wad.pohjalimat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EntryController {
    
    @RequestMapping(value = "entries", method = RequestMethod.GET)
    public String list(Model model) {
        return "entries";
    }
    
    @RequestMapping(value = "entry", method = RequestMethod.GET)
    public String addEntry(Model model) {
        return "entry";
    }
}
