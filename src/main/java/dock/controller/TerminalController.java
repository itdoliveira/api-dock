package dock.controller;

import dock.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api-dock/")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;



}
