package wad.pohjalimat.controller;

import org.springframework.ui.Model;

public interface DefaultControllerInterface {
    String read(String message);
    String write(Model model);
}
