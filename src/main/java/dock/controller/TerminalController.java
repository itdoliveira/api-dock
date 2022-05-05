package dock.controller;

import com.sun.istack.NotNull;
import dock.model.TerminalModel;
import dock.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api-dock/")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @PostMapping(value = {"/converter"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public TerminalModel converter(@RequestBody @NotNull String body) {
        return terminalService.converterJson(body);
    }

    @PostMapping(value = {"/cadastrar"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String cadastrar(@RequestBody @NotNull String body) {
        return terminalService.save(body);
    }


}
