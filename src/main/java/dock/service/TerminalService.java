package dock.service;

import dock.config.TerminalContants;
import dock.exception.TerminalModelException;
import dock.model.TerminalModel;
import dock.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {

    private final TerminalRepository terminalRepository;
    private final TerminalUtilsService utilsService;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository, TerminalUtilsService utilsService) {
        this.terminalRepository = terminalRepository;
        this.utilsService = utilsService;
    }

    public TerminalModel convert(String body) throws TerminalModelException {
        return utilsService.parseTerminalModel(body);
    }

    public TerminalModel save(String body) throws TerminalModelException {
        try {
            TerminalModel terminalModel = utilsService.parseTerminalModel(body);
            return terminalRepository.save(terminalModel);
        } catch (Exception e) {
            throw new TerminalModelException(TerminalContants.TERMINAL_ERRO_AO_SALVAR);
        }
    }

    public TerminalModel query(int logic) throws TerminalModelException {
        TerminalModel terminalModel = terminalRepository.findByLogic(logic);

        if (terminalModel == null) {
            throw new TerminalModelException(TerminalContants.TERMINAL_NAO_LOCALIZADO);
        }
        return terminalModel;
    }

    public TerminalModel update(String body, int logic) throws TerminalModelException {
        TerminalModel terminalModel = terminalRepository.findByLogic(logic);
        TerminalModel tempBody = utilsService.parseTerminalModel(body);

        if (terminalModel == null) {
            throw new TerminalModelException(TerminalContants.TERMINAL_NAO_LOCALIZADO);
        }

        if (tempBody.getLogic() != logic) {
            throw new TerminalModelException(TerminalContants.TERMINAL_UPDATE_NUMERO_LOGICO_DIFERENTE);
        } else {
            terminalRepository.save(tempBody);
        }

        return terminalModel;
    }

}
