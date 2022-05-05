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

    @PostMapping(value = {"/convert"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public TerminalModel convert(@RequestBody @NotNull String body) {
        return terminalService.convertJson(body);
    }

    @PostMapping(value = {"/register"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String cadastrar(@RequestBody @NotNull String body) {
        return terminalService.save(body);
    }

    @PutMapping(value = {"/update/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String update(@RequestBody @NotNull String body, @PathVariable("logic") int logic) {
        return terminalService.update(body, logic);
    }

    @PutMapping(value = {"/delete/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable("logic") int logic) {
        return terminalService.delete(logic);
    }
}
