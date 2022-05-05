package dock.service;

import dock.model.TerminalModel;
import dock.model.TerminalModelBuilder;
import dock.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalService {

    @Autowired
    TerminalRepository terminalRepository;

    public String save(String body) {

        TerminalModel terminalModel = convertJson(body);
        terminalRepository.save(terminalModel);

        return "Salvo";
    }

    public String update(TerminalModel terminalModel, int logic) {

        TerminalModel temp = terminalRepository.findByLogic(logic);

        if (temp == null) {
            return "Terminal não localizado";
        }

        if (terminalModel.getLogic() != logic) {
            return "ID Diferentes";
        } else {
            terminalRepository.save(terminalModel);
        }

        return "Atualizado";
    }

    public String[] splitText(String text) {

        String[] split = text.split(";");

        if (split != null && split.length < 10) {
            return null;
        }

        return split;
    }

    public TerminalModel convertJson(String text) {

        String[] textoSeparado = splitText(text);

        return TerminalModelBuilder
                .builder()
                .addLogic(Integer.parseInt(textoSeparado[0]))
                .addSerial(textoSeparado[1])
                .addModel(textoSeparado[2])
                .addSam(Integer.parseInt(textoSeparado[3]))
                .addPtid(textoSeparado[4])
                .addPlat(Integer.parseInt(textoSeparado[5]))
                .addVersion(textoSeparado[6])
                .addMxr(Integer.parseInt(textoSeparado[7]))
                .addMxf(Integer.parseInt(textoSeparado[8]))
                .addPverfm(textoSeparado[9])
                .build();
    }
}
