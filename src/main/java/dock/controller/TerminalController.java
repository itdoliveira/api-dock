package dock.controller;

import com.sun.istack.NotNull;
import dock.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api-dock/")
public class TerminalController {

    @Autowired
    private TerminalService terminalService;

    @RequestMapping(value = {"/convert"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity convert(@RequestBody @NotNull String body) {
        return terminalService.convert(body);
    }

    @RequestMapping(value = {"/register"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity cadastrar(@RequestBody @NotNull String body) {
        return terminalService.save(body);
    }

    @PutMapping(value = {"/update/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity update(@RequestBody @NotNull String body, @PathVariable("logic") int logic) {
        return terminalService.update(body, logic);
    }
}
