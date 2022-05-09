package dock.controller;

import com.sun.istack.NotNull;
import dock.config.TerminalContants;
import dock.exception.TerminalModelException;
import dock.model.TerminalModel;
import dock.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api-dock/")
public class TerminalController {

    private final TerminalService terminalService;

    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @PostMapping(value = {"/convert"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TerminalModel> convert(@RequestBody String body) throws TerminalModelException {
        TerminalModel terminalModel = terminalService.convert(body);
        return ResponseEntity.ok().body(terminalModel);
    }

    @PostMapping(value = {"/register"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> register(@RequestBody String body) throws TerminalModelException {
        TerminalModel terminalModel = terminalService.save(body);
        return ResponseEntity.ok().body(TerminalContants.TERMINAL_SALVO_COM_SUCESSO + terminalModel.getLogic());
    }

    @GetMapping(value = {"/consult/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<TerminalModel> consult(@RequestBody @NotNull @PathVariable("logic") int body) throws TerminalModelException {
        TerminalModel terminalModel = terminalService.query(body);
        return ResponseEntity.ok().body(terminalModel);
    }

    @PutMapping(value = {"/update/{logic}"}, consumes = {"text/html; charset=utf-8"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> update(@RequestBody @NotNull String body, @PathVariable("logic") int logic) throws TerminalModelException {
        TerminalModel terminalModel = terminalService.update(body, logic);
        return ResponseEntity.ok().body(TerminalContants.TERMINAL_UPDATE_REALIZADO_COM_SUCESSO + terminalModel.getLogic());
    }
}
