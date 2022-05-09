package dock.service;

import dock.config.TerminalContants;
import dock.exception.TerminalModelBuildingException;
import dock.exception.TerminalModelException;
import dock.model.TerminalModel;
import dock.model.TerminalModelBuilder;
import org.springframework.stereotype.Service;

@Service
public class TerminalUtilsService {

    public String[] validateInputText(String text) throws TerminalModelException {
        if (text == null || "".equals(text)) {
            throw new TerminalModelException(TerminalContants.ENTRADA_INVALIDA + text);
        }

        String[] split = text.split(";");

        if (split.length < 4) {
            throw new TerminalModelBuildingException(TerminalContants.PARAMETROS_INVALIDOS + text);
        }

        return split;
    }

    public TerminalModel parseTerminalModel(String text) throws TerminalModelException {

        String[] textSplited = validateInputText(text);

        return TerminalModelBuilder
                .builder()
                .addLogic(Integer.parseInt(textSplited[0]))
                .addSerial(textSplited[1])
                .addModel(textSplited[2])
                .addSam(Integer.parseInt(textSplited[3]))
                .addPtid(textSplited[4])
                .addPlat(Integer.parseInt(textSplited[5]))
                .addVersion(textSplited[6])
                .addMxr(Integer.parseInt(textSplited[7]))
                .addMxf(Integer.parseInt(textSplited[8]))
                .addPverfm(textSplited[9])
                .build();
    }

}
