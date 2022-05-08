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

    @PostMapping(value = {"/convert"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity convert(@RequestBody @NotNull String body) {
        return terminalService.convert(body);
    }

    @PostMapping(value = {"/register"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity cadastrar(@RequestBody @NotNull String body) {
        return terminalService.save(body);
    }

    @GetMapping(value = {"/consult/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity consult(@RequestBody @NotNull @PathVariable("logic") int body) {
        return terminalService.consult(body);
    }

    @PutMapping(value = {"/update/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity update(@RequestBody @NotNull String body, @PathVariable("logic") int logic) {
        return terminalService.update(body, logic);
    }
}
