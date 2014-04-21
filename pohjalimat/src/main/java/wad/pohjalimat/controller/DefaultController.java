package wad.pohjalimat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wad.pohjalimat.WebUI;

@Controller
public class DefaultController implements DefaultControllerInterface {
    @Autowired
    private WebUI webUI;
            
    @RequestMapping(value="write", method = RequestMethod.GET)
    public String write(Model model) {
        model.addAttribute("messages", webUI.write());
        return "write";
    }

    @RequestMapping(value="read",method = RequestMethod.POST)
    public String read(@RequestParam(value="message", required=false) String message) {
        if(message == null || message.isEmpty())return "redirect:web-terminal";
        else {
            webUI.read(message);
            return "redirect:write";
        }
    }
}

