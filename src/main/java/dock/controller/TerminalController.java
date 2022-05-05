package dock.controller;

import com.sun.istack.NotNull;
import dock.model.TerminalModel;
import dock.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api-dock/")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @PostMapping(value = {"/"}, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public TerminalModel init(@RequestBody @NotNull TerminalModel body) {

        System.out.println(body);

        return null;
    }
}
